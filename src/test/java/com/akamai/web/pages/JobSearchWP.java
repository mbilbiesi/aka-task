package com.akamai.web.pages;

import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.Accessors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
@Accessors(fluent = true)
public class JobSearchWP extends BaseWebPage<JobSearchWP> {

  @FindBy(id = "keywordLocation")
  WebElement searchTextBox;

  @FindBy(id = "location")
  WebElement locationTextBox;

  @FindBy(xpath = "//span[starts-with(.,'We found')]")
  WebElement resultLabel;

  @FindBy(className = "btn-primary")
  WebElement searchButton;

  public JobSearchWP(@NonNull WebDriver driver) {
    super(driver);
  }
}
