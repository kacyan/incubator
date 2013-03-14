
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		String	src= "AAA, BBB, CCC, ";
		String	dst= "";

		System.out.println( "["+ src +"]" );
		dst= src.replaceFirst( ", \\z", "" );
		System.out.println( "["+ dst +"]" );

		System.out.println( src.matches(", \\z") );
	}

}
