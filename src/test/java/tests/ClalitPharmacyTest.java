package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.PharmacySearchPage;
import pages.ServicesLocatorPage;

import java.sql.Driver;

public class ClalitPharmacyTest {

    WebDriver driver;
    PharmacySearchPage searchPage;
    HomePage homePage;
    ServicesLocatorPage servicesPage;

    @BeforeClass
    public  void  setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\webdrivers\\chrome\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.clalit.co.il/he/Pages/default.aspx");
        searchPage = new PharmacySearchPage(driver);
        homePage = new HomePage(driver);
        servicesPage = new ServicesLocatorPage(driver);

    }
    @Test
    public void test(){
        homePage.clickServiceLocator();
        servicesPage.clickPharmacyTab();
        servicesPage.checkOpenNow();
        servicesPage.clickSearchButton();
        servicesPage.waitForResults();
        servicesPage.resultsExist();
        Assert.assertTrue(servicesPage.resultsExist(), "לא נמצאו תוצאות חיפוש.");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        searchPage.openTopSearch();
        searchPage.searchClick();
        searchPage.searchString("בתי מרקחת");

        searchPage.searchButton();
        searchPage.waitForResults();
        Assert.assertTrue(searchPage.hasResults());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }


}
