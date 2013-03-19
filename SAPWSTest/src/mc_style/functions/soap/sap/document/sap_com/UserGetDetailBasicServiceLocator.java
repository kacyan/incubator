/**
 * UserGetDetailBasicServiceLocator.java
 *
 * このファイルはWSDLから自動生成されました / [en]-(This file was auto-generated from WSDL)
 * Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java生成器によって / [en]-(by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.)
 */

package mc_style.functions.soap.sap.document.sap_com;

public class UserGetDetailBasicServiceLocator extends org.apache.axis.client.Service implements mc_style.functions.soap.sap.document.sap_com.UserGetDetailBasicService {

    public UserGetDetailBasicServiceLocator() {
    }


    public UserGetDetailBasicServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public UserGetDetailBasicServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // UserGetDetailBasicBindのプロキシクラスの取得に使用します / [en]-(Use to get a proxy class for UserGetDetailBasicBind)
    private java.lang.String UserGetDetailBasicBind_address = "http://recc5.dev.ksi.co.jp:8000/sap/bc/srt/rfc/sap/zusergetdetail/902/usergetdetailbasicservice/usergetdetailbasicbind";

    public java.lang.String getUserGetDetailBasicBindAddress() {
        return UserGetDetailBasicBind_address;
    }

    // WSDDサービス名のデフォルトはポート名です / [en]-(The WSDD service name defaults to the port name.)
    private java.lang.String UserGetDetailBasicBindWSDDServiceName = "UserGetDetailBasicBind";

    public java.lang.String getUserGetDetailBasicBindWSDDServiceName() {
        return UserGetDetailBasicBindWSDDServiceName;
    }

    public void setUserGetDetailBasicBindWSDDServiceName(java.lang.String name) {
        UserGetDetailBasicBindWSDDServiceName = name;
    }

    public mc_style.functions.soap.sap.document.sap_com.ZUserGetDetail getUserGetDetailBasicBind() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(UserGetDetailBasicBind_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getUserGetDetailBasicBind(endpoint);
    }

    public mc_style.functions.soap.sap.document.sap_com.ZUserGetDetail getUserGetDetailBasicBind(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            mc_style.functions.soap.sap.document.sap_com.UserGetDetailBasicBindStub _stub = new mc_style.functions.soap.sap.document.sap_com.UserGetDetailBasicBindStub(portAddress, this);
            _stub.setPortName(getUserGetDetailBasicBindWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setUserGetDetailBasicBindEndpointAddress(java.lang.String address) {
        UserGetDetailBasicBind_address = address;
    }

    /**
     * 与えられたインターフェースに対して、スタブの実装を取得します。 / [en]-(For the given interface, get the stub implementation.)
     * このサービスが与えられたインターフェースに対してポートを持たない場合、 / [en]-(If this service has no port for the given interface,)
     * ServiceExceptionが投げられます。 / [en]-(then ServiceException is thrown.)
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (mc_style.functions.soap.sap.document.sap_com.ZUserGetDetail.class.isAssignableFrom(serviceEndpointInterface)) {
                mc_style.functions.soap.sap.document.sap_com.UserGetDetailBasicBindStub _stub = new mc_style.functions.soap.sap.document.sap_com.UserGetDetailBasicBindStub(new java.net.URL(UserGetDetailBasicBind_address), this);
                _stub.setPortName(getUserGetDetailBasicBindWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("インターフェースに対するスタブの実装がありません: / [en]-(There is no stub implementation for the interface:)  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * 与えられたインターフェースに対して、スタブの実装を取得します。 / [en]-(For the given interface, get the stub implementation.)
     * このサービスが与えられたインターフェースに対してポートを持たない場合、 / [en]-(If this service has no port for the given interface,)
     * ServiceExceptionが投げられます。 / [en]-(then ServiceException is thrown.)
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("UserGetDetailBasicBind".equals(inputPortName)) {
            return getUserGetDetailBasicBind();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "UserGetDetailBasicService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "UserGetDetailBasicBind"));
        }
        return ports.iterator();
    }

    /**
    * 指定したポート名に対するエンドポイントのアドレスをセットします / [en]-(Set the endpoint address for the specified port name.)
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("UserGetDetailBasicBind".equals(portName)) {
            setUserGetDetailBasicBindEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" 未知のポートに対してはエンドポイントのアドレスをセットできません / [en]-(Cannot set Endpoint Address for Unknown Port)" + portName);
        }
    }

    /**
    * 指定したポート名に対するエンドポイントのアドレスをセットします / [en]-(Set the endpoint address for the specified port name.)
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}