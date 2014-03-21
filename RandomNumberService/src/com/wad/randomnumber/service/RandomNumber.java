package com.wad.randomnumber.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.wad.randomnumber.business.RandomNumberImpl;

@WebService()
public class RandomNumber
{ 
  private RandomNumberImpl _randomNumber = new RandomNumberImpl();

  @WebMethod
  public int [] getRandomNumberList(int numbersToRetrieve)
  {
    return _randomNumber.getRandomNumberList (numbersToRetrieve);
  }
  
  @WebMethod
  public int [] getUniqueNumberList(int listLength)
  {
    return _randomNumber.getUniqueNumberList (listLength);
  }
}
