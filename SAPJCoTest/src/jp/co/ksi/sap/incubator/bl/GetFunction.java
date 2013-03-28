package jp.co.ksi.sap.incubator.bl;


import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.action.DynaActionForm;

import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoParameterList;

import jp.co.ksi.eip.commons.struts.InvokeAction;

/**
 * Functionを取得します
 * <pre>
 * [in]
 * 	functionName	String
 * [out]
 * 	importList	JCoParameterList
 * 	tableList	JCoParameterList
 * 	changingList	JCoParameterList
 * 	exportList	JCoParameterList
 * </pre>
 * @author kac
 * @since 2013/03/18
 * @version 2013/03/28
 * <pre>
 * 動作確認
 * BAPI_USER_GET_DETAIL	○
 * BAPI_USER_GETLIST	△
 * 
 * </pre>
 */
public class GetFunction extends BaseBL
{
	private static Logger log= Logger.getLogger( GetFunction.class );

	protected String execBL( InvokeAction action, ActionForm form,
			HttpServletRequest request )
	{
		//	パラメータを取得する
		DynaActionForm	dyna= (DynaActionForm)form;
		String	functionName= dyna.getString( "functionName" );
		
		try
		{
			JCoFunction	function= auth.getDestination().getRepository().getFunction( functionName );
			if( function == null )
			{
				log.info( functionName +" not found." );
				errors.add( ActionMessages.GLOBAL_MESSAGE, new ActionMessage( "BL.GetFunction.ERR.001", functionName ) );
				return APL_OK;
			}
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
			errors.add( ActionMessages.GLOBAL_MESSAGE, new ActionMessage( "BL.ERR.DEFAULT", getClass().getName(), e.toString() ) );
			return APL_ERR;
		}
		finally
		{
			
		}
	}
}
