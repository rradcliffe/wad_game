package com.wad.jaxb.xmlmarshalling;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;


public class XMLUnmarshal<T>
{
  //
  // Example found on the following web site.
  //
  // http://valliappanr.blogspot.com/2012/08/jaxb-marshalling-unmarshalling-using.html
  //
  
  @SuppressWarnings("unchecked")
  public T unmarshal(String filename, Class<T> classt)
  {
    T data = null;
    
    try
    {
      File file = new File(filename);

      JAXBContext jaxbContext = JAXBContext.newInstance(classt);
  
      Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
      data = (T) jaxbUnmarshaller.unmarshal(file);
    }
    catch (JAXBException e)
    {
      e.printStackTrace();
    }

    return data;
  }
}
