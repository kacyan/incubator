/**
 * UserGetDetailBasicBindStub.java
 *
 * このファイルはWSDLから自動生成されました / [en]-(This file was auto-generated from WSDL)
 * Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java生成器によって / [en]-(by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.)
 */

package mc_style.functions.soap.sap.document.sap_com;

public class UserGetDetailBasicBindStub extends org.apache.axis.client.Stub implements mc_style.functions.soap.sap.document.sap_com.ZUserGetDetail {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[1];
        _initOperationDesc1();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("UserGetDetail");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "Activitygroups"), org.apache.axis.description.ParameterDesc.INOUT, new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "TableOfBapiagr"), mc_style.functions.soap.sap.document.sap_com.Bapiagr[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "Addcomrem"), org.apache.axis.description.ParameterDesc.INOUT, new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "TableOfBapicomrem"), mc_style.functions.soap.sap.document.sap_com.Bapicomrem[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "Addfax"), org.apache.axis.description.ParameterDesc.INOUT, new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "TableOfBapiadfax"), mc_style.functions.soap.sap.document.sap_com.Bapiadfax[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "Addpag"), org.apache.axis.description.ParameterDesc.INOUT, new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "TableOfBapiadpag"), mc_style.functions.soap.sap.document.sap_com.Bapiadpag[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "Addprt"), org.apache.axis.description.ParameterDesc.INOUT, new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "TableOfBapiadprt"), mc_style.functions.soap.sap.document.sap_com.Bapiadprt[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "Addrfc"), org.apache.axis.description.ParameterDesc.INOUT, new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "TableOfBapiadrfc"), mc_style.functions.soap.sap.document.sap_com.Bapiadrfc[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "Addrml"), org.apache.axis.description.ParameterDesc.INOUT, new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "TableOfBapiadrml"), mc_style.functions.soap.sap.document.sap_com.Bapiadrml[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "Addsmtp"), org.apache.axis.description.ParameterDesc.INOUT, new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "TableOfBapiadsmtp"), mc_style.functions.soap.sap.document.sap_com.Bapiadsmtp[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "Addssf"), org.apache.axis.description.ParameterDesc.INOUT, new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "TableOfBapiadssf"), mc_style.functions.soap.sap.document.sap_com.Bapiadssf[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "Addtel"), org.apache.axis.description.ParameterDesc.INOUT, new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "TableOfBapiadtel"), mc_style.functions.soap.sap.document.sap_com.Bapiadtel[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "Addtlx"), org.apache.axis.description.ParameterDesc.INOUT, new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "TableOfBapiadtlx"), mc_style.functions.soap.sap.document.sap_com.Bapiadtlx[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "Addttx"), org.apache.axis.description.ParameterDesc.INOUT, new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "TableOfBapiadttx"), mc_style.functions.soap.sap.document.sap_com.Bapiadttx[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "Adduri"), org.apache.axis.description.ParameterDesc.INOUT, new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "TableOfBapiaduri"), mc_style.functions.soap.sap.document.sap_com.Bapiaduri[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "Addx400"), org.apache.axis.description.ParameterDesc.INOUT, new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "TableOfBapiadx400"), mc_style.functions.soap.sap.document.sap_com.Bapiadx400[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "CacheResults"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "char1"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "Extidhead"), org.apache.axis.description.ParameterDesc.INOUT, new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "TableOfBapiusextidhead"), mc_style.functions.soap.sap.document.sap_com.Bapiusextidhead[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "Extidpart"), org.apache.axis.description.ParameterDesc.INOUT, new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "TableOfBapiusextidpart"), mc_style.functions.soap.sap.document.sap_com.Bapiusextidpart[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "Groups"), org.apache.axis.description.ParameterDesc.INOUT, new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "TableOfBapigroups"), mc_style.functions.soap.sap.document.sap_com.Bapigroups[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "Parameter"), org.apache.axis.description.ParameterDesc.INOUT, new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "TableOfBapiparam"), mc_style.functions.soap.sap.document.sap_com.Bapiparam[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "Parameter1"), org.apache.axis.description.ParameterDesc.INOUT, new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "TableOfBapiparam1"), mc_style.functions.soap.sap.document.sap_com.Bapiparam1[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "Profiles"), org.apache.axis.description.ParameterDesc.INOUT, new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "TableOfBapiprof"), mc_style.functions.soap.sap.document.sap_com.Bapiprof[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "Return"), org.apache.axis.description.ParameterDesc.INOUT, new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "TableOfBapiret2"), mc_style.functions.soap.sap.document.sap_com.Bapiret2[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "Systems"), org.apache.axis.description.ParameterDesc.INOUT, new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "TableOfBapircvsys"), mc_style.functions.soap.sap.document.sap_com.Bapircvsys[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "Uclasssys"), org.apache.axis.description.ParameterDesc.INOUT, new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "TableOfBapiuclasssys"), mc_style.functions.soap.sap.document.sap_com.Bapiuclasssys[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "Username"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "char12"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "Address"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "Bapiaddr3"), mc_style.functions.soap.sap.document.sap_com.Bapiaddr3.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "Alias"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "Bapialias"), mc_style.functions.soap.sap.document.sap_com.Bapialias.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "Company"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "Bapiuscomp"), mc_style.functions.soap.sap.document.sap_com.Bapiuscomp.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "Defaults"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "Bapidefaul"), mc_style.functions.soap.sap.document.sap_com.Bapidefaul.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "Islocked"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "Bapislockd"), mc_style.functions.soap.sap.document.sap_com.Bapislockd.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "Lastmodified"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "Bapimoddat"), mc_style.functions.soap.sap.document.sap_com.Bapimoddat.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "Logondata"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "Bapilogond"), mc_style.functions.soap.sap.document.sap_com.Bapilogond.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "RefUser"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "Bapirefus"), mc_style.functions.soap.sap.document.sap_com.Bapirefus.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "Snc"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "Bapisncu"), mc_style.functions.soap.sap.document.sap_com.Bapisncu.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "Uclass"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "Bapiuclass"), mc_style.functions.soap.sap.document.sap_com.Bapiuclass.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[0] = oper;

    }

    public UserGetDetailBasicBindStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public UserGetDetailBasicBindStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public UserGetDetailBasicBindStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "byte16");
            cachedSerQNames.add(qName);
            cls = byte[].class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(arraysf);
            cachedDeserFactories.add(arraydf);

            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "byte20");
            cachedSerQNames.add(qName);
            cls = byte[].class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(arraysf);
            cachedDeserFactories.add(arraydf);

            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "byte8");
            cachedSerQNames.add(qName);
            cls = byte[].class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(arraysf);
            cachedDeserFactories.add(arraydf);

            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "char1");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "char10");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "char12");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "char128");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "char132");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "char14");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "char15");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "char16");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "char18");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "char192");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "char2");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "char20");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "char220");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "char24");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "char241");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "char250");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "char255");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "char3");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "char30");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "char32");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "char4");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "char40");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "char42");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "char48");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "char5");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "char50");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "char6");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "char60");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "char64");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "char8");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "char80");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "clnt3");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "date");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "decimal3.0");
            cachedSerQNames.add(qName);
            cls = java.math.BigDecimal.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "lang");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "numeric3");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "numeric4");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "numeric6");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "time");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "Bapiaddr3");
            cachedSerQNames.add(qName);
            cls = mc_style.functions.soap.sap.document.sap_com.Bapiaddr3.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "Bapiadfax");
            cachedSerQNames.add(qName);
            cls = mc_style.functions.soap.sap.document.sap_com.Bapiadfax.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "Bapiadpag");
            cachedSerQNames.add(qName);
            cls = mc_style.functions.soap.sap.document.sap_com.Bapiadpag.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "Bapiadprt");
            cachedSerQNames.add(qName);
            cls = mc_style.functions.soap.sap.document.sap_com.Bapiadprt.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "Bapiadrfc");
            cachedSerQNames.add(qName);
            cls = mc_style.functions.soap.sap.document.sap_com.Bapiadrfc.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "Bapiadrml");
            cachedSerQNames.add(qName);
            cls = mc_style.functions.soap.sap.document.sap_com.Bapiadrml.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "Bapiadsmtp");
            cachedSerQNames.add(qName);
            cls = mc_style.functions.soap.sap.document.sap_com.Bapiadsmtp.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "Bapiadssf");
            cachedSerQNames.add(qName);
            cls = mc_style.functions.soap.sap.document.sap_com.Bapiadssf.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "Bapiadtel");
            cachedSerQNames.add(qName);
            cls = mc_style.functions.soap.sap.document.sap_com.Bapiadtel.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "Bapiadtlx");
            cachedSerQNames.add(qName);
            cls = mc_style.functions.soap.sap.document.sap_com.Bapiadtlx.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "Bapiadttx");
            cachedSerQNames.add(qName);
            cls = mc_style.functions.soap.sap.document.sap_com.Bapiadttx.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "Bapiaduri");
            cachedSerQNames.add(qName);
            cls = mc_style.functions.soap.sap.document.sap_com.Bapiaduri.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "Bapiadx400");
            cachedSerQNames.add(qName);
            cls = mc_style.functions.soap.sap.document.sap_com.Bapiadx400.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "Bapiagr");
            cachedSerQNames.add(qName);
            cls = mc_style.functions.soap.sap.document.sap_com.Bapiagr.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "Bapialias");
            cachedSerQNames.add(qName);
            cls = mc_style.functions.soap.sap.document.sap_com.Bapialias.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "Bapicomrem");
            cachedSerQNames.add(qName);
            cls = mc_style.functions.soap.sap.document.sap_com.Bapicomrem.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "Bapidefaul");
            cachedSerQNames.add(qName);
            cls = mc_style.functions.soap.sap.document.sap_com.Bapidefaul.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "Bapigroups");
            cachedSerQNames.add(qName);
            cls = mc_style.functions.soap.sap.document.sap_com.Bapigroups.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "Bapilogond");
            cachedSerQNames.add(qName);
            cls = mc_style.functions.soap.sap.document.sap_com.Bapilogond.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "Bapimoddat");
            cachedSerQNames.add(qName);
            cls = mc_style.functions.soap.sap.document.sap_com.Bapimoddat.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "Bapiparam");
            cachedSerQNames.add(qName);
            cls = mc_style.functions.soap.sap.document.sap_com.Bapiparam.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "Bapiparam1");
            cachedSerQNames.add(qName);
            cls = mc_style.functions.soap.sap.document.sap_com.Bapiparam1.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "Bapiprof");
            cachedSerQNames.add(qName);
            cls = mc_style.functions.soap.sap.document.sap_com.Bapiprof.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "Bapircvsys");
            cachedSerQNames.add(qName);
            cls = mc_style.functions.soap.sap.document.sap_com.Bapircvsys.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "Bapirefus");
            cachedSerQNames.add(qName);
            cls = mc_style.functions.soap.sap.document.sap_com.Bapirefus.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "Bapiret2");
            cachedSerQNames.add(qName);
            cls = mc_style.functions.soap.sap.document.sap_com.Bapiret2.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "Bapislockd");
            cachedSerQNames.add(qName);
            cls = mc_style.functions.soap.sap.document.sap_com.Bapislockd.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "Bapisncu");
            cachedSerQNames.add(qName);
            cls = mc_style.functions.soap.sap.document.sap_com.Bapisncu.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "Bapiuclass");
            cachedSerQNames.add(qName);
            cls = mc_style.functions.soap.sap.document.sap_com.Bapiuclass.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "Bapiuclasssys");
            cachedSerQNames.add(qName);
            cls = mc_style.functions.soap.sap.document.sap_com.Bapiuclasssys.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "Bapiuscomp");
            cachedSerQNames.add(qName);
            cls = mc_style.functions.soap.sap.document.sap_com.Bapiuscomp.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "Bapiusextidhead");
            cachedSerQNames.add(qName);
            cls = mc_style.functions.soap.sap.document.sap_com.Bapiusextidhead.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "Bapiusextidpart");
            cachedSerQNames.add(qName);
            cls = mc_style.functions.soap.sap.document.sap_com.Bapiusextidpart.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "TableOfBapiadfax");
            cachedSerQNames.add(qName);
            cls = mc_style.functions.soap.sap.document.sap_com.Bapiadfax[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "Bapiadfax");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "TableOfBapiadpag");
            cachedSerQNames.add(qName);
            cls = mc_style.functions.soap.sap.document.sap_com.Bapiadpag[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "Bapiadpag");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "TableOfBapiadprt");
            cachedSerQNames.add(qName);
            cls = mc_style.functions.soap.sap.document.sap_com.Bapiadprt[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "Bapiadprt");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "TableOfBapiadrfc");
            cachedSerQNames.add(qName);
            cls = mc_style.functions.soap.sap.document.sap_com.Bapiadrfc[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "Bapiadrfc");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "TableOfBapiadrml");
            cachedSerQNames.add(qName);
            cls = mc_style.functions.soap.sap.document.sap_com.Bapiadrml[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "Bapiadrml");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "TableOfBapiadsmtp");
            cachedSerQNames.add(qName);
            cls = mc_style.functions.soap.sap.document.sap_com.Bapiadsmtp[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "Bapiadsmtp");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "TableOfBapiadssf");
            cachedSerQNames.add(qName);
            cls = mc_style.functions.soap.sap.document.sap_com.Bapiadssf[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "Bapiadssf");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "TableOfBapiadtel");
            cachedSerQNames.add(qName);
            cls = mc_style.functions.soap.sap.document.sap_com.Bapiadtel[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "Bapiadtel");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "TableOfBapiadtlx");
            cachedSerQNames.add(qName);
            cls = mc_style.functions.soap.sap.document.sap_com.Bapiadtlx[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "Bapiadtlx");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "TableOfBapiadttx");
            cachedSerQNames.add(qName);
            cls = mc_style.functions.soap.sap.document.sap_com.Bapiadttx[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "Bapiadttx");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "TableOfBapiaduri");
            cachedSerQNames.add(qName);
            cls = mc_style.functions.soap.sap.document.sap_com.Bapiaduri[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "Bapiaduri");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "TableOfBapiadx400");
            cachedSerQNames.add(qName);
            cls = mc_style.functions.soap.sap.document.sap_com.Bapiadx400[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "Bapiadx400");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "TableOfBapiagr");
            cachedSerQNames.add(qName);
            cls = mc_style.functions.soap.sap.document.sap_com.Bapiagr[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "Bapiagr");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "TableOfBapicomrem");
            cachedSerQNames.add(qName);
            cls = mc_style.functions.soap.sap.document.sap_com.Bapicomrem[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "Bapicomrem");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "TableOfBapigroups");
            cachedSerQNames.add(qName);
            cls = mc_style.functions.soap.sap.document.sap_com.Bapigroups[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "Bapigroups");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "TableOfBapiparam");
            cachedSerQNames.add(qName);
            cls = mc_style.functions.soap.sap.document.sap_com.Bapiparam[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "Bapiparam");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "TableOfBapiparam1");
            cachedSerQNames.add(qName);
            cls = mc_style.functions.soap.sap.document.sap_com.Bapiparam1[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "Bapiparam1");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "TableOfBapiprof");
            cachedSerQNames.add(qName);
            cls = mc_style.functions.soap.sap.document.sap_com.Bapiprof[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "Bapiprof");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "TableOfBapircvsys");
            cachedSerQNames.add(qName);
            cls = mc_style.functions.soap.sap.document.sap_com.Bapircvsys[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "Bapircvsys");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "TableOfBapiret2");
            cachedSerQNames.add(qName);
            cls = mc_style.functions.soap.sap.document.sap_com.Bapiret2[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "Bapiret2");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "TableOfBapiuclasssys");
            cachedSerQNames.add(qName);
            cls = mc_style.functions.soap.sap.document.sap_com.Bapiuclasssys[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "Bapiuclasssys");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "TableOfBapiusextidhead");
            cachedSerQNames.add(qName);
            cls = mc_style.functions.soap.sap.document.sap_com.Bapiusextidhead[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "Bapiusextidhead");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "TableOfBapiusextidpart");
            cachedSerQNames.add(qName);
            cls = mc_style.functions.soap.sap.document.sap_com.Bapiusextidpart[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "Bapiusextidpart");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // 全てのtypeマッピング情報は登録されています / [en]-(All the type mapping information is registered)
            // それらは最初に呼出される時に登録されます / [en]-(when the first call is made.)
            // typeマッピング情報は実際には登録されています / [en]-(The type mapping information is actually registered in)
            // サービスのTypeMappingRegistryに登録されています, / [en]-(the TypeMappingRegistry of the service, which)
            // その理由は登録が最初の呼び出しに必要とされるときだけであるからです. / [en]-(is the reason why registration is only needed for the first call.)
            synchronized (this) {
                if (firstCall()) {
                    // シリアライザを登録する前にエンコードスタイルをセットしなくてはなりません / [en]-(must set encoding style before registering serializers)
                    _call.setEncodingStyle(null);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                            java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable _t) {
            throw new org.apache.axis.AxisFault("Callオブジェクトの取得失敗 / [en]-(Failure trying to get the Call object)", _t);
        }
    }

    public void userGetDetail(mc_style.functions.soap.sap.document.sap_com.holders.TableOfBapiagrHolder activitygroups, mc_style.functions.soap.sap.document.sap_com.holders.TableOfBapicomremHolder addcomrem, mc_style.functions.soap.sap.document.sap_com.holders.TableOfBapiadfaxHolder addfax, mc_style.functions.soap.sap.document.sap_com.holders.TableOfBapiadpagHolder addpag, mc_style.functions.soap.sap.document.sap_com.holders.TableOfBapiadprtHolder addprt, mc_style.functions.soap.sap.document.sap_com.holders.TableOfBapiadrfcHolder addrfc, mc_style.functions.soap.sap.document.sap_com.holders.TableOfBapiadrmlHolder addrml, mc_style.functions.soap.sap.document.sap_com.holders.TableOfBapiadsmtpHolder addsmtp, mc_style.functions.soap.sap.document.sap_com.holders.TableOfBapiadssfHolder addssf, mc_style.functions.soap.sap.document.sap_com.holders.TableOfBapiadtelHolder addtel, mc_style.functions.soap.sap.document.sap_com.holders.TableOfBapiadtlxHolder addtlx, mc_style.functions.soap.sap.document.sap_com.holders.TableOfBapiadttxHolder addttx, mc_style.functions.soap.sap.document.sap_com.holders.TableOfBapiaduriHolder adduri, mc_style.functions.soap.sap.document.sap_com.holders.TableOfBapiadx400Holder addx400, java.lang.String cacheResults, mc_style.functions.soap.sap.document.sap_com.holders.TableOfBapiusextidheadHolder extidhead, mc_style.functions.soap.sap.document.sap_com.holders.TableOfBapiusextidpartHolder extidpart, mc_style.functions.soap.sap.document.sap_com.holders.TableOfBapigroupsHolder groups, mc_style.functions.soap.sap.document.sap_com.holders.TableOfBapiparamHolder parameter, mc_style.functions.soap.sap.document.sap_com.holders.TableOfBapiparam1Holder parameter1, mc_style.functions.soap.sap.document.sap_com.holders.TableOfBapiprofHolder profiles, mc_style.functions.soap.sap.document.sap_com.holders.TableOfBapiret2Holder _return, mc_style.functions.soap.sap.document.sap_com.holders.TableOfBapircvsysHolder systems, mc_style.functions.soap.sap.document.sap_com.holders.TableOfBapiuclasssysHolder uclasssys, java.lang.String username, mc_style.functions.soap.sap.document.sap_com.holders.Bapiaddr3Holder address, mc_style.functions.soap.sap.document.sap_com.holders.BapialiasHolder alias, mc_style.functions.soap.sap.document.sap_com.holders.BapiuscompHolder company, mc_style.functions.soap.sap.document.sap_com.holders.BapidefaulHolder defaults, mc_style.functions.soap.sap.document.sap_com.holders.BapislockdHolder islocked, mc_style.functions.soap.sap.document.sap_com.holders.BapimoddatHolder lastmodified, mc_style.functions.soap.sap.document.sap_com.holders.BapilogondHolder logondata, mc_style.functions.soap.sap.document.sap_com.holders.BapirefusHolder refUser, mc_style.functions.soap.sap.document.sap_com.holders.BapisncuHolder snc, mc_style.functions.soap.sap.document.sap_com.holders.BapiuclassHolder uclass) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:sap-com:document:sap:soap:functions:mc-style", "UserGetDetail"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {activitygroups.value, addcomrem.value, addfax.value, addpag.value, addprt.value, addrfc.value, addrml.value, addsmtp.value, addssf.value, addtel.value, addtlx.value, addttx.value, adduri.value, addx400.value, cacheResults, extidhead.value, extidpart.value, groups.value, parameter.value, parameter1.value, profiles.value, _return.value, systems.value, uclasssys.value, username});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                activitygroups.value = (mc_style.functions.soap.sap.document.sap_com.Bapiagr[]) _output.get(new javax.xml.namespace.QName("", "Activitygroups"));
            } catch (java.lang.Exception _exception) {
                activitygroups.value = (mc_style.functions.soap.sap.document.sap_com.Bapiagr[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "Activitygroups")), mc_style.functions.soap.sap.document.sap_com.Bapiagr[].class);
            }
            try {
                addcomrem.value = (mc_style.functions.soap.sap.document.sap_com.Bapicomrem[]) _output.get(new javax.xml.namespace.QName("", "Addcomrem"));
            } catch (java.lang.Exception _exception) {
                addcomrem.value = (mc_style.functions.soap.sap.document.sap_com.Bapicomrem[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "Addcomrem")), mc_style.functions.soap.sap.document.sap_com.Bapicomrem[].class);
            }
            try {
                addfax.value = (mc_style.functions.soap.sap.document.sap_com.Bapiadfax[]) _output.get(new javax.xml.namespace.QName("", "Addfax"));
            } catch (java.lang.Exception _exception) {
                addfax.value = (mc_style.functions.soap.sap.document.sap_com.Bapiadfax[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "Addfax")), mc_style.functions.soap.sap.document.sap_com.Bapiadfax[].class);
            }
            try {
                addpag.value = (mc_style.functions.soap.sap.document.sap_com.Bapiadpag[]) _output.get(new javax.xml.namespace.QName("", "Addpag"));
            } catch (java.lang.Exception _exception) {
                addpag.value = (mc_style.functions.soap.sap.document.sap_com.Bapiadpag[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "Addpag")), mc_style.functions.soap.sap.document.sap_com.Bapiadpag[].class);
            }
            try {
                addprt.value = (mc_style.functions.soap.sap.document.sap_com.Bapiadprt[]) _output.get(new javax.xml.namespace.QName("", "Addprt"));
            } catch (java.lang.Exception _exception) {
                addprt.value = (mc_style.functions.soap.sap.document.sap_com.Bapiadprt[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "Addprt")), mc_style.functions.soap.sap.document.sap_com.Bapiadprt[].class);
            }
            try {
                addrfc.value = (mc_style.functions.soap.sap.document.sap_com.Bapiadrfc[]) _output.get(new javax.xml.namespace.QName("", "Addrfc"));
            } catch (java.lang.Exception _exception) {
                addrfc.value = (mc_style.functions.soap.sap.document.sap_com.Bapiadrfc[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "Addrfc")), mc_style.functions.soap.sap.document.sap_com.Bapiadrfc[].class);
            }
            try {
                addrml.value = (mc_style.functions.soap.sap.document.sap_com.Bapiadrml[]) _output.get(new javax.xml.namespace.QName("", "Addrml"));
            } catch (java.lang.Exception _exception) {
                addrml.value = (mc_style.functions.soap.sap.document.sap_com.Bapiadrml[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "Addrml")), mc_style.functions.soap.sap.document.sap_com.Bapiadrml[].class);
            }
            try {
                addsmtp.value = (mc_style.functions.soap.sap.document.sap_com.Bapiadsmtp[]) _output.get(new javax.xml.namespace.QName("", "Addsmtp"));
            } catch (java.lang.Exception _exception) {
                addsmtp.value = (mc_style.functions.soap.sap.document.sap_com.Bapiadsmtp[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "Addsmtp")), mc_style.functions.soap.sap.document.sap_com.Bapiadsmtp[].class);
            }
            try {
                addssf.value = (mc_style.functions.soap.sap.document.sap_com.Bapiadssf[]) _output.get(new javax.xml.namespace.QName("", "Addssf"));
            } catch (java.lang.Exception _exception) {
                addssf.value = (mc_style.functions.soap.sap.document.sap_com.Bapiadssf[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "Addssf")), mc_style.functions.soap.sap.document.sap_com.Bapiadssf[].class);
            }
            try {
                addtel.value = (mc_style.functions.soap.sap.document.sap_com.Bapiadtel[]) _output.get(new javax.xml.namespace.QName("", "Addtel"));
            } catch (java.lang.Exception _exception) {
                addtel.value = (mc_style.functions.soap.sap.document.sap_com.Bapiadtel[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "Addtel")), mc_style.functions.soap.sap.document.sap_com.Bapiadtel[].class);
            }
            try {
                addtlx.value = (mc_style.functions.soap.sap.document.sap_com.Bapiadtlx[]) _output.get(new javax.xml.namespace.QName("", "Addtlx"));
            } catch (java.lang.Exception _exception) {
                addtlx.value = (mc_style.functions.soap.sap.document.sap_com.Bapiadtlx[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "Addtlx")), mc_style.functions.soap.sap.document.sap_com.Bapiadtlx[].class);
            }
            try {
                addttx.value = (mc_style.functions.soap.sap.document.sap_com.Bapiadttx[]) _output.get(new javax.xml.namespace.QName("", "Addttx"));
            } catch (java.lang.Exception _exception) {
                addttx.value = (mc_style.functions.soap.sap.document.sap_com.Bapiadttx[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "Addttx")), mc_style.functions.soap.sap.document.sap_com.Bapiadttx[].class);
            }
            try {
                adduri.value = (mc_style.functions.soap.sap.document.sap_com.Bapiaduri[]) _output.get(new javax.xml.namespace.QName("", "Adduri"));
            } catch (java.lang.Exception _exception) {
                adduri.value = (mc_style.functions.soap.sap.document.sap_com.Bapiaduri[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "Adduri")), mc_style.functions.soap.sap.document.sap_com.Bapiaduri[].class);
            }
            try {
                addx400.value = (mc_style.functions.soap.sap.document.sap_com.Bapiadx400[]) _output.get(new javax.xml.namespace.QName("", "Addx400"));
            } catch (java.lang.Exception _exception) {
                addx400.value = (mc_style.functions.soap.sap.document.sap_com.Bapiadx400[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "Addx400")), mc_style.functions.soap.sap.document.sap_com.Bapiadx400[].class);
            }
            try {
                extidhead.value = (mc_style.functions.soap.sap.document.sap_com.Bapiusextidhead[]) _output.get(new javax.xml.namespace.QName("", "Extidhead"));
            } catch (java.lang.Exception _exception) {
                extidhead.value = (mc_style.functions.soap.sap.document.sap_com.Bapiusextidhead[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "Extidhead")), mc_style.functions.soap.sap.document.sap_com.Bapiusextidhead[].class);
            }
            try {
                extidpart.value = (mc_style.functions.soap.sap.document.sap_com.Bapiusextidpart[]) _output.get(new javax.xml.namespace.QName("", "Extidpart"));
            } catch (java.lang.Exception _exception) {
                extidpart.value = (mc_style.functions.soap.sap.document.sap_com.Bapiusextidpart[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "Extidpart")), mc_style.functions.soap.sap.document.sap_com.Bapiusextidpart[].class);
            }
            try {
                groups.value = (mc_style.functions.soap.sap.document.sap_com.Bapigroups[]) _output.get(new javax.xml.namespace.QName("", "Groups"));
            } catch (java.lang.Exception _exception) {
                groups.value = (mc_style.functions.soap.sap.document.sap_com.Bapigroups[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "Groups")), mc_style.functions.soap.sap.document.sap_com.Bapigroups[].class);
            }
            try {
                parameter.value = (mc_style.functions.soap.sap.document.sap_com.Bapiparam[]) _output.get(new javax.xml.namespace.QName("", "Parameter"));
            } catch (java.lang.Exception _exception) {
                parameter.value = (mc_style.functions.soap.sap.document.sap_com.Bapiparam[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "Parameter")), mc_style.functions.soap.sap.document.sap_com.Bapiparam[].class);
            }
            try {
                parameter1.value = (mc_style.functions.soap.sap.document.sap_com.Bapiparam1[]) _output.get(new javax.xml.namespace.QName("", "Parameter1"));
            } catch (java.lang.Exception _exception) {
                parameter1.value = (mc_style.functions.soap.sap.document.sap_com.Bapiparam1[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "Parameter1")), mc_style.functions.soap.sap.document.sap_com.Bapiparam1[].class);
            }
            try {
                profiles.value = (mc_style.functions.soap.sap.document.sap_com.Bapiprof[]) _output.get(new javax.xml.namespace.QName("", "Profiles"));
            } catch (java.lang.Exception _exception) {
                profiles.value = (mc_style.functions.soap.sap.document.sap_com.Bapiprof[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "Profiles")), mc_style.functions.soap.sap.document.sap_com.Bapiprof[].class);
            }
            try {
                _return.value = (mc_style.functions.soap.sap.document.sap_com.Bapiret2[]) _output.get(new javax.xml.namespace.QName("", "Return"));
            } catch (java.lang.Exception _exception) {
                _return.value = (mc_style.functions.soap.sap.document.sap_com.Bapiret2[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "Return")), mc_style.functions.soap.sap.document.sap_com.Bapiret2[].class);
            }
            try {
                systems.value = (mc_style.functions.soap.sap.document.sap_com.Bapircvsys[]) _output.get(new javax.xml.namespace.QName("", "Systems"));
            } catch (java.lang.Exception _exception) {
                systems.value = (mc_style.functions.soap.sap.document.sap_com.Bapircvsys[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "Systems")), mc_style.functions.soap.sap.document.sap_com.Bapircvsys[].class);
            }
            try {
                uclasssys.value = (mc_style.functions.soap.sap.document.sap_com.Bapiuclasssys[]) _output.get(new javax.xml.namespace.QName("", "Uclasssys"));
            } catch (java.lang.Exception _exception) {
                uclasssys.value = (mc_style.functions.soap.sap.document.sap_com.Bapiuclasssys[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "Uclasssys")), mc_style.functions.soap.sap.document.sap_com.Bapiuclasssys[].class);
            }
            try {
                address.value = (mc_style.functions.soap.sap.document.sap_com.Bapiaddr3) _output.get(new javax.xml.namespace.QName("", "Address"));
            } catch (java.lang.Exception _exception) {
                address.value = (mc_style.functions.soap.sap.document.sap_com.Bapiaddr3) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "Address")), mc_style.functions.soap.sap.document.sap_com.Bapiaddr3.class);
            }
            try {
                alias.value = (mc_style.functions.soap.sap.document.sap_com.Bapialias) _output.get(new javax.xml.namespace.QName("", "Alias"));
            } catch (java.lang.Exception _exception) {
                alias.value = (mc_style.functions.soap.sap.document.sap_com.Bapialias) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "Alias")), mc_style.functions.soap.sap.document.sap_com.Bapialias.class);
            }
            try {
                company.value = (mc_style.functions.soap.sap.document.sap_com.Bapiuscomp) _output.get(new javax.xml.namespace.QName("", "Company"));
            } catch (java.lang.Exception _exception) {
                company.value = (mc_style.functions.soap.sap.document.sap_com.Bapiuscomp) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "Company")), mc_style.functions.soap.sap.document.sap_com.Bapiuscomp.class);
            }
            try {
                defaults.value = (mc_style.functions.soap.sap.document.sap_com.Bapidefaul) _output.get(new javax.xml.namespace.QName("", "Defaults"));
            } catch (java.lang.Exception _exception) {
                defaults.value = (mc_style.functions.soap.sap.document.sap_com.Bapidefaul) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "Defaults")), mc_style.functions.soap.sap.document.sap_com.Bapidefaul.class);
            }
            try {
                islocked.value = (mc_style.functions.soap.sap.document.sap_com.Bapislockd) _output.get(new javax.xml.namespace.QName("", "Islocked"));
            } catch (java.lang.Exception _exception) {
                islocked.value = (mc_style.functions.soap.sap.document.sap_com.Bapislockd) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "Islocked")), mc_style.functions.soap.sap.document.sap_com.Bapislockd.class);
            }
            try {
                lastmodified.value = (mc_style.functions.soap.sap.document.sap_com.Bapimoddat) _output.get(new javax.xml.namespace.QName("", "Lastmodified"));
            } catch (java.lang.Exception _exception) {
                lastmodified.value = (mc_style.functions.soap.sap.document.sap_com.Bapimoddat) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "Lastmodified")), mc_style.functions.soap.sap.document.sap_com.Bapimoddat.class);
            }
            try {
                logondata.value = (mc_style.functions.soap.sap.document.sap_com.Bapilogond) _output.get(new javax.xml.namespace.QName("", "Logondata"));
            } catch (java.lang.Exception _exception) {
                logondata.value = (mc_style.functions.soap.sap.document.sap_com.Bapilogond) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "Logondata")), mc_style.functions.soap.sap.document.sap_com.Bapilogond.class);
            }
            try {
                refUser.value = (mc_style.functions.soap.sap.document.sap_com.Bapirefus) _output.get(new javax.xml.namespace.QName("", "RefUser"));
            } catch (java.lang.Exception _exception) {
                refUser.value = (mc_style.functions.soap.sap.document.sap_com.Bapirefus) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "RefUser")), mc_style.functions.soap.sap.document.sap_com.Bapirefus.class);
            }
            try {
                snc.value = (mc_style.functions.soap.sap.document.sap_com.Bapisncu) _output.get(new javax.xml.namespace.QName("", "Snc"));
            } catch (java.lang.Exception _exception) {
                snc.value = (mc_style.functions.soap.sap.document.sap_com.Bapisncu) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "Snc")), mc_style.functions.soap.sap.document.sap_com.Bapisncu.class);
            }
            try {
                uclass.value = (mc_style.functions.soap.sap.document.sap_com.Bapiuclass) _output.get(new javax.xml.namespace.QName("", "Uclass"));
            } catch (java.lang.Exception _exception) {
                uclass.value = (mc_style.functions.soap.sap.document.sap_com.Bapiuclass) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "Uclass")), mc_style.functions.soap.sap.document.sap_com.Bapiuclass.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

}
