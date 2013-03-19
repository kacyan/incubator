/**
 * Bapimoddat.java
 *
 * このファイルはWSDLから自動生成されました / [en]-(This file was auto-generated from WSDL)
 * Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java生成器によって / [en]-(by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.)
 */

package mc_style.functions.soap.sap.document.sap_com;

public class Bapimoddat  implements java.io.Serializable {
    private java.lang.String moddate;

    private java.lang.String modtime;

    public Bapimoddat() {
    }

    public Bapimoddat(
           java.lang.String moddate,
           java.lang.String modtime) {
           this.moddate = moddate;
           this.modtime = modtime;
    }


    /**
     * Gets the moddate value for this Bapimoddat.
     * 
     * @return moddate
     */
    public java.lang.String getModdate() {
        return moddate;
    }


    /**
     * Sets the moddate value for this Bapimoddat.
     * 
     * @param moddate
     */
    public void setModdate(java.lang.String moddate) {
        this.moddate = moddate;
    }


    /**
     * Gets the modtime value for this Bapimoddat.
     * 
     * @return modtime
     */
    public java.lang.String getModtime() {
        return modtime;
    }


    /**
     * Sets the modtime value for this Bapimoddat.
     * 
     * @param modtime
     */
    public void setModtime(java.lang.String modtime) {
        this.modtime = modtime;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Bapimoddat)) return false;
        Bapimoddat other = (Bapimoddat) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.moddate==null && other.getModdate()==null) || 
             (this.moddate!=null &&
              this.moddate.equals(other.getModdate()))) &&
            ((this.modtime==null && other.getModtime()==null) || 
             (this.modtime!=null &&
              this.modtime.equals(other.getModtime())));
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
        if (getModdate() != null) {
            _hashCode += getModdate().hashCode();
        }
        if (getModtime() != null) {
            _hashCode += getModtime().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // メタデータ型 / [en]-(Type metadata)
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Bapimoddat.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "Bapimoddat"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("moddate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Moddate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("modtime");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Modtime"));
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
