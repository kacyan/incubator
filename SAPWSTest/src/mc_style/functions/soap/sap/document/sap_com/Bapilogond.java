/**
 * Bapilogond.java
 *
 * このファイルはWSDLから自動生成されました / [en]-(This file was auto-generated from WSDL)
 * Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java生成器によって / [en]-(by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.)
 */

package mc_style.functions.soap.sap.document.sap_com;

public class Bapilogond  implements java.io.Serializable {
    private java.lang.String gltgv;

    private java.lang.String gltgb;

    private java.lang.String ustyp;

    private java.lang.String _class;

    private java.lang.String accnt;

    private java.lang.String tzone;

    private java.lang.String ltime;

    private byte[] bcode;

    private java.lang.String codvn;

    private byte[] passcode;

    private java.lang.String codvc;

    public Bapilogond() {
    }

    public Bapilogond(
           java.lang.String gltgv,
           java.lang.String gltgb,
           java.lang.String ustyp,
           java.lang.String _class,
           java.lang.String accnt,
           java.lang.String tzone,
           java.lang.String ltime,
           byte[] bcode,
           java.lang.String codvn,
           byte[] passcode,
           java.lang.String codvc) {
           this.gltgv = gltgv;
           this.gltgb = gltgb;
           this.ustyp = ustyp;
           this._class = _class;
           this.accnt = accnt;
           this.tzone = tzone;
           this.ltime = ltime;
           this.bcode = bcode;
           this.codvn = codvn;
           this.passcode = passcode;
           this.codvc = codvc;
    }


    /**
     * Gets the gltgv value for this Bapilogond.
     * 
     * @return gltgv
     */
    public java.lang.String getGltgv() {
        return gltgv;
    }


    /**
     * Sets the gltgv value for this Bapilogond.
     * 
     * @param gltgv
     */
    public void setGltgv(java.lang.String gltgv) {
        this.gltgv = gltgv;
    }


    /**
     * Gets the gltgb value for this Bapilogond.
     * 
     * @return gltgb
     */
    public java.lang.String getGltgb() {
        return gltgb;
    }


    /**
     * Sets the gltgb value for this Bapilogond.
     * 
     * @param gltgb
     */
    public void setGltgb(java.lang.String gltgb) {
        this.gltgb = gltgb;
    }


    /**
     * Gets the ustyp value for this Bapilogond.
     * 
     * @return ustyp
     */
    public java.lang.String getUstyp() {
        return ustyp;
    }


    /**
     * Sets the ustyp value for this Bapilogond.
     * 
     * @param ustyp
     */
    public void setUstyp(java.lang.String ustyp) {
        this.ustyp = ustyp;
    }


    /**
     * Gets the _class value for this Bapilogond.
     * 
     * @return _class
     */
    public java.lang.String get_class() {
        return _class;
    }


    /**
     * Sets the _class value for this Bapilogond.
     * 
     * @param _class
     */
    public void set_class(java.lang.String _class) {
        this._class = _class;
    }


    /**
     * Gets the accnt value for this Bapilogond.
     * 
     * @return accnt
     */
    public java.lang.String getAccnt() {
        return accnt;
    }


    /**
     * Sets the accnt value for this Bapilogond.
     * 
     * @param accnt
     */
    public void setAccnt(java.lang.String accnt) {
        this.accnt = accnt;
    }


    /**
     * Gets the tzone value for this Bapilogond.
     * 
     * @return tzone
     */
    public java.lang.String getTzone() {
        return tzone;
    }


    /**
     * Sets the tzone value for this Bapilogond.
     * 
     * @param tzone
     */
    public void setTzone(java.lang.String tzone) {
        this.tzone = tzone;
    }


    /**
     * Gets the ltime value for this Bapilogond.
     * 
     * @return ltime
     */
    public java.lang.String getLtime() {
        return ltime;
    }


    /**
     * Sets the ltime value for this Bapilogond.
     * 
     * @param ltime
     */
    public void setLtime(java.lang.String ltime) {
        this.ltime = ltime;
    }


    /**
     * Gets the bcode value for this Bapilogond.
     * 
     * @return bcode
     */
    public byte[] getBcode() {
        return bcode;
    }


