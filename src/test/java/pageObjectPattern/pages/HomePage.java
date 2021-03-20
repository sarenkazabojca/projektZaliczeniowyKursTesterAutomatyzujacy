package pageObjectPattern.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void searchOurCatalog(String searchPhrase){
        WebElement searchProduct = driver.findElement(By.name("s"));
        searchProduct.clear();
        searchProduct.sendKeys(searchPhrase);
        searchProduct.submit();
    }
}
