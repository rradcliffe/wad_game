
package com.wad.dice;

import java.util.List;

import com.wad.randomnumber.*;


public class DiceController
{
  //private final String       _className    = "Dice";
  
  private int _min     = 1;
  private int _max     = 6;
  private SortType _sortType  = SortType.NONE;
  private RandomNumberClient _client       = null;

  public enum SortType { NONE, ASCENDING, DESCENDING };

  
  public DiceController ()
  {
    _client = new RandomNumberClient();
  }
  
  public DiceController (int max)
  {
    _max = max;

    _client = new RandomNumberClient();
  }

  public DiceController (int min, int max)
  {
    _min = min;
    _max = max;

    _client = new RandomNumberClient();
  }
  
  public void setSorting(SortType sortType)
  {
    _sortType = sortType;
  }
   
  public Dice getDice (int count)
  {
    Dice dice = null;
    
    List<Integer> tempList = _client.getList(count);
    if (tempList.size() > 0)
    {
      dice = new Dice();
      
      int modulus  = _max - _min + 1;
      for (int index = 0; index < tempList.size(); index++)
      {
        Die die = new Die(_min + (Math.abs (tempList.get(index)) % modulus));

        dice.add(die);
      }
    }
    
    sort(dice);
    
    return dice;
  }
  
  private void sort(Dice dice)
  {
    if (_sortType == SortType.ASCENDING)
    {
      dice.sortAscending();
    }
    else if (_sortType == SortType.DESCENDING)
    {
      dice.sortDescending();
    }
  }
}


    

