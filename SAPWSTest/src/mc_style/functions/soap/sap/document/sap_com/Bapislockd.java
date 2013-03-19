/**
 * Bapislockd.java
 *
 * このファイルはWSDLから自動生成されました / [en]-(This file was auto-generated from WSDL)
 * Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java生成器によって / [en]-(by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.)
 */

package mc_style.functions.soap.sap.document.sap_com;

public class Bapislockd  implements java.io.Serializable {
    private java.lang.String wrngLogon;

    private java.lang.String localLock;

    private java.lang.String globLock;

    private java.lang.String noUserPw;

    public Bapislockd() {
    }

    public Bapislockd(
           java.lang.String wrngLogon,
           java.lang.String localLock,
           java.lang.String globLock,
           java.lang.String noUserPw) {
           this.wrngLogon = wrngLogon;
           this.localLock = localLock;
           this.globLock = globLock;
           this.noUserPw = noUserPw;
    }


    /**
     * Gets the wrngLogon value for this Bapislockd.
     * 
     * @return wrngLogon
     */
    public java.lang.String getWrngLogon() {
        return wrngLogon;
    }


    /**
     * Sets the wrngLogon value for this Bapislockd.
     * 
     * @param wrngLogon
     */
    public void setWrngLogon(java.lang.String wrngLogon) {
        this.wrngLogon = wrngLogon;
    }


    /**
     * Gets the localLock value for this Bapislockd.
     * 
     * @return localLock
     */
    public java.lang.String getLocalLock() {
        return localLock;
    }


    /**
     * Sets the localLock value for this Bapislockd.
     * 
     * @param localLock
     */
    public void setLocalLock(java.lang.String localLock) {
        this.localLock = localLock;
    }


    /**
     * Gets the globLock value for this Bapislockd.
     * 
     * @return globLock
     */
    public java.lang.String getGlobLock() {
        return globLock;
    }


    /**
     * Sets the globLock value for this Bapislockd.
     * 
     * @param globLock
     */
    public void setGlobLock(java.lang.String globLock) {
        this.globLock = globLock;
    }


    /**
     * Gets the noUserPw value for this Bapislockd.
     * 
     * @return noUserPw
     */
    public java.lang.String getNoUserPw() {
        return noUserPw;
    }


    /**
     * Sets the noUserPw value for this Bapislockd.
     * 
     * @param noUserPw
     */
    public void setNoUserPw(java.lang.String noUserPw) {
        this.noUserPw = noUserPw;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Bapislockd)) return false;
        Bapislockd other = (Bapislockd) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.wrngLogon==null && other.getWrngLogon()==null) || 
             (this.wrngLogon!=null &&
              this.wrngLogon.equals(other.getWrngLogon()))) &&
            ((this.localLock==null && other.getLocalLock()==null) || 
             (this.localLock!=null &&
              this.localLock.equals(other.getLocalLock()))) &&
            ((this.globLock==null && other.getGlobLock()==null) || 
             (this.globLock!=null &&
              this.globLock.equals(other.getGlobLock()))) &&
            ((this.noUserPw==null && other.getNoUserPw()==null) || 
             (this.noUserPw!=null &&
              this.noUserPw.equals(other.getNoUserPw())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getWrngLogon() != null) {
            _hashCode += getWrngLogon().hashCode();
        }
        if (getLocalLock() != null) {
            _hashCode += getLocalLock().hashCode();
        }
        if (getGlobLock() != null) {
            _hashCode += getGlobLock().hashCode();
        }
        if (getNoUserPw() != null) {
            _hashCode += getNoUserPw().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // メタデータ型 / [en]-(Type metadata)
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Bapislockd.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "Bapislockd"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("wrngLogon");
        elemField.setXmlName(new javax.xml.namespace.QName("", "WrngLogon"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("localLock");
        elemField.setXmlName(new javax.xml.namespace.QName("", "LocalLock"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("globLock");
        elemField.setXmlName(new javax.xml.namespace.QName("", "GlobLock"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("noUserPw");
        elemField.setXmlName(new javax.xml.namespace.QName("", "NoUserPw"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * メタデータオブジェクトの型を返却 / [en]-(Return type metadata object)
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