    /**
     * Sets the bcode value for this Bapilogond.
     * 
     * @param bcode
     */
    public void setBcode(byte[] bcode) {
        this.bcode = bcode;
    }


    /**
     * Gets the codvn value for this Bapilogond.
     * 
     * @return codvn
     */
    public java.lang.String getCodvn() {
        return codvn;
    }


    /**
     * Sets the codvn value for this Bapilogond.
     * 
     * @param codvn
     */
    public void setCodvn(java.lang.String codvn) {
        this.codvn = codvn;
    }


    /**
     * Gets the passcode value for this Bapilogond.
     * 
     * @return passcode
     */
    public byte[] getPasscode() {
        return passcode;
    }


    /**
     * Sets the passcode value for this Bapilogond.
     * 
     * @param passcode
     */
    public void setPasscode(byte[] passcode) {
        this.passcode = passcode;
    }


    /**
     * Gets the codvc value for this Bapilogond.
     * 
     * @return codvc
     */
    public java.lang.String getCodvc() {
        return codvc;
    }


    /**
     * Sets the codvc value for this Bapilogond.
     * 
     * @param codvc
     */
    public void setCodvc(java.lang.String codvc) {
        this.codvc = codvc;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Bapilogond)) return false;
        Bapilogond other = (Bapilogond) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.gltgv==null && other.getGltgv()==null) || 
             (this.gltgv!=null &&
              this.gltgv.equals(other.getGltgv()))) &&
            ((this.gltgb==null && other.getGltgb()==null) || 
             (this.gltgb!=null &&
              this.gltgb.equals(other.getGltgb()))) &&
            ((this.ustyp==null && other.getUstyp()==null) || 
             (this.ustyp!=null &&
              this.ustyp.equals(other.getUstyp()))) &&
            ((this._class==null && other.get_class()==null) || 
             (this._class!=null &&
              this._class.equals(other.get_class()))) &&
            ((this.accnt==null && other.getAccnt()==null) || 
             (this.accnt!=null &&
              this.accnt.equals(other.getAccnt()))) &&
            ((this.tzone==null && other.getTzone()==null) || 
             (this.tzone!=null &&
              this.tzone.equals(other.getTzone()))) &&
            ((this.ltime==null && other.getLtime()==null) || 
             (this.ltime!=null &&
              this.ltime.equals(other.getLtime()))) &&
            ((this.bcode==null && other.getBcode()==null) || 
             (this.bcode!=null &&
              java.util.Arrays.equals(this.bcode, other.getBcode()))) &&
            ((this.codvn==null && other.getCodvn()==null) || 
             (this.codvn!=null &&
              this.codvn.equals(other.getCodvn()))) &&
            ((this.passcode==null && other.getPasscode()==null) || 
             (this.passcode!=null &&
              java.util.Arrays.equals(this.passcode, other.getPasscode()))) &&
            ((this.codvc==null && other.getCodvc()==null) || 
             (this.codvc!=null &&
              this.codvc.equals(other.getCodvc())));
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
        if (getGltgv() != null) {
            _hashCode += getGltgv().hashCode();
        }
        if (getGltgb() != null) {
            _hashCode += getGltgb().hashCode();
        }
        if (getUstyp() != null) {
            _hashCode += getUstyp().hashCode();
        }
        if (get_class() != null) {
            _hashCode += get_class().hashCode();
        }
        if (getAccnt() != null) {
            _hashCode += getAccnt().hashCode();
        }
        if (getTzone() != null) {
            _hashCode += getTzone().hashCode();
        }
        if (getLtime() != null) {
            _hashCode += getLtime().hashCode();
        }
        if (getBcode() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getBcode());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getBcode(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getCodvn() != null) {
            _hashCode += getCodvn().hashCode();
        }
        if (getPasscode() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPasscode());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPasscode(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getCodvc() != null) {
            _hashCode += getCodvc().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // メタデータ型 / [en]-(Type metadata)
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Bapilogond.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "Bapilogond"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("gltgv");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Gltgv"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("gltgb");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Gltgb"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ustyp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Ustyp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("_class");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Class"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accnt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Accnt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tzone");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Tzone"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ltime");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Ltime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bcode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Bcode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codvn");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Codvn"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("passcode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Passcode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codvc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Codvc"));
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
