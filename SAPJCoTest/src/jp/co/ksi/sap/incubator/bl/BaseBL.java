package jp.co.ksi.sap.incubator.bl;

import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import jp.co.ksi.eip.commons.struts.IStruts;
import jp.co.ksi.eip.commons.struts.InvokeAction;
import jp.co.ksi.sap.incubator.DestinationAuth;

/**
 * B/Lの基底クラス
 * @author kac
 * @since 2013/03/28
 * @version 2013/03/29
 */
public abstract class BaseBL implements IStruts
{

	private static Logger log= Logger.getLogger( GetFunction.class );
	/**
	 * エラー
	 */
	protected ActionMessages errors= new ActionMessages();
	/**
	 * アプリケーションの設定情報
	 */
	protected Properties appConfig;
	/**
	 * 認証情報
	 */
	protected DestinationAuth auth;

	public BaseBL()
	{
		super();
	}

	@Override
	public String execute( InvokeAction action, ActionForm form, HttpServletRequest request, HttpServletResponse response )
			throws Exception
	{
		ServletContext	context= action.getServlet().getServletContext();
		appConfig= (Properties)context.getAttribute( "appConfig" );
	
		HttpSession	session= request.getSession();
		auth= (DestinationAuth)session.getAttribute( Login.SESS_ATTR_NAME_AUTH );
		if( auth == null )
		{//	認証なし -> エラー
			log.error( "destination not found in session" );
			errors.add( ActionMessages.GLOBAL_MESSAGE, new ActionMessage( "BL.ERR.DEFAULT", getClass().getName(), "destination not found in session" ) );
			return APL_ERR;
		}
		
		long	msec= System.currentTimeMillis();
		String result= APL_OK;
		try
		{
			result= execBL( action, form, request );
		}
		catch( Exception e )
		{//	B/Lで例外発生 -> エラー
			result= APL_ERR;
			log.error( getClass().getName() +" - "+ form, e );
			errors.add( ActionMessages.GLOBAL_MESSAGE, new ActionMessage( "BL.ERR.DEFAULT", getClass().getName(), e.toString() ) );
		}
		finally
		{
			action.saveErrors( request, errors );
			msec= System.currentTimeMillis() - msec;
			log.info( "["+ auth.getUid() +"] "+ getClass().getName() +" "+ msec +"msec ["+ result +"]" );
		}
		return result;
		
	}

	protected abstract String execBL( InvokeAction action, ActionForm form, HttpServletRequest request );

}