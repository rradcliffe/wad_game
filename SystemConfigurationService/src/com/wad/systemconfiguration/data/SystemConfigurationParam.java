package com.wad.systemconfiguration.data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

@XmlAccessorType(XmlAccessType.FIELD)
public class SystemConfigurationParam
{
  @XmlAttribute(name="name")
  private String _name = "";
  
  @XmlValue
  private String _value = "";
  
  public SystemConfigurationParam()
  {
    // Do nothing
  }

  public void setName (String name)
  {
    _name = name;
  }
  public String getName()
  {
    return _name;
  }
  
  public void setValue (String value)
  {
    _value = value;
  }
  public String getValue()
  {
    return _value;
  }
}
