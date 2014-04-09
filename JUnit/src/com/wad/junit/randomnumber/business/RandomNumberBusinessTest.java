/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wad.junit.randomnumber.business;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.wad.randomnumber.business.RandomNumberImpl;


public class RandomNumberBusinessTest
{
  public RandomNumberBusinessTest()
  {
  }

  @BeforeClass
  public static void setUpClass() throws Exception
  {
  }

  @AfterClass
  public static void tearDownClass() throws Exception
  {
  }

  /**
   * Test retrieving a set of random numbers.
   */
  @Test
  public void testGetRandomNumberList()
  {
    System.out.println("");
    System.out.println("RandomNumberBusinessTest : testGetRandomNumberList");

    int numbersToRetrieve = 15;
    RandomNumberImpl _randomNumber = new RandomNumberImpl();
    
    int [] intArray = _randomNumber.getRandomNumberList(numbersToRetrieve);

    // Check for correct array length
    assert(intArray.length == numbersToRetrieve);
    
    System.out.println("...Passed");
  }
  
  /**
   * Test retrieving a set of unique random numbers.
   */
  @Test
  public void testGetUniqueNumberList()
  {
    System.out.println("");
    System.out.println("RandomNumberBusinessTest : testGetUniqueNumberList");

    int numbersToRetrieve = 15;
    RandomNumberImpl _randomNumber = new RandomNumberImpl();
    
    int [] intArray = _randomNumber.getUniqueNumberList(numbersToRetrieve);
    
    // Check for correct return value
    assertTrue (intArray.length == numbersToRetrieve);
    
    // Ensure numbers are unique.
    for (int index = 0; index < numbersToRetrieve; index++)
    {
      int value = intArray[index];
      
      for (int index2 = 0; index2 < numbersToRetrieve; index2++)
      {
        if (index == index2)
        {
          continue;
        }
        
        assertFalse(value == intArray[index2]);
      }
    }

    System.out.println("...Passed");
  }
}