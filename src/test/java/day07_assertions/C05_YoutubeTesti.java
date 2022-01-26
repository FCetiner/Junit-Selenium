package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_YoutubeTesti {
  static  WebDriver driver;

    @BeforeClass
    public static void setup(){
    WebDriverManager.chromedriver().setup();
    driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    driver.get("https://www.youtube.com");
    }
//2)https://www.youtube.com adresine gidin
//3)Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin

    @Test
    public void titleTesti(){
//titleTest => Sayfa başlığının YouTube ” oldugunu test edin
        String actualTitle=driver.getTitle();
        String arananKelime="YouTube";
        Assert.assertTrue(actualTitle.contains(arananKelime));
    }

    @Test
    public void imageTest(){
//imageTest => YouTube resminin görüntülendiğini isDisplayed()) test edin
        WebElement youtubeResmi=driver.findElement(By.xpath("(//yt-icon[@id='logo-icon'])[2]"));
        Assert.assertTrue(youtubeResmi.isDisplayed());
    }

    @Test
    public void searchBoxTest (){
//Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        WebElement searchBox=driver.findElement(By.xpath("//input[@id='search']"));
        Assert.assertTrue(searchBox.isEnabled());
    }

    @Test
    public void wrongTitleTest (){
//wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
        String actualTitle=driver.getTitle();
        Assert.assertFalse(actualTitle.equals("youtube"));
    }
    @AfterClass
    public static void teardown(){
    driver.close();
    }
}
