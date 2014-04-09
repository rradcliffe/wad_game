/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wad.junit.dice;

import java.util.Formatter;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.wad.dice.Dice;
import com.wad.dice.DiceController;
import com.wad.dice.Die;


public class RollDistributionTest
{
  public RollDistributionTest()
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
   * Test the probabilities of various attack/defend simulations.
   */
  @Test
  public void testRollDistribution()
  {
    System.out.println("");
    System.out.println("RollDistributionTest : testRollDistribution");

    int min      = 1;
    int max      = 6;

    DiceController controller = new DiceController(min, max);
    
    int samples  = 1000;
    _analyzeDistribution(controller, samples, min, max);
    
    samples  = 2500;
    _analyzeDistribution(controller, samples, min, max);
    
    samples  = 5000;
    _analyzeDistribution(controller, samples, min, max);
    
    samples  = 10000;
    _analyzeDistribution(controller, samples, min, max);
    
    samples  = 25000;
    _analyzeDistribution(controller, samples, min, max);
    
    samples  = 50000;
    _analyzeDistribution(controller, samples, min, max);

    samples  = 100000;
    _analyzeDistribution(controller, samples, min, max);
    
    System.out.println("...Passed");
  }
  
  private void _analyzeDistribution(
          DiceController controller,
          int samples,
          int min,
          int max)
  {
    int values   = max - min + 1;
    int expected = samples / values;
    
    System.out.print("   Samples " + samples);
    System.out.println(", Min " + min+ ", Max " + max + ", Expected " + expected);

    Dice dice = controller.getDice(samples);
    
    if (dice == null )
    	return;
    
    int [] distribution = new int[values];
    
    for (int index = 0; index < samples; index++)
    {
      Die die = dice.get();

      if (die != null)
      {
    	  distribution[(die.get() - 1)]++;
      }
    }

    // Perform Analysis
    for (int index = 0; index < values; index++)
    {
      Formatter formatter  = new Formatter();

      float deviation = distribution[index] - expected;
      float percentage = (Math.abs(deviation) / expected) * 100;

      System.out.print ("      [" + (min + index) + "] " + distribution[index]);
      System.out.println (", Deviation " + (int) deviation + " (" +
              formatter.format ("%3.2f", percentage).toString() + "%)");
      
      formatter.close();
    }
  }
}