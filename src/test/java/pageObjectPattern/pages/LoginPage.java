package pageObjectPattern.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void loginAs(String email, String password){
        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.clear();
        emailInput.sendKeys(email);

        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.clear();
        passwordInput.sendKeys(password);

        WebElement signIn = driver.findElement(By.id("submit-login"));
        signIn.click();
    }

    public String getLoggedUsername() {
        WebElement userName = driver.findElement(By.cssSelector("#_desktop_user_info span"));
        return userName.getText();
    }
}
