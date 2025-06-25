package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ServicesLocatorPage {

    WebDriver driver;
    public ServicesLocatorPage(WebDriver driver){
        this.driver = driver;
    }

    public void waitForResults(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("search_results_list")
        ));
    }

    public void clickPharmacyTab()
    {
        driver.findElement(By.id("pharmacies")).click();
    }

    public void checkOpenNow() {
//        WebElement checkbox = driver.findElement(By.id("checkbox10"));
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkbox);
//        checkbox.click();

            WebElement checkbox = driver.findElement(By.id("checkbox10"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkbox);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);

//        if (!checkbox.isSelected()) {
//            checkbox.click();
//        }
        //*[@id="services_book_doctors"]/div[2]/div[2]/div/div/label
    }

    public void clickSearchButton(){
        driver.findElement(By.xpath("//*[@id=\"lobby_search\"]/div/div/div/fieldset[2]/div/a")).click();
    }


    public boolean resultsExist() {
        return driver.findElements(By.id("search_results_list")).size() > 0;
    }

}
