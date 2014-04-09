package com.wad.systemconfiguration.data;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;


@XmlAccessorType(XmlAccessType.FIELD)
public class SystemConfigurationCategory
{
  @XmlAttribute(name="name")
  private String _name = "";
  
  @XmlElement(name="param_id")
  private List<SystemConfigurationParam> _list = null;
  
 
  public void setName (String name)
  {
    _name = name;
  }
  public String getName()
  {
    return _name;
  }
  
  public void setParamList (List<SystemConfigurationParam> list)
  {
    _list = list;
  }
  public List<SystemConfigurationParam> getParamList()
  {
    return _list;
  }
}
