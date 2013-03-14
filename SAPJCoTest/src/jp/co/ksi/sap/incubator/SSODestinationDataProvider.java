package jp.co.ksi.sap.incubator;

import java.util.Properties;

import org.apache.log4j.Logger;

import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.ext.DestinationDataEventListener;
import com.sap.conn.jco.ext.DestinationDataProvider;
import com.sap.conn.jco.ext.Environment;

/**
 * JCoの習作。
 * ssoTicketを扱うために DestinationDataProvider を拡張してみる
 * @author kac
 * @since 2013/03/12
 * @version 2013/03/12
 * <pre>
 * [使い方]
 * １．SSODestinationDataProvider を生成する
 * ２．Environment.registerDestinationDataProvider()で登録する
 * ３．JCoDestinationManager.getDestination( destinationName )を呼ぶ。
 * 　destinationName は、${type}:${host}:${systemNumber}:${clientNumber}:${uid}:${pwd} という文字列
 * ４．得られたJCoDestinationを使ってRFC呼出を行う。
 * ５．Environment.unregisterDestinationDataProvider()で登録を解除する
 * 
 * ※destinationには終了処理が無い。
 * JCoDestinationのJavadocによると、
 * 　JCoDestinationは、JCoランタイムがコネクションを生成するのために必要な情報を持っているだけ。
 * 　それ自身で接続を作成しないし保持しない。
 * 　JCoランタイムがコネクションの生成を行い、設定によってはプーリングも行う。
 * と書いてある。
 * JCoランタイムとは実体のsapjco3.dllとかsapjco3.soの事。
 * 
 *  * ※Environmentには１つしかプロバイダ登録できない。Enviromentのスコープを調査する必要あり。
 * 　サーバ・インスタンスで共通でした。つまりインスタンス毎に１つしかプロバイダは設定できない。
 * 　
 * </pre>
 */
public class SSODestinationDataProvider implements DestinationDataProvider
{
	private static Logger	log= Logger.getLogger( SSODestinationDataProvider.class );
	
	/**
	 * 言語 (例=ja)
	 */
	private String lang= "ja";
	/**
	 * トレース
	 */
	private String trace= "enable";
	
	public String getLang()
	{
		return lang;
	}
	public void setLang( String lang )
	{
		this.lang= lang;
	}
	public String getTrace()
	{
		return trace;
	}
	public void setTrace( String trace )
	{
		this.trace= trace;
	}
	
