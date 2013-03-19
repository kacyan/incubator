/**
 * Bapiparam1.java
 *
 * このファイルはWSDLから自動生成されました / [en]-(This file was auto-generated from WSDL)
 * Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java生成器によって / [en]-(by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.)
 */

package mc_style.functions.soap.sap.document.sap_com;

public class Bapiparam1  implements java.io.Serializable {
    private java.lang.String parid;

    private java.lang.String parva;

    private java.lang.String partxt;

    public Bapiparam1() {
    }

    public Bapiparam1(
           java.lang.String parid,
           java.lang.String parva,
           java.lang.String partxt) {
           this.parid = parid;
           this.parva = parva;
           this.partxt = partxt;
    }


    /**
     * Gets the parid value for this Bapiparam1.
     * 
     * @return parid
     */
    public java.lang.String getParid() {
        return parid;
    }


    /**
     * Sets the parid value for this Bapiparam1.
     * 
     * @param parid
     */
    public void setParid(java.lang.String parid) {
        this.parid = parid;
    }


    /**
     * Gets the parva value for this Bapiparam1.
     * 
     * @return parva
     */
    public java.lang.String getParva() {
        return parva;
    }


    /**
     * Sets the parva value for this Bapiparam1.
     * 
     * @param parva
     */
    public void setParva(java.lang.String parva) {
        this.parva = parva;
    }


    /**
     * Gets the partxt value for this Bapiparam1.
     * 
     * @return partxt
     */
    public java.lang.String getPartxt() {
        return partxt;
    }


    /**
     * Sets the partxt value for this Bapiparam1.
     * 
     * @param partxt
     */
    public void setPartxt(java.lang.String partxt) {
        this.partxt = partxt;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Bapiparam1)) return false;
        Bapiparam1 other = (Bapiparam1) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.parid==null && other.getParid()==null) || 
             (this.parid!=null &&
              this.parid.equals(other.getParid()))) &&
            ((this.parva==null && other.getParva()==null) || 
             (this.parva!=null &&
              this.parva.equals(other.getParva()))) &&
            ((this.partxt==null && other.getPartxt()==null) || 
             (this.partxt!=null &&
              this.partxt.equals(other.getPartxt())));
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
        if (getParid() != null) {
            _hashCode += getParid().hashCode();
        }
        if (getParva() != null) {
            _hashCode += getParva().hashCode();
        }
        if (getPartxt() != null) {
            _hashCode += getPartxt().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // メタデータ型 / [en]-(Type metadata)
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Bapiparam1.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "Bapiparam1"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("parid");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Parid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("parva");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Parva"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("partxt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Partxt"));
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
