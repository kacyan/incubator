package jp.co.ksi.sap.incubator;

import org.apache.log4j.Logger;

import com.sap.conn.jco.JCoContext;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoParameterList;
import com.sap.conn.jco.JCoRepository;
import com.sap.conn.jco.ext.Environment;

/**
 * 汎用モジュールBAPI_MATERIAL_GETLISTの習作
 * @author kac
 * @since 2013/04/02
 * @version 2013/04/02
 */
public class TestJCoMaterialGetList
{
	private static final String BAPI_TRANSACTION_ROLLBACK = "BAPI_TRANSACTION_ROLLBACK";
	private static final String BAPI_TRANSACTION_COMMIT= "BAPI_TRANSACTION_COMMIT";

	private static Logger	log= Logger.getLogger( TestJCoMaterialGetList.class );

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		String functionName= "BAPI_MATERIAL_GETLIST";

		String destinationString= ":172.16.98.214:00:902:baseUid:basePwd";
		if( args.length > 0 )
		{
			destinationString= args[0];
		}

		SSODestinationDataProvider	provider= new SSODestinationDataProvider();
		provider.setLang( "ja" );
		
		try
		{
			//	データプロバイダを登録する
			Environment.registerDestinationDataProvider( provider );
			log.debug( "isDestinationDataProviderRegistered="+ Environment.isDestinationDataProviderRegistered() );

			//	実行時カレントフォルダの sap.jcoDestication というファイルから接続情報を読み込む
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
				TestJCoDestination.debugMetaData( importParams.getMetaData(), 0 );
			}
			importParams.setValue( "MAXROWS", "10" );

			//	テーブルパラメータ
			JCoParameterList	tableParams= function.getTableParameterList();
			if( tableParams != null )
			{
				TestJCoDestination.debugMetaData( tableParams.getMetaData(), 0 );
				
				tableParams.getTable( "" );
			}

			try
			{
				//	トランザクション開始
				JCoContext.begin( destination );
				log.info( "isStateful="+ JCoContext.isStateful( destination ) );
				function.execute( destination );

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
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}
		finally
		{
			if( Environment.isDestinationDataProviderRegistered() )
			{//	データプロバイダを除去する
				Environment.unregisterDestinationDataProvider( provider );
				log.debug( "isDestinationDataProviderRegistered="+ Environment.isDestinationDataProviderRegistered() );
			}
		}

	}

}
