package jp.co.ksi.sap.test;
import java.util.Iterator;
import java.util.Map;

import org.apache.axis.message.SOAPHeaderElement;
import org.apache.axis.transport.http.HTTPConstants;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

import mc_style.functions.soap.sap.document.sap_com.UserGetDetailTicketBind1Stub;
import mc_style.functions.soap.sap.document.sap_com.UserGetDetailTicketService1Locator;
import mc_style.functions.soap.sap.document.sap_com.ZUserGetDetail;
import mc_style.functions.soap.sap.document.sap_com.holders.Bapiaddr3Holder;
import mc_style.functions.soap.sap.document.sap_com.holders.BapialiasHolder;
import mc_style.functions.soap.sap.document.sap_com.holders.BapidefaulHolder;
import mc_style.functions.soap.sap.document.sap_com.holders.BapilogondHolder;
import mc_style.functions.soap.sap.document.sap_com.holders.BapimoddatHolder;
import mc_style.functions.soap.sap.document.sap_com.holders.BapirefusHolder;
import mc_style.functions.soap.sap.document.sap_com.holders.BapislockdHolder;
import mc_style.functions.soap.sap.document.sap_com.holders.BapisncuHolder;
import mc_style.functions.soap.sap.document.sap_com.holders.BapiuclassHolder;
import mc_style.functions.soap.sap.document.sap_com.holders.BapiuscompHolder;
import mc_style.functions.soap.sap.document.sap_com.holders.TableOfBapiadfaxHolder;
import mc_style.functions.soap.sap.document.sap_com.holders.TableOfBapiadpagHolder;
import mc_style.functions.soap.sap.document.sap_com.holders.TableOfBapiadprtHolder;
import mc_style.functions.soap.sap.document.sap_com.holders.TableOfBapiadrfcHolder;
import mc_style.functions.soap.sap.document.sap_com.holders.TableOfBapiadrmlHolder;
import mc_style.functions.soap.sap.document.sap_com.holders.TableOfBapiadsmtpHolder;
import mc_style.functions.soap.sap.document.sap_com.holders.TableOfBapiadssfHolder;
import mc_style.functions.soap.sap.document.sap_com.holders.TableOfBapiadtelHolder;
import mc_style.functions.soap.sap.document.sap_com.holders.TableOfBapiadtlxHolder;
import mc_style.functions.soap.sap.document.sap_com.holders.TableOfBapiadttxHolder;
import mc_style.functions.soap.sap.document.sap_com.holders.TableOfBapiaduriHolder;
import mc_style.functions.soap.sap.document.sap_com.holders.TableOfBapiadx400Holder;
import mc_style.functions.soap.sap.document.sap_com.holders.TableOfBapiagrHolder;
import mc_style.functions.soap.sap.document.sap_com.holders.TableOfBapicomremHolder;
import mc_style.functions.soap.sap.document.sap_com.holders.TableOfBapigroupsHolder;
import mc_style.functions.soap.sap.document.sap_com.holders.TableOfBapiparam1Holder;
import mc_style.functions.soap.sap.document.sap_com.holders.TableOfBapiparamHolder;
import mc_style.functions.soap.sap.document.sap_com.holders.TableOfBapiprofHolder;
import mc_style.functions.soap.sap.document.sap_com.holders.TableOfBapircvsysHolder;
import mc_style.functions.soap.sap.document.sap_com.holders.TableOfBapiret2Holder;
import mc_style.functions.soap.sap.document.sap_com.holders.TableOfBapiuclasssysHolder;
import mc_style.functions.soap.sap.document.sap_com.holders.TableOfBapiusextidheadHolder;
import mc_style.functions.soap.sap.document.sap_com.holders.TableOfBapiusextidpartHolder;

/**
 * チケット認証が設定されたSOAPを呼び出す習作
 * <pre>
 * axisを使った例です。
 * チケットは、TestUserGetDetailBasic等を使って、事前に取得しておきます。
 * </pre>
 * @author kac
 * @since 2013/03/19
 * @version 2013/03/19
 */
public class TestUserGetDetailTicket1
{

