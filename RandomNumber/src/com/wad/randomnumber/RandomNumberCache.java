
package com.wad.randomnumber;

import java.util.List;

import com.wad.cache.GenericCache;
import com.wad.randomnumber.client.IRandomNumberClient;
import com.wad.randomnumber.client.RandomNumberClient;

//import wad.advisory.Advisory;
//import wad.advisory.Status;
//import wad.constants.ConstantsPackages;
//import wad.exception.WadException;
//import wad.log.AdvisoryLog;


public class RandomNumberCache extends GenericCache<Integer>
{
  //private static final String  _className  = "RandomNumberCache";

  private static final int CACHE_PAGES    = 5;
  private static final int CACHE_SIZE     = 100000;

  private static RandomNumberCache _instance = null;
  private static IRandomNumberClient<Integer> _client = null;

  public RandomNumberCache()
  //      throws WadException
  {
    super (CACHE_PAGES, CACHE_SIZE);
  }

  public static synchronized RandomNumberCache getInstance()
  //      throws WadException
  {
    if (_instance == null)
    {
      _instance = new RandomNumberCache();
    }

    return _instance;
  }

  public List<Integer> fill(int cachePageSize)
  {   
    if (_client == null)
    {     
      _client = new RandomNumberClient();
    }
    
    return _client.getList (cachePageSize);
  }
}
