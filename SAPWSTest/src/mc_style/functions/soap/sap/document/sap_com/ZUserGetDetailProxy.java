package mc_style.functions.soap.sap.document.sap_com;

public class ZUserGetDetailProxy implements mc_style.functions.soap.sap.document.sap_com.ZUserGetDetail {
  private String _endpoint = null;
  private mc_style.functions.soap.sap.document.sap_com.ZUserGetDetail zUserGetDetail = null;
  
  public ZUserGetDetailProxy() {
    _initZUserGetDetailProxy();
  }
  
  public ZUserGetDetailProxy(String endpoint) {
    _endpoint = endpoint;
    _initZUserGetDetailProxy();
  }
  
  private void _initZUserGetDetailProxy() {
    try {
      zUserGetDetail = (new mc_style.functions.soap.sap.document.sap_com.UserGetDetailTicket2Service2Locator()).getUserGetDetailTicketBind2();
      if (zUserGetDetail != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)zUserGetDetail)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)zUserGetDetail)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (zUserGetDetail != null)
      ((javax.xml.rpc.Stub)zUserGetDetail)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public mc_style.functions.soap.sap.document.sap_com.ZUserGetDetail getZUserGetDetail() {
    if (zUserGetDetail == null)
      _initZUserGetDetailProxy();
    return zUserGetDetail;
  }
  
  public void userGetDetail(mc_style.functions.soap.sap.document.sap_com.holders.TableOfBapiagrHolder activitygroups, mc_style.functions.soap.sap.document.sap_com.holders.TableOfBapicomremHolder addcomrem, mc_style.functions.soap.sap.document.sap_com.holders.TableOfBapiadfaxHolder addfax, mc_style.functions.soap.sap.document.sap_com.holders.TableOfBapiadpagHolder addpag, mc_style.functions.soap.sap.document.sap_com.holders.TableOfBapiadprtHolder addprt, mc_style.functions.soap.sap.document.sap_com.holders.TableOfBapiadrfcHolder addrfc, mc_style.functions.soap.sap.document.sap_com.holders.TableOfBapiadrmlHolder addrml, mc_style.functions.soap.sap.document.sap_com.holders.TableOfBapiadsmtpHolder addsmtp, mc_style.functions.soap.sap.document.sap_com.holders.TableOfBapiadssfHolder addssf, mc_style.functions.soap.sap.document.sap_com.holders.TableOfBapiadtelHolder addtel, mc_style.functions.soap.sap.document.sap_com.holders.TableOfBapiadtlxHolder addtlx, mc_style.functions.soap.sap.document.sap_com.holders.TableOfBapiadttxHolder addttx, mc_style.functions.soap.sap.document.sap_com.holders.TableOfBapiaduriHolder adduri, mc_style.functions.soap.sap.document.sap_com.holders.TableOfBapiadx400Holder addx400, java.lang.String cacheResults, mc_style.functions.soap.sap.document.sap_com.holders.TableOfBapiusextidheadHolder extidhead, mc_style.functions.soap.sap.document.sap_com.holders.TableOfBapiusextidpartHolder extidpart, mc_style.functions.soap.sap.document.sap_com.holders.TableOfBapigroupsHolder groups, mc_style.functions.soap.sap.document.sap_com.holders.TableOfBapiparamHolder parameter, mc_style.functions.soap.sap.document.sap_com.holders.TableOfBapiparam1Holder parameter1, mc_style.functions.soap.sap.document.sap_com.holders.TableOfBapiprofHolder profiles, mc_style.functions.soap.sap.document.sap_com.holders.TableOfBapiret2Holder _return, mc_style.functions.soap.sap.document.sap_com.holders.TableOfBapircvsysHolder systems, mc_style.functions.soap.sap.document.sap_com.holders.TableOfBapiuclasssysHolder uclasssys, java.lang.String username, mc_style.functions.soap.sap.document.sap_com.holders.Bapiaddr3Holder address, mc_style.functions.soap.sap.document.sap_com.holders.BapialiasHolder alias, mc_style.functions.soap.sap.document.sap_com.holders.BapiuscompHolder company, mc_style.functions.soap.sap.document.sap_com.holders.BapidefaulHolder defaults, mc_style.functions.soap.sap.document.sap_com.holders.BapislockdHolder islocked, mc_style.functions.soap.sap.document.sap_com.holders.BapimoddatHolder lastmodified, mc_style.functions.soap.sap.document.sap_com.holders.BapilogondHolder logondata, mc_style.functions.soap.sap.document.sap_com.holders.BapirefusHolder refUser, mc_style.functions.soap.sap.document.sap_com.holders.BapisncuHolder snc, mc_style.functions.soap.sap.document.sap_com.holders.BapiuclassHolder uclass) throws java.rmi.RemoteException{
    if (zUserGetDetail == null)
      _initZUserGetDetailProxy();
    zUserGetDetail.userGetDetail(activitygroups, addcomrem, addfax, addpag, addprt, addrfc, addrml, addsmtp, addssf, addtel, addtlx, addttx, adduri, addx400, cacheResults, extidhead, extidpart, groups, parameter, parameter1, profiles, _return, systems, uclasssys, username, address, alias, company, defaults, islocked, lastmodified, logondata, refUser, snc, uclass);
  }
  
  
}