	/**
	 * JCoDestinationManager.getDestination()の中で呼ばれる(JNIなのでDLLの中からかも)
	 */
	public Properties getDestinationProperties( String destinationName )
	{
		//	destinationNameを分解する
		String	type= "";
		String	host= "";
		String	systemNumber= "";
		String	clientNumber= "";
		String	uid= "";
		String	pwd= "";
		String	mysapsso2= "";
		
		Properties	props= new Properties();
		
		try
		{
			String[]	token= destinationName.split( ":" );
			type= token[0];
			if( type.matches( "[gG][eE][tT][sS][sS][oO][2]" ) )
			{//	ssoTicketの取得要求だ
				log.debug( "[ssoTicket要求]" );
				host= token[1];
				systemNumber= token[2];
				clientNumber= token[3];
				uid= token[4];
				pwd= token[5];
				
				props.setProperty( DestinationDataProvider.JCO_ASHOST, host );
				props.setProperty( DestinationDataProvider.JCO_SYSNR, systemNumber );
				props.setProperty( DestinationDataProvider.JCO_CLIENT, clientNumber );
				props.setProperty( DestinationDataProvider.JCO_USER, uid );
				props.setProperty( DestinationDataProvider.JCO_PASSWD, pwd );
				props.setProperty( DestinationDataProvider.JCO_GETSSO2, "1" );
				props.setProperty( DestinationDataProvider.JCO_SNC_SSO, "1" );
				props.setProperty( DestinationDataProvider.JCO_SNC_MODE, "0" );
			}
			else if( type.matches( "[mM][yY][sS][aA][pP][sS][sS][oO][2]" ) )
			{//	ssoTicketでの認証処理だ
				log.debug( "[ssoTicket認証]" );
				host= token[1];
				systemNumber= token[2];
				clientNumber= token[3];
				uid= token[4];
				pwd= token[5];
				log.debug( mysapsso2 );
				
				props.setProperty( DestinationDataProvider.JCO_ASHOST, host );
				props.setProperty( DestinationDataProvider.JCO_SYSNR, systemNumber );
				props.setProperty( DestinationDataProvider.JCO_CLIENT, clientNumber );
				props.setProperty( DestinationDataProvider.JCO_USER, uid );
				props.setProperty( DestinationDataProvider.JCO_PASSWD, pwd );
//				props.setProperty( DestinationDataProvider.JCO_MYSAPSSO2, "Password" );
				
			}
			else
			{//	その他->普通
				log.debug( "[普通]" );
				host= token[1];
				systemNumber= token[2];
				clientNumber= token[3];
				uid= token[4];
				pwd= token[5];

				props.setProperty( DestinationDataProvider.JCO_ASHOST, host );
				props.setProperty( DestinationDataProvider.JCO_SYSNR, systemNumber );
				props.setProperty( DestinationDataProvider.JCO_CLIENT, clientNumber );
				props.setProperty( DestinationDataProvider.JCO_USER, uid );
				props.setProperty( DestinationDataProvider.JCO_PASSWD, pwd );
			}
			props.setProperty( DestinationDataProvider.JCO_LANG, lang );
			props.setProperty( DestinationDataProvider.JCO_TRACE, trace );
		}
		catch( Exception e )
		{
			log.error( destinationName, e );
		}
		
		
		return props;
	}
	
	/**
	 * 
	 */
	public void setDestinationDataEventListener( DestinationDataEventListener listener )
	{
		// TODO 自動生成されたメソッド・スタブ
		log.debug( listener );
	}

	/**
	 * 
	 */
	public boolean supportsEvents()
	{
		// TODO 自動生成されたメソッド・スタブ
		log.debug( "called." );
		return false;
	}

	/**
	 * 単体テスト用のメイン
	 * @param args
	 */
	public static void main( String[] args )
	{
		String	uid= "";
		String	pwd= "";
		if( args.length > 0 )
		{
			uid= args[0];
		}
		if( args.length >1 )
		{
			pwd= args[1];
		}
		
		
		SSODestinationDataProvider	provider= new SSODestinationDataProvider();
		provider.setLang( "ja" );
		
		try
		{
			//	データプロバイダを登録する
			Environment.registerDestinationDataProvider( provider );
			log.debug( "isDestinationDataProviderRegistered="+ Environment.isDestinationDataProviderRegistered() );
			
			JCoDestination	destination= JCoDestinationManager.getDestination( "getsso2:133.253.62.89:00:903:"+ uid +":"+ pwd );
			destination.getProperties().list( System.out );
			log.info( destination.isValid() );
			
			log.debug( "destination="+ destination.getDestinationID() +" "+ destination.getDestinationName() );
			log.debug( "logonCheck="+ destination.getLogonCheck() );
			String ssoTicket= destination.getAttributes().getSSOTicket();
			log.debug( "ssoTicket="+ ssoTicket );
			
			log.info( "----------" );
			
			JCoDestination	destination2= JCoDestinationManager.getDestination( "mysapsso2:133.253.62.89:00:903:"+ uid +":"+ssoTicket );
			destination2.getProperties().list( System.out );
			log.info( destination2.isValid() );
			log.debug( "destination="+ destination2.getDestinationID() +" "+ destination2.getDestinationName() );
			log.debug( "logonCheck="+ destination2.getLogonCheck() );

			JCoFunction	function= destination2.getRepository().getFunction( "BAPI_USER_GET_DETAIL" );
			System.out.println( function );

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
