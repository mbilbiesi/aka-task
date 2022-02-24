package com.akamai.web.listeners;

import io.qameta.allure.Allure;
import java.io.ByteArrayInputStream;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

@Slf4j
public class TestListener implements ITestListener {

  @Override
  public void onTestSuccess(ITestResult iTestResult) {
    attachScreenshotToTestReport(iTestResult);
  }

  @Override
  public void onTestFailure(ITestResult iTestResult) {
    attachScreenshotToTestReport(iTestResult);
  }

  private void attachScreenshotToTestReport(ITestResult iTestResult) {
    WebDriver driver = ((WebDriver) iTestResult.getTestContext().getAttribute("webDriver"));
    try {
      Allure.addAttachment(
          RandomStringUtils.randomAlphanumeric(30),
          "image/png",
          new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)),
          ".png");
    } catch (Exception e) {
      log.error("There was an issue taking screenshot :", e);
    }
  }
}
