package jp.co.ksi.sap.incubator;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;

public class HttpURLConnectionTest
{
	public static final String MATCH_ASCII = "^[\\u0020-\\u007E]+$";
	
	/**
	 * @param args
	 */
	public static void main( String[] args )
	{
		String	url= "http://recc5.dev.ksi.co.jp:8000/sap/public/myssocntl?sap-client=902";
		String	mySapSso2= "AjQxMDMBABg0ADUAMAAxADkAMQAxADAAMQAzACAAIAACAAYzADAAMgADABBSAEUANQAgACAAIAAgACAABAAYMgAwADEAMwAwADQAMQAyADAANQA1ADQABQAEAAAACAYAAlgACQACSgD%2fA1UwggNRBgkqhkiG9w0BBwKgggNCMIIDPgIBATELMAkGBSsOAwIaBQAwCwYJKoZIhvcNAQcBoIICUzCCAk8wggIPAgcgEQQEExYFMAkGByqGSM44BAMwDjEMMAoGA1UEAxMDREU0MB4XDTExMDQwNDEzMTYwNVoXDTM4MDEwMTAwMDAwMVowDjEMMAoGA1UEAxMDREU0MIIBtzCCASwGByqGSM44BAEwggEfAoGBAP%2fxj%21B47Lr%21SRFHxMni7HS6i4UICAlsbwH5AU5bW52ST3cElPASiYkciYlKM9Dc0vcTx%21jhN1j7Dw7tp71Rpxs3t6yBY3S1CpanVCURxLjm4VBVINmRX9fJQVXFuNtpcC9dCr1IcJ4LenmSHWJgFJ%2fQsK4R8hk6GUeFYAgvsbbTAhUAjCnu6GdzaKBE1tG5z4ksen6cSAsCgYEA1oenEWTrY%2fSGknhHZAHlFQOCs7XiSHV8vdG7IgZ1Da%215iLRpZ6yiyenVwEH16ifS5epjmVuFCNFrZJbbsrQv%2119JyOfx0kHRVrDGYyZhtrmARbMpl8BEq5QvsEZbcLAft3XaaCpJozizCULViKILZWBAKx%21OsFYwGB6N0gTfXS0DgYQAAoGAW%21LcxvMveSAALvtINAMve8Ys%2fFCefVIxrV7pjdIG2UP5%21SQBhmuuMV7ITLLwURaRZKXBbIj64I6R3VgFN9MGvtADA3Wa2hX0FuqY6U40fHuGMMzuM379xBbWCT0IaFw%21MWsj1aZxk5PsGDDAYm4QWWORWvvu3PldAuEZnmLWi8gwCQYHKoZIzjgEAwMvADAsAhQhNSSM8zlabyORUxYt57XPyvdIHAIUbeH9pfFcdDJ6HpkcgLHAA0XbevIxgccwgcQCAQEwGTAOMQwwCgYDVQQDEwNERTQCByARBAQTFgUwCQYFKw4DAhoFAKBdMBgGCSqGSIb3DQEJAzELBgkqhkiG9w0BBwEwHAYJKoZIhvcNAQkFMQ8XDTEzMDQxMjA1NTQxOVowIwYJKoZIhvcNAQkEMRYEFHrdkNPIEgy7tW9e9JXUmdCkT%21MbMAkGByqGSM44BAMELzAtAhRba5V%2fae4yFH%21rjxsL2ssiluV7iAIVAIu63ll4VVyScCcYSiczZ7fMoii6";
		String	mySapSso = "AjQxMDMBABg0ADUAMAAxADkAMQAxADAAMQAzACAAIAACAAYzADAAMgADABBSAEUANQAgACAAIAAgACAABAAYMgAwADEAMwAwADQAMQAyADAANQA1ADQABwAEAAAAAggAAQEJAAJKAA8AAzMwMhAACFJFNSAgICAg/wNUMIIDUAYJKoZIhvcNAQcCoIIDQTCCAz0CAQExCzAJBgUrDgMCGgUAMAsGCSqGSIb3DQEHAaCCAlMwggJPMIICDwIHIBEEBBMWBTAJBgcqhkjOOAQDMA4xDDAKBgNVBAMTA0RFNDAeFw0xMTA0MDQxMzE2MDVaFw0zODAxMDEwMDAwMDFaMA4xDDAKBgNVBAMTA0RFNDCCAbcwggEsBgcqhkjOOAQBMIIBHwKBgQD/8Y/geOy6/kkRR8TJ4ux0uouFCAgJbG8B!QFOW1udkk93BJTwEomJHImJSjPQ3NL3E8fo4TdY!w8O7ae9UacbN7esgWN0tQqWp1QlEcS45uFQVSDZkV/XyUFVxbjbaXAvXQq9SHCeC3p5kh1iYBSf0LCuEfIZOhlHhWAIL7G20wIVAIwp7uhnc2igRNbRuc!JLHp!nEgLAoGBANaHpxFk62P0hpJ4R2QB5RUDgrO14kh1fL3RuyIGdQ2vuYi0aWesosnp1cBB9eon0uXqY5lbhQjRa2SW27K0L/tfScjn8dJB0VawxmMmYba5gEWzKZfARKuUL7BGW3CwH7d12mgqSaM4swlC1YiiC2VgQCsfjrBWMBgejdIE310tA4GEAAKBgFvi3MbzL3kgAC77SDQDL3vGLPxQnn1SMa1e6Y3SBtlD!fkkAYZrrjFeyEyy8FEWkWSlwWyI!uCOkd1YBTfTBr7QAwN1mtoV9BbqmOlONHx7hjDM7jN!/cQW1gk9CGhcPjFrI9WmcZOT7BgwwGJuEFljkVr77tz5XQLhGZ5i1ovIMAkGByqGSM44BAMDLwAwLAIUITUkjPM5Wm8jkVMWLee1z8r3SBwCFG3h/aXxXHQyeh6ZHICxwANF23ryMYHGMIHDAgEBMBkwDjEMMAoGA1UEAxMDREU0AgcgEQQEExYFMAkGBSsOAwIaBQCgXTAYBgkqhkiG9w0BCQMxCwYJKoZIhvcNAQcBMBwGCSqGSIb3DQEJBTEPFw0xMzA0MTIwNTU0MThaMCMGCSqGSIb3DQEJBDEWBBRpLFNgYjnAgIqlOibPzpIk5WMfjjAJBgcqhkjOOAQDBC4wLAIUB!MT7vOC7mAOy8JwvKTgyVB/Pr8CFGdRCjGldhWu0o2zER6EbYaxh4QO";
		mySapSso= "AjQxMDMBABg0ADUAMAAxADkAMQAxADAAMQAzACAAIAACAAY5ADAAMgADABBSAEUANQAgACAAIAAgACAABAAYMgAwADEAMwAwADQAMQA2ADAANgAzADIABQAEAAAACAYAAlgACQACSgD/A1QwggNQBgkqhkiG9w0BBwKgggNBMIIDPQIBATELMAkGBSsOAwIaBQAwCwYJKoZIhvcNAQcBoIICUzCCAk8wggIPAgcgEQQEExYFMAkGByqGSM44BAMwDjEMMAoGA1UEAxMDREU0MB4XDTExMDQwNDEzMTYwNVoXDTM4MDEwMTAwMDAwMVowDjEMMAoGA1UEAxMDREU0MIIBtzCCASwGByqGSM44BAEwggEfAoGBAP/xj!B47Lr!SRFHxMni7HS6i4UICAlsbwH5AU5bW52ST3cElPASiYkciYlKM9Dc0vcTx!jhN1j7Dw7tp71Rpxs3t6yBY3S1CpanVCURxLjm4VBVINmRX9fJQVXFuNtpcC9dCr1IcJ4LenmSHWJgFJ/QsK4R8hk6GUeFYAgvsbbTAhUAjCnu6GdzaKBE1tG5z4ksen6cSAsCgYEA1oenEWTrY/SGknhHZAHlFQOCs7XiSHV8vdG7IgZ1Da!5iLRpZ6yiyenVwEH16ifS5epjmVuFCNFrZJbbsrQv!19JyOfx0kHRVrDGYyZhtrmARbMpl8BEq5QvsEZbcLAft3XaaCpJozizCULViKILZWBAKx!OsFYwGB6N0gTfXS0DgYQAAoGAW!LcxvMveSAALvtINAMve8Ys/FCefVIxrV7pjdIG2UP5!SQBhmuuMV7ITLLwURaRZKXBbIj64I6R3VgFN9MGvtADA3Wa2hX0FuqY6U40fHuGMMzuM379xBbWCT0IaFw!MWsj1aZxk5PsGDDAYm4QWWORWvvu3PldAuEZnmLWi8gwCQYHKoZIzjgEAwMvADAsAhQhNSSM8zlabyORUxYt57XPyvdIHAIUbeH9pfFcdDJ6HpkcgLHAA0XbevIxgcYwgcMCAQEwGTAOMQwwCgYDVQQDEwNERTQCByARBAQTFgUwCQYFKw4DAhoFAKBdMBgGCSqGSIb3DQEJAzELBgkqhkiG9w0BBwEwHAYJKoZIhvcNAQkFMQ8XDTEzMDQxNjA2MzIxN1owIwYJKoZIhvcNAQkEMRYEFBIhvEsDVIgM0xUWfm0T57nQPCNMMAkGByqGSM44BAMELjAsAhRurJ7srIhPd2/OqxopBS0qquyfWQIUai2Scc0so1hByGYAROotjYOOwNQ=";
		String	sapMysapred= "http://recc5.dev.ksi.co.jp:8000/sap/bc/webdynpro/sap/appl_soap_management?sap-client=902&sap-language=JA";
		try
		{
			URL	u= new URL( url );
			HttpURLConnection	http= (HttpURLConnection)u.openConnection();

			http.addRequestProperty( "sap-mysapsso", "902"+ mySapSso );
			http.addRequestProperty( "sap-mysapred", sapMysapred );
			
			int resCode= http.getResponseCode();
			String	resMsg= http.getResponseMessage();
			System.out.println( resCode +" "+ resMsg );
			
			String	contentType= http.getContentType();
			System.out.println( contentType );
			
			//	レスポンス・ヘッダーを表示する
			Map<String, List<String>> 	responseHeaders= http.getHeaderFields();
			Object[]	names= responseHeaders.keySet().toArray();
			for( int i= 0; i < names.length; i++ )
			{
				List<String>	values= responseHeaders.get( names[i] );
				for( Iterator<?> it= values.iterator(); it.hasNext(); )
				{
					System.out.println( names[i] +": "+ it.next() );
				}
			}			
			System.out.println( "----- レスポンス・ヘッダー ここまで -----" );
			
			//	レスポンス・データを表示する
			BufferedReader	in= null;
			try
			{
				in= new BufferedReader( new InputStreamReader( http.getInputStream() ) );
				String	line= in.readLine();
				while( line != null )
				{
					System.out.println( line );
					line= in.readLine();
				}
			}
			catch( Exception e )
			{
				e.printStackTrace();
			}
			finally
			{
				if( in != null )
				{
					in.close();
				}
			}
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}
		
		byte[]	dec= Base64.decodeBase64( mySapSso.getBytes() );
		StringBuffer	buf= new StringBuffer();
		for( int i= 0; i < dec.length; i++ )
		{
			String	tmp= String.valueOf( (char)dec[i] );
			//if( tmp.matches( "\\p{ASCII}*" ) )
			if( tmp.matches( MATCH_ASCII ) )
			{
				buf.append( tmp );
			}
			else if( tmp.matches( "^[\\u0000]+$" ) )
			{
				
			}
			else
			{
				int	code = dec[i] & 255;
				String prefix = "0x";
				if(code < 16)	prefix = "0x0";
				buf.append( "("+ prefix + Integer.toHexString(code) +")" );
			}
		}
		System.out.println( "---------+---------+---------+---------+---------+---------+---------+---------+---------+---------+" );
		System.out.println( buf.toString() );
		System.out.println( "---------+---------+---------+---------+---------+---------+---------+---------+---------+---------+" );
		System.out.println( new String( dec ) );
	}
	
}
