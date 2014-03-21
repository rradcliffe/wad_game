
package com.wad.randomnumber;

import java.util.List;

//import wad.exception.WadException;


public interface IRandomNumberClient<TBusiness>
{
  List<TBusiness> getList (int count);
//        throws WadException;
}

