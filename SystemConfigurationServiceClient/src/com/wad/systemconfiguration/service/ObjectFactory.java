
package com.wad.systemconfiguration.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.wad.systemconfiguration.service package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetString_QNAME = new QName("http://service.systemconfiguration.wad.com/", "getString");
    private final static QName _GetBooleanResponse_QNAME = new QName("http://service.systemconfiguration.wad.com/", "getBooleanResponse");
    private final static QName _GetStringResponse_QNAME = new QName("http://service.systemconfiguration.wad.com/", "getStringResponse");
    private final static QName _GetIntResponse_QNAME = new QName("http://service.systemconfiguration.wad.com/", "getIntResponse");
    private final static QName _GetInt_QNAME = new QName("http://service.systemconfiguration.wad.com/", "getInt");
    private final static QName _GetBoolean_QNAME = new QName("http://service.systemconfiguration.wad.com/", "getBoolean");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.wad.systemconfiguration.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetIntResponse }
     * 
     */
    public GetIntResponse createGetIntResponse() {
        return new GetIntResponse();
    }

    /**
     * Create an instance of {@link GetInt }
     * 
     */
    public GetInt createGetInt() {
        return new GetInt();
    }

    /**
     * Create an instance of {@link GetBoolean }
     * 
     */
    public GetBoolean createGetBoolean() {
        return new GetBoolean();
    }

    /**
     * Create an instance of {@link GetString }
     * 
     */
    public GetString createGetString() {
        return new GetString();
    }

    /**
     * Create an instance of {@link GetStringResponse }
     * 
     */
    public GetStringResponse createGetStringResponse() {
        return new GetStringResponse();
    }

    /**
     * Create an instance of {@link GetBooleanResponse }
     * 
     */
    public GetBooleanResponse createGetBooleanResponse() {
        return new GetBooleanResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetString }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.systemconfiguration.wad.com/", name = "getString")
    public JAXBElement<GetString> createGetString(GetString value) {
        return new JAXBElement<GetString>(_GetString_QNAME, GetString.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBooleanResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.systemconfiguration.wad.com/", name = "getBooleanResponse")
    public JAXBElement<GetBooleanResponse> createGetBooleanResponse(GetBooleanResponse value) {
        return new JAXBElement<GetBooleanResponse>(_GetBooleanResponse_QNAME, GetBooleanResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStringResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.systemconfiguration.wad.com/", name = "getStringResponse")
    public JAXBElement<GetStringResponse> createGetStringResponse(GetStringResponse value) {
        return new JAXBElement<GetStringResponse>(_GetStringResponse_QNAME, GetStringResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetIntResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.systemconfiguration.wad.com/", name = "getIntResponse")
    public JAXBElement<GetIntResponse> createGetIntResponse(GetIntResponse value) {
        return new JAXBElement<GetIntResponse>(_GetIntResponse_QNAME, GetIntResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetInt }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.systemconfiguration.wad.com/", name = "getInt")
    public JAXBElement<GetInt> createGetInt(GetInt value) {
        return new JAXBElement<GetInt>(_GetInt_QNAME, GetInt.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBoolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.systemconfiguration.wad.com/", name = "getBoolean")
    public JAXBElement<GetBoolean> createGetBoolean(GetBoolean value) {
        return new JAXBElement<GetBoolean>(_GetBoolean_QNAME, GetBoolean.class, null, value);
    }

}
