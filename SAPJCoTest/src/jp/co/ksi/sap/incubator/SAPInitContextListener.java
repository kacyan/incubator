package jp.co.ksi.sap.incubator;

import javax.servlet.ServletContextEvent;

import org.apache.log4j.Logger;

import com.sap.conn.jco.ext.Environment;

import jp.co.ksi.eip.commons.servlet.InitContextListener;

/**
 * JCo環境の初期化を行います。
 * @author kac
 * @since 2013/03/07
 * @version 2013/03/18
 */
public class SAPInitContextListener extends InitContextListener
{
	private static Logger	log= Logger.getLogger( SAPInitContextListener.class );

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
			SSODestinationDataProvider	ddProvider= new SSODestinationDataProvider();
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

	
}
