/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wad.randomnumber.business;

import java.util.ArrayList;
import java.security.SecureRandom;
import java.security.NoSuchAlgorithmException;


public class RandomNumberImpl
{
  private boolean initialized = false;
  private SecureRandom sr = null;
 
  private void _initialize()
  {
    if (!initialized)
    {
      try
      {
        // Create a secure random number generator
        sr = SecureRandom.getInstance("SHA1PRNG");
    
        // Re-seed the secure number generator.
        int seedByteCount = 100;
        byte[] seed = sr.generateSeed(seedByteCount);
        sr.setSeed(seed);

        initialized = true;
      }
      catch (NoSuchAlgorithmException e)
      {
      }
    }
  }
  
  private int _getRandomNumber()
  {
    int number = sr.nextInt();

    return number;
  }

  private int _getRandomNumber(int maxValue)
  {
    int number = sr.nextInt (maxValue);

    return number;
  }

  public int [] getRandomNumberList(
                int numbersToRetrieve)
  {
    int [] list = new int[numbersToRetrieve];

    if (!initialized)
    {
      _initialize();
    }

    if (initialized)
    {
      if (numbersToRetrieve > 0)
      {
         for (int index = 0; index < numbersToRetrieve; index++)
         {
           list[index] = _getRandomNumber();
         }
      }
    }

    return list;
  }

  public int [] getUniqueNumberList(
                int listLength)
  {
    int [] numberList = new int[listLength];

    if (!initialized)
    {
      _initialize();
    }

    if (initialized)
    {
      if (listLength > 0)
      {
        ArrayList<Integer> internalList = new ArrayList<Integer>();

        // Initialize the starting list
        for (int index = 1; index < (listLength + 1); index++)
        {
          Integer value = new Integer (index);

          internalList.add (value);
        }

        int index    = 0;
        while (internalList.size() > 0)
        {
          int maxValue = internalList.size();

          //int number = Math.abs (_getRandomNumber()) % maxValue;
          int number = _getRandomNumber (maxValue);

          Integer value = internalList.get (number);

          numberList[index++] = value.intValue();

          internalList.remove (number);
        }
      }
    }

    return numberList;
  }
}
