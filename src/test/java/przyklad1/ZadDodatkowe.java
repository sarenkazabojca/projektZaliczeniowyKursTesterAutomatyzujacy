package przyklad1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Random;

public class ZadDodatkowe {

    String[] products = {"mug", "t-shirt", "notebook", "sweater", "cushion", "graphics",  "poster"};
    Random random = new Random();
    int randomInteger = random.nextInt(products.length);

    private WebDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(" https://prod-kurs.coderslab.pl");
    }

    @Test
    public void searchProductRandom(){
        WebElement element = driver.findElement(By.name("s"));
        element.clear();
        element.sendKeys(products[randomInteger]);
        element.submit();
    }

    @After
    public void tearDown(){
        driver.quit();
    }


}
