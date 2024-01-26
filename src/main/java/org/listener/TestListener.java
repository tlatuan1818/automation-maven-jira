package org.listener;


import org.apache.commons.lang.exception.ExceptionUtils;

import org.testng.ITestContext;

import org.testng.ITestListener;

import org.testng.ITestResult;
import org.utility.JiraCreateIssue;
import org.utility.JiraServiceProvider;


public class TestListener implements ITestListener {


    @Override

    public void onTestFailure(ITestResult result) {

        boolean islogIssue = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(JiraCreateIssue.class).isCreateIssue();

        if (islogIssue) {

//Provide proper Jira project URL ex: https://browsertack.atlassian.net

//Jira User name ex: browserstack@gmail.com

//API token copy from Jira dashboard ex: lorelimpusm12uijk

//Project key should be, Short name ex: BS


            JiraServiceProvider JiraServiceProvider = new JiraServiceProvider("https://tuan1111.atlassian.net",

                    "tramleanhtuan1111@gmail.com", "ATATT3xFfGF0Q5np4Mti8kBAOfUPG3iQwfIc52f6cRsnsQiiJL7NrWDRuYOut7epQTKPAJVUnUMfMuKEHx4YKlvx0V8rRQUUWt1hy8hlSd1WjxEkiDCO6UyCt-AGoFRIjMnXr45mO8kdahjptaueC4Oc4i30xwILbgDyaoXwo_JcgpF2JAvzNPo=0E10F2DA", "ATM");



            String issueDescription = "Failure Reason from Automation Testing\n\n" + result.getThrowable().getMessage()

                    + "\n";

            issueDescription.concat(ExceptionUtils.getFullStackTrace(result.getThrowable()));




            String issueSummary = result.getMethod().getConstructorOrMethod().getMethod().getName()

                    + " Failed in Automation Testing";



            JiraServiceProvider.createJiraIssue("Bug", issueSummary, issueDescription, "Automated Testing");

        }

    }

    @Override

    public void onTestSkipped(ITestResult result) {

        // TODO Auto-generated method stub




    }

    @Override

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

        // TODO Auto-generated method stub


    }

    @Override

    public void onStart(ITestContext context) {

        // TODO Auto-generated method stub


    }


    @Override

    public void onFinish(ITestContext context) {

        // TODO Auto-generated method stub


    }


    @Override

    public void onTestStart(ITestResult result) {

        // TODO Auto-generated method stub


    }


    @Override

    public void onTestSuccess(ITestResult result) {

        // TODO Auto-generated method stub


    }

}
