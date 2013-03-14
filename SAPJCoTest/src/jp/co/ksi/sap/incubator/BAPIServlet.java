package jp.co.ksi.sap.incubator;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;
import com.sap.conn.jco.JCoException;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoParameterList;
import com.sap.conn.jco.ext.Environment;

public class BAPIServlet extends HttpServlet
{
	private static Logger	log= Logger.getLogger( BAPIServlet.class );

	@Override
	protected void doPost( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException
	{
		
		UserDestinationDataProvider	provider= new UserDestinationDataProvider();

		String	uid= req.getParameter( "uid" );
		String	pwd= req.getParameter( "pwd" );
		String	host= req.getParameter( "host" );
		String	systemNumber= req.getParameter( "systemNumber" );
		String	clientNumber= req.getParameter( "clientNumber" );
		String	functionName= req.getParameter( "functionName" );

		try
		{
			//	データプロバイダを登録する
			Environment.registerDestinationDataProvider( provider );
			log.debug( "isDestinationDataProviderRegistered="+ Environment.isDestinationDataProviderRegistered() );

			String	destinationName= "";
			JCoDestination	destination= JCoDestinationManager.getDestination( destinationName );

			//	functionName には汎用モジュール名を指定する
			JCoFunction	function= destination.getRepository().getFunction( functionName );
			if( function == null )
			{//	ファンクションが見つからない
				throw new RuntimeException( "["+ functionName +"] not found in SAP.");
			}

			//	ファンクションのinパラメータ
			JCoParameterList	importParams= function.getImportParameterList();

		}
		catch (JCoException e)
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

		super.doPost(req, resp);
	}

}
