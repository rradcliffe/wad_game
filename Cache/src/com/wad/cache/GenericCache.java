
package com.wad.cache;

import java.util.ArrayList;
import java.util.List;

//import wad.advisory.Advisory;
//import wad.constants.ConstantsPackages;
//import wad.advisory.Status;
//import wad.exception.WadException;
//import wad.log.AdvisoryLog;


public abstract class GenericCache<T> implements IGenericCache<T>
{
//  private static final String  _className    = "CacheGeneric";
 
  private List<List<T>> _cache      = null;

  private int  _cachePages    = 2;
  private int  _cachePageSize = 100;

  private AddCachePagesThread _cachePagesThread = null;
  
//  protected GenericCache(int cachePages, int cachePageSize)
//        throws WadException
//  {
//    final String  methodName  = "CacheGeneric";

//    // Check for invalid cache settings.
//    if ((cachePages == 0) || (cachePageSize == 0))
//    {
////      Advisory      advisory      = new Advisory();
////      WadException  wadException  = new WadException();
////
////      advisory.setPackageName  (ConstantsPackages.CACHE);
////      advisory.setMethodName   (_className + "::" + methodName);
////      advisory.setStatus       (Status.STATUS_CACHE_SETTINGS);
////      advisory.setSupplemental ("Pages " + cachePages + ", Size " + cachePageSize);
////
////      AdvisoryLog.log (advisory);
////
////      wadException.setAdvisory (advisory);
////
////      throw wadException;
//    }
//    else
//    {
//      _cachePages = cachePages;
//      _cachePageSize = cachePageSize;
//
//      _cache = new ArrayList<List<T>>();
//      
//      synchronized(_cache)
//      {
//        List<T> list = fill(_cachePageSize);
//        
//        _cache.add(list);
//      }
//      
//      // Initialize the remaining pages of the cache. This will be done in
//      // a separate thread.
//      _addPages(_cachePages - 1);
//    }
//  }

  public void setCacheParams(int cachePages, int cachePageSize)
  {
    // Check for invalid cache settings.
    if ((cachePages == 0) || (cachePageSize == 0))
    {
//      Advisory      advisory      = new Advisory();
//      WadException  wadException  = new WadException();
//
//      advisory.setPackageName  (ConstantsPackages.CACHE);
//      advisory.setMethodName   (_className + "::" + methodName);
//      advisory.setStatus       (Status.STATUS_CACHE_SETTINGS);
//      advisory.setSupplemental ("Pages " + cachePages + ", Size " + cachePageSize);
//
//      AdvisoryLog.log (advisory);
//
//      wadException.setAdvisory (advisory);
//
//      throw wadException;
    }
    else
    {
      _cachePages = cachePages;
      _cachePageSize = cachePageSize;

      _cache = new ArrayList<List<T>>();
    
      synchronized(_cache)
      {
        List<T> list = fill(_cachePageSize);
      
        _cache.add(list);
      }
    
      // Initialize the remaining pages of the cache. This will be done in
      // a separate thread.
      _addPages(_cachePages - 1);
    }
  }
  
  // NOTE: this method can return: 
  
  // 1) null 
  // 2) a complete list containing ALL the requested numbers 
  // 3) an incomplete list that does NOT contain all the requested numbers (incomplete)
  
  // the caller needs to be able to handle all three cases
  
  public List<T> read(int numbersToRetrieve)
  {
//    final String          methodName  = "read";
    List<T> list = null;

    if (_cache.isEmpty())
    {
//      Advisory      advisory      = new Advisory();
//
//      advisory.setPackageName  (ConstantsPackages.CACHE);
//      advisory.setMethodName   (_className + "::" + methodName);
//      advisory.setStatus       (Status.STATUS_CACHE_INVALID);
//
//      AdvisoryLog.log (advisory);
    }

    else
    {
      int elementIndex   = 0;
      int pageIndex      = 0;

      list = new ArrayList<T>();

      while((list.size() < numbersToRetrieve)&&(!_cache.isEmpty()))
      {
        List<T> workList;
        
        synchronized(_cache)
        {
          workList = _cache.get (pageIndex);
        }
        
        int numbersRemaining = numbersToRetrieve - list.size();

        // Can current cache be used to retrieve all data?
        if (numbersRemaining < workList.size())
        {
          for (int index = 0; index < numbersRemaining; index++)
          {
            list.add (workList.remove (elementIndex));
          }
        }

        // Data must be retrieved from multiple pages of cache.
        else
        {
          // Retrieve available data from current page of cache.
          int available = workList.size();

          for (int index = 0; index < available; index++)
          {
            list.add (workList.remove (elementIndex));
          }
          
          synchronized(_cache)
          {
            _cache.remove (pageIndex);
          }
          
          // Refill page.
          _addPages (1);
        }
      }
    }

    return list;
  }

  private void _addPages (int pages)
  {   
    if (_cachePagesThread == null)
    {
      _cachePagesThread = new AddCachePagesThread();
      _cachePagesThread.start();
    }
    
    _cachePagesThread.fillPages(pages);
  }

  private class AddCachePagesThread extends Thread
  {
    private int _pages = 0;
    private boolean _done = false;

    public AddCachePagesThread ()
    {
    }

    public void fillPages(int pages)
    {
      if (pages > 0)
      {
        _pages += pages;
      }
    }
    
    public void run()
    {
      while (!_done)
      {
        if (_pages > 0)
        {
          List<T> list = fill(_cachePageSize);
          
          synchronized(_cache)
          {
            _cache.add(list);
          }
          
          _pages--;
        }
        
        try
        {
          Thread.sleep(100);
        }
        catch (InterruptedException ex)
        {
          _done = true;
        }
      }
    }
  }
}

