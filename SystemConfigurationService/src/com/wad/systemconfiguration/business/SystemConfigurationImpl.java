package com.wad.systemconfiguration.business;

import java.util.HashMap;
import java.util.List;

import com.wad.jaxb.xmlmarshalling.XMLUnmarshal;
import com.wad.systemconfiguration.data.SystemConfiguration;
import com.wad.systemconfiguration.data.SystemConfigurationCategory;
import com.wad.systemconfiguration.data.SystemConfigurationParam;


public class SystemConfigurationImpl
{
  //private static final String  _className  = "Configuration";

  private final String _filepath = "E:\\My Baseline\\Eclipse\\Data\\system_configuration.xml";

  private HashMap<String, HashMap<String, String>> _categoryMap = null;

  public SystemConfigurationImpl()
 //      throws WadException
  {
    _categoryMap = new HashMap<String, HashMap<String, String>>();

    _load (_filepath);
  }

  public synchronized String getString (String category, String key)
   //     throws WadException
  {
    String value = _getValue (category, key);

    return value;
  }

  public synchronized int getInt (String section, String key)
   //    throws NumberFormatException, WadException
  {
    String value = _getValue (section, key);

    return Integer.parseInt (value);
  }

  public synchronized boolean getBoolean (String section, String key)
 //       throws WadException
  {
    String value = _getValue (section, key);

    /* The boolean returned represents the value true if the string argument
       is not null and is equal, ignoring case, to the string "true". */
    return Boolean.parseBoolean(value);
  }

  private String _getValue(String category, String key)
   //     throws WadException
  {
    //final String   methodName     = "_getValue";
    String value = "";
    HashMap<String, String> map = _categoryMap.get(category);

    System.out.println(category);
    System.out.println(key);
    
    // Section not found
    if (map == null)
    {
    }
    else
    {
      value = map.get (key);
    }

    return value;
  }

  private void _load (String filepath)
   //     throws WadException
  {
    //final String methodName = "_load";
    
    XMLUnmarshal<SystemConfiguration> unmarshal = new XMLUnmarshal<SystemConfiguration>();
    
    SystemConfiguration sysConfig = unmarshal.unmarshal(_filepath, SystemConfiguration.class);
       
    _transform(sysConfig);
  }

  private void _transform(SystemConfiguration sysConfig)
  {
    List<SystemConfigurationCategory> categoryList = sysConfig.getCategoryList();
    for (SystemConfigurationCategory category : categoryList)
    {
      String categoryName = category.getName();

      List<SystemConfigurationParam> paramList = category.getParamList();
      for (SystemConfigurationParam param : paramList)
      {
        String paramName = param.getName();
        String paramValue = param.getValue();

        HashMap<String, String> map = _categoryMap.get (categoryName);
      
        // Add initial section map for the given section.
        if (map == null)
        {
          map = new HashMap<String, String>();

          map.put(paramName, paramValue);

          _categoryMap.put(categoryName, map);
        }

        // Add configuration value to existing section map.
        else
        {
          map.put(paramName, paramValue);

          _categoryMap.put(categoryName, map);
        }
      }
    }
  }
}
