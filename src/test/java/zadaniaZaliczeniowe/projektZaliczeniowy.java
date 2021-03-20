package zadaniaZaliczeniowe;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import pageObjectPattern.pages.HomePage;
import pageObjectPattern.pages.LoginPage;
import pageObjectPattern.pages.createNewAddressPage;

public class projektZaliczeniowy{

    private static WebDriver driver;

    @Given("user is on login page")
    public void openLogInPage(){
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        //maksymalizacja okna przeglądarki
        driver.manage().window().maximize();
        //otwarcie strony logowania
        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=authentication&back=my-account");
    }

    @When("^user makes proper login$")
    public void userInputLogInData() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("MarcelinaSokolowska@jourrapide.com", "aeC9Oich1ee");
        Assert.assertEquals("Marcelina Sokołowska", loginPage.getLoggedUsername());
    }

    @When("^user clicks 'Addresses' tile$")
    public void userClicksAddressesTile() {
        WebElement addresses = driver.findElement(By.id("addresses-link"));
        addresses.click();
    }

    @When("^user clicks '\\+Create new address' button$")
    public void userClicksCreateNewAddressButton() {
        WebElement createNewAddress = driver.findElement(By.cssSelector("#content > div.addresses-footer > a "));
        createNewAddress.click();
    }


    @When("user inputs (.*), (.*), (.*), (.*), (.*) to address form")
    public void userInputsProperAddressData(String address, String city, String postalCode, String country,  String phone){
        createNewAddressPage newAddress = new createNewAddressPage(driver);
        newAddress.createNewAddress(address, city, postalCode, country, phone);
    }

    @When("^user clicks 'Save' button$")
    public void userClicksSaveButton() {
        WebElement saveAddressForm = driver.findElement(By.cssSelector(".address-form button[type=submit]"));
        saveAddressForm.click();
    }

//  Sprawdzenie czy dodanie adresu się powiodło
    @Then("^user added a new proper address$")
    public void userHasAddedANewAddress() {
        createNewAddressPage addressPage = new createNewAddressPage(driver);
        Assert.assertEquals("Address successfully added!", addressPage.getSuccessfulMessage());
    }

//Zad2||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||

    @When("^user search in catalog 'Hummingbird Printed Sweater'$")
    public void userSearchProductInCatalog() {
        HomePage homePage = new HomePage(driver);
        homePage.searchOurCatalog("Hummingbird Printed Sweater");
    }

    @When("^user choose 'Hummingbird Printed Sweater' in search result$")
    public void userChooseProductInSearchResult() {
        WebElement chooseProduct = driver.findElement(By.xpath("//*[text()='Hummingbird printed sweater']"));
        chooseProduct.click();
    }

    @When("^user choose size 'M'$")
    public void userChooseSizeM() {
        WebElement productSize = driver.findElement(By.cssSelector("#group_1 > option:nth-child(2)"));
        productSize.click();
    }

    @When("^user set the quantity to (\\d+)$")
    public void userSetTheQuantityTo(String arg0) {
        WebElement quantity = driver.findElement(By.cssSelector("#quantity_wanted"));
        quantity.clear();
        quantity.sendKeys(arg0);
    }

    @When("^user add product to cart$")
    public void userAddProductToCart() {
        WebElement addToCart = driver.findElement(By.cssSelector("button.add-to-cart"));
        addToCart.click();
    }

    @When("^user click 'Proceed to checkout' in dialog window$")
    public void userClickProceedToCheckoutInDialogWindow() {
//      czekamy maksymalnie do 5 sekund, aż pojawi się element i kilkamy w niego
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".cart-content a.btn"))).click();
    }

    @When("^user click 'Proceed to checkout' in cart$")
    public void userClickProceedToCheckoutInCart() {
        WebElement proceedToCheckout = driver.findElement(By.cssSelector(".cart-summary a.btn"));
        proceedToCheckout.click();
    }

    @When("^user click 'Continue' on address page$")
    public void userClickContinueOnAddressPage() {
        WebElement continueAddress = driver.findElement(By.name("confirm-addresses"));
        continueAddress.click();
    }

    @When("^user click 'Continue' on shipping method page$")
    public void userClickContinueOnShippingMethodPage() {
        WebElement continueShipping = driver.findElement(By.name("confirmDeliveryOption"));
        continueShipping.click();

    }

    @When("^user choose 'Pay by Check' option$")
    public void userChoosePayByCheckOption() {
        WebElement choosePaymentOption = driver.findElement(By.id("payment-option-1"));
        choosePaymentOption.click();
    }

    @When("^user click checkbox with terms of service$")
    public void userClickCheckboxWithTermsOfService() {
        WebElement checkboxTermsOfService = driver.findElement(By.id("conditions_to_approve[terms-and-conditions]"));
        checkboxTermsOfService.click();
    }

    @When("^user submit on payment page$")
    public void userSubmitOnPaymentPage() {
        WebElement paymentSubmit = driver.findElement(By.cssSelector("#payment-confirmation button[type=submit]"));
        paymentSubmit.click();
    }

    @When("^user make screenshot with order details$")
    public void userMakeScreenshotWithOrderDetails() throws IOException {
        WebElement orderDetailsScreenshot = driver.findElement(By.id("content"));
        File source = orderDetailsScreenshot.getScreenshotAs(OutputType.FILE);
        String path = "./target/screenshots/" + source.getName();
        FileUtils.copyFile(source, new File(path));
    }

    @Then("^user made proper order$")
    public void userMadeProperOrder() {
//        Jak to zrobić?????? 
    }

    @And("^close browser$")
    public void closeBrowser() {
        driver.quit();
    }
}



//    @Before
//    public void setUp(){
//        before();
//        driver = super.driver;
//    }
//
//    @Test
//    public void login(){
//
//        WebElement email = driver.findElement(By.name("email"));
//        email.clear();
//        email.sendKeys("MarcelinaSokolowska@jourrapide.com");
//
//        WebElement password = driver.findElement(By.name("password"));
//        password.clear();
//        password.sendKeys("aeC9Oich1ee");
//
//        WebElement signIn = driver.findElement(By.cssSelector("#submit-login"));
//        signIn.click();
//
////      Sprawdzenie który przycisk jest dostępny "Add first Address" czy "Adresses", a następnie kliknięcie w niego
//        WebElement addFirstAddress = null;
//        WebElement addresses;
//        WebElement createNewAddress;
//
//        try {
//            addFirstAddress = driver.findElement(By.cssSelector("#address-link > span"));
//        } catch (Exception e) {
//        }
//
//        if (addFirstAddress == null){
//            System.out.println("Stary");
//            addresses = driver.findElement(By.cssSelector("#addresses-link > span"));
//            addresses.click();
//            createNewAddress = driver.findElement(By.cssSelector("#content > div.addresses-footer > a > span"));
//            createNewAddress.click();
//        } else {
//            System.out.println("Nowy użytkownik");
//            addFirstAddress.click();
//
//
//        }
//    }
//
//
//
//    @After
//    public void tearDown(){
//        after();
//    }
//}
