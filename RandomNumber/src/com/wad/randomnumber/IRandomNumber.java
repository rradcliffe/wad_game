
package com.wad.randomnumber;

import java.util.List;

//import wad.exception.WadException;


public interface IRandomNumber<TBusiness>
{
  List<TBusiness> getList (int count);
//        throws WadException;
}

