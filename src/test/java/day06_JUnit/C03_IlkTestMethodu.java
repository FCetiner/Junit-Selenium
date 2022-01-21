package day06_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_IlkTestMethodu {
    WebDriver driver;

    @Test
    public void test01(){
        driver.get("https://www.amazon.com");
        String actualTitle=driver.getTitle();
        String arananKelime="amazon";
        if(actualTitle.contains(arananKelime)){
            System.out.println("amazon testi PASSED");
        }else{
            System.out.println("amazon testi FAILED");
        }
        // amazon.com gidelim ve title in amazon icerdigini test edelim

    }
    @Test
    public void test02(){
        driver.get("https://www.google.com/");
        //google a gidelim ve baslıgın google icerdigini test edelim
        String actualSayfatitle=driver.getTitle();
        String arananKelime="Google";
        if(actualSayfatitle.contains(arananKelime)){
            System.out.println("google testi PASSED");
        }else{
            System.out.println("google testi FAILED");
        }


    }
    @Before
    public void ayarlariDuzenle(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void ortaligiTopla(){
        driver.close();
    }
}
