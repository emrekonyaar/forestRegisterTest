import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class foreksTest {
    WebDriver driver;
    private By canliBorsa = By.linkText("Yatırım Yap");
    private By girisBtn = By.linkText("Ücretsiz Kayıt Ol");
    private By email = By.id("email");
    private By isim = By.id("name");
    private By soyisim= By.id("surname");
    private By adres = By.id("address");
    private By span = By.cssSelector("input.switch[type=\"checkbox\"] + label span");
    private By telefon = By.id("phone");
    private By selectCountry = By.id("country");
    private By selectCity = By.id("city");
    private By kayitbtn = By.id("submitbtn");
    @BeforeSuite
    public void beforeSuite(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\emrek\\IdeaProjects\\automation_tutorial\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    void tutorial() {

        String baseUrl = "https://www.foreks.com/";
        driver.get(baseUrl);
        driver.findElement(canliBorsa).click();
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
        driver.findElement(girisBtn).click();
        driver.findElement(email).sendKeys("emrekonyar8@gmail.com");
        driver.findElement(isim).sendKeys("emre");
        driver.findElement(soyisim).sendKeys("konyar");
        driver.findElement(adres).sendKeys("Mersin/Mezitli");
        driver.findElement(telefon).sendKeys("5464333008");
        Select selectCoun = new Select(driver.findElement(selectCountry));
        selectCoun.selectByVisibleText("TÜRKIYE");
        Select selectc = new Select(driver.findElement(selectCity));
        selectc.selectByVisibleText("MERSİN");
        driver.findElement(span).click();
        driver.findElement(kayitbtn).click();
    }
     @AfterSuite
   public void afterSuite(){
       driver.quit();
    }
}
