package day00_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Q03 {

    /*
     ...Exercise3...
    // http://the-internet.herokuapp.com/add_remove_elements/
    // click on the "Add Element" button 100 times
    // write a function that takes a number, and clicks the "Delete" button
    // given number of times, and then validates that given number of
    // buttons was deleted
 */
    public static void main(String[] args) {
        //Before method yerine bu yontemle basladik
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");


        createButtons(driver,100);
        deleteButtonsAndValidate(driver,60);
    }

    private static void createButtons(WebDriver driver, int eklenecekSayi) {
        WebElement addButton=driver.findElement(By.xpath("//*[@onclick='addElement()']"));
    for(int j=0;j<eklenecekSayi; j++){
        addButton.click();
    }


    }


    private static void deleteButtonsAndValidate(WebDriver driver, int number) {

        List<WebElement> elements=driver.findElements(By.cssSelector("[onclick='deleteElement()']"));
        int sizeBeforeDelete=elements.size();

        List<WebElement> buttonsDelete=driver.findElements(By.cssSelector("[onclick='deleteElement()']"));
        int sayac=0;

        for(WebElement w: buttonsDelete){
            sayac++;
            if(sayac>number){
                break;
            }
            w.click();
        }

        List<WebElement> elementsAfter=driver.findElements(By.cssSelector("[onclick='deleteElement()']"));
        int sizeAfterDelete=elementsAfter.size();



        if((sizeBeforeDelete-number)==sizeAfterDelete){
            System.out.println("sizeAfterDelete = " + sizeAfterDelete);
            System.out.println("SUCCESS");
        }else
            System.out.println("Fail");

    }




}
