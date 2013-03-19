/**
 * Bapiprof.java
 *
 * このファイルはWSDLから自動生成されました / [en]-(This file was auto-generated from WSDL)
 * Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java生成器によって / [en]-(by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.)
 */

package mc_style.functions.soap.sap.document.sap_com;

public class Bapiprof  implements java.io.Serializable {
    private java.lang.String bapiprof;

    private java.lang.String bapiptext;

    private java.lang.String bapitype;

    private java.lang.String bapiaktps;

    public Bapiprof() {
    }

    public Bapiprof(
           java.lang.String bapiprof,
           java.lang.String bapiptext,
           java.lang.String bapitype,
           java.lang.String bapiaktps) {
           this.bapiprof = bapiprof;
           this.bapiptext = bapiptext;
           this.bapitype = bapitype;
           this.bapiaktps = bapiaktps;
    }


    /**
     * Gets the bapiprof value for this Bapiprof.
     * 
     * @return bapiprof
     */
    public java.lang.String getBapiprof() {
        return bapiprof;
    }


    /**
     * Sets the bapiprof value for this Bapiprof.
     * 
     * @param bapiprof
     */
    public void setBapiprof(java.lang.String bapiprof) {
        this.bapiprof = bapiprof;
    }


    /**
     * Gets the bapiptext value for this Bapiprof.
     * 
     * @return bapiptext
     */
    public java.lang.String getBapiptext() {
        return bapiptext;
    }


    /**
     * Sets the bapiptext value for this Bapiprof.
     * 
     * @param bapiptext
     */
    public void setBapiptext(java.lang.String bapiptext) {
        this.bapiptext = bapiptext;
    }


    /**
     * Gets the bapitype value for this Bapiprof.
     * 
     * @return bapitype
     */
    public java.lang.String getBapitype() {
        return bapitype;
    }


    /**
     * Sets the bapitype value for this Bapiprof.
     * 
     * @param bapitype
     */
    public void setBapitype(java.lang.String bapitype) {
        this.bapitype = bapitype;
    }


    /**
     * Gets the bapiaktps value for this Bapiprof.
     * 
     * @return bapiaktps
     */
    public java.lang.String getBapiaktps() {
        return bapiaktps;
    }


    /**
     * Sets the bapiaktps value for this Bapiprof.
     * 
     * @param bapiaktps
     */
    public void setBapiaktps(java.lang.String bapiaktps) {
        this.bapiaktps = bapiaktps;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Bapiprof)) return false;
        Bapiprof other = (Bapiprof) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.bapiprof==null && other.getBapiprof()==null) || 
             (this.bapiprof!=null &&
              this.bapiprof.equals(other.getBapiprof()))) &&
            ((this.bapiptext==null && other.getBapiptext()==null) || 
             (this.bapiptext!=null &&
              this.bapiptext.equals(other.getBapiptext()))) &&
            ((this.bapitype==null && other.getBapitype()==null) || 
             (this.bapitype!=null &&
              this.bapitype.equals(other.getBapitype()))) &&
            ((this.bapiaktps==null && other.getBapiaktps()==null) || 
             (this.bapiaktps!=null &&
              this.bapiaktps.equals(other.getBapiaktps())));
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
        if (getBapiprof() != null) {
            _hashCode += getBapiprof().hashCode();
        }
        if (getBapiptext() != null) {
            _hashCode += getBapiptext().hashCode();
        }
        if (getBapitype() != null) {
            _hashCode += getBapitype().hashCode();
        }
        if (getBapiaktps() != null) {
            _hashCode += getBapiaktps().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // メタデータ型 / [en]-(Type metadata)
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Bapiprof.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "Bapiprof"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bapiprof");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Bapiprof"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bapiptext");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Bapiptext"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bapitype");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Bapitype"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bapiaktps");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Bapiaktps"));
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
