
package com.wad.randomnumber.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.wad.randomnumber.service package. 
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

    private final static QName _GetRandomNumberList_QNAME = new QName("http://service.randomnumber.wad.com/", "getRandomNumberList");
    private final static QName _GetRandomNumberListResponse_QNAME = new QName("http://service.randomnumber.wad.com/", "getRandomNumberListResponse");
    private final static QName _GetUniqueNumberList_QNAME = new QName("http://service.randomnumber.wad.com/", "getUniqueNumberList");
    private final static QName _GetUniqueNumberListResponse_QNAME = new QName("http://service.randomnumber.wad.com/", "getUniqueNumberListResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.wad.randomnumber.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetUniqueNumberListResponse }
     * 
     */
    public GetUniqueNumberListResponse createGetUniqueNumberListResponse() {
        return new GetUniqueNumberListResponse();
    }

    /**
     * Create an instance of {@link GetUniqueNumberList }
     * 
     */
    public GetUniqueNumberList createGetUniqueNumberList() {
        return new GetUniqueNumberList();
    }

    /**
     * Create an instance of {@link GetRandomNumberListResponse }
     * 
     */
    public GetRandomNumberListResponse createGetRandomNumberListResponse() {
        return new GetRandomNumberListResponse();
    }

    /**
     * Create an instance of {@link GetRandomNumberList }
     * 
     */
    public GetRandomNumberList createGetRandomNumberList() {
        return new GetRandomNumberList();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRandomNumberList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.randomnumber.wad.com/", name = "getRandomNumberList")
    public JAXBElement<GetRandomNumberList> createGetRandomNumberList(GetRandomNumberList value) {
        return new JAXBElement<GetRandomNumberList>(_GetRandomNumberList_QNAME, GetRandomNumberList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRandomNumberListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.randomnumber.wad.com/", name = "getRandomNumberListResponse")
    public JAXBElement<GetRandomNumberListResponse> createGetRandomNumberListResponse(GetRandomNumberListResponse value) {
        return new JAXBElement<GetRandomNumberListResponse>(_GetRandomNumberListResponse_QNAME, GetRandomNumberListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUniqueNumberList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.randomnumber.wad.com/", name = "getUniqueNumberList")
    public JAXBElement<GetUniqueNumberList> createGetUniqueNumberList(GetUniqueNumberList value) {
        return new JAXBElement<GetUniqueNumberList>(_GetUniqueNumberList_QNAME, GetUniqueNumberList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUniqueNumberListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.randomnumber.wad.com/", name = "getUniqueNumberListResponse")
    public JAXBElement<GetUniqueNumberListResponse> createGetUniqueNumberListResponse(GetUniqueNumberListResponse value) {
        return new JAXBElement<GetUniqueNumberListResponse>(_GetUniqueNumberListResponse_QNAME, GetUniqueNumberListResponse.class, null, value);
    }

}
