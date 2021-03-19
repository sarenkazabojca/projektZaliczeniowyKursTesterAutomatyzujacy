package przyklad1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Random;
import java.util.UUID;

public class ZadDodatkowe2 {
    private WebDriver driver;

    Random random = new Random();

    String[] names = {"Basia", "Asia", "Krzyś", "Ziutek", "Lusia"};
    int randomName = random.nextInt(names.length);
    String[] surnames = {"Odkurzacz", "Guarana", "Ledowy", "Lingwistyka"};
    int randomSurname = random.nextInt(surnames.length);
    UUID uuidEmail = UUID.randomUUID();
    UUID uuidPassword = UUID.randomUUID();


    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=authentication&create_account=1");
    }

    @Test
    public void fillForm() {
        WebElement NameInput = driver.findElement(By.cssSelector("#customer-form > section > div:nth-child(3) > div.col-md-6 > input"));
        NameInput.clear();
        NameInput.sendKeys(names[randomName]);
        NameInput.submit();

        WebElement SurnameInput = driver.findElement(By.cssSelector("#customer-form > section > div:nth-child(4) > div.col-md-6 > input"));
        SurnameInput.clear();
        SurnameInput.sendKeys(surnames[randomSurname]);
        SurnameInput.submit();

        WebElement emailInput = driver.findElement(By.cssSelector("#customer-form > section > div:nth-child(5) > div.col-md-6 > input"));
        emailInput.clear();
        emailInput.sendKeys(uuidEmail + "@email.com");
        emailInput.submit();

        WebElement passwordInput = driver.findElement(By.cssSelector("#customer-form > section > div:nth-child(6) > div.col-md-6 > div > input"));
        passwordInput.clear();
        passwordInput.sendKeys(String.valueOf(uuidPassword));
        passwordInput.submit();

    }

    @After
    public void tearDown(){
//        driver.quit();
    }
}
