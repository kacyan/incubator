/**
 * Bapiuclass.java
 *
 * このファイルはWSDLから自動生成されました / [en]-(This file was auto-generated from WSDL)
 * Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java生成器によって / [en]-(by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.)
 */

package mc_style.functions.soap.sap.document.sap_com;

public class Bapiuclass  implements java.io.Serializable {
    private java.lang.String licType;

    private java.lang.String specVers;

    private java.math.BigDecimal countrySurcharge;

    private java.lang.String substituteFrom;

    private java.lang.String substituteUntil;

    private java.lang.String sysid;

    private java.lang.String client;

    private java.lang.String bnameChargeable;

    public Bapiuclass() {
    }

    public Bapiuclass(
           java.lang.String licType,
           java.lang.String specVers,
           java.math.BigDecimal countrySurcharge,
           java.lang.String substituteFrom,
           java.lang.String substituteUntil,
           java.lang.String sysid,
           java.lang.String client,
           java.lang.String bnameChargeable) {
           this.licType = licType;
           this.specVers = specVers;
           this.countrySurcharge = countrySurcharge;
           this.substituteFrom = substituteFrom;
           this.substituteUntil = substituteUntil;
           this.sysid = sysid;
           this.client = client;
           this.bnameChargeable = bnameChargeable;
    }


    /**
     * Gets the licType value for this Bapiuclass.
     * 
     * @return licType
     */
    public java.lang.String getLicType() {
        return licType;
    }


    /**
     * Sets the licType value for this Bapiuclass.
     * 
     * @param licType
     */
    public void setLicType(java.lang.String licType) {
        this.licType = licType;
    }


    /**
     * Gets the specVers value for this Bapiuclass.
     * 
     * @return specVers
     */
    public java.lang.String getSpecVers() {
        return specVers;
    }


    /**
     * Sets the specVers value for this Bapiuclass.
     * 
     * @param specVers
     */
    public void setSpecVers(java.lang.String specVers) {
        this.specVers = specVers;
    }


    /**
     * Gets the countrySurcharge value for this Bapiuclass.
     * 
     * @return countrySurcharge
     */
    public java.math.BigDecimal getCountrySurcharge() {
        return countrySurcharge;
    }


    /**
     * Sets the countrySurcharge value for this Bapiuclass.
     * 
     * @param countrySurcharge
     */
    public void setCountrySurcharge(java.math.BigDecimal countrySurcharge) {
        this.countrySurcharge = countrySurcharge;
    }


    /**
     * Gets the substituteFrom value for this Bapiuclass.
     * 
     * @return substituteFrom
     */
    public java.lang.String getSubstituteFrom() {
        return substituteFrom;
    }


    /**
     * Sets the substituteFrom value for this Bapiuclass.
     * 
     * @param substituteFrom
     */
    public void setSubstituteFrom(java.lang.String substituteFrom) {
        this.substituteFrom = substituteFrom;
    }


    /**
     * Gets the substituteUntil value for this Bapiuclass.
     * 
     * @return substituteUntil
     */
    public java.lang.String getSubstituteUntil() {
        return substituteUntil;
    }


    /**
     * Sets the substituteUntil value for this Bapiuclass.
     * 
     * @param substituteUntil
     */
    public void setSubstituteUntil(java.lang.String substituteUntil) {
        this.substituteUntil = substituteUntil;
    }


    /**
     * Gets the sysid value for this Bapiuclass.
     * 
     * @return sysid
     */
    public java.lang.String getSysid() {
        return sysid;
    }


    /**
     * Sets the sysid value for this Bapiuclass.
     * 
     * @param sysid
     */
    public void setSysid(java.lang.String sysid) {
        this.sysid = sysid;
    }


    /**
     * Gets the client value for this Bapiuclass.
     * 
     * @return client
     */
    public java.lang.String getClient() {
        return client;
    }


    /**
     * Sets the client value for this Bapiuclass.
     * 
     * @param client
     */
    public void setClient(java.lang.String client) {
        this.client = client;
    }


    /**
     * Gets the bnameChargeable value for this Bapiuclass.
     * 
     * @return bnameChargeable
     */
    public java.lang.String getBnameChargeable() {
        return bnameChargeable;
    }


    /**
     * Sets the bnameChargeable value for this Bapiuclass.
     * 
     * @param bnameChargeable
     */
    public void setBnameChargeable(java.lang.String bnameChargeable) {
        this.bnameChargeable = bnameChargeable;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Bapiuclass)) return false;
        Bapiuclass other = (Bapiuclass) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.licType==null && other.getLicType()==null) || 
             (this.licType!=null &&
              this.licType.equals(other.getLicType()))) &&
            ((this.specVers==null && other.getSpecVers()==null) || 
             (this.specVers!=null &&
              this.specVers.equals(other.getSpecVers()))) &&
            ((this.countrySurcharge==null && other.getCountrySurcharge()==null) || 
             (this.countrySurcharge!=null &&
              this.countrySurcharge.equals(other.getCountrySurcharge()))) &&
            ((this.substituteFrom==null && other.getSubstituteFrom()==null) || 
             (this.substituteFrom!=null &&
              this.substituteFrom.equals(other.getSubstituteFrom()))) &&
            ((this.substituteUntil==null && other.getSubstituteUntil()==null) || 
             (this.substituteUntil!=null &&
              this.substituteUntil.equals(other.getSubstituteUntil()))) &&
            ((this.sysid==null && other.getSysid()==null) || 
             (this.sysid!=null &&
              this.sysid.equals(other.getSysid()))) &&
            ((this.client==null && other.getClient()==null) || 
             (this.client!=null &&
              this.client.equals(other.getClient()))) &&
            ((this.bnameChargeable==null && other.getBnameChargeable()==null) || 
             (this.bnameChargeable!=null &&
              this.bnameChargeable.equals(other.getBnameChargeable())));
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
        if (getLicType() != null) {
            _hashCode += getLicType().hashCode();
        }
        if (getSpecVers() != null) {
            _hashCode += getSpecVers().hashCode();
        }
        if (getCountrySurcharge() != null) {
            _hashCode += getCountrySurcharge().hashCode();
        }
        if (getSubstituteFrom() != null) {
            _hashCode += getSubstituteFrom().hashCode();
        }
        if (getSubstituteUntil() != null) {
            _hashCode += getSubstituteUntil().hashCode();
        }
        if (getSysid() != null) {
            _hashCode += getSysid().hashCode();
        }
        if (getClient() != null) {
            _hashCode += getClient().hashCode();
        }
        if (getBnameChargeable() != null) {
            _hashCode += getBnameChargeable().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // メタデータ型 / [en]-(Type metadata)
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Bapiuclass.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "Bapiuclass"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("licType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "LicType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("specVers");
        elemField.setXmlName(new javax.xml.namespace.QName("", "SpecVers"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("countrySurcharge");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CountrySurcharge"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("substituteFrom");
        elemField.setXmlName(new javax.xml.namespace.QName("", "SubstituteFrom"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("substituteUntil");
        elemField.setXmlName(new javax.xml.namespace.QName("", "SubstituteUntil"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sysid");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Sysid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("client");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Client"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bnameChargeable");
        elemField.setXmlName(new javax.xml.namespace.QName("", "BnameChargeable"));
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