	private static Logger	log= Logger.getLogger( TestUserGetDetailTicket1.class );
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{

		TableOfBapiagrHolder activitygroups= new TableOfBapiagrHolder();
		TableOfBapicomremHolder addcomrem= new TableOfBapicomremHolder();
		TableOfBapiadfaxHolder addfax= new TableOfBapiadfaxHolder();
		TableOfBapiadpagHolder addpag= new TableOfBapiadpagHolder();
		TableOfBapiadprtHolder addprt= new TableOfBapiadprtHolder();
		TableOfBapiadrfcHolder addrfc= new TableOfBapiadrfcHolder();
		TableOfBapiadrmlHolder addrml= new TableOfBapiadrmlHolder();
		TableOfBapiadsmtpHolder addsmtp= new TableOfBapiadsmtpHolder();
		TableOfBapiadssfHolder addssf= new TableOfBapiadssfHolder();
		TableOfBapiadtelHolder addtel= new TableOfBapiadtelHolder();
		TableOfBapiadtlxHolder addtlx= new TableOfBapiadtlxHolder();
		TableOfBapiadttxHolder addttx= new TableOfBapiadttxHolder();
		TableOfBapiaduriHolder adduri= new TableOfBapiaduriHolder();
		TableOfBapiadx400Holder addx400= new TableOfBapiadx400Holder();
		String cacheResults= "";
		TableOfBapiusextidheadHolder extidhead= new TableOfBapiusextidheadHolder();
		TableOfBapiusextidpartHolder extidpart= new TableOfBapiusextidpartHolder();
		TableOfBapigroupsHolder groups= new TableOfBapigroupsHolder();
		TableOfBapiparamHolder parameter= new TableOfBapiparamHolder();
		TableOfBapiparam1Holder parameter1= new TableOfBapiparam1Holder();
		TableOfBapiprofHolder profiles= new TableOfBapiprofHolder();
		TableOfBapiret2Holder _return= new TableOfBapiret2Holder();
		TableOfBapircvsysHolder systems= new TableOfBapircvsysHolder();
		TableOfBapiuclasssysHolder uclasssys= new TableOfBapiuclasssysHolder();
		String username= "4501911013";
		Bapiaddr3Holder address= new Bapiaddr3Holder();
		BapialiasHolder alias= new BapialiasHolder();
		BapiuscompHolder company= new BapiuscompHolder();
		BapidefaulHolder defaults= new BapidefaulHolder();
		BapislockdHolder islocked= new BapislockdHolder();
		BapimoddatHolder lastmodified= new BapimoddatHolder();
		BapilogondHolder logondata= new BapilogondHolder();
		BapirefusHolder refUser= new BapirefusHolder();
		BapisncuHolder snc= new BapisncuHolder();
		BapiuclassHolder uclass= new BapiuclassHolder();

		String	ssoTicket= "";
		//	UserGetDetailBasicをBasic認証で呼んだ時に返されたチケット
		ssoTicket= "AjQxMDMBABg0ADUAMAAxADkAMQAxADAAMQAzACAAIAACAAY5ADAAMgADABBSAEUANQAgACAAIAAgACAABAAYMgAwADEAMwAwADMAMQA5ADAAMQAxADcABQAEAAAACAYAAlgACQACSgD%2fA1UwggNRBgkqhkiG9w0BBwKgggNCMIIDPgIBATELMAkGBSsOAwIaBQAwCwYJKoZIhvcNAQcBoIICUzCCAk8wggIPAgcgEQQEExYFMAkGByqGSM44BAMwDjEMMAoGA1UEAxMDREU0MB4XDTExMDQwNDEzMTYwNVoXDTM4MDEwMTAwMDAwMVowDjEMMAoGA1UEAxMDREU0MIIBtzCCASwGByqGSM44BAEwggEfAoGBAP%2fxj%21B47Lr%21SRFHxMni7HS6i4UICAlsbwH5AU5bW52ST3cElPASiYkciYlKM9Dc0vcTx%21jhN1j7Dw7tp71Rpxs3t6yBY3S1CpanVCURxLjm4VBVINmRX9fJQVXFuNtpcC9dCr1IcJ4LenmSHWJgFJ%2fQsK4R8hk6GUeFYAgvsbbTAhUAjCnu6GdzaKBE1tG5z4ksen6cSAsCgYEA1oenEWTrY%2fSGknhHZAHlFQOCs7XiSHV8vdG7IgZ1Da%215iLRpZ6yiyenVwEH16ifS5epjmVuFCNFrZJbbsrQv%2119JyOfx0kHRVrDGYyZhtrmARbMpl8BEq5QvsEZbcLAft3XaaCpJozizCULViKILZWBAKx%21OsFYwGB6N0gTfXS0DgYQAAoGAW%21LcxvMveSAALvtINAMve8Ys%2fFCefVIxrV7pjdIG2UP5%21SQBhmuuMV7ITLLwURaRZKXBbIj64I6R3VgFN9MGvtADA3Wa2hX0FuqY6U40fHuGMMzuM379xBbWCT0IaFw%21MWsj1aZxk5PsGDDAYm4QWWORWvvu3PldAuEZnmLWi8gwCQYHKoZIzjgEAwMvADAsAhQhNSSM8zlabyORUxYt57XPyvdIHAIUbeH9pfFcdDJ6HpkcgLHAA0XbevIxgccwgcQCAQEwGTAOMQwwCgYDVQQDEwNERTQCByARBAQTFgUwCQYFKw4DAhoFAKBdMBgGCSqGSIb3DQEJAzELBgkqhkiG9w0BBwEwHAYJKoZIhvcNAQkFMQ8XDTEzMDMxOTAxMTc1M1owIwYJKoZIhvcNAQkEMRYEFERF%2fyfk0GBfIPv6do2dwaTiFPJ8MAkGByqGSM44BAMELzAtAhUAgHE5xeusn2pC1av7cjXPmgI0yKkCFCQkx5sugfPglm3X2qyRrdm%21y%2fBh";
		//	JCoで取得したチケット
		ssoTicket= "AjQxMDMBABg0ADUAMAAxADkAMQAxADAAMQAzACAAIAACAAY5ADAAMgADABBSAEUANQAgACAAIAAgACAABAAYMgAwADEAMwAwADMAMQA5ADAAMQA0ADEABQAEAAAACAYAAlgACQACSgD/A1QwggNQBgkqhkiG9w0BBwKgggNBMIIDPQIBATELMAkGBSsOAwIaBQAwCwYJKoZIhvcNAQcBoIICUzCCAk8wggIPAgcgEQQEExYFMAkGByqGSM44BAMwDjEMMAoGA1UEAxMDREU0MB4XDTExMDQwNDEzMTYwNVoXDTM4MDEwMTAwMDAwMVowDjEMMAoGA1UEAxMDREU0MIIBtzCCASwGByqGSM44BAEwggEfAoGBAP/xj!B47Lr!SRFHxMni7HS6i4UICAlsbwH5AU5bW52ST3cElPASiYkciYlKM9Dc0vcTx!jhN1j7Dw7tp71Rpxs3t6yBY3S1CpanVCURxLjm4VBVINmRX9fJQVXFuNtpcC9dCr1IcJ4LenmSHWJgFJ/QsK4R8hk6GUeFYAgvsbbTAhUAjCnu6GdzaKBE1tG5z4ksen6cSAsCgYEA1oenEWTrY/SGknhHZAHlFQOCs7XiSHV8vdG7IgZ1Da!5iLRpZ6yiyenVwEH16ifS5epjmVuFCNFrZJbbsrQv!19JyOfx0kHRVrDGYyZhtrmARbMpl8BEq5QvsEZbcLAft3XaaCpJozizCULViKILZWBAKx!OsFYwGB6N0gTfXS0DgYQAAoGAW!LcxvMveSAALvtINAMve8Ys/FCefVIxrV7pjdIG2UP5!SQBhmuuMV7ITLLwURaRZKXBbIj64I6R3VgFN9MGvtADA3Wa2hX0FuqY6U40fHuGMMzuM379xBbWCT0IaFw!MWsj1aZxk5PsGDDAYm4QWWORWvvu3PldAuEZnmLWi8gwCQYHKoZIzjgEAwMvADAsAhQhNSSM8zlabyORUxYt57XPyvdIHAIUbeH9pfFcdDJ6HpkcgLHAA0XbevIxgcYwgcMCAQEwGTAOMQwwCgYDVQQDEwNERTQCByARBAQTFgUwCQYFKw4DAhoFAKBdMBgGCSqGSIb3DQEJAzELBgkqhkiG9w0BBwEwHAYJKoZIhvcNAQkFMQ8XDTEzMDMxOTAxNDEwNlowIwYJKoZIhvcNAQkEMRYEFDiNgsOUgLL/SnIhnXmPvcbhkZ0DMAkGByqGSM44BAMELjAsAhROXxYL7dIuiuqwRmhAWI0Uw4wowgIUKigAak3m08!K4PTTld7mBfLrlMc=";
		//	別のクライアントで取得したチケット
//		ssoTicket= "AjQxMDMBABg0ADUAMAAxADkAMQAxADAAMQAzACAAIAACAAY5ADAAMgADABBSAEUANQAgACAAIAAgACAABAAYMgAwADEAMwAwADMAMQA4ADAANwAxADcABQAEAAAACAYAAlgACQACSgD/A1QwggNQBgkqhkiG9w0BBwKgggNBMIIDPQIBATELMAkGBSsOAwIaBQAwCwYJKoZIhvcNAQcBoIICUzCCAk8wggIPAgcgEQQEExYFMAkGByqGSM44BAMwDjEMMAoGA1UEAxMDREU0MB4XDTExMDQwNDEzMTYwNVoXDTM4MDEwMTAwMDAwMVowDjEMMAoGA1UEAxMDREU0MIIBtzCCASwGByqGSM44BAEwggEfAoGBAP/xj!B47Lr!SRFHxMni7HS6i4UICAlsbwH5AU5bW52ST3cElPASiYkciYlKM9Dc0vcTx!jhN1j7Dw7tp71Rpxs3t6yBY3S1CpanVCURxLjm4VBVINmRX9fJQVXFuNtpcC9dCr1IcJ4LenmSHWJgFJ/QsK4R8hk6GUeFYAgvsbbTAhUAjCnu6GdzaKBE1tG5z4ksen6cSAsCgYEA1oenEWTrY/SGknhHZAHlFQOCs7XiSHV8vdG7IgZ1Da!5iLRpZ6yiyenVwEH16ifS5epjmVuFCNFrZJbbsrQv!19JyOfx0kHRVrDGYyZhtrmARbMpl8BEq5QvsEZbcLAft3XaaCpJozizCULViKILZWBAKx!OsFYwGB6N0gTfXS0DgYQAAoGAW!LcxvMveSAALvtINAMve8Ys/FCefVIxrV7pjdIG2UP5!SQBhmuuMV7ITLLwURaRZKXBbIj64I6R3VgFN9MGvtADA3Wa2hX0FuqY6U40fHuGMMzuM379xBbWCT0IaFw!MWsj1aZxk5PsGDDAYm4QWWORWvvu3PldAuEZnmLWi8gwCQYHKoZIzjgEAwMvADAsAhQhNSSM8zlabyORUxYt57XPyvdIHAIUbeH9pfFcdDJ6HpkcgLHAA0XbevIxgcYwgcMCAQEwGTAOMQwwCgYDVQQDEwNERTQCByARBAQTFgUwCQYFKw4DAhoFAKBdMBgGCSqGSIb3DQEJAzELBgkqhkiG9w0BBwEwHAYJKoZIhvcNAQkFMQ8XDTEzMDMxODA3MTcwNFowIwYJKoZIhvcNAQkEMRYEFIDDv!gouw3zjq02qZ2MFUc1kyQFMAkGByqGSM44BAMELjAsAhQe!sNTQRq0KRTRvRVuVnm3IOAJcgIUK6UYSoZ9n3iPD!!R/zUOrU4tjLU=";

		try
		{
			//	locatorを生成し、サービスを取得する
			UserGetDetailTicketService1Locator	locator= new UserGetDetailTicketService1Locator();
			ZUserGetDetail	zUserGetDetail= locator.getUserGetDetailTicketBind1();
			
			if( zUserGetDetail instanceof UserGetDetailTicketBind1Stub )
			{//	スタブがあるなら、認証情報を付加する
				UserGetDetailTicketBind1Stub	stub= (UserGetDetailTicketBind1Stub)zUserGetDetail;
				stub.setMaintainSession( true );	//	2013/03/19 Kac cookieを使うには、これが要る!!
				//	チケットをcookieにセットする
				stub._setProperty( HTTPConstants.HEADER_COOKIE, "MYSAPSSO2="+ ssoTicket );

				//	KacDebug
				SOAPHeaderElement[]	elements= stub.getHeaders();
				log.debug( "stub.getHeaders().length="+ elements.length );
				for( int i= 0; i < elements.length; i++ )
				{
					log.debug( elements[i] );
				}
				
			}
			
			//	サービスメソッドを実行する
			zUserGetDetail.userGetDetail( activitygroups, addcomrem, addfax, addpag, addprt, addrfc,
					addrml, addsmtp, addssf, addtel, addtlx, addttx, adduri, addx400, cacheResults, extidhead,
					extidpart, groups, parameter, parameter1, profiles, _return, systems, uclasssys, username,
					address, alias, company, defaults, islocked, lastmodified, logondata, refUser, snc, uclass );
			
			//	結果を表示する(addressの中身を表示してみる)
			log.info( "address.fullname="+ address.value.getFullname() );
			log.info( "address.city="+ address.value.getCity() );
			log.info( "address.postlCod1="+ address.value.getPostlCod1() );
			log.info( "address.addrNo="+ address.value.getAddrNo() );

//			Map<?,?>	m= BeanUtils.describe( address.value );
//			for( Iterator<?> i= m.keySet().iterator(); i.hasNext(); )
//			{
//				Object	key= i.next();
//				log.info( "address: "+ key +"="+ m.get( key ) );
//			}

		} catch (Exception e) {

			log.error( "", e );
			System.out.println( "tomcat.home="+ System.getProperty( "tomcat.home" ) );
			System.out.println( "user.home="+ System.getProperty( "user.home" ) );
			System.out.println( "user.dir="+ System.getProperty( "user.dir" ) );
		}


	}

}
