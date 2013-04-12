package jp.co.ksi.sap.incubator;

import java.util.Iterator;

import org.apache.log4j.Logger;

import com.sap.conn.jco.JCoContext;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;
import com.sap.conn.jco.JCoField;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoParameterList;
import com.sap.conn.jco.JCoRepository;
import com.sap.conn.jco.JCoStructure;

/**
 * BAPI_BANK_CERATEの習作
 * @author kac
 * @since 2013/03/05
 * @version 2013/03/05
 */
public class TestJCoBankCreate
{
	private static final String BAPI_TRANSACTION_ROLLBACK = "BAPI_TRANSACTION_ROLLBACK";
	private static final String BAPI_TRANSACTION_COMMIT= "BAPI_TRANSACTION_COMMIT";

	private static Logger	log= Logger.getLogger( TestJCoBankCreate.class );

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		String functionName= "BAPI_BANK_CREATE";

		try
		{
			//	実行時カレントフォルダの sap.jcoDestication というファイルから接続情報を読み込む
			JCoDestination	destination= JCoDestinationManager.getDestination( "kac" );

			//	functionName には汎用モジュール名を指定する
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
			importParams.setValue( "BANK_CTRY", "JP" );
			importParams.setValue( "BANK_KEY", "0005004" );
			JCoStructure	bankAddress= (JCoStructure)importParams.getValue( "BANK_ADDRESS" );
			bankAddress.setValue( "BANK_NAME", "かくテスト銀行" );
			bankAddress.setValue( "CITY", "大阪市" );

			try
			{
				//	トランザクション開始
				JCoContext.begin( destination );
				log.info( "isStateful="+ JCoContext.isStateful( destination ) );
				function.execute( destination );

				JCoStructure	bapiret2= (JCoStructure)function.getExportParameterList().getValue( "RETURN" );
				for( Iterator<JCoField>	i= bapiret2.iterator(); i.hasNext(); )
				{
					JCoField	field= i.next();
					log.debug( bapiret2.getMetaData().getName() +"."+ field.getName() +"="+ field.getValue() );
				}

				//	コミット
				commitFunction.execute( destination );
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

	}

}
