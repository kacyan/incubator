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
import com.sap.conn.jco.JCoStructure;
import com.sap.conn.jco.JCoTable;
import com.sap.conn.jco.ext.DestinationDataProvider;
import com.sap.conn.jco.ext.Environment;

/**
 * SSOTicketの習作
 * @author kac
 * @since 2013/01/08
 * @version 2013/03/15
 * <pre>
 * [2013/03/15]
 * 
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
		
		String destinationString= "";
		String uid= "";
		String pwd= "";
		if( args.length > 0 )
		{
			destinationString= args[0];
		}
		if( args.length > 1 )
		{
			uid= args[1];
		}
		if( args.length > 2 )
		{
			pwd= args[2];
		}
		String	ssoTicket1= "";
		String	ssoTicket2= "";
		
		try
		{
			if( !Environment.isDestinationDataProviderRegistered() )
			{
				Environment.registerDestinationDataProvider( ddProvider );
			}

			//	GETSSO2を指定する
			JCoDestination	destination= JCoDestinationManager.getDestination( "GETSSO2"+ destinationString );
			debugDestination( destination );
			ssoTicket1= destination.getAttributes().getSSOTicket();
			log.info( ssoTicket1 );
			
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
				ssoTicket2= custom.getAttributes().getSSOTicket();
				
				if( ssoTicket2 == null )
				{
					throw new Exception( "GETSSO2 failed. ssoTicket null." );
				}
				log.info( ssoTicket2 );
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
			destination= JCoDestinationManager.getDestination( destinationString );
			debugDestination( destination );
			
			//	CustomDstinationを使って、uid/ssoTicketをセットする
			custom= destination.createCustomDestination();
			userData= custom.getUserLogonData();
			userData.setUser( "4501021010" );	//	別のユーザにしてみる -> 結果はssoTicketのユーザが優先された。
//			userData.setSSOTicket( ssoTicket1 );	//	ベースユーザのチケットを使う(更新権限なし)
			userData.setSSOTicket( ssoTicket2 );
			
			custom.getProperties().list( System.out );
			log.debug( userData );
			
			try
			{
				JCoContext.begin( custom );
				log.debug( "---- start ----" );

				custom.ping();
				log.info( "ping ok!" );
				
				//	受注登録処理
				JCoFunction	function= custom.getRepository().getFunction( "BAPI_SALESORDER_CREATEFROMDAT2" );
				JCoFunction	commitfunc= custom.getRepository().getFunction( "BAPI_TRANSACTION_COMMIT" );
				
				JCoStructure orderHeaderIn= function.getImportParameterList().getStructure("ORDER_HEADER_IN");
				orderHeaderIn.setValue("DOC_TYPE","SO");
				orderHeaderIn.setValue("SALES_ORG","SALE");
				orderHeaderIn.setValue("DISTR_CHAN","01");
				orderHeaderIn.setValue("DIVISION","01");
				orderHeaderIn.setValue("PMNTTRMS","0001");
				orderHeaderIn.setValue("PURCH_NO_C","888888");

				JCoStructure orderHeaderInx= function.getImportParameterList().getStructure("ORDER_HEADER_INX");
				orderHeaderInx.setValue("UPDATEFLAG","I");
				orderHeaderInx.setValue("DOC_TYPE","X");
				orderHeaderInx.setValue("SALES_ORG","X");
				orderHeaderInx.setValue("DISTR_CHAN","X");
				orderHeaderInx.setValue("DIVISION","X");
				orderHeaderInx.setValue("PMNTTRMS","X");
				orderHeaderInx.setValue("PURCH_NO_C","X");

				/*　得意先コードを入力 */
				JCoTable orderPartners= function.getTableParameterList().getTable("ORDER_PARTNERS");
				orderPartners.appendRow();
				orderPartners.setValue("PARTN_ROLE","AG");
				orderPartners.setValue("PARTN_NUMB","0000000039");

				/* 明細の品番入力 */
				JCoTable orderItemsIn= function.getTableParameterList().getTable("ORDER_ITEMS_IN");
				orderItemsIn.appendRow();
				orderItemsIn.setValue("ITM_NUMBER","000010");
				orderItemsIn.setValue("MATERIAL","M01");
				orderItemsIn.setValue("TARGET_QTY",1);
				orderItemsIn.setValue("PLANT","PLNT");
				orderItemsIn.setValue("SHIP_POINT","0001");
				orderItemsIn.setValue("STORE_LOC","0001");
				orderItemsIn.setValue("PO_DAT_S","20130331");

				JCoTable orderItemsInx= function.getTableParameterList().getTable("ORDER_ITEMS_INX");
				orderItemsInx.appendRow();
				orderItemsInx.setValue("UPDATEFLAG","I");
				orderItemsInx.setValue("ITM_NUMBER","000010");
				orderItemsInx.setValue("MATERIAL","X");
				orderItemsInx.setValue("TARGET_QTY","X");
				orderItemsInx.setValue("PLANT","X");
				orderItemsInx.setValue("SHIP_POINT","X");
				orderItemsInx.setValue("STORE_LOC","X");
				orderItemsInx.setValue("PO_DAT_S","X");

				/* スケジュール入力 */
				JCoTable orderSchedulesIn= function.getTableParameterList().getTable("ORDER_SCHEDULES_IN");
				orderSchedulesIn.appendRow();
				orderSchedulesIn.setValue("ITM_NUMBER","000010");
				orderSchedulesIn.setValue("SCHED_LINE","0001");
				orderSchedulesIn.setValue("REQ_DATE","20130331");
				orderSchedulesIn.setValue("REQ_QTY","1");

				JCoTable orderSchedulesInx= function.getTableParameterList().getTable("ORDER_SCHEDULES_INX");
				orderSchedulesInx.appendRow();
				orderSchedulesInx.setValue("UPDATEFLAG","I");
				orderSchedulesInx.setValue("ITM_NUMBER","000010");
				orderSchedulesInx.setValue("SCHED_LINE","0001");
				orderSchedulesInx.setValue("REQ_DATE","X");
				orderSchedulesInx.setValue("REQ_QTY","X");

				/* 条件（金額設定）入力 */
				JCoTable orderConditionsIn= function.getTableParameterList().getTable("ORDER_CONDITIONS_IN");
				orderConditionsIn.appendRow();
				orderConditionsIn.setValue("ITM_NUMBER","000010");
//				function.getTableParameterList().getTable("ORDER_CONDITIONS_IN").setValue("SCHED_LINE",1);
				orderConditionsIn.setValue("COND_ST_NO","001");
				orderConditionsIn.setValue("COND_TYPE","PR00");			/*金額*/
				orderConditionsIn.setValue("COND_VALUE","500");			/*金額*/
				orderConditionsIn.setValue("COND_P_UNT","001");
				
				JCoTable orderConditionsInx= function.getTableParameterList().getTable("ORDER_CONDITIONS_INX");
				orderConditionsInx.appendRow();
				orderConditionsInx.setValue("UPDATEFLAG","I");
				orderConditionsInx.setValue("ITM_NUMBER","000010");
//				function.getTableParameterList().getTable("ORDER_CONDITIONS_INX").setValue("SCHED_LINE","X");
				orderConditionsInx.setValue("COND_ST_NO","001");
				orderConditionsInx.setValue("COND_TYPE","X");			/*金額*/
				orderConditionsInx.setValue("COND_VALUE","X");
				orderConditionsInx.setValue("COND_P_UNT","X");

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
