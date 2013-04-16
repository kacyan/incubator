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
import com.sap.conn.jco.JCoTable;

import jp.co.ksi.eip.commons.struts.InvokeAction;

/**
 * Functionを実行します
 * @author kac
 * @since 2013/03/26
 * @version 2013/04/16
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
			if( importList != null )
			{
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
							String	paramValue= request.getParameter( paramName +"."+ field2.getName() );
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
						String	paramValue= request.getParameter( paramName );
						if( paramValue != null )
						{//	フィールド名に一致するパラメータがあれば、その値をセットする
							field.setValue( paramValue );
							log.debug( "\t"+ paramName +"="+ paramValue );
						}
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
				
				return APL_OK;
			}
			catch( Exception e )
			{
				log.error( "["+ auth.getUid() +"] "+ functionName +" execution failed.", e );
				errors.add( ActionMessages.GLOBAL_MESSAGE, new ActionMessage( "BL.ERR.DEFAULT", getClass().getName(), e.toString() ) );
				return APL_ERR;
			}
			finally
			{
				//	トランザクション終了
				JCoContext.end( destination );
				log.info( "isStateful="+ JCoContext.isStateful( destination ) );

				JCoParameterList	tableList= function.getTableParameterList();
				JCoParameterList	changingList= function.getChangingParameterList();
				JCoParameterList	exportList= function.getExportParameterList();
				log.debug( "トランザクション終了後\n"+ exportList );
				request.setAttribute( "importList", importList );
				request.setAttribute( "tableList", tableList );
				request.setAttribute( "changingList", changingList );
				request.setAttribute( "exportList", exportList );
			}
		}
		catch( Exception e )
		{//	エラー
			log.error( "["+ auth.getUid() +"] "+ functionName +" parameter failed.", e );
			errors.add( ActionMessages.GLOBAL_MESSAGE, new ActionMessage( "BL.ERR.DEFAULT", getClass().getName(), e.toString() ) );
			return APL_ERR;
		}
	}

}
