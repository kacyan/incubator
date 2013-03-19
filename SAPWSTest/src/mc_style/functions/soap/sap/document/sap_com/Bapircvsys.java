/**
 * Bapircvsys.java
 *
 * このファイルはWSDLから自動生成されました / [en]-(This file was auto-generated from WSDL)
 * Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java生成器によって / [en]-(by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.)
 */

package mc_style.functions.soap.sap.document.sap_com;

public class Bapircvsys  implements java.io.Serializable {
    private java.lang.String subsystem;

    public Bapircvsys() {
    }

    public Bapircvsys(
           java.lang.String subsystem) {
           this.subsystem = subsystem;
    }


    /**
     * Gets the subsystem value for this Bapircvsys.
     * 
     * @return subsystem
     */
    public java.lang.String getSubsystem() {
        return subsystem;
    }


    /**
     * Sets the subsystem value for this Bapircvsys.
     * 
     * @param subsystem
     */
    public void setSubsystem(java.lang.String subsystem) {
        this.subsystem = subsystem;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Bapircvsys)) return false;
        Bapircvsys other = (Bapircvsys) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.subsystem==null && other.getSubsystem()==null) || 
             (this.subsystem!=null &&
              this.subsystem.equals(other.getSubsystem())));
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
        if (getSubsystem() != null) {
            _hashCode += getSubsystem().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // メタデータ型 / [en]-(Type metadata)
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Bapircvsys.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "Bapircvsys"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subsystem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Subsystem"));
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
