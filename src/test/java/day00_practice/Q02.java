package day00_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class Q02 {
      /*
...Exercise2...

   Ayrica Relative Locator kullanarak;


*/
  static  WebDriver driver;
    @BeforeClass
    public static void set_up(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Before
    public void testtenOnce(){

    }
    @Test
    public void titleTest(){
        //http://www.bestbuy.com 'a gidin,
        driver.get("http://www.bestbuy.com");
        //   Sayfa basliginin "Best" icerdigini(contains) dogrulayin
        String actualTitle=driver.getTitle();
        String arananKelime="Best";
        Assert.assertTrue("Title Best kelimesini icermiyor",actualTitle.contains(arananKelime));
    }

    @Test
    public void logoTest(){
      //  logoTest => BestBuy logosunun gorunutulenip goruntulenmedigini dogrulayin
        WebElement helloWebElementi=driver.findElement(By.xpath("//div[text()='Hello!']"));
        boolean goruntuleniyorMu=driver.findElement(RelativeLocator.with(By.tagName("img")).above(helloWebElementi)).isDisplayed();
    Assert.assertTrue(goruntuleniyorMu);
    }

    @Test
    public void linkTest(){
        //mexicoLinkTest => Linkin gorunutulenip goruntulenmedigini dogrulayin
        WebElement usaWebElementi=driver.findElement(By.xpath("//img[@alt='United States']"));
        boolean goruntuleniyorMu=driver.findElement(RelativeLocator.with(By.tagName("img")).toRightOf(usaWebElementi)).isDisplayed();
    Assert.assertTrue(goruntuleniyorMu);
    }

    @AfterClass
    public static void kapat(){
        driver.close();
    }
}
