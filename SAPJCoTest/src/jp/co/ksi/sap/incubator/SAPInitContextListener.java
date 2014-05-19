package jp.co.ksi.sap.incubator;

import javax.servlet.ServletContextEvent;

import org.apache.log4j.Logger;

import com.sap.conn.jco.ext.Environment;

import jp.co.ksi.eip.commons.servlet.InitContextListener;

/**
 * JCo環境の初期化を行います。
 * @author kac
 * @since 2013/03/07
 * @version 2013/05/13 終了処理を追加した。(これでメモリリークしなくなるか？)
 */
public class SAPInitContextListener extends InitContextListener
{
	private static Logger	log= Logger.getLogger( SAPInitContextListener.class );
	private SSODestinationDataProvider ddProvider;

	@Override
	public void contextInitialized( ServletContextEvent event )
	{
		//	オリジナル処理
		super.contextInitialized( event );
		
		if( Environment.isDestinationDataProviderRegistered() )
		{//	既に登録済なら、何もしない
		}
		else
		{//	カスタム・プロバイダを登録する
			ddProvider= new SSODestinationDataProvider();
			ddProvider.setLang( "ja" );
			
			try
			{
				Environment.registerDestinationDataProvider( ddProvider );
				log.info( "----- registered " + ddProvider.getClass().getName() +" -----" );
			}
			catch( Exception e )
			{
				log.error( ddProvider.getClass().getName(), e );
			}
		}
	}

	@Override
	public void contextDestroyed( ServletContextEvent event )
	{
		if( Environment.isDestinationDataProviderRegistered() )
		{//	登録済なら、解除する
			Environment.unregisterDestinationDataProvider( ddProvider );
			log.info( "----- unregistered " + ddProvider.getClass().getName() +" -----" );
		}
		
		//	オリジナル処理
		super.contextDestroyed( event );
	}

	
}
