package jp.co.ksi.sap.test;
import java.util.Iterator;
import java.util.Map;

import javax.xml.soap.MimeHeader;
import javax.xml.soap.MimeHeaders;

import org.apache.axis.Message;
import org.apache.axis.MessageContext;
import org.apache.axis.message.SOAPHeaderElement;
import org.apache.axis.transport.http.HTTPConstants;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

import mc_style.functions.soap.sap.document.sap_com.UserGetDetailBasicBindStub;
import mc_style.functions.soap.sap.document.sap_com.UserGetDetailBasicServiceLocator;
import mc_style.functions.soap.sap.document.sap_com.ZUserGetDetail;
import mc_style.functions.soap.sap.document.sap_com.holders.Bapiaddr3Holder;
import mc_style.functions.soap.sap.document.sap_com.holders.BapialiasHolder;
import mc_style.functions.soap.sap.document.sap_com.holders.BapidefaulHolder;
import mc_style.functions.soap.sap.document.sap_com.holders.BapilogondHolder;
import mc_style.functions.soap.sap.document.sap_com.holders.BapimoddatHolder;
import mc_style.functions.soap.sap.document.sap_com.holders.BapirefusHolder;
import mc_style.functions.soap.sap.document.sap_com.holders.BapislockdHolder;
import mc_style.functions.soap.sap.document.sap_com.holders.BapisncuHolder;
import mc_style.functions.soap.sap.document.sap_com.holders.BapiuclassHolder;
import mc_style.functions.soap.sap.document.sap_com.holders.BapiuscompHolder;
import mc_style.functions.soap.sap.document.sap_com.holders.TableOfBapiadfaxHolder;
import mc_style.functions.soap.sap.document.sap_com.holders.TableOfBapiadpagHolder;
import mc_style.functions.soap.sap.document.sap_com.holders.TableOfBapiadprtHolder;
import mc_style.functions.soap.sap.document.sap_com.holders.TableOfBapiadrfcHolder;
import mc_style.functions.soap.sap.document.sap_com.holders.TableOfBapiadrmlHolder;
import mc_style.functions.soap.sap.document.sap_com.holders.TableOfBapiadsmtpHolder;
import mc_style.functions.soap.sap.document.sap_com.holders.TableOfBapiadssfHolder;
import mc_style.functions.soap.sap.document.sap_com.holders.TableOfBapiadtelHolder;
import mc_style.functions.soap.sap.document.sap_com.holders.TableOfBapiadtlxHolder;
import mc_style.functions.soap.sap.document.sap_com.holders.TableOfBapiadttxHolder;
import mc_style.functions.soap.sap.document.sap_com.holders.TableOfBapiaduriHolder;
import mc_style.functions.soap.sap.document.sap_com.holders.TableOfBapiadx400Holder;
import mc_style.functions.soap.sap.document.sap_com.holders.TableOfBapiagrHolder;
import mc_style.functions.soap.sap.document.sap_com.holders.TableOfBapicomremHolder;
import mc_style.functions.soap.sap.document.sap_com.holders.TableOfBapigroupsHolder;
import mc_style.functions.soap.sap.document.sap_com.holders.TableOfBapiparam1Holder;
import mc_style.functions.soap.sap.document.sap_com.holders.TableOfBapiparamHolder;
import mc_style.functions.soap.sap.document.sap_com.holders.TableOfBapiprofHolder;
import mc_style.functions.soap.sap.document.sap_com.holders.TableOfBapircvsysHolder;
import mc_style.functions.soap.sap.document.sap_com.holders.TableOfBapiret2Holder;
import mc_style.functions.soap.sap.document.sap_com.holders.TableOfBapiuclasssysHolder;
import mc_style.functions.soap.sap.document.sap_com.holders.TableOfBapiusextidheadHolder;
import mc_style.functions.soap.sap.document.sap_com.holders.TableOfBapiusextidpartHolder;

/**
 * BASIC認証が設定されているSOAPを呼び出す習作
 * <pre>
 * axisを使った例になります。
 * 他のSOAPライブライでは、やり方が異なります。
 * </pre>
 * @author kac
 * @since 2013/03/19
 * @version 2013/03/19
 */
public class TestUserGetDetailBasic
{

	private static Logger	log= Logger.getLogger( TestUserGetDetailBasic.class );
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		String uid= "";
		if( args.length > 0 )
		{
			uid= args[0];
		}
		String pwd= "";
		if( args.length > 1 )
		{
			pwd= args[1];
		}

