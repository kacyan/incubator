package jp.co.ksi.sap.incubator;

import org.apache.log4j.Logger;

import com.sap.conn.jco.ext.ClientPassportManager;
import com.sap.jdsr.passport.DSRPassport;
import com.sap.jdsr.writer.DsrIPassport;

/**
 * ClientPassportManagerの習作
 * @author kac
 * jdsr.jar をNWDS-7.3から持って来た。
 */
public class KacPassportManager implements ClientPassportManager {

	private static Logger	log= Logger.getLogger( KacPassportManager.class );

	@Override
	public void callFinished(int i, long l, long l1) {
		// TODO 自動生成されたメソッド・スタブ
		log.info( "i="+ i +", l="+ l +", l1="+ l1 );
	}

	@Override
	public DsrIPassport callStarted(int i, String s, String s1) {
		// TODO 自動生成されたメソッド・スタブ
		log.info( "i="+ i +", s="+ s +", s1="+ s1 );
		int	version= 0;
		int	traceFlag= 0;
		String	systemId= "";
		int	service= 0;
		String	user= "4501911013";
		String	action= "";
		int	actionType= 0;
		String prevSystemId= "";
		String	transId= "";
		String	clientNumber= "";
		int	systemType= 0;
		byte[]	rootContextId= {};
		byte[]	connectionId= {};
		int	connectionCounter= 0;
		DSRPassport	dsr= new DSRPassport( version, traceFlag, systemId,
				service, user, action, actionType, prevSystemId, transId,
				clientNumber, systemType, rootContextId, connectionId, connectionCounter );

		return dsr;
	}

}
