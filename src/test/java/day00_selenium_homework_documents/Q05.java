package day00_selenium_homework_documents;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Q05 {
   static WebDriver driver;


        ////● https://www.amazon.com/ adresine gidin.
        ////            - Test 1
        ////    Arama kutusunun yanindaki kategori menusundeki kategori
        ////    sayisinin 45 oldugunu test edin
    @Test
   public void test01(){

    List<WebElement> kategoriMenusuListesi=driver.findElements(By.tagName("option"));
    if(kategoriMenusuListesi.size()==45){
        System.out.println("Kategori menusu listesi testi PASSED");
    } else{
        System.out.println("Kategori menusu listesi testi FAILED\n" +kategoriMenusuListesi.size());
    }
   }
    ////-Test 2
    ////1. Kategori menusunden Books secenegini secin
    ////2. Arama kutusuna Java yazin ve aratin
    ////3. Bulunan sonuc sayisini yazdirin
    ////4. Sonucun Java kelimesini icerdigini test edin
    @Test
   public void test02(){
    driver.findElement(By.xpath("(//option)[6]")).click();
    WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
    aramaKutusu.sendKeys("java"+ Keys.ENTER);
    WebElement javaAramaSonucu=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));

       System.out.println(javaAramaSonucu.getText().contains("java") ? "Arama Sonucu Java iceriyor testi PASSED" :
               "Arama Sonucu Java iceriyor testi FAILED\n" +javaAramaSonucu.getText());


   }




    @BeforeClass
    public static void ayarlar(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com");
    }

    @AfterClass
    public static void kapat(){
        driver.close();
    }

}
