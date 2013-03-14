package jp.co.ksi.sap.incubator;
import java.util.Date;

import jp.co.ksi.eip.commons.util.StringUtil;

import org.apache.log4j.Logger;

import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;
import com.sap.conn.jco.JCoException;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoMetaData;
import com.sap.conn.jco.JCoParameterList;


public class TestKac {

	private static Logger	log= Logger.getLogger( TestKac.class );
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String functionName = "BAPI_SALESORDER_GETSTATUS";
		functionName= "RFC_READ_TABLE";
		try
		{
//			log.info( "inEclipsePlugin="+ Environment.inEclipsePlugin() );
//			log.info( "inSAPJ2EE="+ Environment.inSAPJ2EE() );
//			log.info( "inSAPVM="+ Environment.inSAPVM() );
//			log.info( "inStandalone="+ Environment.inStandalone() );
//			log.info( "isClientPassportManagerRegistered="+ Environment.isClientPassportManagerRegistered() );
//			log.info( "isDestinationDataProviderRegistered="+ Environment.isDestinationDataProviderRegistered() );
//			log.info( "isSessionReferenceProviderRegistered="+ Environment.isSessionReferenceProviderRegistered() );
			log.info( "user.dir="+ System.getProperty( "user.dir" ) );

			//	ClientPassportManagerの習作
//			Environment.registerClientPassportManager( new KacPassportManager() );

			//	実行時カレントフォルダの sap.jcoDestication というファイルから接続情報を読み込む
			JCoDestination	destination= JCoDestinationManager.getDestination( "RE4" );
			destination.getProperties().list( System.out );

			//	functionName には汎用モジュール名を指定する
			JCoFunction	function= destination.getRepository().getFunction( functionName );
			if( function == null )
			{//	ファンクションが見つからない
				throw new RuntimeException( "["+ functionName +"] not found in SAP.");
			}
			log.info( "---- ["+ functionName +"] ----\n"+ function );

			//	ファンクションのinパラメータ
			JCoParameterList	importParams= function.getImportParameterList();
			if( importParams != null )
			{
				debugMetaData( importParams.getMetaData(), 0 );
			}
			importParams.setValue( "QUERY_TABLE", "TFTIT" );

			function.execute( destination );

			JCoParameterList	exportParams= function.getExportParameterList();
			log.info( exportParams );
//			debugMetaData( exportParams.getMetaData(), 0 );
			for( int i= 0; i < exportParams.getFieldCount(); i++ )
			{
				log.info( "exportParam["+ i +"]\n"+ exportParams.getStructure( i ) );
			}

			JCoParameterList	tableParams= function.getTableParameterList();
			log.info( tableParams );
			for( int i= 0; i < tableParams.getFieldCount(); i++ )
			{
				log.info( "tableParam["+ i +"]\n"+ tableParams.getTable( i ) );
			}

			//	DOC_DATEのデータ型を確認する
			Date	docDate= tableParams.getTable(0).getDate("DOC_DATE");
			log.info( "docDate="+ docDate );

		}
		catch( AbapException e ) {
			e.printStackTrace();
		}
		catch( JCoException e ) {
			e.printStackTrace();
		}
		catch( RuntimeException e ) {
			e.printStackTrace();
		}

	}

	/**
	 * パラメータのメタデータを表示する
	 * @param params
	 */
	public static void debugMetaData( JCoMetaData md, int nest ) {

		String	indent= StringUtil.generateText( "　", nest );
		log.debug( indent +"md.name="+ md.getName() +", "+ md.getFieldCount() );

		for( int i= 0; i < md.getFieldCount(); i++ )
		{
			log.debug( indent +"name="+ md.getName(i)
					+", type="+ md.getTypeAsString(i)
					+", recordType="+ md.getRecordTypeName(i)
					+", length="+ md.getLength(i)
					+", description="+ md.getDescription(i) );

			if( md.isStructure(i) || md.isTable(i) )
			{//	構造体 or テーブル
				debugMetaData( md.getRecordMetaData(i), nest+1 );
			}
		}
	}

}
