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
 * 接続情報をPropertiesで渡すために DestinationDataProvider を拡張してみる
 * @author kac
 * @since 2013/03/07
 * @version 2013/03/08
 * <pre>
 * [使い方]
 * １．UserDestinationDataProvider を生成し、値をセットする
 * ２．Environment.registerDestinationDataProvider()で登録する
 * ３．JCoDestinationManager.getDestination( destinationName )を呼ぶ。
 * 　destinationName は、${host}:${systemNumber}:${clientNumber}:${uid}:${pwd} という文字列
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
 * JCoランタイムはどのようなコネクション管理をしているのだろうか？
 * 
 * </pre>
 */
public class UserDestinationDataProvider implements DestinationDataProvider
{
	private static Logger	log= Logger.getLogger( UserDestinationDataProvider.class );
	
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
		String	host= "";
		String	systemNumber= "";
		String	clientNumber= "";
		String	uid= "";
		String	pwd= "";
		try
		{
			String[]	token= destinationName.split( ":" );
			host= token[0];
			systemNumber= token[1];
			clientNumber= token[2];
			uid= token[3];
			pwd= token[4];
		}
		catch( Exception e )
		{
			log.error( destinationName, e );
		}
		
		Properties	props= new Properties();
		props.setProperty( DestinationDataProvider.JCO_ASHOST, host );
		props.setProperty( DestinationDataProvider.JCO_SYSNR, systemNumber );
		props.setProperty( DestinationDataProvider.JCO_CLIENT, clientNumber );
//		props.setProperty( DestinationDataProvider.JCO_AUTH_TYPE, "" );
		props.setProperty( DestinationDataProvider.JCO_USER, uid );
		props.setProperty( DestinationDataProvider.JCO_PASSWD, pwd );
		props.setProperty( DestinationDataProvider.JCO_LANG, lang );
		props.setProperty( DestinationDataProvider.JCO_TRACE, trace );
		
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
		
		
		UserDestinationDataProvider	provider= new UserDestinationDataProvider();
		provider.setLang( "ja" );
		
		try
		{
			//	データプロバイダを登録する
			Environment.registerDestinationDataProvider( provider );
			log.debug( "isDestinationDataProviderRegistered="+ Environment.isDestinationDataProviderRegistered() );
			
			JCoDestination	destination= JCoDestinationManager.getDestination( "133.253.62.89:00:903:"+ uid +":"+ pwd );
			destination.getProperties().list( System.out );
			log.info( destination.isValid() );
			
			JCoFunction	function= destination.getRepository().getFunction( "BAPI_USER_GET_DETAIL" );
			System.out.println( function );

			log.debug( "destination1="+ destination.getDestinationID() +" "+ destination.getDestinationName() );

			log.debug( "logonCheck="+ destination.getLogonCheck() );
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
