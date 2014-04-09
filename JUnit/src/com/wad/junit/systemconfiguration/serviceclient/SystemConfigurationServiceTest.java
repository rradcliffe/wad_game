package com.wad.junit.systemconfiguration.serviceclient;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.wad.systemconfiguration.client.SystemConfigurationClient;

public class SystemConfigurationServiceTest
{
  public SystemConfigurationServiceTest()
  {
  }

  @BeforeClass
  public static void setUpClass() throws Exception
  {
  }

  @AfterClass
  public static void tearDownClass() throws Exception
  {
  }
  
  /**
   * Test retrieving a string value.
   */
  @Test
  public void testGetConfigurationString()
  {
    System.out.println("");
    System.out.println("SystemConfigurationServiceClientTest : testGetConfigurationString");

    SystemConfigurationClient serviceClient = new SystemConfigurationClient();
    
    String category = "Debug";
    String key = "TestString";
    
    String result = serviceClient.getString(category, key);
    
    // Check for correct return value
    assertTrue (result.equals("StringResult"));
    
    System.out.println("...Passed");
  }
}
