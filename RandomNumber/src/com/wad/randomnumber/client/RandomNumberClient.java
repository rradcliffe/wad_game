
package com.wad.randomnumber.client;

import java.util.List;

import javax.xml.ws.soap.SOAPFaultException;

import com.wad.randomnumber.client.IRandomNumberClient;
import com.wad.randomnumber.service.RandomNumber;
import com.wad.randomnumber.service.RandomNumberService;


public class RandomNumberClient implements IRandomNumberClient<Integer>
{
  private RandomNumberService _service = null;
  private RandomNumber _port = null;

  public RandomNumberClient()
  {
    // Initialize Web Service Operation
    _service = new RandomNumberService();
    if (_service == null)
    {
      System.out.println("Error: Failed to obtain instance of Random Number web service.");
    }
    else
    {
      _port = _service.getRandomNumberPort();
    }
  }

  public List<Integer> getList (int count)
  {
    List<Integer> list = null;

    try
    {
      if (count > 0)
      {
        list = _port.getRandomNumberList (count);
      }
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

    return list;
  }
}
