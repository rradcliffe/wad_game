
package com.wad.dice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Dice
{
  //private final String       _className    = "Dice";
  
  private List<Die> _list = null;
  

  public Dice()
  {
    _list = new ArrayList<Die>();
  }
  
  public void add(Die die)
  {
    _list.add(die);
  }
  
  public void add(List<Die> list)
  {
    for (int index = 0; index < list.size(); index++)
    {
      _list.add(list.get(index));
    }
  }
  
  public Die get()
  {
	if (_list.isEmpty())
		return null;
	
    Die result = _list.get(0);
    
    _list.remove(0);
    
    return result;
  }
  
  public List<Die> get(int count)
  {
	if (_list.isEmpty())
		return null;
	
    List<Die> list = null;
    
    if (_list.size() >= count)
    {
      list = new ArrayList<Die>();
      
      for (int index = 0; index < count; index++)
      {
        list.add(_list.get(0));
        
        _list.remove(0);
      }
    }
    
    return list;
  }
  
  public List<Die> getAll()
  {
    List<Die> list = null;
    
    if (_list.size() > 0)
    {
      list = new ArrayList<Die>();
      
      int size = _list.size();
      for (int index = 0; index < size; index++)
      {
        list.add(_list.get(0));
      
        _list.remove(0);
      }
    }
    
    return list;
  }
  
  public int length()
  {
    return _list.size();
  }
  
  public void sortAscending()
  {
    Collections.sort(_list, new AscendingComparator());
  }
  
  public void sortDescending()
  {
    Collections.sort(_list, new DescendingComparator());
  }
}


    

