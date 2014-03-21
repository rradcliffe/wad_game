
package com.wad.cache;

import java.util.List;

//import wad.advisory.Advisory;
//import wad.constants.ConstantsPackages;
//import wad.advisory.Status;
//import wad.exception.WadException;
//import wad.log.AdvisoryLog;

public interface IGenericCache<T>
{
  //public abstract void fill(List<T> list, int cachePageSize);
  public abstract List<T> fill(int cachePageSize);
}