		TableOfBapiagrHolder activitygroups= new TableOfBapiagrHolder();
		TableOfBapicomremHolder addcomrem= new TableOfBapicomremHolder();
		TableOfBapiadfaxHolder addfax= new TableOfBapiadfaxHolder();
		TableOfBapiadpagHolder addpag= new TableOfBapiadpagHolder();
		TableOfBapiadprtHolder addprt= new TableOfBapiadprtHolder();
		TableOfBapiadrfcHolder addrfc= new TableOfBapiadrfcHolder();
		TableOfBapiadrmlHolder addrml= new TableOfBapiadrmlHolder();
		TableOfBapiadsmtpHolder addsmtp= new TableOfBapiadsmtpHolder();
		TableOfBapiadssfHolder addssf= new TableOfBapiadssfHolder();
		TableOfBapiadtelHolder addtel= new TableOfBapiadtelHolder();
		TableOfBapiadtlxHolder addtlx= new TableOfBapiadtlxHolder();
		TableOfBapiadttxHolder addttx= new TableOfBapiadttxHolder();
		TableOfBapiaduriHolder adduri= new TableOfBapiaduriHolder();
		TableOfBapiadx400Holder addx400= new TableOfBapiadx400Holder();
		String cacheResults= "";
		TableOfBapiusextidheadHolder extidhead= new TableOfBapiusextidheadHolder();
		TableOfBapiusextidpartHolder extidpart= new TableOfBapiusextidpartHolder();
		TableOfBapigroupsHolder groups= new TableOfBapigroupsHolder();
		TableOfBapiparamHolder parameter= new TableOfBapiparamHolder();
		TableOfBapiparam1Holder parameter1= new TableOfBapiparam1Holder();
		TableOfBapiprofHolder profiles= new TableOfBapiprofHolder();
		TableOfBapiret2Holder _return= new TableOfBapiret2Holder();
		TableOfBapircvsysHolder systems= new TableOfBapircvsysHolder();
		TableOfBapiuclasssysHolder uclasssys= new TableOfBapiuclasssysHolder();
		String username= "4501911013";
		Bapiaddr3Holder address= new Bapiaddr3Holder();
		BapialiasHolder alias= new BapialiasHolder();
		BapiuscompHolder company= new BapiuscompHolder();
		BapidefaulHolder defaults= new BapidefaulHolder();
		BapislockdHolder islocked= new BapislockdHolder();
		BapimoddatHolder lastmodified= new BapimoddatHolder();
		BapilogondHolder logondata= new BapilogondHolder();
		BapirefusHolder refUser= new BapirefusHolder();
		BapisncuHolder snc= new BapisncuHolder();
		BapiuclassHolder uclass= new BapiuclassHolder();

		try
		{
			//	locatorを生成し、サービスを取得する
			UserGetDetailBasicServiceLocator	locator= new UserGetDetailBasicServiceLocator();
			ZUserGetDetail	zUserGetDetail= locator.getUserGetDetailBasicBind();
			
			if( zUserGetDetail instanceof UserGetDetailBasicBindStub )
			{//	スタブがあるなら、認証情報を付加する
				UserGetDetailBasicBindStub	stub= (UserGetDetailBasicBindStub)zUserGetDetail;
				stub.setUsername( uid );
				stub.setPassword( pwd );
				
				//	KacDebug
				SOAPHeaderElement[]	elements= stub.getHeaders();
				log.debug( "stub.getHeaders().length="+ elements.length );
				for( int i= 0; i < elements.length; i++ )
				{
					log.debug( elements[i] );
				}
				
			}
			
			//	サービスメソッドを実行する
			zUserGetDetail.userGetDetail( activitygroups, addcomrem, addfax, addpag, addprt, addrfc,
					addrml, addsmtp, addssf, addtel, addtlx, addttx, adduri, addx400, cacheResults, extidhead,
					extidpart, groups, parameter, parameter1, profiles, _return, systems, uclasssys, username,
					address, alias, company, defaults, islocked, lastmodified, logondata, refUser, snc, uclass );
			
			//	結果を表示する(addressの中身を表示してみる)
			log.info( "address.fullname="+ address.value.getFullname() );
			log.info( "address.city="+ address.value.getCity() );
			log.info( "address.postlCod1="+ address.value.getPostlCod1() );
			log.info( "address.addrNo="+ address.value.getAddrNo() );

//			Map<?,?>	m= BeanUtils.describe( address.value );
//			for( Iterator<?> i= m.keySet().iterator(); i.hasNext(); )
//			{
//				Object	key= i.next();
//				log.info( "address: "+ key +"="+ m.get( key ) );
//			}

			if( zUserGetDetail instanceof UserGetDetailBasicBindStub )
			{//	スタブがあるなら、認証情報を取得する
				UserGetDetailBasicBindStub	stub= (UserGetDetailBasicBindStub)zUserGetDetail;
				MessageContext	msgContext= stub._getCall().getMessageContext();
				Message	responseMsg= msgContext.getResponseMessage();
				MimeHeaders	headers= responseMsg.getMimeHeaders();
				for( Iterator i= headers.getAllHeaders(); i.hasNext(); )
				{
					MimeHeader	header= (MimeHeader)i.next();
					log.debug( "[ResponseHeader] "+ header.getName() +"="+ header.getValue() );
				}

				//	ssoTicketを取得する
				String	mysapsso2= "";
				String[]	cookies= stub._getCall().getMessageContext().getResponseMessage().getMimeHeaders().getHeader( HTTPConstants.HEADER_SET_COOKIE );
				if( cookies != null )
				{
					for( int i= 0; i < cookies.length; i++ )
					{
						int	start= cookies[i].indexOf( "=" );
						if( start <= 0 )
						{
							continue;
						}
						String	name= cookies[i].substring( 0, start );
						int	end= cookies[i].indexOf( ";", start+1 );
						if( end < 0 )
						{
							continue;
						}
						mysapsso2= cookies[i].substring( start+1, end );
						log.debug( name +"="+ mysapsso2 );
						if( "mysapsso2".equalsIgnoreCase( name ) )
						{
							break;
						}
					}
				}
				log.info( "mysapsso2="+ mysapsso2 );
			}

		} catch (Exception e) {

			log.error( "", e );
			System.out.println( "tomcat.home="+ System.getProperty( "tomcat.home" ) );
			System.out.println( "user.home="+ System.getProperty( "user.home" ) );
			System.out.println( "user.dir="+ System.getProperty( "user.dir" ) );
		}


	}

}
