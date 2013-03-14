package jp.co.ksi.sap.incubator;

import java.util.Iterator;

import jp.co.ksi.eip.commons.util.StringUtil;

import org.apache.log4j.Logger;

import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;
import com.sap.conn.jco.JCoField;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoMetaData;
import com.sap.conn.jco.JCoParameterList;
import com.sap.conn.jco.JCoStructure;
import com.sap.conn.jco.JCoTable;
import com.sap.conn.jco.ext.Environment;

/**
 * JCoDestinationの習作
 * @author kac
 * @since 2013/03/08
 * @version 2013/03/08
 * <pre>
 * JCoDestinationのJavadocによると、
 * 　JCoDestinationは、JCoランタイムがコネクションを生成するのために必要な情報を持っているだけ。
 * 　それ自身で接続を作成しないし保持しない。
 * 　JCoランタイムがコネクションの生成を行い、設定によってはプーリングも行う。
 * と書いてある。
 * JCoランタイムとは、sapjco3.dllやsapjco3.soの事だ。
 * コネクションの管理は、sapjco3.dll等で行われているという事だろう。
 * 
 * JNIでのdllは、javaインスタンスで１個ロードされると思う。
 * ということはコネクションの管理は、javaインスタンス内で共通管理されるのか？
 * サーブレット環境であれば、１つのjavaインスタンスで複数コンテキストというのが一般的だ。
 * そしてコンテキスト間でデータは独立している。
 * JCoランタイムは、コンテキスト間でも共通という事だろうか？
 * 
 * 
 * </pre>
 */
public class TestJCoDestination
{

	private static Logger	log= Logger.getLogger( TestJCoDestination.class );
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		String functionName = "BAPI_SALESORDER_GETSTATUS";
		functionName= "BAPI_EQUI_GETLIST";	//	importがないやつ
		functionName= "RFC_READ_TABLE";
		
		UserDestinationDataProvider	provider= new UserDestinationDataProvider();
		try
		{
			Environment.registerDestinationDataProvider( provider );
						
			//	${host}:${systemNumber}:${clientNumber}:${uid}:${pwd}
			JCoDestination	destination= JCoDestinationManager.getDestination( "133.253.62.89:00:903:4501911013:password25" );
			
			JCoFunction	function= destination.getRepository().getFunction( functionName );
			System.out.println( function );
			
			JCoParameterList	importParameterList= function.getImportParameterList();
			if( importParameterList != null )
			{
				importParameterList.setValue(  "QUERY_TABLE", "TFTIT" );
				importParameterList.setValue( "ROWCOUNT", 10 );
				debugMetaData( importParameterList.getMetaData(), 0 );
			}
			
			JCoParameterList	tableParameterList= function.getTableParameterList();
			if( tableParameterList != null )
			{
				debugMetaData( tableParameterList.getMetaData(), 0 );
			}
			
			JCoParameterList	changingParameterList= function.getChangingParameterList();
			if( changingParameterList != null )
			{
				debugMetaData( changingParameterList.getMetaData(), 0 );
			}

			JCoParameterList	exportParameterList= function.getExportParameterList();
			if( exportParameterList != null )
			{
				debugMetaData( exportParameterList.getMetaData(), 0 );
			}
			
			function.execute( destination );
			System.out.println( "----+----+----+----+----+----+----+----+----+----+----+----" );
			
			exportParameterList= function.getExportParameterList();
			if( exportParameterList != null )
			{
				debugParameterList( exportParameterList );
			}
			
			tableParameterList= function.getTableParameterList();
			if( tableParameterList != null )
			{
				log.debug( tableParameterList.getValue( "DATA" ) );
				JCoTable	table= (JCoTable)tableParameterList.getValue( "DATA" );
				log.debug( table.getClassNameOfValue( "WA" ) );
				log.debug( table.getString( "WA" ) );
				log.debug( table.getValue( "WA" ) );
				log.debug( table.getValue( "WA" ).getClass().getName() );
				System.out.println();
				
				debugParameterList( tableParameterList );
			}
			
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}

	}

	private static void debugParameterList( JCoParameterList parameterList )
	{
		JCoMetaData	md= parameterList.getMetaData();
		for( int i= 0; i < md.getFieldCount(); i++ )
		{
			String	name= md.getName( i );
			Object	value= parameterList.getValue( name );
			if( value instanceof JCoTable )
			{
				JCoTable table= (JCoTable)value;
				for( Iterator<JCoField> it= table.iterator(); it.hasNext(); )
				{
					JCoField	field= it.next();
					if( field.isInitialized() )
					{
						log.debug( name +"."+ field.getName() +"="+ field.getValue() +" - "+ field.getClassNameOfValue() );
					}
					else
					{
						log.debug( name +"."+ field.getName() +"="+ "" +" - "+ field.getClassNameOfValue() );
					}
				}
			}
			else if( value instanceof JCoStructure )
			{
				JCoStructure structure= (JCoStructure)value;
				for( Iterator<JCoField> it= structure.iterator(); it.hasNext(); )
				{
					JCoField	field= it.next();
					log.debug( name +"."+ field.getName() +"="+ field.getValue() +" - "+ field.getTypeAsString() );
				}
			}
			else
			{
				log.debug( name +"="+ value );
			}
		}
		
	}

	/**
	 * パラメータのメタデータを表示する
	 * @param params
	 */
	public static void debugMetaData( JCoMetaData md, int nest ) {

		String	indent= StringUtil.generateText( "　", nest );
		log.debug( indent +"md.name="+ md.getName() +", "+ md.getFieldCount() );

		for( int i= 0; i < md.getFieldCount(); i++ )
		{
			log.debug( indent +"name="+ md.getName(i)
					+", type="+ md.getTypeAsString(i)
					+", recordType="+ md.getRecordTypeName(i)
					+", className="+ md.getClassNameOfField(i)
					+", length="+ md.getLength(i)
					+", description="+ md.getDescription(i) );

			if( md.isStructure(i) || md.isTable(i) )
			{//	構造体 or テーブル
				debugMetaData( md.getRecordMetaData(i), nest+1 );
			}
		}
	}

}
