package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {


    WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void clickServiceLocator() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("search_overlay")));
        driver.findElement(By.id("ClalitNewMaster_QuickLinksUC_rptQuickLinks_ctl04_nav_item_link")).click();
    }


}
