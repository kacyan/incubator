/**
 * Bapisncu.java
 *
 * このファイルはWSDLから自動生成されました / [en]-(This file was auto-generated from WSDL)
 * Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java生成器によって / [en]-(by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.)
 */

package mc_style.functions.soap.sap.document.sap_com;

public class Bapisncu  implements java.io.Serializable {
    private java.lang.String guiflag;

    private java.lang.String pname;

    public Bapisncu() {
    }

    public Bapisncu(
           java.lang.String guiflag,
           java.lang.String pname) {
           this.guiflag = guiflag;
           this.pname = pname;
    }


    /**
     * Gets the guiflag value for this Bapisncu.
     * 
     * @return guiflag
     */
    public java.lang.String getGuiflag() {
        return guiflag;
    }


    /**
     * Sets the guiflag value for this Bapisncu.
     * 
     * @param guiflag
     */
    public void setGuiflag(java.lang.String guiflag) {
        this.guiflag = guiflag;
    }


    /**
     * Gets the pname value for this Bapisncu.
     * 
     * @return pname
     */
    public java.lang.String getPname() {
        return pname;
    }


    /**
     * Sets the pname value for this Bapisncu.
     * 
     * @param pname
     */
    public void setPname(java.lang.String pname) {
        this.pname = pname;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Bapisncu)) return false;
        Bapisncu other = (Bapisncu) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.guiflag==null && other.getGuiflag()==null) || 
             (this.guiflag!=null &&
              this.guiflag.equals(other.getGuiflag()))) &&
            ((this.pname==null && other.getPname()==null) || 
             (this.pname!=null &&
              this.pname.equals(other.getPname())));
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
        if (getGuiflag() != null) {
            _hashCode += getGuiflag().hashCode();
        }
        if (getPname() != null) {
            _hashCode += getPname().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // メタデータ型 / [en]-(Type metadata)
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Bapisncu.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "Bapisncu"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("guiflag");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Guiflag"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pname");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Pname"));
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
