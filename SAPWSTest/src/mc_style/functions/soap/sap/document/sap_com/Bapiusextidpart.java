/**
 * Bapiusextidpart.java
 *
 * このファイルはWSDLから自動生成されました / [en]-(This file was auto-generated from WSDL)
 * Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java生成器によって / [en]-(by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.)
 */

package mc_style.functions.soap.sap.document.sap_com;

public class Bapiusextidpart  implements java.io.Serializable {
    private java.lang.String seqNoId;

    private java.lang.String fieldname;

    private java.lang.String seqNoPart;

    private java.lang.String partData;

    private java.lang.String extflag;

    public Bapiusextidpart() {
    }

    public Bapiusextidpart(
           java.lang.String seqNoId,
           java.lang.String fieldname,
           java.lang.String seqNoPart,
           java.lang.String partData,
           java.lang.String extflag) {
           this.seqNoId = seqNoId;
           this.fieldname = fieldname;
           this.seqNoPart = seqNoPart;
           this.partData = partData;
           this.extflag = extflag;
    }


    /**
     * Gets the seqNoId value for this Bapiusextidpart.
     * 
     * @return seqNoId
     */
    public java.lang.String getSeqNoId() {
        return seqNoId;
    }


    /**
     * Sets the seqNoId value for this Bapiusextidpart.
     * 
     * @param seqNoId
     */
    public void setSeqNoId(java.lang.String seqNoId) {
        this.seqNoId = seqNoId;
    }


    /**
     * Gets the fieldname value for this Bapiusextidpart.
     * 
     * @return fieldname
     */
    public java.lang.String getFieldname() {
        return fieldname;
    }


    /**
     * Sets the fieldname value for this Bapiusextidpart.
     * 
     * @param fieldname
     */
    public void setFieldname(java.lang.String fieldname) {
        this.fieldname = fieldname;
    }


    /**
     * Gets the seqNoPart value for this Bapiusextidpart.
     * 
     * @return seqNoPart
     */
    public java.lang.String getSeqNoPart() {
        return seqNoPart;
    }


    /**
     * Sets the seqNoPart value for this Bapiusextidpart.
     * 
     * @param seqNoPart
     */
    public void setSeqNoPart(java.lang.String seqNoPart) {
        this.seqNoPart = seqNoPart;
    }


    /**
     * Gets the partData value for this Bapiusextidpart.
     * 
     * @return partData
     */
    public java.lang.String getPartData() {
        return partData;
    }


    /**
     * Sets the partData value for this Bapiusextidpart.
     * 
     * @param partData
     */
    public void setPartData(java.lang.String partData) {
        this.partData = partData;
    }


    /**
     * Gets the extflag value for this Bapiusextidpart.
     * 
     * @return extflag
     */
    public java.lang.String getExtflag() {
        return extflag;
    }


    /**
     * Sets the extflag value for this Bapiusextidpart.
     * 
     * @param extflag
     */
    public void setExtflag(java.lang.String extflag) {
        this.extflag = extflag;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Bapiusextidpart)) return false;
        Bapiusextidpart other = (Bapiusextidpart) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.seqNoId==null && other.getSeqNoId()==null) || 
             (this.seqNoId!=null &&
              this.seqNoId.equals(other.getSeqNoId()))) &&
            ((this.fieldname==null && other.getFieldname()==null) || 
             (this.fieldname!=null &&
              this.fieldname.equals(other.getFieldname()))) &&
            ((this.seqNoPart==null && other.getSeqNoPart()==null) || 
             (this.seqNoPart!=null &&
              this.seqNoPart.equals(other.getSeqNoPart()))) &&
            ((this.partData==null && other.getPartData()==null) || 
             (this.partData!=null &&
              this.partData.equals(other.getPartData()))) &&
            ((this.extflag==null && other.getExtflag()==null) || 
             (this.extflag!=null &&
              this.extflag.equals(other.getExtflag())));
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
        if (getSeqNoId() != null) {
            _hashCode += getSeqNoId().hashCode();
        }
        if (getFieldname() != null) {
            _hashCode += getFieldname().hashCode();
        }
        if (getSeqNoPart() != null) {
            _hashCode += getSeqNoPart().hashCode();
        }
        if (getPartData() != null) {
            _hashCode += getPartData().hashCode();
        }
        if (getExtflag() != null) {
            _hashCode += getExtflag().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // メタデータ型 / [en]-(Type metadata)
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Bapiusextidpart.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "Bapiusextidpart"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("seqNoId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "SeqNoId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fieldname");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Fieldname"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("seqNoPart");
        elemField.setXmlName(new javax.xml.namespace.QName("", "SeqNoPart"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("partData");
        elemField.setXmlName(new javax.xml.namespace.QName("", "PartData"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("extflag");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Extflag"));
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
