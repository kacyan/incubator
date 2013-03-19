/**
 * Bapicomrem.java
 *
 * このファイルはWSDLから自動生成されました / [en]-(This file was auto-generated from WSDL)
 * Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java生成器によって / [en]-(by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.)
 */

package mc_style.functions.soap.sap.document.sap_com;

public class Bapicomrem  implements java.io.Serializable {
    private java.lang.String commType;

    private java.lang.String langu;

    private java.lang.String languIso;

    private java.lang.String commNotes;

    private java.lang.String consnumber;

    private java.lang.String errorflag;

    public Bapicomrem() {
    }

    public Bapicomrem(
           java.lang.String commType,
           java.lang.String langu,
           java.lang.String languIso,
           java.lang.String commNotes,
           java.lang.String consnumber,
           java.lang.String errorflag) {
           this.commType = commType;
           this.langu = langu;
           this.languIso = languIso;
           this.commNotes = commNotes;
           this.consnumber = consnumber;
           this.errorflag = errorflag;
    }


    /**
     * Gets the commType value for this Bapicomrem.
     * 
     * @return commType
     */
    public java.lang.String getCommType() {
        return commType;
    }


    /**
     * Sets the commType value for this Bapicomrem.
     * 
     * @param commType
     */
    public void setCommType(java.lang.String commType) {
        this.commType = commType;
    }


    /**
     * Gets the langu value for this Bapicomrem.
     * 
     * @return langu
     */
    public java.lang.String getLangu() {
        return langu;
    }


    /**
     * Sets the langu value for this Bapicomrem.
     * 
     * @param langu
     */
    public void setLangu(java.lang.String langu) {
        this.langu = langu;
    }


    /**
     * Gets the languIso value for this Bapicomrem.
     * 
     * @return languIso
     */
    public java.lang.String getLanguIso() {
        return languIso;
    }


    /**
     * Sets the languIso value for this Bapicomrem.
     * 
     * @param languIso
     */
    public void setLanguIso(java.lang.String languIso) {
        this.languIso = languIso;
    }


    /**
     * Gets the commNotes value for this Bapicomrem.
     * 
     * @return commNotes
     */
    public java.lang.String getCommNotes() {
        return commNotes;
    }


    /**
     * Sets the commNotes value for this Bapicomrem.
     * 
     * @param commNotes
     */
    public void setCommNotes(java.lang.String commNotes) {
        this.commNotes = commNotes;
    }


    /**
     * Gets the consnumber value for this Bapicomrem.
     * 
     * @return consnumber
     */
    public java.lang.String getConsnumber() {
        return consnumber;
    }


    /**
     * Sets the consnumber value for this Bapicomrem.
     * 
     * @param consnumber
     */
    public void setConsnumber(java.lang.String consnumber) {
        this.consnumber = consnumber;
    }


    /**
     * Gets the errorflag value for this Bapicomrem.
     * 
     * @return errorflag
     */
    public java.lang.String getErrorflag() {
        return errorflag;
    }


    /**
     * Sets the errorflag value for this Bapicomrem.
     * 
     * @param errorflag
     */
    public void setErrorflag(java.lang.String errorflag) {
        this.errorflag = errorflag;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Bapicomrem)) return false;
        Bapicomrem other = (Bapicomrem) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.commType==null && other.getCommType()==null) || 
             (this.commType!=null &&
              this.commType.equals(other.getCommType()))) &&
            ((this.langu==null && other.getLangu()==null) || 
             (this.langu!=null &&
              this.langu.equals(other.getLangu()))) &&
            ((this.languIso==null && other.getLanguIso()==null) || 
             (this.languIso!=null &&
              this.languIso.equals(other.getLanguIso()))) &&
            ((this.commNotes==null && other.getCommNotes()==null) || 
             (this.commNotes!=null &&
              this.commNotes.equals(other.getCommNotes()))) &&
            ((this.consnumber==null && other.getConsnumber()==null) || 
             (this.consnumber!=null &&
              this.consnumber.equals(other.getConsnumber()))) &&
            ((this.errorflag==null && other.getErrorflag()==null) || 
             (this.errorflag!=null &&
              this.errorflag.equals(other.getErrorflag())));
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
        if (getCommType() != null) {
            _hashCode += getCommType().hashCode();
        }
        if (getLangu() != null) {
            _hashCode += getLangu().hashCode();
        }
        if (getLanguIso() != null) {
            _hashCode += getLanguIso().hashCode();
        }
        if (getCommNotes() != null) {
            _hashCode += getCommNotes().hashCode();
        }
        if (getConsnumber() != null) {
            _hashCode += getConsnumber().hashCode();
        }
        if (getErrorflag() != null) {
            _hashCode += getErrorflag().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // メタデータ型 / [en]-(Type metadata)
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Bapicomrem.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "Bapicomrem"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("commType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CommType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("langu");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Langu"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("languIso");
        elemField.setXmlName(new javax.xml.namespace.QName("", "LanguIso"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("commNotes");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CommNotes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("consnumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Consnumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("errorflag");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Errorflag"));
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
