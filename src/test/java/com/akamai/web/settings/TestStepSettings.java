package com.akamai.web.settings;

import lombok.Builder;
import lombok.Getter;
import org.openqa.selenium.WebDriver;

@Builder
@Getter
public class TestStepSettings {
  private WebDriver driver;
  private String pageURL;
}
