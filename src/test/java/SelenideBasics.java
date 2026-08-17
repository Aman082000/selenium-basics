import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.*;

public class SelenideBasics {
    static WebDriver driver = new ChromeDriver();

    public static void main(String[] args) {

    }

    public static void basics(){
        open("url");
        closeWebDriver();

        SelenideElement username = $("#username");


        //driver.findElement(By.id("username"))
        //      .sendKeys("admin");
        //
        //driver.findElement(By.id("password"))
        //      .sendKeys("password123");
        //
        //driver.findElement(By.id("login"))
        //      .click();

        $("#username").setValue("admin");

        $("#password").setValue("password123");

        $("#login").click();

        //List<WebElement> fruits = driver.findElements(By.tagName("li"));
        ElementsCollection ec = $$("li");

        //<button class="menu">Home</button>
        //<button class="menu">Products</button>
        //<button class="menu">About</button>
        //<button class="menu">Contact</button>

        //Selenium
        List<WebElement> buttons = driver.findElements(By.className("menu"));

        //Selenide
        ElementsCollection button = $$(".menu");
        button.shouldHave(size(4));

        button.get(0).click();

        //<ul>
        //    <li>Apple</li>
        //    <li>Orange</li>
        //    <li>Banana</li>
        //</ul>

        List<WebElement> lists = driver.findElements(By.tagName("li"));
        for(WebElement list : lists){
            System.out.println(list.getText());
        }

        ElementsCollection collection = $$("li");
        for(SelenideElement se : collection){
            System.out.println(se.getText());
        }


    }

    public static void basicsAssignment(){
        //Open https://example.com
        //Find the username field using $()
        //Enter "admin"
        //Find the password field using $()
        //Enter "admin123"
        //Find all buttons using $$()
        //Print the number of buttons
        //Click the first button

        //Selenium
        driver.get("https://example.com");
        driver.findElement(By.id("username"))
                .sendKeys("admin");
        driver.findElement(By.id("password"))
                .sendKeys("admin123");

        List<WebElement> buttons = driver.findElements(By.className("button"));
        System.out.println(buttons.size());

        buttons.getFirst().click();

        //Selenide
        open("https://example.com");

        $("#username").setValue("admin");
        $("#password").setValue("admin123");

        ElementsCollection buttons1 = $$(".button");
        System.out.println(buttons1.size());

        buttons1.get(0).click();

    }

}
