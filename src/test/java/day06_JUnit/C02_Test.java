package day06_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Test {
    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //1. “https://www.saucedemo.com” Adresine gidin
        driver.get("https://www.saucedemo.com");
        //2. Username kutusuna “standard_user” yazdirin
        WebElement usernameKutusu=driver.findElement(By.xpath("//input[@id='user-name']"));
        usernameKutusu.sendKeys("standard_user");
        //3. Password kutusuna “secret_sauce” yazdirin
        WebElement passwordKutusu=driver.findElement(By.xpath("//input[@id='password']"));
        passwordKutusu.sendKeys("secret_sauce");
        //4. Login tusuna basin
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
        //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        WebElement ilkUrunElementi=driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]"));
        String ilkUrunIsmi=ilkUrunElementi.getText();
        //6. Add to Cart butonuna basin
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        //7. Alisveris sepetine tiklayin
        driver.findElement(By.id("shopping_cart_container")).click();
        //8. Sectiginiz urunun basarili olarak sepete eklendigini kontrol edin
        WebElement sepettekiUrunismiElementi=driver.findElement(By.xpath("//div[@class='inventory_item_name']"));
        String sepettekiIrunismi=sepettekiUrunismiElementi.getText();
        if(sepettekiIrunismi.equals(ilkUrunIsmi)){
            System.out.println("Alis veris Testi PASSED");
        }else{
            System.out.println("Alis veris Testi FAILED");
        }
        //9. Sayfayi kapatin
        driver.close();
    }
}
