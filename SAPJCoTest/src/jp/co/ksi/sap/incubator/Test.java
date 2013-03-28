package jp.co.ksi.sap.incubator;

public class Test
{

	/**
	 * @param args
	 */
	public static void main( String[] args )
	{
		String	src= "/SAPJCoTest/jcoLogin.jsp";
		
		System.out.println( src.matches( ".*[Ll][Oo][Gg][Ii][Nn].*" ) );
		
		String regex= ".*/jcoLogin.jsp|.*/login.do|.*/check.jsp";
		System.out.println( src.matches( regex ) );
		src= "aaa/check.jsp";
		System.out.println( src.matches( regex ) );
		src= "aaa/jcoLogin.jsp";
		System.out.println( src.matches( regex ) );
		src= "aaa/login.do";
		System.out.println( src.matches( regex ) );
		
	}

}
