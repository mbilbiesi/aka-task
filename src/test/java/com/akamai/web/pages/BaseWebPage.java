package com.akamai.web.pages;

import lombok.NonNull;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BaseWebPage<T extends BaseWebPage<T>> {

  public BaseWebPage(@NonNull WebDriver driver) {
    PageFactory.initElements(driver, this);
  }
}
