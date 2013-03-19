/**
 * Bapiadrfc.java
 *
 * このファイルはWSDLから自動生成されました / [en]-(This file was auto-generated from WSDL)
 * Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java生成器によって / [en]-(by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.)
 */

package mc_style.functions.soap.sap.document.sap_com;

public class Bapiadrfc  implements java.io.Serializable {
    private java.lang.String stdNo;

    private java.lang.String logDest;

    private java.lang.String stdRecip;

    private java.lang.String r3User;

    private java.lang.String homeFlag;

    private java.lang.String consnumber;

    private java.lang.String errorflag;

    private java.lang.String flgNouse;

    private java.lang.String validFrom;

    private java.lang.String validTo;

    public Bapiadrfc() {
    }

    public Bapiadrfc(
           java.lang.String stdNo,
           java.lang.String logDest,
           java.lang.String stdRecip,
           java.lang.String r3User,
           java.lang.String homeFlag,
           java.lang.String consnumber,
           java.lang.String errorflag,
           java.lang.String flgNouse,
           java.lang.String validFrom,
           java.lang.String validTo) {
           this.stdNo = stdNo;
           this.logDest = logDest;
           this.stdRecip = stdRecip;
           this.r3User = r3User;
           this.homeFlag = homeFlag;
           this.consnumber = consnumber;
           this.errorflag = errorflag;
           this.flgNouse = flgNouse;
           this.validFrom = validFrom;
           this.validTo = validTo;
    }


    /**
     * Gets the stdNo value for this Bapiadrfc.
     * 
     * @return stdNo
     */
    public java.lang.String getStdNo() {
        return stdNo;
    }


    /**
     * Sets the stdNo value for this Bapiadrfc.
     * 
     * @param stdNo
     */
    public void setStdNo(java.lang.String stdNo) {
        this.stdNo = stdNo;
    }


    /**
     * Gets the logDest value for this Bapiadrfc.
     * 
     * @return logDest
     */
    public java.lang.String getLogDest() {
        return logDest;
    }


    /**
     * Sets the logDest value for this Bapiadrfc.
     * 
     * @param logDest
     */
    public void setLogDest(java.lang.String logDest) {
        this.logDest = logDest;
    }


    /**
     * Gets the stdRecip value for this Bapiadrfc.
     * 
     * @return stdRecip
     */
    public java.lang.String getStdRecip() {
        return stdRecip;
    }


    /**
     * Sets the stdRecip value for this Bapiadrfc.
     * 
     * @param stdRecip
     */
    public void setStdRecip(java.lang.String stdRecip) {
        this.stdRecip = stdRecip;
    }


    /**
     * Gets the r3User value for this Bapiadrfc.
     * 
     * @return r3User
     */
    public java.lang.String getR3User() {
        return r3User;
    }


    /**
     * Sets the r3User value for this Bapiadrfc.
     * 
     * @param r3User
     */
    public void setR3User(java.lang.String r3User) {
        this.r3User = r3User;
    }


    /**
     * Gets the homeFlag value for this Bapiadrfc.
     * 
     * @return homeFlag
     */
    public java.lang.String getHomeFlag() {
        return homeFlag;
    }


    /**
     * Sets the homeFlag value for this Bapiadrfc.
     * 
     * @param homeFlag
     */
    public void setHomeFlag(java.lang.String homeFlag) {
        this.homeFlag = homeFlag;
    }


    /**
     * Gets the consnumber value for this Bapiadrfc.
     * 
     * @return consnumber
     */
    public java.lang.String getConsnumber() {
        return consnumber;
    }


    /**
     * Sets the consnumber value for this Bapiadrfc.
     * 
     * @param consnumber
     */
    public void setConsnumber(java.lang.String consnumber) {
        this.consnumber = consnumber;
    }


    /**
     * Gets the errorflag value for this Bapiadrfc.
     * 
     * @return errorflag
     */
    public java.lang.String getErrorflag() {
        return errorflag;
    }


    /**
     * Sets the errorflag value for this Bapiadrfc.
     * 
     * @param errorflag
     */
    public void setErrorflag(java.lang.String errorflag) {
        this.errorflag = errorflag;
    }


    /**
     * Gets the flgNouse value for this Bapiadrfc.
     * 
     * @return flgNouse
     */
    public java.lang.String getFlgNouse() {
        return flgNouse;
    }


