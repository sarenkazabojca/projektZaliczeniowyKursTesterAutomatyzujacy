package przyklad1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import java.util.Random;

public class zad1 {


    private WebDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.bing.com/");
    }


    @Test
    public void searchGivenPhase(){
        WebElement element = driver.findElement(By.name("q"));
        element.clear();
        element.sendKeys("Mistrzostwa Świata w piłce nożnej 2018");
        element.submit();
    }

    @After
    public void tearDown(){
        driver.quit();
    }

}
