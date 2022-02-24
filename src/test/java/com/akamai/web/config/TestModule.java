package com.akamai.web.config;

import com.akamai.web.settings.TestStepSettings;
import com.akamai.web.steps.JobSearchSteps;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.Browser;

public class TestModule extends AbstractModule {

  @Provides
  @Singleton
  public JobSearchSteps jobSearchSteps(WebDriver driver, TestProperties properties) {
    var stepSetting =
        TestStepSettings.builder().driver(driver).pageURL(properties.getSearchJobUrl()).build();
    return new JobSearchSteps(stepSetting);
  }

  @Provides
  @Singleton
  public WebDriver webDriver(TestProperties properties) {
    if (properties.getBrowserName().equals(Browser.CHROME.browserName())) {
      WebDriverManager.chromedriver().setup();
      WebDriver driver = new ChromeDriver();
      driver.manage().window().maximize();
      driver
          .manage()
          .timeouts()
          .pageLoadTimeout(Duration.ofSeconds(properties.getDriverPageLoadTimeout()));
      driver
          .manage()
          .timeouts()
          .implicitlyWait(Duration.ofSeconds(properties.getDriverImplicitlyWait()));
      return driver;
    } else
      throw new IllegalStateException(
          String.format(
              "Framework doesn't support the provided browser : %s", properties.getBrowserName()));
  }

  @Provides
  @Singleton
  public TestProperties properties() {
    return ConfigFactory.create(TestProperties.class, System.getProperties());
  }
}
