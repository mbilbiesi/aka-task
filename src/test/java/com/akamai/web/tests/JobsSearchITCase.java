package com.akamai.web.tests;

import org.testng.annotations.Test;

class JobsSearchITCase extends BaseTest {

  @Test(description = "Search for a job matching given criteria")
  void testSearchForJob_jobsReturned() {
    // Given
    var desiredJobKeyword = "Senior Software Development Engineer in Test";
    var desiredLocation = "Poland";
    jobSearchSteps.userNavigateToJobSearchPage();

    // When
    jobSearchSteps.userTypeInJobSearchBox(desiredJobKeyword);
    jobSearchSteps.userClickOnListItem(desiredJobKeyword);
    jobSearchSteps.userTypeInLocationSearchBox(desiredLocation);
    jobSearchSteps.userClickOnListItem(desiredLocation);

    // Then
    jobSearchSteps.verifyReturnedJobsLabelAreMoreThanZero();
  }

  @Test(description = "Customer is notified when no offers match given criteria")
  void testSearchForJob_NoJobsReturned() {
    // Given
    var desiredJobKeyword = "XXX";
    jobSearchSteps.userNavigateToJobSearchPage();

    // When
    jobSearchSteps.userTypeInJobSearchBox(desiredJobKeyword);
    jobSearchSteps.userClickOnSearchIcon();

    // Then
    jobSearchSteps.verifyReturnedJobsLabelHasZeroJobs();
  }
}
