package jp.co.ksi.sap.incubator;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

import org.apache.log4j.Logger;

/**
 * SAPアクセス用の認証情報
 * @author kac
 * @since 2013/03/18
 * @version 2013/03/18
 */
public class Auth implements HttpSessionBindingListener, Serializable
{
	private static final long serialVersionUID= 1L;

	private static Logger	log= Logger.getLogger( Auth.class );
	
	private String	uid;
	private String	ssoTicket;
	private String	host;
	private	String	systemNumber;
	private String	clientNumber;
	
	public String getUid()
	{
		return uid;
	}
	public void setUid( String uid )
	{
		this.uid= uid;
	}
	public String getSsoTicket()
	{
		return ssoTicket;
	}
	public void setSsoTicket( String ssoTicket )
	{
		this.ssoTicket= ssoTicket;
	}
	public String getHost()
	{
		return host;
	}
	public void setHost( String host )
	{
		this.host= host;
	}
	public String getSystemNumber()
	{
		return systemNumber;
	}
	public void setSystemNumber( String systemNumber )
	{
		this.systemNumber= systemNumber;
	}
	public String getClientNumber()
	{
		return clientNumber;
	}
	public void setClientNumber( String clientNumber )
	{
		this.clientNumber= clientNumber;
	}
	
	public String toString()
	{
		return host +":"+ systemNumber +":"+ clientNumber +":"+ uid;
	}
	@Override
	public void valueBound( HttpSessionBindingEvent arg0 )
	{
		log.debug( this.toString() );
	}
	@Override
	public void valueUnbound( HttpSessionBindingEvent arg0 )
	{
		log.debug( this.toString() );
	}
	
}
