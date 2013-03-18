package jp.co.ksi.sap.incubator.bl;

import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.DynaActionForm;

import com.sap.conn.jco.JCoCustomDestination;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoParameterList;

import jp.co.ksi.eip.commons.struts.IStruts;
import jp.co.ksi.eip.commons.struts.InvokeAction;
import jp.co.ksi.sap.incubator.Auth;

/**
 * Functionを取得します
 * @author kac
 * @since 2013/03/18
 * @version 2013/03/18
 */
public class GetFunction implements IStruts
{
	private static Logger	log= Logger.getLogger( GetFunction.class );

	@Override
	public String execute( InvokeAction action, ActionForm form,
			HttpServletRequest request, HttpServletResponse response )
			throws Exception
	{
		ServletContext	context= action.getServlet().getServletContext();
		Properties	appConfig= (Properties)context.getAttribute( "appConfig" );

		HttpSession	session= request.getSession();
		JCoDestination	destination= (JCoDestination)session.getAttribute( Login.SESS_ATTR_NAME_AUTH );
		if( destination == null )
		{
			return APL_ERR;
		}
		
		//	パラメータを取得する
		DynaActionForm	dyna= (DynaActionForm)form;
		String	functionName= dyna.getString( "functionName" );
		
		try
		{
			JCoFunction	function= destination.getRepository().getFunction( functionName );
			JCoParameterList	importList= function.getImportParameterList();
			JCoParameterList	tableList= function.getTableParameterList();
			JCoParameterList	changingList= function.getChangingParameterList();
			JCoParameterList	exportList= function.getExportParameterList();

			request.setAttribute( "importList", importList );
			request.setAttribute( "tableList", tableList );
			request.setAttribute( "changingList", changingList );
			request.setAttribute( "exportList", exportList );
			
			return APL_OK;
		}
		catch( Exception e )
		{//	エラー
			log.warn( "functionName="+ functionName, e );
			return APL_ERR;
		}
	}
}
