
package com.wad.systemconfiguration.client;


public interface ISystemConfigurationClient
{
  String getString(String category, String key);

  int getInt(String category, String key);
  
  Boolean getBoolean(String category, String key);
}

