package com.akamai.web.steps;

import io.qameta.allure.Step;
import java.time.Duration;
import lombok.NonNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BaseSteps<T extends BaseSteps<T>> {

  protected final WebDriver driver;
  protected WebDriverWait wait;

  protected BaseSteps(@NonNull WebDriver driver) {
    this.driver = driver;
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
  }

  @Step("User click on {0} list item")
  public void userClickOnListItem(String item) {
    driver.findElement(By.xpath("//li[. = ' " + item + " ']")).click();
  }
}