    /**
     * Sets the flgNouse value for this Bapiadrfc.
     * 
     * @param flgNouse
     */
    public void setFlgNouse(java.lang.String flgNouse) {
        this.flgNouse = flgNouse;
    }


    /**
     * Gets the validFrom value for this Bapiadrfc.
     * 
     * @return validFrom
     */
    public java.lang.String getValidFrom() {
        return validFrom;
    }


    /**
     * Sets the validFrom value for this Bapiadrfc.
     * 
     * @param validFrom
     */
    public void setValidFrom(java.lang.String validFrom) {
        this.validFrom = validFrom;
    }


    /**
     * Gets the validTo value for this Bapiadrfc.
     * 
     * @return validTo
     */
    public java.lang.String getValidTo() {
        return validTo;
    }


    /**
     * Sets the validTo value for this Bapiadrfc.
     * 
     * @param validTo
     */
    public void setValidTo(java.lang.String validTo) {
        this.validTo = validTo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Bapiadrfc)) return false;
        Bapiadrfc other = (Bapiadrfc) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.stdNo==null && other.getStdNo()==null) || 
             (this.stdNo!=null &&
              this.stdNo.equals(other.getStdNo()))) &&
            ((this.logDest==null && other.getLogDest()==null) || 
             (this.logDest!=null &&
              this.logDest.equals(other.getLogDest()))) &&
            ((this.stdRecip==null && other.getStdRecip()==null) || 
             (this.stdRecip!=null &&
              this.stdRecip.equals(other.getStdRecip()))) &&
            ((this.r3User==null && other.getR3User()==null) || 
             (this.r3User!=null &&
              this.r3User.equals(other.getR3User()))) &&
            ((this.homeFlag==null && other.getHomeFlag()==null) || 
             (this.homeFlag!=null &&
              this.homeFlag.equals(other.getHomeFlag()))) &&
            ((this.consnumber==null && other.getConsnumber()==null) || 
             (this.consnumber!=null &&
              this.consnumber.equals(other.getConsnumber()))) &&
            ((this.errorflag==null && other.getErrorflag()==null) || 
             (this.errorflag!=null &&
              this.errorflag.equals(other.getErrorflag()))) &&
            ((this.flgNouse==null && other.getFlgNouse()==null) || 
             (this.flgNouse!=null &&
              this.flgNouse.equals(other.getFlgNouse()))) &&
            ((this.validFrom==null && other.getValidFrom()==null) || 
             (this.validFrom!=null &&
              this.validFrom.equals(other.getValidFrom()))) &&
            ((this.validTo==null && other.getValidTo()==null) || 
             (this.validTo!=null &&
              this.validTo.equals(other.getValidTo())));
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
        if (getStdNo() != null) {
            _hashCode += getStdNo().hashCode();
        }
        if (getLogDest() != null) {
            _hashCode += getLogDest().hashCode();
        }
        if (getStdRecip() != null) {
            _hashCode += getStdRecip().hashCode();
        }
        if (getR3User() != null) {
            _hashCode += getR3User().hashCode();
        }
        if (getHomeFlag() != null) {
            _hashCode += getHomeFlag().hashCode();
        }
        if (getConsnumber() != null) {
            _hashCode += getConsnumber().hashCode();
        }
        if (getErrorflag() != null) {
            _hashCode += getErrorflag().hashCode();
        }
        if (getFlgNouse() != null) {
            _hashCode += getFlgNouse().hashCode();
        }
        if (getValidFrom() != null) {
            _hashCode += getValidFrom().hashCode();
        }
        if (getValidTo() != null) {
            _hashCode += getValidTo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // メタデータ型 / [en]-(Type metadata)
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Bapiadrfc.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "Bapiadrfc"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stdNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "StdNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("logDest");
        elemField.setXmlName(new javax.xml.namespace.QName("", "LogDest"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stdRecip");
        elemField.setXmlName(new javax.xml.namespace.QName("", "StdRecip"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("r3User");
        elemField.setXmlName(new javax.xml.namespace.QName("", "R3User"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("homeFlag");
        elemField.setXmlName(new javax.xml.namespace.QName("", "HomeFlag"));
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("flgNouse");
        elemField.setXmlName(new javax.xml.namespace.QName("", "FlgNouse"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("validFrom");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ValidFrom"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("validTo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ValidTo"));
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
