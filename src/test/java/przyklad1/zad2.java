package przyklad1;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.*;


public class zad2 {

    private WebDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://katalon-test.s3.amazonaws.com/demo-aut/dist/html/form.html");
    }

    @Test
    public void fillForm(){

        WebElement firstNameInput = driver.findElement(By.id("first-name"));
        if(firstNameInput.isEnabled()){
            WebElement firstNameName = driver.findElement(By.cssSelector("#infoForm > div:nth-child(1) > label"));
//            System.out.println(firstNameName.getText());
            firstNameInput.clear();
            firstNameInput.sendKeys("Karol");
            firstNameInput.submit();
            System.out.println(firstNameName.getText() + " : " + firstNameInput.getAttribute("value"));

        } else {
            Assert.fail();
        }

        WebElement lastNameInput = driver.findElement(By.id("last-name"));
        lastNameInput.clear();
        lastNameInput.sendKeys("Kowalski");
        lastNameInput.submit();

        WebElement chooseGender = driver.findElement(By.cssSelector("#infoForm > div:nth-child(3) > div > div > label:nth-child(1)"));
        chooseGender.click();

        WebElement dateOfBirthInput = driver.findElement(By.id("dob"));
        dateOfBirthInput.clear();
        dateOfBirthInput.sendKeys("10/10/2010");
        dateOfBirthInput.submit();

        WebElement addressInput = driver.findElement(By.xpath("//*[@id=\"address\"]"));
        addressInput.clear();
        addressInput.sendKeys("Prosta 51");
        addressInput.submit();

        WebElement emailInput = driver.findElement(By.cssSelector("#email"));
        emailInput.clear();
        emailInput.sendKeys("karol.kowalski@mailinator.com");
        emailInput.submit();

        WebElement passwordInput = driver.findElement(By.cssSelector("#password"));
        passwordInput.clear();
        passwordInput.sendKeys("Pass123");
        passwordInput.submit();

        WebElement companyInput = driver.findElement(By.cssSelector("#company"));
        companyInput.clear();
        companyInput.sendKeys("Coders Lab");
        companyInput.submit();

        WebElement chooseWaysOfDevelopment = driver.findElement(By.xpath("//*[@id=\"infoForm\"]/div[11]/div/div[4]/label/input"));
        chooseWaysOfDevelopment.click();

        WebElement commentInput = driver.findElement(By.cssSelector("#comment"));
        commentInput.clear();
        commentInput.sendKeys("To jest mój pierwszy automat testowy");
        commentInput.submit();

        WebElement submitButton = driver.findElement(By.cssSelector("#submit"));
        submitButton.click();

        // ZADANIE 4!!! JUnit ZROBIĆ!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//        WebElement successfull = driver.findElement(By.cssSelector("#submit-msg"));
//        String valuesuccessfull = successfull.getAttribute("value");
//        String expectedSuccessfull = "Successfully submitted!";
//        Assert.assertEquals(successfull.getAttribute("value"), expectedSuccessfull );

    }

//    @Test
//    public static void checkingIfSuccesfull(){
//        WebElement succesfull = driver.findElement(By.cssSelector("#submit-msg"));
//        String valuesuccesfull = succesfull.getAttribute("value");
//        String expectedSuccesfull = "Successfully submitted!";
//        assertEquals(succesfull.getAttribute("value"), expectedSuccesfull );
//    }


    @After
    public void tearDown(){
//        Zamknięcie przeglądarki
//        driver.quit();
    }

}
