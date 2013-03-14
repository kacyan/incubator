package jp.co.ksi.sap.incubator;

import java.util.Date;

import jp.co.ksi.eip.commons.util.StringUtil;

import org.apache.log4j.Logger;

import com.sap.conn.jco.JCoClassMetaData;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoMetaData;
import com.sap.conn.jco.JCoRepository;
import com.sap.conn.jco.ext.Environment;
import com.sap.conn.jco.monitor.JCoRepositoryMonitor;

/**
 * JCoRepositoryの習作
 * @author kac
 * @since 2013/02/08
 * @version 2013/02/08
 * <pre>
 * 各種のツールをみてるとBAPIの一覧を表示してBAPIを選択させる画面がある。
 * これらはどうやって実現しているのだろうか？
 * そういう観点で、JCoRepositoryを調べてみる。
 * </pre>
 */
public class TestJCoRepository
{

	private static Logger	log= Logger.getLogger( TestJCoRepository.class );
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		String functionName = "BAPI_SALESORDER_GETSTATUS";
		functionName= "BAPI_EQUI_GETLIST";
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
			Environment.registerClientPassportManager( new KacPassportManager() );

			//	実行時カレントフォルダの sap.jcoDestication というファイルから接続情報を読み込む
			JCoDestination	destination= JCoDestinationManager.getDestination( "sap" );
			
			JCoRepository repository = destination.getRepository();
			log.debug( "repository="+ repository );
			log.debug( "repository.name="+ repository.getName() );
			
			String[]	cachedClsMetaDataNames= repository.getCachedClassMetaDataNames();
			log.info( "cachedClsMetaDataNames="+ cachedClsMetaDataNames.length );
			for( int i= 0; i < cachedClsMetaDataNames.length; i++ )
			{
				log.debug( cachedClsMetaDataNames[i] );
			}
			String[]	cachedFunctionTemplateNames= repository.getCachedFunctionTemplateNames();
			log.info( "cachedFunctionTemplateNames="+ cachedFunctionTemplateNames.length );
			for( int i= 0; i < cachedFunctionTemplateNames.length; i++ )
			{
				log.debug( cachedFunctionTemplateNames[i] );
			}
			String[]	cachedRecordMetaDataNames= repository.getCachedRecordMetaDataNames();
			log.info( "cachedRecordMetaDataNames="+ cachedRecordMetaDataNames.length );
			for( int i= 0; i < cachedRecordMetaDataNames.length; i++ )
			{
				log.debug( cachedRecordMetaDataNames[i] );
			}
			
			JCoClassMetaData	clsMetaData= repository.getClassMetaData( "*" );
			log.debug( "clsMetaData="+ clsMetaData );
			
			JCoRepositoryMonitor	monitor= repository.getMonitor();
			log.debug( "monitor="+ monitor );
			log.debug( "functionMetaDataCount="+ monitor.getFunctionMetaDataCount() );
			log.debug( "LastAccessTimestamp="+ new Date( monitor.getLastAccessTimestamp() ) );
			log.debug( "LastRemoteQueryTimestamp="+ new Date( monitor.getLastRemoteQueryTimestamp() ) );
			log.debug( "TypeMetaDataCount="+ monitor.getTypeMetaDataCount() );
			
			
		}
		catch( Exception e )
		{
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
