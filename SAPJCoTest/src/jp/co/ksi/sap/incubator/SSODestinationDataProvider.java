package jp.co.ksi.sap.incubator;

import java.util.Properties;

import org.apache.log4j.Logger;

import com.sap.conn.jco.JCoCustomDestination;
import com.sap.conn.jco.JCoCustomDestination.UserData;
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
 * @version 2013/03/15
 * <pre>
 * [チケット取得方法]
 * １．SSODestinationDataProvider を生成する
 * ２．Environment.registerDestinationDataProvider()で登録する
 * ３．JCoDestinationManager.getDestination( destinationName )を呼ぶ(チケット発行要求)
 * 　destinationName は、GETSSO2:${host}:${systemNumber}:${clientNumber}:${uid}:${pwd} という文字列
 * ４．得られたJCoDestinationからssoTicketを取得する
 * ５．Environment.unregisterDestinationDataProvider()で登録を解除する
 * 
 * ※Environmentには１つしかプロバイダ登録できないので、登録と解除の実装場所は、実行環境に応じて検討する事。
 * 　インスタンス毎に１つしかプロバイダは設定できないと思われる。
 * 
 * [チケット利用方法]
 * １．SSODestinationDataProvider を生成する
 * ２．Environment.registerDestinationDataProvider()で登録する
 * ３．JCoDestinationManager.getDestination( destinationName )を呼ぶ(普通)
 * 　destinationName は、:${host}:${systemNumber}:${clientNumber}:${uid}:${pwd} という文字列
 * ４．得られたJCoDestinationからJCoCustomDestinationを作成する
 * ５．JCoCustomDestinationからUserDataを取得し、チケットを設定する
 * ６．JCoCustomDestinationでJCoFunctionを取得し、実行する。
 * ７．Environment.unregisterDestinationDataProvider()で登録を解除する
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
		String destinationString= ":172.16.98.214:00:902:baseUid:basePwd";
		String	uid= "";
		String	pwd= "";
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
		
		
		
		SSODestinationDataProvider	provider= new SSODestinationDataProvider();
		provider.setLang( "ja" );
		
		try
		{
			//	データプロバイダを登録する
			Environment.registerDestinationDataProvider( provider );
			log.debug( "isDestinationDataProviderRegistered="+ Environment.isDestinationDataProviderRegistered() );
			
			//	SSO発行要求のdestinationを取得する
			JCoDestination	destination= JCoDestinationManager.getDestination( "getsso2"+destinationString );
			log.info( "destination.valid="+ destination.isValid() );
			destination.getProperties().list( System.out );
			String ssoTicket1= destination.getAttributes().getSSOTicket();
			log.debug( "ssoTicket1="+ ssoTicket1 );
			
			//	uid/pwdで指定されたユーザのSSOチケットを取得する。
			JCoCustomDestination	custom= destination.createCustomDestination();
			UserData	userData= custom.getUserLogonData();
			userData.setUser( uid );
			userData.setPassword( pwd );
			String	ssoTicket2= custom.getAttributes().getSSOTicket();
			log.debug( "ssoTicket2="+ ssoTicket2 );
			
			log.info( "----------" );

			//	普通のdestinationを取得する
			JCoDestination	destination2= JCoDestinationManager.getDestination( destinationString );
			log.info( "destination.valid="+ destination2.isValid() );
			destination2.getProperties().list( System.out );

			//	SSOチケットをセットする
			JCoCustomDestination	custom2= destination2.createCustomDestination();
			UserData	userData2= custom2.getUserLogonData();
			userData2.setSSOTicket( ssoTicket2 );
			
			//	ファンクションを取得し、実行する
			JCoFunction	function= custom2.getRepository().getFunction( "BAPI_USER_GET_DETAIL" );
			function.getImportParameterList().setValue( "USERNAME", "4501911013" );
			function.execute( custom2 );
			System.out.println( function.getExportParameterList().getValue( "ADDRESS" ) );

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
