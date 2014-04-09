
package com.wad.systemconfiguration.client;

import javax.xml.ws.soap.SOAPFaultException;

import com.wad.systemconfiguration.client.ISystemConfigurationClient;
import com.wad.systemconfiguration.service.SystemConfiguration;
import com.wad.systemconfiguration.service.SystemConfigurationService;


public class SystemConfigurationClient implements ISystemConfigurationClient
{
  private SystemConfigurationService _service = null;
  private SystemConfiguration _port = null;

  public SystemConfigurationClient()
  {
    // Initialize Web Service Operation
    _service = new SystemConfigurationService();
    if (_service == null)
    {
      System.out.println("Error: Failed to obtain instance of System Configuration web service.");
    }
    else
    {
      _port = _service.getSystemConfigurationPort();
    }
  }

  public String getString(String category, String key)
  {
    String result = "";

    try
    {
      result = _port.getString(category, key);
    }
    catch (SOAPFaultException ex)
    {
      // TODO : Required - Handle SOAP exception.
      System.out.println("SOAPFaultException: " + ex.getFault().getFaultString());
    }
    catch (Exception ex)
    {
      // TODO : Required - Handle custom exceptions.
      System.out.println("Exception: " + ex.getMessage());
    }

    return result;
  }
  
  public int getInt(String category, String key)
  {
    int result = 0;

    try
    {
      result = _port.getInt(category, key);
    }
    catch (SOAPFaultException ex)
    {
      // TODO : Required - Handle SOAP exception.
      System.out.println("SOAPFaultException: " + ex.getFault().getFaultString());
    }
    catch (Exception ex)
    {
      // TODO : Required - Handle custom exceptions.
      System.out.println("Exception: " + ex.getMessage());
    }

    return result;
  }
  
  public Boolean getBoolean(String category, String key)
  {
    Boolean result = false;

    try
    {
      result = _port.getBoolean(category, key);
    }
    catch (SOAPFaultException ex)
    {
      // TODO : Required - Handle SOAP exception.
      System.out.println("SOAPFaultException: " + ex.getFault().getFaultString());
    }
    catch (Exception ex)
    {
      // TODO : Required - Handle custom exceptions.
      System.out.println("Exception: " + ex.getMessage());
    }

    return result;
  }
}
