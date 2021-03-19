package zadaniaZaliczeniowe;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class testBase {

    protected WebDriver driver;

       public void before(){
        //włączenie przeglądarki
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        //maksymalizacja okna przeglądarki
        driver.manage().window().maximize();
        //otwarcie strony logowania
        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=authentication&back=my-account");
    }

    public void after(){
//        Zamknięcie przeglądarki
        driver.quit();
    }
}
