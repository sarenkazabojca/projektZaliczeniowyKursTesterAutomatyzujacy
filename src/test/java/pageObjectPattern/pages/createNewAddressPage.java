package pageObjectPattern.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class createNewAddressPage {


    private WebDriver driver;

    public createNewAddressPage(WebDriver driver){
        this.driver = driver;
    }

    public void createNewAddress(String address, String postalCode, String city, String country, String phone){
        WebElement inputAddress = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/form/section/div[6]/div[1]/input"));
        inputAddress.clear();
        inputAddress.sendKeys(address);

        WebElement inputCity = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/form/section/div[8]/div[1]/input"));
        inputCity.clear();
        inputCity.sendKeys(city);

        WebElement inputPostalCode = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/form/section/div[9]/div[1]/input"));
        inputPostalCode.clear();
        inputPostalCode.sendKeys(postalCode);

        WebElement selectCountry = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/form/section/div[10]/div[1]/select"));
        new Select(selectCountry).selectByVisibleText(country);

        WebElement inputPhone = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/form/section/div[11]/div[1]/input"));
        inputPhone.clear();
        inputPhone.sendKeys(phone);
    }

    public String getSuccessfulMessage(){
        WebElement successfulMessage = driver.findElement(By.cssSelector("#notifications > div > article"));
        return successfulMessage.getText();
    }
}
