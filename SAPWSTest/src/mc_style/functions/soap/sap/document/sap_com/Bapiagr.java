/**
 * Bapiagr.java
 *
 * このファイルはWSDLから自動生成されました / [en]-(This file was auto-generated from WSDL)
 * Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java生成器によって / [en]-(by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.)
 */

package mc_style.functions.soap.sap.document.sap_com;

public class Bapiagr  implements java.io.Serializable {
    private java.lang.String agrName;

    private java.lang.String fromDat;

    private java.lang.String toDat;

    private java.lang.String agrText;

    private java.lang.String orgFlag;

    public Bapiagr() {
    }

    public Bapiagr(
           java.lang.String agrName,
           java.lang.String fromDat,
           java.lang.String toDat,
           java.lang.String agrText,
           java.lang.String orgFlag) {
           this.agrName = agrName;
           this.fromDat = fromDat;
           this.toDat = toDat;
           this.agrText = agrText;
           this.orgFlag = orgFlag;
    }


    /**
     * Gets the agrName value for this Bapiagr.
     * 
     * @return agrName
     */
    public java.lang.String getAgrName() {
        return agrName;
    }


    /**
     * Sets the agrName value for this Bapiagr.
     * 
     * @param agrName
     */
    public void setAgrName(java.lang.String agrName) {
        this.agrName = agrName;
    }


    /**
     * Gets the fromDat value for this Bapiagr.
     * 
     * @return fromDat
     */
    public java.lang.String getFromDat() {
        return fromDat;
    }


    /**
     * Sets the fromDat value for this Bapiagr.
     * 
     * @param fromDat
     */
    public void setFromDat(java.lang.String fromDat) {
        this.fromDat = fromDat;
    }


    /**
     * Gets the toDat value for this Bapiagr.
     * 
     * @return toDat
     */
    public java.lang.String getToDat() {
        return toDat;
    }


    /**
     * Sets the toDat value for this Bapiagr.
     * 
     * @param toDat
     */
    public void setToDat(java.lang.String toDat) {
        this.toDat = toDat;
    }


    /**
     * Gets the agrText value for this Bapiagr.
     * 
     * @return agrText
     */
    public java.lang.String getAgrText() {
        return agrText;
    }


    /**
     * Sets the agrText value for this Bapiagr.
     * 
     * @param agrText
     */
    public void setAgrText(java.lang.String agrText) {
        this.agrText = agrText;
    }


    /**
     * Gets the orgFlag value for this Bapiagr.
     * 
     * @return orgFlag
     */
    public java.lang.String getOrgFlag() {
        return orgFlag;
    }


    /**
     * Sets the orgFlag value for this Bapiagr.
     * 
     * @param orgFlag
     */
    public void setOrgFlag(java.lang.String orgFlag) {
        this.orgFlag = orgFlag;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Bapiagr)) return false;
        Bapiagr other = (Bapiagr) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.agrName==null && other.getAgrName()==null) || 
             (this.agrName!=null &&
              this.agrName.equals(other.getAgrName()))) &&
            ((this.fromDat==null && other.getFromDat()==null) || 
             (this.fromDat!=null &&
              this.fromDat.equals(other.getFromDat()))) &&
            ((this.toDat==null && other.getToDat()==null) || 
             (this.toDat!=null &&
              this.toDat.equals(other.getToDat()))) &&
            ((this.agrText==null && other.getAgrText()==null) || 
             (this.agrText!=null &&
              this.agrText.equals(other.getAgrText()))) &&
            ((this.orgFlag==null && other.getOrgFlag()==null) || 
             (this.orgFlag!=null &&
              this.orgFlag.equals(other.getOrgFlag())));
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
        if (getAgrName() != null) {
            _hashCode += getAgrName().hashCode();
        }
        if (getFromDat() != null) {
            _hashCode += getFromDat().hashCode();
        }
        if (getToDat() != null) {
            _hashCode += getToDat().hashCode();
        }
        if (getAgrText() != null) {
            _hashCode += getAgrText().hashCode();
        }
        if (getOrgFlag() != null) {
            _hashCode += getOrgFlag().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // メタデータ型 / [en]-(Type metadata)
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Bapiagr.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "Bapiagr"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("agrName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "AgrName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fromDat");
        elemField.setXmlName(new javax.xml.namespace.QName("", "FromDat"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("toDat");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ToDat"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("agrText");
        elemField.setXmlName(new javax.xml.namespace.QName("", "AgrText"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("orgFlag");
        elemField.setXmlName(new javax.xml.namespace.QName("", "OrgFlag"));
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
