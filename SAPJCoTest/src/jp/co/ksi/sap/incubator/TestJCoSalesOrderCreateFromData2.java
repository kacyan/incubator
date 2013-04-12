package jp.co.ksi.sap.incubator;

import java.util.Iterator;
import java.util.Locale;

import org.apache.log4j.Logger;

import com.sap.conn.jco.JCoContext;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;
import com.sap.conn.jco.JCoField;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoListMetaData;
import com.sap.conn.jco.JCoParameterList;
import com.sap.conn.jco.JCoRepository;
import com.sap.conn.jco.JCoStructure;
import com.sap.conn.jco.JCoTable;
import com.sap.conn.jco.ext.Environment;

/**
 * BAPI_SALESORDER_CREATEFROMDAT2の習作
 * @author kac
 * @since 2013/04/04
 * @version 2013/04/04
 */
public class TestJCoSalesOrderCreateFromData2
{
	private static final String BAPI_TRANSACTION_ROLLBACK = "BAPI_TRANSACTION_ROLLBACK";
	private static final String BAPI_TRANSACTION_COMMIT= "BAPI_TRANSACTION_COMMIT";

	private static Logger	log= Logger.getLogger( TestJCoSalesOrderCreateFromData2.class );

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		String destinationString= ":host:00:902:uid:pwd";
		if( args.length > 0 )
		{
			destinationString= args[0];
		}
		String functionName= "BAPI_SALESORDER_CREATEFROMDAT2";

		SSODestinationDataProvider	provider= new SSODestinationDataProvider();
		provider.setLang( Locale.JAPANESE.getLanguage() );
		try
		{
			Environment.registerDestinationDataProvider( provider );
			
			//	${host}:${systemNumber}:${clientNumber}:${uid}:${pwd}
			JCoDestination	destination= JCoDestinationManager.getDestination( destinationString );

			JCoRepository repository = destination.getRepository();
			JCoFunction	function= repository.getFunction( functionName );
			if( function == null )
			{//	ファンクションが見つからない
				throw new RuntimeException( "["+ functionName +"] not found in SAP.");
			}
			log.info( "---- ["+ functionName +"] ----\n"+ function );
			JCoFunction	commitFunction= repository.getFunction( BAPI_TRANSACTION_COMMIT );
			log.info( "---- ["+ BAPI_TRANSACTION_COMMIT +"] ----\n"+ commitFunction );
			JCoFunction	rollbackFunction= repository.getFunction( BAPI_TRANSACTION_ROLLBACK );
			log.info( "---- ["+ BAPI_TRANSACTION_ROLLBACK +"] ----\n"+ rollbackFunction );

			//	ファンクションのinパラメータ
			JCoParameterList	importParams= function.getImportParameterList();
			if( importParams != null )
			{
//				TestJCoDestination.debugListMetaData( importParams.getListMetaData(), 0 );
			}

			JCoParameterList	tableParames= function.getTableParameterList();
			String paramName= "ORDER_PARTNERS";
			JCoListMetaData listMD= tableParames.getListMetaData();
			log.debug( "["+ paramName +"] "+ listMD.getClassNameOfField( paramName ) );
			log.debug( "isAbapObject="+ listMD.isAbapObject( paramName ) );
			log.debug( "isChanging="+ listMD.isChanging( paramName ) );
			log.debug( "isException="+ listMD.isException( paramName ) );
			log.debug( "isExport="+ listMD.isExport( paramName ) );
			log.debug( "isImport="+ listMD.isImport( paramName ) );
			log.debug( "isNestedType1Structure="+ listMD.isNestedType1Structure( paramName ) );
			log.debug( "isOptional="+ listMD.isOptional( paramName ) );
			log.debug( "isStructure="+ listMD.isStructure( paramName ) );
			log.debug( "isTable="+ listMD.isTable( paramName ) );
			TestJCoDestination.debugMetaData( listMD.getRecordMetaData( paramName ), 0 );
			log.debug( "extendedFieldMD="+ tableParames.getMetaData().getExtendedFieldMetaData( paramName ) );
			
//			importParams.setValue( "BANK_KEY", "0005004" );
//			JCoStructure	bankAddress= (JCoStructure)importParams.getValue( "BANK_ADDRESS" );
//			bankAddress.setValue( "BANK_NAME", "かくテスト銀行" );
//			bankAddress.setValue( "CITY", "大阪市" );

			try
			{
				//	トランザクション開始
				JCoContext.begin( destination );
				log.info( "isStateful="+ JCoContext.isStateful( destination ) );
				function.execute( destination );
				System.out.println( "----+----+----+----+----+----+----+----+----+----+----+----" );

				JCoStructure	bapiret2= (JCoStructure)function.getExportParameterList().getValue( "RETURN" );
				for( Iterator<JCoField>	i= bapiret2.iterator(); i.hasNext(); )
				{
					JCoField	field= i.next();
					log.debug( bapiret2.getMetaData().getName() +"."+ field.getName() +"="+ field.getValue() );
				}

				//	コミット
//				commitFunction.execute( destination );
			}
			catch( Exception e )
			{
				log.error( e.toString(), e );
			}
			finally
			{
				//	トランザクション終了
				JCoContext.end( destination );
				log.info( "isStateful="+ JCoContext.isStateful( destination ) );
			}

			JCoParameterList	exportParams= function.getExportParameterList();
			log.info( exportParams );
			Object	bapiret2= exportParams.getValue( "RETURN" );
			log.info( bapiret2 );

			JCoParameterList	tableParams= function.getTableParameterList();
			log.info( tableParams );

		}
		catch( Exception e )
		{
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
