package com.akamai.web.utils;

import java.util.regex.Pattern;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

public final class CustomConditions {

  private CustomConditions() {}

  public static ExpectedCondition<Boolean> elementTextMatch(WebElement element, Pattern pattern) {
    return driver -> {
      try {
        String currentValue = element.getText();
        return pattern.matcher(currentValue).find();
      } catch (Exception e) {
        return false;
      }
    };
  }
}
