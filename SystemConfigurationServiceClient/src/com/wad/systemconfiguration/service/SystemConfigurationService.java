
package com.wad.systemconfiguration.service;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "SystemConfigurationService", targetNamespace = "http://service.systemconfiguration.wad.com/", wsdlLocation = "http://radcliffe-desk:8080/SystemConfigurationService/SystemConfigurationService?wsdl")
public class SystemConfigurationService
    extends Service
{

    private final static URL SYSTEMCONFIGURATIONSERVICE_WSDL_LOCATION;
    private final static WebServiceException SYSTEMCONFIGURATIONSERVICE_EXCEPTION;
    private final static QName SYSTEMCONFIGURATIONSERVICE_QNAME = new QName("http://service.systemconfiguration.wad.com/", "SystemConfigurationService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://radcliffe-desk:8080/SystemConfigurationService/SystemConfigurationService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        SYSTEMCONFIGURATIONSERVICE_WSDL_LOCATION = url;
        SYSTEMCONFIGURATIONSERVICE_EXCEPTION = e;
    }

    public SystemConfigurationService() {
        super(__getWsdlLocation(), SYSTEMCONFIGURATIONSERVICE_QNAME);
    }

    public SystemConfigurationService(WebServiceFeature... features) {
        super(__getWsdlLocation(), SYSTEMCONFIGURATIONSERVICE_QNAME, features);
    }

    public SystemConfigurationService(URL wsdlLocation) {
        super(wsdlLocation, SYSTEMCONFIGURATIONSERVICE_QNAME);
    }

    public SystemConfigurationService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, SYSTEMCONFIGURATIONSERVICE_QNAME, features);
    }

    public SystemConfigurationService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public SystemConfigurationService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns SystemConfiguration
     */
    @WebEndpoint(name = "SystemConfigurationPort")
    public SystemConfiguration getSystemConfigurationPort() {
        return super.getPort(new QName("http://service.systemconfiguration.wad.com/", "SystemConfigurationPort"), SystemConfiguration.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns SystemConfiguration
     */
    @WebEndpoint(name = "SystemConfigurationPort")
    public SystemConfiguration getSystemConfigurationPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://service.systemconfiguration.wad.com/", "SystemConfigurationPort"), SystemConfiguration.class, features);
    }

    private static URL __getWsdlLocation() {
        if (SYSTEMCONFIGURATIONSERVICE_EXCEPTION!= null) {
            throw SYSTEMCONFIGURATIONSERVICE_EXCEPTION;
        }
        return SYSTEMCONFIGURATIONSERVICE_WSDL_LOCATION;
    }

}