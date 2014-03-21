package com.wad.dice;

import java.util.Comparator;


class AscendingComparator implements Comparator<Die>
{
  public int compare(Die die1, Die die2)
  {
    int result = 0;
    
    if (die1.get() < die2.get())
    {
      result = (-1);
    }
    else if (die1.get() > die2.get())
    {
      result = 1;
    }
    
    return result;
  }
}

class DescendingComparator implements Comparator<Die>
{
  public int compare(Die die1, Die die2)
  {
    int result = 0;
    
    if (die1.get() > die2.get())
    {
      result = (-1);
    }
    else if (die1.get() < die2.get())
    {
      result = 1;
    }
    
    return result;
  }
}
