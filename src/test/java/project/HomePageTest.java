package project;

import static org.testng.Assert.assertEquals;

import static org.testng.Assert.assertTrue;

import java.io.File;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;
import org.utility.JiraCreateIssue;


public class HomePageTest {

        private WebDriver driver;

        private String baseUrl;




        @BeforeClass(alwaysRun = true)

        public void setUp() throws Exception {

          File chromedriverExecutable = new File( "driver/chromedriver.exe");
          System.setProperty("web driver.chrome.driver", chromedriverExecutable.getAbsolutePath());
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            driver = new ChromeDriver();
            baseUrl = "https://www.browserstack.com/";
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        }


//Custom annotation explained in following sections

        @JiraCreateIssue(isCreateIssue=true)

        @Test

        public void verifyHomepageHeaderText() throws Exception {

            driver.get(baseUrl);

            WebElement el = driver.findElement(By.xpath("//h1[1]"));

            assertEquals(el.getText(), "Browser Testing Made Easy","Wrong header text displayed in Home page");

        }


        @JiraCreateIssue(isCreateIssue=true)

        @Test

        public void verifyHomePageLogo() throws Exception {

            driver.get(baseUrl);

            WebElement el = driver.findElement(By.id("logo"));

            assertTrue(el.isDisplayed(),"The browserstack logo not displaying in home page");

        }


        @AfterClass(alwaysRun = true)

        public void tearDown() throws Exception {

            driver.quit();

        }

    }


