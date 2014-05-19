package jp.co.ksi.incubator;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * log4jの習作
 * @author kac
 *
 */
public class Log4jTest
{
	private static Logger	log= Logger.getLogger( Log4jTest.class );
	
	/**
	 * @param args
	 */
	public static void main( String[] args )
	{
		System.out.println( System.getProperty( LogManager.DEFAULT_CONFIGURATION_KEY ) );
		log.debug( "KacDebug" );
		
	}
	
}
