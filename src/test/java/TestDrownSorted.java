import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import java.time.Duration;

public class TestDrownSorted {

    WebDriver driver;


    @BeforeTest
    public void OpenBrowser(){

        System.setProperty("webdriver.chrome.driver","/home/mint/COSAS MIAS/JAVA/drivers/chromedriver-linux64/chromedriver");
        driver=new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void TestDrown1() throws InterruptedException {
        driver.get("https://twoplugs.com/");
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//a[contains(text(),'Live Posting')]")));

        driver.findElement(By.xpath("//a[contains(text(),'Live Posting')]")).click();

        Select selectList=new Select(driver.findElement(By.name("category_id")));

        List<WebElement> options= selectList.getOptions();

        System.out.println("la lista tiene" + options.size() + "elementos");

        ArrayList listOriginal=new ArrayList();
        ArrayList listTemporal=new ArrayList();

        for (WebElement option: options){

              if(!option.getText().equals("All")) {
                  listOriginal.add(option.getText());
                  listTemporal.add(option.getText());
              }
        }
//metodo que me organiza una lista por el orden alfabetico
        Collections.sort(listTemporal);
        System.out.println("lista Orignal"  +  listOriginal);
        System.out.println("lista Temporal"  +  listOriginal);

        Assert.assertEquals(listOriginal,listTemporal);

       System.out.println("The list is sort");

    }

    @AfterTest
    public void TheardDown(){
     //   driver.quit();
    }
}
