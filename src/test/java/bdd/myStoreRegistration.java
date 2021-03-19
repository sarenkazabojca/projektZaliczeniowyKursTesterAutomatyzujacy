package bdd;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class myStoreRegistration {

    WebDriver driver;

    @Given("user is on registration page")
        public void openRegistrationPage(){
            System.setProperty("webdriver.chrome.driver",
                    "src/main/resources/drivers/chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://prod-kurs.coderslab.pl/index.php?controller=authentication&create_account=1");
        }

    @When("^user inputs (.*), (.*), (.*), (.*)$")
    public void userInputsFirstNameLastNameEmailPassword() {
        WebElement firstNameInput = driver.findElement(By.name("firstname"));
//        firstNameInput.sendKeys(firstname);


    }

    @When("^user clicks Save button$")
    public void userClicksSaveButton() {
    }

    @Then("^user is registered$")
    public void userIsRegistered() {
    }
}
