import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Login {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.id("inputUsername")).sendKeys("rahul");
        driver.findElement(By.name("inputPassword")).sendKeys("rahul");

        driver.findElement(By.className("signInBtn")).click();
        System.out.println(driver.findElement(By.cssSelector("p.error")).getText());

        driver.findElement(By.linkText("Forgot your password?")).click();

        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("John");
        driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("john.telekom.com");

        driver.findElement(By.cssSelector("input[placeholder='Email']")).clear();
        driver.findElement(By.xpath("//input[@type='text'][2]")).sendKeys("aman.bhardwaj@telekom.com");

//        driver.findElement(By.xpath("input[type='text']:nth-child(4)")).clear();
//        driver.findElement(By.xpath("input[type='text']:nth-child(4)")).sendKeys("Stones");
        //driver.quit();

        //Parent-child - XPath
        driver.findElement(By.xpath("//form/input[3]")).sendKeys("873333");

//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement reset = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.cssSelector("button.reset-pwd-btn")
                )
        );
        reset.click();


//        WebElement button = driver.findElement(By.cssSelector("button.reset-pwd-btn"));
//        System.out.println(button.isDisplayed());
//        System.out.println(button.isEnabled());

        //Parent-child - CSS
        System.out.println(driver.findElement(By.cssSelector("form p")).getText());

    }

}
