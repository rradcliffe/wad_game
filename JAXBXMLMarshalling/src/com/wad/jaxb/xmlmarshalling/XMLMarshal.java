package com.wad.jaxb.xmlmarshalling;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;


public class XMLMarshal<T>
{
  //
  // Example found on the following web site.
  //
  // http://valliappanr.blogspot.com/2012/08/jaxb-marshalling-unmarshalling-using.html
  //
  
  public void marshal(T data, String filename)
  {
    try
    {
      File file = new File(filename);
      JAXBContext jaxbContext = JAXBContext.newInstance(data.getClass());
      Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

      // Pretty print the output.
      jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

      jaxbMarshaller.marshal(data, file);
    }
    catch (JAXBException e)
    {
      e.printStackTrace();
    }
  }
  
  //
  // The following was an attempt at implementing a generic solution
  // for marshalling of data from Java classes generated from a schema.
  // The solution works. The problem was the inability to implement
  // a generic solution for the unmarshalling of data. As a result,
  // annotated POJOs are now being used.
  //
//  public void marshal(T data, String packageName, String filename)
//  {   
//    try
//    {
//      File file = new File(filename);
//      
//      JAXBContext jaxbContext = JAXBContext.newInstance(packageName);
//      
//      Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
//
//      // Pretty print the output.
//      //jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//
//      jaxbMarshaller.marshal(data, file);
//    }
//    catch (JAXBException e)
//    {
//      e.printStackTrace();
//    }
//  }
}
