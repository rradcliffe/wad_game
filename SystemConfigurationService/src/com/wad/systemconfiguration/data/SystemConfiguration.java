
package com.wad.systemconfiguration.data;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="systemConfiguration")
@XmlAccessorType(XmlAccessType.FIELD)
public class SystemConfiguration
{
  //
  // XML Annotations for collections has been described pretty well on the
  // following web sites.
  //
  // http://blog.bdoughan.com/2010/09/jaxb-collection-properties.html
  // http://www.mytechnotes.biz/2012/08/jaxb-annotation-summary-advanced-topics_9.html
  //
    
    
  @XmlElement(name="category")
  private List<SystemConfigurationCategory> _list = null;
  

  public SystemConfiguration()
  {
    // Do nothing
  }

  public void setCategoryList (List<SystemConfigurationCategory> list)
  {
    _list = list;
  }
  public List<SystemConfigurationCategory> getCategoryList()
  {
    return _list;
  }
}
