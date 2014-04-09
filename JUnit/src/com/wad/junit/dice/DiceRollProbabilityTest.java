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
import com.wad.dice.DiceController.SortType;
import com.wad.dice.Die;


public class DiceRollProbabilityTest
{
  public DiceRollProbabilityTest()
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
  //@Ignore
  @Test
  public void testDiceRollProbability()
  {
    System.out.println("");
    System.out.println("DiceRoleProbabilityTest : testDiceRollProbability");

    int min        = 1;
    int max        = 6;
    
    DiceController controller = new DiceController(min, max);
    controller.setSorting(SortType.DESCENDING);
    
    int samples = 1000;
    _analyzeProbability(controller, samples, min, max);
    
    samples = 2500;
    _analyzeProbability(controller, samples, min, max);
    
    samples = 5000;
    _analyzeProbability(controller, samples, min, max);
    
    samples = 10000;
    _analyzeProbability(controller, samples, min, max);
    
    samples = 25000;
    _analyzeProbability(controller, samples, min, max);

    samples = 50000;
    _analyzeProbability(controller, samples, min, max);
    
    System.out.println("...Passed");
  }

  private void _analyzeProbability(
          DiceController controller,
          int samples,
          int min,
          int max)
  {
    //Attacker: 1 dice, Defender: 1 dice:
    //  Attacker wins 15 out of 36 (41.67 %)
    //  Defender wins 21 out of 36 (58.33 %)

    int attackDice = 1;
    int defendDice = 1;

    System.out.print("   Samples " + samples);
    System.out.print(", Min " + min + ", Max " + max);
    System.out.println(", Dice " + attackDice + " vs. " + defendDice);
    System.out.println("       Attacker 41.67, Defender 58.33");
    _checkDiceRoleAttack (controller, samples, min, max, attackDice, defendDice);

    //Attacker: 1 dice, Defender: 2 dice:
    //  Attacker wins 55 out of 216 (25.46 %)
    //  Defender wins 161 out of 216 (74.54 %)
    attackDice = 1;
    defendDice = 2;

    System.out.print("   Samples " + samples);
    System.out.print(", Min " + min + ", Max " + max);
    System.out.println(", Dice " + attackDice + " vs. " + defendDice);
    System.out.println("       Attacker 25.46, Defender 74.54");
    _checkDiceRoleAttack (controller, samples, min, max, attackDice, defendDice);

    //Attacker: 2 dice, Defender: 1 dice:
    //  Attacker wins 125 out of 216 (57.87 %)
    //  Defender wins 91 out of 216 (42.13 %)
    attackDice = 2;
    defendDice = 1;

    System.out.print("   Samples " + samples);
    System.out.print(", Min " + min + ", Max " + max);
    System.out.println(", Dice " + attackDice + " vs. " + defendDice);
    System.out.println("       Attacker 57.87, Defender 42.13");
    _checkDiceRoleAttack (controller, samples, min, max, attackDice, defendDice);

    //Attacker: 2 dice, Defender: 2 dice:
    //  Attacker wins both: 295 out of 1296 (22.76 %)
    //  Defender wins both: 581 out of 1296 (44.83 %)
    //  Both win one: 420 out of 1296 (32.41 %)
    attackDice = 2;
    defendDice = 2;

    System.out.print("   Samples " + samples);
    System.out.print(", Min " + min + ", Max " + max);
    System.out.println(", Dice " + attackDice + " vs. " + defendDice);
    System.out.println("       Attacker 22.76, Defender 44.83");
    _checkDiceRoleAttack (controller, samples, min, max, attackDice, defendDice);

    //Attacker: 3 dice, Defender: 1 dice:
    //  Attacker wins 855 out of 1296 (65.97 %)
    //  Defender wins 441 out of 1296 (34.03 %)
    attackDice = 3;
    defendDice = 1;

    System.out.print("   Samples " + samples);
    System.out.print(", Min " + min + ", Max " + max);
    System.out.println(", Dice " + attackDice + " vs. " + defendDice);
    System.out.println("       Attacker 65.97, Defender 34.03");
    _checkDiceRoleAttack (controller, samples, min, max, attackDice, defendDice);

    //Attacker: 3 dice, Defender: 2 dice:
    //  Attacker wins both: 2890 out of 7776 (37.17 %)
    //  Defender wins both: 2275 out of 7776 (29.26 %)
    //  Both win one: 2611 out of 7776 (33.58 %)
    attackDice = 3;
    defendDice = 2;

    System.out.print("   Samples " + samples);
    System.out.print(", Min " + min + ", Max " + max);
    System.out.println(", Dice " + attackDice + " vs. " + defendDice);
    System.out.println("       Attacker 37.17, Defender 29.26, Split 33.58");
    _checkDiceRoleAttack (controller, samples, min, max, attackDice, defendDice);
  }
  
  private void _checkDiceRoleAttack(
          DiceController controller,
          int samples,
          int min,
          int max,
          int attackDice,
          int defendDice)
  {
    //
    // Initialize results array
    //
    int splitStat     = 0;
    int attackerStat  = 0;
    int defenderStat  = 0;
    
    // Determine the fewest dice being thrown by player (attacker / defender). 
    int fewestDice = ((defendDice < attackDice) ? defendDice : attackDice);

    for (int index1 = 0; index1 < samples; index1++)
    {
      int attacker = 0;
      int defender = 0;

      Dice diceAttack = controller.getDice(attackDice);
      Dice diceDefend = controller.getDice(defendDice);
      
      if ((diceAttack != null)&&(diceDefend != null))
      {
	      for (int index2 = 0; index2 < fewestDice; index2++)
	      {
	        Die dieAttack = diceAttack.get();
	        Die dieDefend = diceDefend.get();
	        
	        if ((dieAttack != null)&&(dieDefend != null))
	        {
		        if (dieAttack.get() > dieDefend.get())
		        {
		          attacker++;
		        }
		        else
		        {
		          defender++;
		        }
	         }
	      }
      }

      if (defender == 0)
      {
        attackerStat++;
      }
      else if (attacker == 0)
      {
        defenderStat++;
      }
      else
      {
        splitStat++;
      }
    }

    Formatter formatter  = new Formatter();
    float percentage = (attackerStat / (float) samples) * 100;
    System.out.print ("      [Attacker ");
    System.out.print (formatter.format ("%3.2f", percentage).toString());
    formatter.close();
    
    formatter  = new Formatter();
    percentage = (defenderStat / (float) samples) * 100;
    System.out.print (", Defender ");
    System.out.print (formatter.format ("%3.2f", percentage).toString());
    formatter.close();
    
    formatter  = new Formatter();
    percentage = (splitStat / (float) samples) * 100;
    System.out.print (", Split ");
    System.out.println (formatter.format ("%3.2f", percentage).toString() + "]");
    formatter.close();
  }
}