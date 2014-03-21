
package com.wad.randomnumber.serviceclient;

import java.util.List;

//import wad.exception.WadException;


public interface IRandomNumberServiceClient<TBusiness>
{
  List<TBusiness> getList (int count);
//        throws WadException;
}

