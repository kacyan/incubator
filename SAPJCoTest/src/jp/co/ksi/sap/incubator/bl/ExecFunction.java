package jp.co.ksi.sap.incubator.bl;

import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.action.DynaActionForm;

import com.sap.conn.jco.JCoContext;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoField;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoParameterList;
import com.sap.conn.jco.JCoStructure;

import jp.co.ksi.eip.commons.struts.InvokeAction;

/**
 * Functionを実行します
 * @author kac
 * @since 2013/03/26
 * @version 2013/03/28
 * <pre>
 * [in]
 * 	functionName	String
 * 	{parameter}	(option)String
 * [out]
 * 	importList	JCoParameterList
 * 	tableList	JCoParameterList
 * 	changingList	JCoParameterList
 * 	exportList	JCoParameterList
 * </pre>
 */
public class ExecFunction extends BaseBL
{
	private static final String BAPI_TRANSACTION_ROLLBACK = "BAPI_TRANSACTION_ROLLBACK";
	private static final String BAPI_TRANSACTION_COMMIT= "BAPI_TRANSACTION_COMMIT";

	private static Logger	log= Logger.getLogger( ExecFunction.class );

	protected ActionMessages	errors= new ActionMessages();

	@Override
	protected String execBL( InvokeAction action, ActionForm form,
			HttpServletRequest request )
	{
		//	パラメータを取得する
		DynaActionForm	dyna= (DynaActionForm)form;
		String	functionName= dyna.getString( "functionName" );
		String	flgCommit= dyna.getString( "flgCommit" );
		
		try
		{
			JCoDestination destination= auth.getDestination();
			JCoFunction	commitFunction= destination.getRepository().getFunction( BAPI_TRANSACTION_COMMIT );
			JCoFunction	function= destination.getRepository().getFunction( functionName );
			JCoParameterList	importList= function.getImportParameterList();
			for( Iterator<JCoField>	i= importList.iterator(); i.hasNext(); )
			{
				JCoField	field= i.next();
				String	paramName= field.getName();
				log.debug( paramName +" - "+ field.getClassNameOfValue() );
				if( field.isStructure() )
				{//	構造体
					JCoStructure	structure= field.getStructure();
					for( Iterator<JCoField> it2= structure.iterator(); it2.hasNext(); )
					{
						JCoField	field2= it2.next();
						String	paramValue= request.getParameter( paramName +"."+ field2.getName() );
						if( paramValue != null )
						{
							field2.setValue( paramValue );
							log.debug( paramName +"."+ field2.getName() +"="+ paramValue );
						}
					}
				}
				else if( field.isTable() )
				{//	テーブル
					
				}
				else if( field.isInitialized() )
				{//	初期化？
					
				}
				else
				{//	普通
					String	paramValue= request.getParameter( paramName );
					if( paramValue != null )
					{
						field.setValue( paramValue );
					}
				}
			}
			
			try
			{
				//	トランザクション開始
				JCoContext.begin( destination );
				log.info( "isStateful="+ JCoContext.isStateful( destination ) );
				
				//	ファンクションを実行する
				function.execute( destination );
				log.debug( "execute後\n"+ function.getExportParameterList() );
				
				if( flgCommit.equalsIgnoreCase( "true" ) )
				{//	コミットする
					commitFunction.execute( destination );
					log.debug( "commit後\n"+ function.getExportParameterList() );
				}
				
			}
			catch( Exception e )
			{
				log.error( e.toString(), e );
			}
			finally
			{
				//	トランザクション終了
				JCoContext.end( destination );
				log.info( "isStateful="+ JCoContext.isStateful( destination ) );
			}
			
			JCoParameterList	tableList= function.getTableParameterList();
			JCoParameterList	changingList= function.getChangingParameterList();
			JCoParameterList	exportList= function.getExportParameterList();
			log.debug( "トランザクション終了後\n"+ exportList );
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
	}

}
