package jp.co.ksi.sap.incubator;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

import jp.co.ksi.eip.commons.servlet.Auth;

import org.apache.log4j.Logger;

import com.sap.conn.jco.JCoDestination;

/**
 * SAPアクセス用の認証情報
 * @author kac
 * @since 2013/03/18
 * @version 2013/03/27
 */
public class DestinationAuth implements Auth, HttpSessionBindingListener
{
	private static Logger	log= Logger.getLogger( DestinationAuth.class );
	
	private String	uid;
	private JCoDestination	destination;
	
	public String getUid()
	{
		return uid;
	}
	public void setUid( String uid )
	{
		this.uid= uid;
	}
	public JCoDestination getDestination()
	{
		return destination;
	}
	public void setDestination( JCoDestination destination )
	{
		this.destination= destination;
	}
	public String toString()
	{
		return destination.getApplicationServerHost() +";"+ destination.getSystemNumber() +":"+ destination.getClient() +":"+ destination.getUser();
	}
	@Override
	public boolean isValid()
	{
		if( destination == null )	return false;
		if( uid == null )	return false;
		
		return true;
	}
	@Override
	public Class getAuthClass()
	{
		return this.getClass();
	}
	@Override
	public void valueBound( HttpSessionBindingEvent event )
	{
		log.debug( uid +" - "+ event );
	}
	@Override
	public void valueUnbound( HttpSessionBindingEvent event )
	{
		log.debug( uid +" - "+ event );
	}
	
}
