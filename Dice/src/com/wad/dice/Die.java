
package com.wad.dice;


public class Die
{
  //private final String       _className    = "Die";
  
  private int _min = 1;
  private int _max = 6;
  private int _value = 0;

  public Die(int value)
  {
    _value = value;
  }
  
  public Die(int max, int value)
  {
    _max = max;
    _value = value;
  }

  public Die(int min, int max, int value)
  {   
    _min = min;
    _max = max;
    _value = value;
  }
    
  public int getMin()
  {
    return _min;
  }
  
  public int getMax()
  {
    return _max;
  }
  
  public int get()
  {
    return _value;
  }
}


    

