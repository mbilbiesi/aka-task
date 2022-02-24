package com.akamai.web.tests;

import com.akamai.web.config.TestModule;
import com.akamai.web.steps.JobSearchSteps;
import com.google.inject.Inject;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Guice;

@Guice(modules = TestModule.class)
public abstract class BaseTest {
  @Inject protected JobSearchSteps jobSearchSteps;
  @Inject protected WebDriver driver;

  @BeforeClass(alwaysRun = true)
  public void setup(ITestContext context) {
    context.setAttribute("webDriver", driver);
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() {
    driver.quit();
  }
}
