/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wad.junit.dice;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.wad.dice.Dice;
import com.wad.dice.DiceController;
import com.wad.dice.DiceController.SortType;
import com.wad.dice.Die;

import static org.junit.Assert.*;


public class DiceTest
{
  public DiceTest()
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
   * Test of getRoles method, of class Dice.
   */
  @Test
  public void testGetRoles()
  {
    System.out.println("");
    System.out.println("DiceTest : testGetRoles");

    int   min   = 1;
    int   max   = 6;
    int   rolls = 100;

    DiceController controller = new DiceController();
    Dice dice = controller.getDice(rolls);
        
    // Check for null object
    assertTrue (dice != null);
    
    // Check for correct length
    assertTrue (dice.length() == rolls);
    
    // Check for correct range
    _checkRange (min, max, dice);

    System.out.println("...Passed");
  }

  /**
   * Test of setSort method, of class Dice.
   */
  @Test
  public void testSetSort()
  {
    System.out.println("");
    System.out.println("DiceTest : testSetSort");

    int    min   = 1;
    int    max   = 6;
    int    rolls = 100;
    
    DiceController controller = new DiceController(min, max);
    
    //
    // Ascending Sort
    //
    controller.setSorting(SortType.ASCENDING);
    Dice dice = controller.getDice(rolls);
    
    // Check for null object
    //assertTrue (list != null);
    assertTrue (dice != null);
    
    // Check for correct length
    //assertTrue (list.length == roles);
    assertTrue (dice.length() == rolls);
    
    // Check sorting
    _checkSort (SortType.ASCENDING, dice);

    //
    // Descending Sort
    //
    controller.setSorting(SortType.DESCENDING);
    dice = controller.getDice(rolls);
    
    // Check for null object
    assertTrue (dice != null);

    // Check for correct length
    assertTrue (dice.length() == rolls);

    // Check sorting
    _checkSort (SortType.DESCENDING, dice);

    System.out.println("...Passed");
  }

  private void _checkRange(int min, int max, Dice dice)
  {
    for (int index = 0; index < dice.length(); index++)
    {
      Die die = dice.get();
      
      int value = die.get();
      assertTrue((min <= value) && (value <= max));
    }
  }

  private void _checkSort (SortType sortType, Dice dice)
  {
    List<Die> list = dice.getAll();
    
    if (sortType == SortType.ASCENDING)
    {     
      Die prev = list.get(0);
      
      for (int index = 1; index < (list.size() - 1); index++)
      {        
        assertTrue((prev.get() <= list.get(index).get()) &&
                   (list.get(index).get() <= list.get(index + 1).get()));
        
        prev = list.get(index);
      }
    }

    else if (sortType == SortType.DESCENDING)
    {     
      Die prev = list.get(0);
      
      for (int index = 1; index < (list.size() - 1); index++)
      {       
        assertTrue((prev.get() >= list.get(index).get()) &&
                   (list.get(index).get() >= list.get(index + 1).get()));
        
        prev = list.get(index);
      }
    }
  }
}