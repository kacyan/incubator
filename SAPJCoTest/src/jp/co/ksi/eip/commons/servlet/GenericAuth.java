package jp.co.ksi.eip.commons.servlet;

/**
 * 認証情報
 * @author kac
 * @since 2013/03/27
 * @version 2013/03/27
 */
public class GenericAuth implements Auth
{
	private String user;
	
	/* (非 Javadoc)
	 * @see jp.co.ksi.eip.commons.servlet.Auth#isValid()
	 */
	@Override
	public boolean isValid()
	{
		return !user.isEmpty();
	}
	
	/* (非 Javadoc)
	 * @see jp.co.ksi.eip.commons.servlet.Auth#getAuthClass()
	 */
	@Override
	public Class getAuthClass()
	{
		return this.getClass();
	}
	
	public String getUser()
	{
		return user;
	}
	public void setUser( String user )
	{
		this.user= user;
	}
	
	public String toString()
	{
		return getUser();
	}
	
}
