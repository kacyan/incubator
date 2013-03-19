/**
 * Bapiusextidhead.java
 *
 * このファイルはWSDLから自動生成されました / [en]-(This file was auto-generated from WSDL)
 * Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java生成器によって / [en]-(by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.)
 */

package mc_style.functions.soap.sap.document.sap_com;

public class Bapiusextidhead  implements java.io.Serializable {
    private java.lang.String seqNoId;

    private java.lang.String type;

    private java.lang.String codeType;

    private short extidLen;

    private short issuerLen;

    private short serialLen;

    private byte[] valityinfo;

    private org.apache.axis.types.UnsignedByte version;

    private java.lang.String status;

    private java.lang.String extflag;

    public Bapiusextidhead() {
    }

    public Bapiusextidhead(
           java.lang.String seqNoId,
           java.lang.String type,
           java.lang.String codeType,
           short extidLen,
           short issuerLen,
           short serialLen,
           byte[] valityinfo,
           org.apache.axis.types.UnsignedByte version,
           java.lang.String status,
           java.lang.String extflag) {
           this.seqNoId = seqNoId;
           this.type = type;
           this.codeType = codeType;
           this.extidLen = extidLen;
           this.issuerLen = issuerLen;
           this.serialLen = serialLen;
           this.valityinfo = valityinfo;
           this.version = version;
           this.status = status;
           this.extflag = extflag;
    }


    /**
     * Gets the seqNoId value for this Bapiusextidhead.
     * 
     * @return seqNoId
     */
    public java.lang.String getSeqNoId() {
        return seqNoId;
    }


    /**
     * Sets the seqNoId value for this Bapiusextidhead.
     * 
     * @param seqNoId
     */
    public void setSeqNoId(java.lang.String seqNoId) {
        this.seqNoId = seqNoId;
    }


    /**
     * Gets the type value for this Bapiusextidhead.
     * 
     * @return type
     */
    public java.lang.String getType() {
        return type;
    }


    /**
     * Sets the type value for this Bapiusextidhead.
     * 
     * @param type
     */
    public void setType(java.lang.String type) {
        this.type = type;
    }


    /**
     * Gets the codeType value for this Bapiusextidhead.
     * 
     * @return codeType
     */
    public java.lang.String getCodeType() {
        return codeType;
    }


    /**
     * Sets the codeType value for this Bapiusextidhead.
     * 
     * @param codeType
     */
    public void setCodeType(java.lang.String codeType) {
        this.codeType = codeType;
    }


    /**
     * Gets the extidLen value for this Bapiusextidhead.
     * 
     * @return extidLen
     */
    public short getExtidLen() {
        return extidLen;
    }


    /**
     * Sets the extidLen value for this Bapiusextidhead.
     * 
     * @param extidLen
     */
    public void setExtidLen(short extidLen) {
        this.extidLen = extidLen;
    }


    /**
     * Gets the issuerLen value for this Bapiusextidhead.
     * 
     * @return issuerLen
     */
    public short getIssuerLen() {
        return issuerLen;
    }


    /**
     * Sets the issuerLen value for this Bapiusextidhead.
     * 
     * @param issuerLen
     */
    public void setIssuerLen(short issuerLen) {
        this.issuerLen = issuerLen;
    }


    /**
     * Gets the serialLen value for this Bapiusextidhead.
     * 
     * @return serialLen
     */
    public short getSerialLen() {
        return serialLen;
    }


    /**
     * Sets the serialLen value for this Bapiusextidhead.
     * 
     * @param serialLen
     */
    public void setSerialLen(short serialLen) {
        this.serialLen = serialLen;
    }


    /**
     * Gets the valityinfo value for this Bapiusextidhead.
     * 
     * @return valityinfo
     */
    public byte[] getValityinfo() {
        return valityinfo;
    }


    /**
     * Sets the valityinfo value for this Bapiusextidhead.
     * 
     * @param valityinfo
     */
    public void setValityinfo(byte[] valityinfo) {
        this.valityinfo = valityinfo;
    }


    /**
     * Gets the version value for this Bapiusextidhead.
     * 
     * @return version
     */
    public org.apache.axis.types.UnsignedByte getVersion() {
        return version;
    }


    /**
     * Sets the version value for this Bapiusextidhead.
     * 
     * @param version
     */
    public void setVersion(org.apache.axis.types.UnsignedByte version) {
        this.version = version;
    }


    /**
     * Gets the status value for this Bapiusextidhead.
     * 
     * @return status
     */
    public java.lang.String getStatus() {
        return status;
    }


    /**
     * Sets the status value for this Bapiusextidhead.
     * 
     * @param status
     */
    public void setStatus(java.lang.String status) {
        this.status = status;
    }


    /**
     * Gets the extflag value for this Bapiusextidhead.
     * 
     * @return extflag
     */
    public java.lang.String getExtflag() {
        return extflag;
    }


    /**
     * Sets the extflag value for this Bapiusextidhead.
     * 
     * @param extflag
     */
    public void setExtflag(java.lang.String extflag) {
        this.extflag = extflag;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Bapiusextidhead)) return false;
        Bapiusextidhead other = (Bapiusextidhead) obj;
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
            ((this.type==null && other.getType()==null) || 
             (this.type!=null &&
              this.type.equals(other.getType()))) &&
            ((this.codeType==null && other.getCodeType()==null) || 
             (this.codeType!=null &&
              this.codeType.equals(other.getCodeType()))) &&
            this.extidLen == other.getExtidLen() &&
            this.issuerLen == other.getIssuerLen() &&
            this.serialLen == other.getSerialLen() &&
            ((this.valityinfo==null && other.getValityinfo()==null) || 
             (this.valityinfo!=null &&
              java.util.Arrays.equals(this.valityinfo, other.getValityinfo()))) &&
            ((this.version==null && other.getVersion()==null) || 
             (this.version!=null &&
              this.version.equals(other.getVersion()))) &&
            ((this.status==null && other.getStatus()==null) || 
             (this.status!=null &&
              this.status.equals(other.getStatus()))) &&
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
        if (getType() != null) {
            _hashCode += getType().hashCode();
        }
        if (getCodeType() != null) {
            _hashCode += getCodeType().hashCode();
        }
        _hashCode += getExtidLen();
        _hashCode += getIssuerLen();
        _hashCode += getSerialLen();
        if (getValityinfo() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getValityinfo());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getValityinfo(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getVersion() != null) {
            _hashCode += getVersion().hashCode();
        }
        if (getStatus() != null) {
            _hashCode += getStatus().hashCode();
        }
        if (getExtflag() != null) {
            _hashCode += getExtflag().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // メタデータ型 / [en]-(Type metadata)
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Bapiusextidhead.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "Bapiusextidhead"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("seqNoId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "SeqNoId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("type");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Type"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codeType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CodeType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("extidLen");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ExtidLen"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("issuerLen");
        elemField.setXmlName(new javax.xml.namespace.QName("", "IssuerLen"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("serialLen");
        elemField.setXmlName(new javax.xml.namespace.QName("", "SerialLen"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("valityinfo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Valityinfo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("version");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Version"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedByte"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("status");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Status"));
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
