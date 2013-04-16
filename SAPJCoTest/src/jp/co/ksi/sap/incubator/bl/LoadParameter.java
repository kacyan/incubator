package jp.co.ksi.sap.incubator.bl;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import jp.co.ksi.eip.commons.struts.InvokeAction;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.action.DynaActionForm;

import com.sap.conn.jco.JCoField;
import com.sap.conn.jco.JCoParameterList;
import com.sap.conn.jco.JCoStructure;
import com.sap.conn.jco.JCoTable;

/**
 * パラメータをファイルからロードする
 * @author kac
 * @since 2013/04/01
 * @version 2013/04/16
 */
public class LoadParameter extends GetFunction
{
	public static final String PARAM_FILE_BASE= "paramFile.base";
	
	private static Logger	log= Logger.getLogger( LoadParameter.class );

	@Override
	protected String execBL( InvokeAction action, ActionForm form, HttpServletRequest request )
	{
		DynaActionForm	dyna= (DynaActionForm)form;
		String	paramFile= dyna.getString( "paramFile" );
		if( ( paramFile == null ) || paramFile.equals( "" ) )
		{
			errors.add( ActionMessages.GLOBAL_MESSAGE, new ActionMessage( "BL.ERR.DEFAULT", getClass().getName(), "paramFile invalid" ) );
			return APL_ERR;
		}
		
		String	paramFileBase= appConfig.getProperty( PARAM_FILE_BASE, "/users/kac/SAPTest/" );
		
		Properties	paramProperties= new Properties();
		InputStream in= null;
		try
		{
			in= new FileInputStream( paramFileBase + paramFile );
			paramProperties.load( in );
		}
		catch( Exception e )
		{
			log.error( "["+ auth.getUid() +"] "+ paramFile, e );
		}
		finally
		{
			if( in != null )
			{
				try
				{
					in.close();
				}
				catch( Exception e )
				{
				}
			}
		}
		request.setAttribute( "paramProperties", paramProperties );
		
		String	functionName= paramProperties.getProperty( "functionName", "" );
		log.debug( "functionName="+ functionName );
		dyna.set( "functionName", functionName );
		request.setAttribute( "functionName", functionName );
		
		//	GetFunctionを呼び出す
		String	result= super.execBL( action, form, request );
		if( !result.equals( APL_OK ) )
		{//	エラーなら何もしない
			return result;
		}
		
		JCoParameterList	importList= (JCoParameterList)request.getAttribute( "importList" );
		for( Iterator<JCoField>	i= importList.iterator(); i.hasNext(); )
		{
			JCoField	field= i.next();
			String	paramName= field.getName();
			log.debug( paramName +" - "+ field.getClassNameOfValue() +" - "+ field.getLength() +" - "+ field.getDescription() );
			if( field.isStructure() )
			{//	構造体
				JCoStructure	structure= field.getStructure();
				for( Iterator<JCoField> it2= structure.iterator(); it2.hasNext(); )
				{//	構造体の各フィールドを調べる
					JCoField	field2= it2.next();
					log.debug( "\t"+ field2.getClassNameOfValue() +" - "+ field2.getLength() +" - "+ field2.getDescription() );
					String	paramValue= paramProperties.getProperty( paramName +"."+ field2.getName() );
					if( paramValue != null )
					{//	構造体のフィールド名に一致するパラメータがあれば、その値をセットする
						field2.setValue( paramValue );
						log.debug( "\t"+ paramName +"."+ field2.getName() +"="+ paramValue );
					}
				}
			}
			else if( field.isTable() )
			{//	テーブル
				JCoTable	table= field.getTable();
				log.debug( "cols="+ table.getNumColumns() +", rows="+ table.getNumRows() );
			}
			else if( field.isInitialized() )
			{//	初期化？
				
			}
			else
			{//	普通
				String	paramValue= paramProperties.getProperty( paramName );
				if( paramValue != null )
				{//	フィールド名に一致するパラメータがあれば、その値をセットする
					field.setValue( paramValue );
					log.debug( "\t"+ paramName +"="+ paramValue );
				}
			}
		}

		return result;
	}

}
