package jp.co.ksi.sap.incubator.bl;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Enumeration;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import jp.co.ksi.eip.commons.struts.InvokeAction;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.action.DynaActionForm;

/**
 * パラメータをファイルにセーブする
 * @author kac
 * @since 2013/04/01
 * @version 2013/04/01
 */
public class SaveParameter extends GetFunction
{
	private static Logger	log= Logger.getLogger( SaveParameter.class );

	@Override
	protected String execBL( InvokeAction action, ActionForm form, HttpServletRequest request )
	{
		DynaActionForm	dyna= (DynaActionForm)form;
		String	paramFile= dyna.getString( "paramFile" );
		if( ( paramFile ==null ) || paramFile.equals( "" ) )
		{//	param error
			errors.add( ActionMessages.GLOBAL_MESSAGE, new ActionMessage( "BL.ERR.DEFAULT", getClass().getName(), "paramFile invalid" ) );
			return APL_ERR;
		}
			
		String	functionName= dyna.getString( "functionName" );
		
		String	result= super.execBL( action, form, request );

		String	paramFileBase= appConfig.getProperty( LoadParameter.PARAM_FILE_BASE, "/users/kac/SAPTest/" );
		
		Properties	props= new Properties();
		//	BAPI名
		props.setProperty( "functionName", functionName );
		Enumeration	enumeration= request.getParameterNames();
		while( enumeration.hasMoreElements() )
		{//	パラメータ
			String	name= (String)enumeration.nextElement();
			props.setProperty( name, request.getParameter( name ) );
		}
		
		PrintStream	out= null;
		try
		{
			out= new PrintStream( new FileOutputStream( paramFileBase + paramFile ) );
			props.list( out );
			out.flush();
			log.debug( "saved. "+ paramFileBase + paramFile );
		}
		catch( Exception e )
		{
			log.error( "save error. "+ paramFileBase + paramFile, e );
			errors.add( ActionMessages.GLOBAL_MESSAGE, new ActionMessage( "BL.ERR.DEFAULT", getClass().getName(), "save error. "+ paramFileBase + paramFile ) );
			result= APL_ERR;
		}
		finally
		{
			if( out != null )
			{
				try
				{
					out.close();
				}
				catch( Exception e )
				{
				}
			}
		}
		
		return result;
	}

}
