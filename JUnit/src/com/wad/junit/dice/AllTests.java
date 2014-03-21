package com.wad.junit.dice;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses(
{
  DiceTest.class,
  RollDistributionTest.class,
  DiceRollProbabilityTest.class
})

public class AllTests
{

}
