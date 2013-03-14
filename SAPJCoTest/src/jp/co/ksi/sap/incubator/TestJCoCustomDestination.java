package jp.co.ksi.sap.incubator;

import java.util.Properties;

import com.sap.conn.jco.JCoContext;
import com.sap.conn.jco.JCoCustomDestination;
import com.sap.conn.jco.JCoCustomDestination.UserData;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;
import com.sap.conn.jco.JCoException;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoParameterList;
import com.sap.conn.jco.ext.Environment;

/**
 * JCoCustomDestination の習作
 * ユーザを個別に指定してBAPIを呼び出す。
 * @author kac
 * @since 2013/03/12
 * @version 2013/03/13
 */
public class TestJCoCustomDestination
{

	/**
	 * @param args
	 */
	public static void main( String[] args )
	{
		UserDestinationDataProvider	provider= new UserDestinationDataProvider();
		
		try
		{
			Environment.registerDestinationDataProvider( provider );
			
//			JCoDestination	destination= JCoDestinationManager.getDestination( "133.253.62.89:00:903:4501981027B:makoto321" );
			JCoDestination	destination= JCoDestinationManager.getDestination( "133.253.62.89:00:903:hoge:huga" );
			
			System.out.println( "RepositoryUser"+ destination.getRepositoryUser() );
			JCoFunction	function= destination.getRepository().getFunction( "BAPI_USER_GET_DETAIL" );
			System.out.println( function );
			JCoParameterList	importList= function.getImportParameterList();
			importList.setValue( "USERNAME", "4501911013" );
			function.execute( destination );
			
			System.out.println( "----------" );
			
			JCoCustomDestination	custom= destination.createCustomDestination();
			UserData	userData= custom.getUserLogonData();
			String ssoTicket= "AjQxMDMBABg0ADUAMAAxADkAMQAxADAAMQAzACAAIAACAAY5ADAAMwADABBSAEUANAAgACAAIAAgACAABAAYMgAwADEAMwAwADMAMQAyADAANQAyADcABQAEAAAACAYAAlgACQACSgD/A1YwggNSBgkqhkiG9w0BBwKgggNDMIIDPwIBATELMAkGBSsOAwIaBQAwCwYJKoZIhvcNAQcBoIICVDCCAlAwggIPAgcgEQUmIDREMAkGByqGSM44BAMwDjEMMAoGA1UEAxMDUkU0MB4XDTExMDUyNjIwMzQ0NFoXDTM4MDEwMTAwMDAwMVowDjEMMAoGA1UEAxMDUkU0MIIBtzCCASsGByqGSM44BAEwggEeAoGBAP!/M0mJ4InoCEj41g0Mzrc96VuolQtSrRFVAAf0SMXIG9LBwlzsCoUU77/uN!CPqM!e23dvae/KeaJIq3/vdPUTiHhvGZT9yzcovjwrFNryAlVC2ZorQO9RPT3ujGFfKYzM235CLq9tsrBf!TXi8HYAfwvwxw0aB8osaG0DFI5nAhUA9CWNcGjLi9DXEZJIym/kn/QfIlUCgYBx16kMUW!soXSrmjGauqh3snYYX0v!/OaqFas0xr1dReT6VeOUwaoazu5aNcTU4BfPBc0/FGyrZgJgwvKc5OQ3V9GEnT3fuLQCAlun1TzulMwL409nO21FXL/1HvaE2InEqrWQoul2QUtzb!3MjHT8grg/kWdKyVhWaTs/vNav!gOBhQACgYEAkBvZkUYG2hSNp/pF2PjaqPJXZESiA1rPVzEmNDvmFTo04H9zK030SOUiDwYfwrXsnvHNJMlyxm6ek8G4a0F2cFIKOlYzxNQm5fHeqT4PR9eQX3r6Ni4ggjo9EDLs0bv17wuUh/1VDvYrRSHhxkRqrkxxuM867MiY3GsTTAg0xNswCQYHKoZIzjgEAwMwADAtAhUAh62GFVv!UBCPn6fR0/xZUEC97X0CFCq0/7iEoCJ92IoVx50gXGZ0qeUPMYHHMIHEAgEBMBkwDjEMMAoGA1UEAxMDUkU0AgcgEQUmIDREMAkGBSsOAwIaBQCgXTAYBgkqhkiG9w0BCQMxCwYJKoZIhvcNAQcBMBwGCSqGSIb3DQEJBTEPFw0xMzAzMTIwNTI3MjlaMCMGCSqGSIb3DQEJBDEWBBQvzYUU4/qCIRDZav7QzMAVauOoFDAJBgcqhkjOOAQDBC8wLQIUF6TkGCswuk!nSHqXxwKzpB3QsvkCFQCGhR2aLM1U7DtxtCOe3NQSQrPiWQ==";
				   ssoTicket= "AjQxMDMBABg0ADUAMAAxADkAMQAxADAAMQAzACAAIAACAAY5ADAAMwADABBSAEUANAAgACAAIAAgACAABAAYMgAwADEAMwAwADMAMQAzADAANAAxADIABQAEAAAACAYAAlgACQACSgD/A1UwggNRBgkqhkiG9w0BBwKgggNCMIIDPgIBATELMAkGBSsOAwIaBQAwCwYJKoZIhvcNAQcBoIICVDCCAlAwggIPAgcgEQUmIDREMAkGByqGSM44BAMwDjEMMAoGA1UEAxMDUkU0MB4XDTExMDUyNjIwMzQ0NFoXDTM4MDEwMTAwMDAwMVowDjEMMAoGA1UEAxMDUkU0MIIBtzCCASsGByqGSM44BAEwggEeAoGBAP!/M0mJ4InoCEj41g0Mzrc96VuolQtSrRFVAAf0SMXIG9LBwlzsCoUU77/uN!CPqM!e23dvae/KeaJIq3/vdPUTiHhvGZT9yzcovjwrFNryAlVC2ZorQO9RPT3ujGFfKYzM235CLq9tsrBf!TXi8HYAfwvwxw0aB8osaG0DFI5nAhUA9CWNcGjLi9DXEZJIym/kn/QfIlUCgYBx16kMUW!soXSrmjGauqh3snYYX0v!/OaqFas0xr1dReT6VeOUwaoazu5aNcTU4BfPBc0/FGyrZgJgwvKc5OQ3V9GEnT3fuLQCAlun1TzulMwL409nO21FXL/1HvaE2InEqrWQoul2QUtzb!3MjHT8grg/kWdKyVhWaTs/vNav!gOBhQACgYEAkBvZkUYG2hSNp/pF2PjaqPJXZESiA1rPVzEmNDvmFTo04H9zK030SOUiDwYfwrXsnvHNJMlyxm6ek8G4a0F2cFIKOlYzxNQm5fHeqT4PR9eQX3r6Ni4ggjo9EDLs0bv17wuUh/1VDvYrRSHhxkRqrkxxuM867MiY3GsTTAg0xNswCQYHKoZIzjgEAwMwADAtAhUAh62GFVv!UBCPn6fR0/xZUEC97X0CFCq0/7iEoCJ92IoVx50gXGZ0qeUPMYHGMIHDAgEBMBkwDjEMMAoGA1UEAxMDUkU0AgcgEQUmIDREMAkGBSsOAwIaBQCgXTAYBgkqhkiG9w0BCQMxCwYJKoZIhvcNAQcBMBwGCSqGSIb3DQEJBTEPFw0xMzAzMTMwNDEyNDJaMCMGCSqGSIb3DQEJBDEWBBQIVEm5obs5HIqAQ6G1fwM96koXfDAJBgcqhkjOOAQDBC4wLAIUaVEa8LRHFzqzsDS9jJmlRE7Hhh4CFFSAB!9FwN/FSh7mMZ8fYFYvHzCD";

			userData.setSSOTicket( ssoTicket );
			userData.setUser( "4501911013" );
//			userData.setPassword( "password25" );
			
			JCoContext.begin( custom );	//	カスタム開始
			
			System.out.println( "RepositoryUser="+ custom.getRepositoryUser() );
			Properties	props= custom.getProperties();
			props.list( System.out );
			
			function= custom.getRepository().getFunction( "BAPI_USER_GET_DETAIL" );
			System.out.println( function );
			importList= function.getImportParameterList();
			importList.setValue( "USERNAME", "4501911013" );
			function.execute( custom );
			JCoParameterList	exportList= function.getExportParameterList();
			System.out.println( exportList.getValue( "ADDRESS" ) );
			
			JCoContext.end( custom );	//	カスタム終了
			
		}
		catch( JCoException e )
		{
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		finally
		{
			if( Environment.isDestinationDataProviderRegistered() )
			{
				Environment.unregisterDestinationDataProvider( provider );
			}
		}

	}

}
