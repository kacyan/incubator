package jp.co.ksi.sap.incubator.bl;

import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.DynaActionForm;

import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

import jp.co.ksi.eip.commons.servlet.CheckAuthFilter;
import jp.co.ksi.eip.commons.struts.IStruts;
import jp.co.ksi.eip.commons.struts.InvokeAction;
import jp.co.ksi.sap.incubator.DestinationAuth;

/**
 * SAPへのログイン処理を行います。
 * <pre>
 * [in]
 * 	host	SAPサーバのホスト名orIPアドレス
 * 	sysNo	システム番号(例：00)
 * 	clientNo	クライアント番号(例：902)
 * 	uid	ユーザID
 * 	pwd	パスワード
 * [out]
 * 	なし
 * APL_OK
 * 	ログイン成功。destinationをセッションに保存します。
 * APL_ERR
 * 	ログイン失敗。
 * </pre>
 * @author kac
 * @since 2013/03/15
 * @version 2013/03/27
 */
public class Login implements IStruts
{
	public static final String SESS_ATTR_NAME_AUTH= CheckAuthFilter.SESS_ATTR_NAME_AUTH;
	
	private static Logger	log= Logger.getLogger( Login.class );

	@Override
	public String execute( InvokeAction action, ActionForm form,
			HttpServletRequest request, HttpServletResponse response )
			throws Exception
	{
		ServletContext	context= action.getServlet().getServletContext();
		Properties	appConfig= (Properties)context.getAttribute( "appConfig" );
//		String	destinationName= appConfig.getProperty( "destinationName", "" );
		
		//	パラメータを取得する
		DynaActionForm	dyna= (DynaActionForm)form;
		String	host= dyna.getString( "host" );
		String	systemNumber= dyna.getString( "systemNumber" );
		String	clientNumber= dyna.getString( "clientNumber" );
		String	uid= dyna.getString( "uid" );
		String	pwd= dyna.getString( "pwd" );
		String	type= dyna.getString( "type" );
		log.debug( "type="+ type );
		
		try
		{
			//	SSOチケットを取得する
			JCoDestination	destination= JCoDestinationManager.getDestination( type+ ":"+ host+ ":"+ systemNumber +":"+ clientNumber +":"+ uid +":"+ pwd  );
			destination.ping();
			
			//	セッションを初期化する
			HttpSession	session= request.getSession();
			session.invalidate();
			session= request.getSession();
			
			//	authを生成して、セッションに保存する
			DestinationAuth	auth= new DestinationAuth();
			auth.setDestination( destination );
			auth.setUid( uid );
			session.setAttribute( SESS_ATTR_NAME_AUTH, auth );

			log.info( "destinaion ok. "+ type +":"+ host+ ":"+ systemNumber +":"+ clientNumber +":"+ uid );
			return APL_OK;
		}
		catch( Exception e )
		{//	認証失敗
			log.warn( "destinaion failed. "+ type +":"+ host+ ":"+ systemNumber +":"+ clientNumber +":"+ uid, e );
			return APL_ERR;
		}

	}

}
