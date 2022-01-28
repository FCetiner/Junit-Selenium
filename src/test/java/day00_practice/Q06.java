package day00_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Q06 {
     /*
   ...Exercise6...
// 1. Amazon.com'a gidelim.
// 2. DropDown üzerinde Books secelim.(All yazan yerde)
//    kategorilerin hepsini konsola yazdiralim
// 3. Arama kutusuna Les Miserables yazalım ve arama yapalim.
// 4. Sonuc sayisini ekrana yazdiralim.
// 5. Sonucların Les Miserables i icerdigini assert edelim
*/
     static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void test01(){
        driver.get("https://www.amazon.com");
        WebElement option=driver.findElement(By.id("searchDropdownBox"));
        Select select=new Select(option);
        List<WebElement> optionList=select.getOptions();
        optionList.stream().forEach(t-> System.out.println(t.getText()));
        select.selectByVisibleText("Books");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Les Miserables"+ Keys.ENTER);
        String aramaSonucu=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).getText();
        System.out.println("aramaSonucu = " + aramaSonucu);
        List<WebElement> aramaSonuclariListesi=driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
        String arananKelime="Les";
        for(WebElement each:aramaSonuclariListesi){
            Assert.assertTrue("Arama Sonuclari Les Miserable iceriyor testi FAILED",(each.getText().contains(arananKelime)));
        }
    }

    @AfterClass
    public static void tearDown(){
        driver.close();
    }
}
