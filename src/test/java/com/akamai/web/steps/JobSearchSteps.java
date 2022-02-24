package com.akamai.web.steps;

import com.akamai.web.pages.JobSearchWP;
import com.akamai.web.settings.TestStepSettings;
import com.akamai.web.utils.CustomConditions;
import io.qameta.allure.Step;
import java.util.regex.Pattern;
import lombok.NonNull;

public class JobSearchSteps extends BaseSteps<JobSearchSteps> {

  private final TestStepSettings settings;
  private final JobSearchWP jobSearchWebPage;

  public JobSearchSteps(@NonNull TestStepSettings settings) {
    super(settings.getDriver());
    this.settings = settings;
    jobSearchWebPage = new JobSearchWP(settings.getDriver());
  }

  @Step("User navigate to search job page")
  public void userNavigateToJobSearchPage() {
    driver.get(settings.getPageURL());
  }

  @Step("User type {0} in job search box")
  public void userTypeInJobSearchBox(String desiredJobKeyword) {
    jobSearchWebPage.searchTextBox().click();
    jobSearchWebPage.searchTextBox().sendKeys(desiredJobKeyword);
  }

  @Step("User type {0} in location search box")
  public void userTypeInLocationSearchBox(String desiredLocation) {
    jobSearchWebPage.locationTextBox().click();
    jobSearchWebPage.locationTextBox().sendKeys(desiredLocation);
  }

  @Step("User click on Search icon")
  public void userClickOnSearchIcon() {
    jobSearchWebPage.searchButton().click();
  }

  @Step("Verify search result label includes more than 0 jobs")
  public void verifyReturnedJobsLabelAreMoreThanZero() {
    var jobsLabelGreaterThanZeroPattern =
        Pattern.compile("We found [1-9][0-9]* jobs based on your search criteria");
    verifyJobsResultLabel(jobsLabelGreaterThanZeroPattern);
  }

  @Step("Verify search result label is showing ZERO jobs returned")
  public void verifyReturnedJobsLabelHasZeroJobs() {
    var jobsLabelGreaterThanZeroPattern =
        Pattern.compile("We found 0 jobs based on your search criteria");
    verifyJobsResultLabel(jobsLabelGreaterThanZeroPattern);
  }

  private void verifyJobsResultLabel(Pattern resultLabelTextPattern) {
    wait.withMessage("No Jobs returned by the provided search criteria")
        .until(
            CustomConditions.elementTextMatch(
                jobSearchWebPage.resultLabel(), resultLabelTextPattern));
  }
}
