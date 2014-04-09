/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wad.junit.systemconfiguration.business;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.wad.systemconfiguration.business.SystemConfigurationImpl;

import static org.junit.Assert.*;


public class SystemConfigurationBusinessTest
{
  public SystemConfigurationBusinessTest()
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
    System.out.println("SystemConfigurationBusinessTest : testGetConfigurationString");

    SystemConfigurationImpl systemConfig = new SystemConfigurationImpl();

    String result = systemConfig.getString("Debug", "TestString");
    
    // Check for correct return value
    assertTrue (result.equals("StringResult"));
    
    System.out.println("...Passed");
  }
  
  /**
   * Test retrieving an int value.
   */
  @Test
  public void testGetConfigurationInt()
  {
    System.out.println("");
    System.out.println("SystemConfigurationTest : testGetConfigurationInt");

    SystemConfigurationImpl systemConfig = new SystemConfigurationImpl();

    int result = systemConfig.getInt("Debug", "TestInt");
    
    // Check for correct return value
    assertTrue (result == 99);
    
    System.out.println("...Passed");
  }
  
  /**
   * Test retrieving a boolean value.
   */
  @Test
  public void testGetConfigurationBoolean()
  {
    System.out.println("");
    System.out.println("SystemConfigurationTest : testGetConfigurationBoolean");

    SystemConfigurationImpl systemConfig = new SystemConfigurationImpl();

    boolean result = systemConfig.getBoolean("Debug", "TestBoolean");
    
    // Check for correct return value
    assertTrue (result == true);
    
    System.out.println("...Passed");
  }
}