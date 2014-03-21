
package com.wad.randomnumber;

import java.util.List;

//import wad.advisory.Advisory;
//import wad.advisory.Status;
//import wad.constants.ConstantsPackages;
//import wad.exception.WadException;
//import wad.log.AdvisoryLog;


public class RandomNumberClient implements IRandomNumberClient<Integer>
{
  //private static final String  _className  = "RandomNumberCache";

  private static RandomNumberCache _cache = null;
  

  public RandomNumberClient()
  //      throws WadException
  {   
    _cache = RandomNumberCache.getInstance();
  }

  public List<Integer> getList(int count)
  {
    List<Integer> list = null;
        
    if (count > 0)
    {
      list = _cache.read(count);
      if (list == null)
      {
        System.out.println("Retuned list == null");
      }
    }
    
    return list;
  }
}
