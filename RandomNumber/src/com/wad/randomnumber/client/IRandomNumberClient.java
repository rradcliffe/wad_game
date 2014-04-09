
package com.wad.randomnumber.client;

import java.util.List;

//import wad.exception.WadException;


public interface IRandomNumberClient<TBusiness>
{
  List<TBusiness> getList (int count);
//        throws WadException;
}

