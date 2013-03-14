package jp.co.ksi.sap.incubator;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.sap.conn.jco.JCoCustomDestination;
import com.sap.conn.jco.JCoCustomDestination.UserData;
import com.sap.conn.jco.JCoContext;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;
import com.sap.conn.jco.JCoException;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoParameterList;
import com.sap.conn.jco.JCoTable;
import com.sap.conn.jco.ext.DestinationDataProvider;
import com.sap.conn.jco.ext.Environment;

/**
 * SSOTicketの習作
 * @author kac
 * @since 2013/01/08
 * @version 2013/03/13
 * <pre>
 * [2013/03/13]
 * SSOTicketを取得する。
 * 　destinationのプロパティjco.client.getsso に 1 をセットする為に、DestinationDataProviderを拡張する。
 * 
 * </pre>
 */
public class TestSSOTicket
{
	private static Logger	log= Logger.getLogger( TestSSOTicket.class );

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		
		DestinationDataProvider	ddProvider= new SSODestinationDataProvider();
		
		String uid= "4501911013";
		String pwd= "password25";
		String	ssoTicket= "";
		String	functionName= "BAPI_USER_GET_DETAIL";
		
		try
		{
			if( !Environment.isDestinationDataProviderRegistered() )
			{
				Environment.registerDestinationDataProvider( ddProvider );
			}

			//	GETSSO2を指定する
//			JCoDestination	destination= JCoDestinationManager.getDestination( "GETSSO2:133.253.62.89:00:903:hoge:huga:" );
			JCoDestination	destination= JCoDestinationManager.getDestination( "GETSSO2:172.16.98.214:00:902:hoge:huga:" );
			debugDestination( destination );
			
			//	CustomDstinationを使って、uid/pwdをセットする
			JCoCustomDestination	custom= destination.createCustomDestination();
			UserData	userData= custom.getUserLogonData();
			userData.setUser( uid );
			userData.setPassword( pwd );
			custom.getProperties().list( System.out );
			
			try
			{
				JCoContext.begin( custom );
				
				//	ssoチケットを取得する
				ssoTicket= custom.getAttributes().getSSOTicket();
				
				System.out.println( ssoTicket );
			}
			catch( Exception e )
			{
				e.printStackTrace();
			}
			finally
			{
				JCoContext.end( custom );
			}

			//	ssoチケットで認証してみる
			destination= JCoDestinationManager.getDestination( ":133.253.62.89:00:903:"+ "4501981027B" +":"+ "makoto321" );
			debugDestination( destination );
			
			//	CustomDstinationを使って、uid/ssoTicketをセットする
			custom= destination.createCustomDestination();
			userData= custom.getUserLogonData();
			userData.setUser( "4501021010" );	//	別のユーザにしてみる
			userData.setSSOTicket( ssoTicket );
			
			custom.getProperties().list( System.out );
			log.debug( userData );
			
			try
			{
				JCoContext.begin( custom );
				
				//	受注登録処理
				JCoFunction	function= custom.getRepository().getFunction( "BAPI_SALESORDER_CREATEFROMDAT2" );
				JCoFunction	commitfunc= custom.getRepository().getFunction( "BAPI_TRANSACTION_COMMIT" );
				
				function.getImportParameterList().getStructure("ORDER_HEADER_IN").setValue("DOC_TYPE","SO");
				function.getImportParameterList().getStructure("ORDER_HEADER_IN").setValue("SALES_ORG","SALE");
				function.getImportParameterList().getStructure("ORDER_HEADER_IN").setValue("DISTR_CHAN","01");
				function.getImportParameterList().getStructure("ORDER_HEADER_IN").setValue("DIVISION","01");
				function.getImportParameterList().getStructure("ORDER_HEADER_IN").setValue("PMNTTRMS","0001");
				function.getImportParameterList().getStructure("ORDER_HEADER_IN").setValue("PURCH_NO_C","888888");

				function.getImportParameterList().getStructure("ORDER_HEADER_INX").setValue("UPDATEFLAG","I");
				function.getImportParameterList().getStructure("ORDER_HEADER_INX").setValue("DOC_TYPE","X");
				function.getImportParameterList().getStructure("ORDER_HEADER_INX").setValue("SALES_ORG","X");
				function.getImportParameterList().getStructure("ORDER_HEADER_INX").setValue("DISTR_CHAN","X");
				function.getImportParameterList().getStructure("ORDER_HEADER_INX").setValue("DIVISION","X");
				function.getImportParameterList().getStructure("ORDER_HEADER_INX").setValue("PMNTTRMS","X");
				function.getImportParameterList().getStructure("ORDER_HEADER_INX").setValue("PURCH_NO_C","X");


				/*　得意先コードを入力 */
				function.getTableParameterList().getTable("ORDER_PARTNERS").appendRow();
				function.getTableParameterList().getTable("ORDER_PARTNERS").setValue("PARTN_ROLE","AG");
				function.getTableParameterList().getTable("ORDER_PARTNERS").setValue("PARTN_NUMB","0000000039");


				/* 明細の品番入力 */
				function.getTableParameterList().getTable("ORDER_ITEMS_IN").appendRow();
				function.getTableParameterList().getTable("ORDER_ITEMS_IN").setValue("ITM_NUMBER","000010");
				function.getTableParameterList().getTable("ORDER_ITEMS_IN").setValue("MATERIAL","M01");
				function.getTableParameterList().getTable("ORDER_ITEMS_IN").setValue("TARGET_QTY",1);
				function.getTableParameterList().getTable("ORDER_ITEMS_IN").setValue("PLANT","PLNT");
				function.getTableParameterList().getTable("ORDER_ITEMS_IN").setValue("SHIP_POINT","0001");
				function.getTableParameterList().getTable("ORDER_ITEMS_IN").setValue("STORE_LOC","0001");
				function.getTableParameterList().getTable("ORDER_ITEMS_IN").setValue("PO_DAT_S","20130331");


				function.getTableParameterList().getTable("ORDER_ITEMS_INX").appendRow();
				function.getTableParameterList().getTable("ORDER_ITEMS_INX").setValue("UPDATEFLAG","I");
				function.getTableParameterList().getTable("ORDER_ITEMS_INX").setValue("ITM_NUMBER","000010");
				function.getTableParameterList().getTable("ORDER_ITEMS_INX").setValue("MATERIAL","X");
				function.getTableParameterList().getTable("ORDER_ITEMS_INX").setValue("TARGET_QTY","X");
				function.getTableParameterList().getTable("ORDER_ITEMS_INX").setValue("PLANT","X");
				function.getTableParameterList().getTable("ORDER_ITEMS_INX").setValue("SHIP_POINT","X");
				function.getTableParameterList().getTable("ORDER_ITEMS_INX").setValue("STORE_LOC","X");
				function.getTableParameterList().getTable("ORDER_ITEMS_INX").setValue("PO_DAT_S","X");


				/* スケジュール入力 */
				function.getTableParameterList().getTable("ORDER_SCHEDULES_IN").appendRow();
				function.getTableParameterList().getTable("ORDER_SCHEDULES_IN").setValue("ITM_NUMBER","000010");
				function.getTableParameterList().getTable("ORDER_SCHEDULES_IN").setValue("SCHED_LINE","0001");
				function.getTableParameterList().getTable("ORDER_SCHEDULES_IN").setValue("REQ_DATE","20130331");
				function.getTableParameterList().getTable("ORDER_SCHEDULES_IN").setValue("REQ_QTY","1");

				function.getTableParameterList().getTable("ORDER_SCHEDULES_INX").appendRow();
				function.getTableParameterList().getTable("ORDER_SCHEDULES_INX").setValue("UPDATEFLAG","I");
				function.getTableParameterList().getTable("ORDER_SCHEDULES_INX").setValue("ITM_NUMBER","000010");
				function.getTableParameterList().getTable("ORDER_SCHEDULES_INX").setValue("SCHED_LINE","0001");
				function.getTableParameterList().getTable("ORDER_SCHEDULES_INX").setValue("REQ_DATE","X");
				function.getTableParameterList().getTable("ORDER_SCHEDULES_INX").setValue("REQ_QTY","X");


				/* 条件（金額設定）入力 */
				function.getTableParameterList().getTable("ORDER_CONDITIONS_IN").appendRow();
				function.getTableParameterList().getTable("ORDER_CONDITIONS_IN").setValue("ITM_NUMBER","000010");
//				function.getTableParameterList().getTable("ORDER_CONDITIONS_IN").setValue("SCHED_LINE",1);
				function.getTableParameterList().getTable("ORDER_CONDITIONS_IN").setValue("COND_ST_NO","001");
				function.getTableParameterList().getTable("ORDER_CONDITIONS_IN").setValue("COND_TYPE","PR00");			/*金額*/
				function.getTableParameterList().getTable("ORDER_CONDITIONS_IN").setValue("COND_VALUE","500");			/*金額*/
				function.getTableParameterList().getTable("ORDER_CONDITIONS_IN").setValue("COND_P_UNT","001");
				
				function.getTableParameterList().getTable("ORDER_CONDITIONS_INX").appendRow();
				function.getTableParameterList().getTable("ORDER_CONDITIONS_INX").setValue("UPDATEFLAG","I");
				function.getTableParameterList().getTable("ORDER_CONDITIONS_INX").setValue("ITM_NUMBER","000010");
//				function.getTableParameterList().getTable("ORDER_CONDITIONS_INX").setValue("SCHED_LINE","X");
				function.getTableParameterList().getTable("ORDER_CONDITIONS_INX").setValue("COND_ST_NO","001");
				function.getTableParameterList().getTable("ORDER_CONDITIONS_INX").setValue("COND_TYPE","X");			/*金額*/
				function.getTableParameterList().getTable("ORDER_CONDITIONS_INX").setValue("COND_VALUE","X");
				function.getTableParameterList().getTable("ORDER_CONDITIONS_INX").setValue("COND_P_UNT","X");

				//	実行
				function.execute( custom );
			
	//項目GET
//				getFieldInfo(function.getTableParameterList().getTable("FIELDS"));
			
	//データGET			   
				JCoTable tableList = function.getTableParameterList().getTable("RETURN");
				for (int i = 0; i < tableList.getNumRows(); i++)
				{
					tableList.setRow(i);
					System.out.println( tableList.getString("TYPE")
							+ tableList.getString("NUMBER")
							+ " : "
					        + tableList.getString("MESSAGE") );
				}
				System.out.println("SALESDOCMENT = " + function.getExportParameterList().getValue("SALESDOCUMENT"));
				if( function.getExportParameterList().getValue("SALESDOCUMENT") != null )
				{//	コミット処理
					commitfunc.execute( custom );
					log.debug( "---- commit ----" );
				}
				
			}
			catch( Exception e )
			{
				e.printStackTrace();
			}
			finally
			{
				JCoContext.end( custom );
				log.debug( "---- end ----" );
			}
		}
		catch( Exception e )
		{
			log.error( e.toString(), e );
		}
		finally
		{
			if( Environment.isDestinationDataProviderRegistered() )
			{
				Environment.unregisterDestinationDataProvider( ddProvider );
			}
		}

	}

	private static void debugDestination( JCoDestination destination )
			throws JCoException
	{
		Properties	props= destination.getProperties();
		String[]	names= new String[props.size()];
		names= props.keySet().toArray( names );
		java.util.Arrays.sort( names );
		for( int i= 0; i < names.length; i++ )
		{
			log.debug( "[Properties] "+ names[i] +"="+ props.getProperty( names[i] ) );
		}
		//	destinationはBeanUtilsが使えない(トホホ)
		log.debug( "AliasUser="+ destination.getAliasUser() );
		log.debug( "ApplicationServerHost="+ destination.getApplicationServerHost() );
		log.debug( "Client="+ destination.getClient() );
		log.debug( "DestinationID="+ destination.getDestinationID() );
		log.debug( "DestinationName="+ destination.getDestinationName() );
		log.debug( "ExpirationCheckPeriod="+ destination.getExpirationCheckPeriod() );
		log.debug( "ExpirationTime="+ destination.getExpirationTime() );
		log.debug( "ExternalIDData="+ destination.getExternalIDData() );
		log.debug( "ExternalIDType="+ destination.getExternalIDType() );
		log.debug( "GatewayHost="+ destination.getGatewayHost() );
		log.debug( "GatewayService="+ destination.getGatewayService() );
		log.debug( "Language="+ destination.getLanguage() );
		log.debug( "LogonCheck="+ destination.getLogonCheck() );
		log.debug( "LogonGroup="+ destination.getLogonGroup() );
		log.debug( "MaxGetClientTime="+ destination.getMaxGetClientTime() );
		log.debug( "MessageServerHost="+ destination.getMessageServerHost() );
		log.debug( "MessageServerService="+ destination.getMessageServerService() );
		log.debug( "PeakLimit="+ destination.getPeakLimit() );
		log.debug( "PoolCapacity="+ destination.getPoolCapacity() );
		log.debug( "R3Name="+ destination.getR3Name() );
		log.debug( "RepositoryUser="+ destination.getRepositoryUser() );
		log.debug( "SAPRouterString="+ destination.getSAPRouterString() );
		log.debug( "SncLibrary="+ destination.getSncLibrary() );
		log.debug( "SncMode="+ destination.getSncMode() );
		log.debug( "SncMyName="+ destination.getSncMyName() );
		log.debug( "SncPartnerName="+ destination.getSncPartnerName() );
		log.debug( "SncQOP="+ destination.getSncQOP() );
		log.debug( "SncSSO="+ destination.getSncSSO() );
		log.debug( "SystemNumber="+ destination.getSystemNumber() );
		log.debug( "TPHost="+ destination.getTPHost() );
		log.debug( "Type="+ destination.getType() );
		log.debug( "User="+ destination.getUser() );
		log.debug( "Class="+ destination.getClass() );
		
//		log.debug( "attributes="+ destination.getAttributes() );
	}

}
