package com.akamai.web.config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:test-props.properties")
public interface TestProperties extends Config {

  @Key("browser")
  String getBrowserName();

  @Key("job.search.url")
  String getSearchJobUrl();

  @Key("driver.page.load.timeout")
  Long getDriverPageLoadTimeout();

  @Key("driver.implicitly.wait")
  Long getDriverImplicitlyWait();
}
