package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PharmacySearchPage {

    WebDriver driver;

    public PharmacySearchPage(WebDriver driver){
        this.driver = driver;
    }
    public void openTopSearch(){
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
        driver.findElement(By.xpath("//*[@id=\"DeltaPlaceHolderMain\"]/header/div[1]/div/div/div[3]/ul/li[3]/a/em")).click();
    }
    public void searchClick(){
//        driver.findElement(By.xpath("//*[@id=\"DeltaPlaceHolderMain\"]/header/div[1]/div/div/div[3]/ul/li[3]/a/em")).click();
        driver.findElement(By.cssSelector("a.btn-search")).click();

    }
    public  void searchString(String s){
        driver.findElement(By.id("ClalitNewMaster_ClalitSearchBoxUC_mainSearchField")).sendKeys(s);
    }

    public  void searchButton(){
//        driver.findElement(By.xpath("//*[@id=\"search_fields_lg\"]/form/div/div[3]/button")).click();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.btn.btn-primary")));
            button.click();
    }

    public void waitForResults() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search_results_list")));
    }

    public boolean hasResults() {
        return driver.findElements(By.id("search_results_list")).size() > 0;
    }
}
