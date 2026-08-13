import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ValidCredsLogin {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/locatorspractice/");

        driver.findElement(By.id("inputUsername")).sendKeys("aman");
        driver.findElement(By.name("inputPassword")).sendKeys("rahulshettyacademy");

        driver.findElement(By.cssSelector("div.checkbox-container #chkboxTwo")).click();
        driver.findElement(By.xpath("//button[@class='submit signInBtn']")).click();

        //Partial matching using className
        //driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
        //driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[@class='reset-pwd-btn']"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement tag = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("p")));

        String successFullLoginText = tag.getText();;
        Assert.assertEquals(successFullLoginText, "You are successfully logged in.","Not logged in succesfully");
    }
}
