package com.wad.systemconfiguration.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.wad.systemconfiguration.business.SystemConfigurationImpl;

//
// JAX-WS Exception Handling / Throwing
//     http://io.typepad.com/eben_hewitt_on_java/2009/07/using-soap-faults-and-exceptions-in-java-jaxws-web-services.html
//
// If web console is not working after portal is deployed, with the following
// message in the log:
//     File "D:\liferay@git\bundles\glassfish-3.1.2.2\lib\install\applications\__admingui\common\index.jsp" not found
//
// Then just use the following url:
//
//     http://localhost:4848/login.jsf
//

@WebService()
public class SystemConfiguration
{ 
  private SystemConfigurationImpl _systemConfiguration = new SystemConfigurationImpl();

  @WebMethod
  public String getString(String category, String key)
  {
    return _systemConfiguration.getString (category, key);
  }
  
  @WebMethod
  public int getInt(String category, String key)
  {
    return _systemConfiguration.getInt (category, key);
  }
  
  @WebMethod
  public boolean getBoolean(String category, String key)
  {
    return _systemConfiguration.getBoolean (category, key);
  }
}
