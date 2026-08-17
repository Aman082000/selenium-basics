import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
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

    public static void locators(){
        //CSS Locators
        //<input id="username" class="input-field">

        //Selenium
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.className("input-field")).sendKeys("admin");

        //Selenide
        $("#username").setValue("admin");
        $(".input-field").setValue("admin");

        //XPath + text locator
        //<button class="login-button">Login</button>

        //Selenium
        driver.findElement(By.xpath("//button[@class='login-button']"))
                .click();


        //Selenide
        $x("//button[@class='login-button']").click();
        $(byText("Login")).click();


        //Assignment
        //<div class="login-form">
        //    <input id="username" name="username">
        //    <input id="password" name="password">
        //    <button class="login-button">Login</button>
        //    <button class="register-button">Register</button>
        //</div>

        $("input#username").setValue("admin");
        $("input#password").setValue("password");
        $(byText("Login")).click();

        $x("//button[@class='register-button']").click();

        ElementsCollection buttons = $$("button");
        for(SelenideElement button : buttons){
            button.click();
        }

    }

    public static void elementActions(){
        //<input id="username">
        //<input id="search">
        //<button id="login">Login</button>

        //Selenium
        driver.findElement(By.id("username")).sendKeys("admin");

        driver.findElement(By.id("search")).clear();
        driver.findElement(By.id("search")).sendKeys("laptop");

        driver.findElement(By.xpath("//button[text()='Login']")).click();

        //Selenide
        $("#username").setValue("admin");

        $("#search").clear();
        $("#search").setValue("laptop");

        $x("//button[text()='Login']").click();

        String message = $("#message").getText();
        String username = $("#username").getValue();

        //<input id="search">
        //<div id="menu">Menu</div>
        //<button id="submit">Submit</button>

        $("#search").setValue("laptop");
        $("#search").pressEnter();

        $x("//div[@id='menu']").hover();
        $("#submit").scrollTo();

        //Assignment
        //<input id="username" value="">
        //<input id="search" value="">
        //<button id="login">Login</button>
        //<div id="menu">Products</div>
        //<p id="message">Welcome Admin</p>
        //<button id="submit">Submit</button>

        //Selenide
        $("#username").setValue("admin");
        $("#search").setValue("laptop");
        $("#search").clear();

        $x("//input[@id='search']").setValue("mobile");
        $("#search").pressEnter();

        $x("//div[@id='menu']").hover();

        System.out.println($x("//p[@id='message']").getText());
        System.out.println($x("//input[@id='search']").getValue());

        $("#submit").scrollTo();
        $x("//button[@id='login']").click();
    }

    public static void conditions(){
        //<button id="login">Login</button>
        //<input id="username" value="admin">

        $("#login").shouldBe(exist);
        $x("//button[@id='login']").shouldBe(visible);
        $x("//button[text()='Login']").shouldBe(enabled);

        //<input id="username" value="admin">
        //<p id="message">Login successful</p>

        $("#message").shouldHave(text("Login successful"));
        $("#username").shouldHave(value("admin"));

        $("#login").shouldNotBe(visible);
        $("#message").shouldNotHave(text("Login Failed"));

        //Assignment
        //<button id="login">Login</button>
        //<input id="username" value="admin">
        //<p id="message">Login successful</p>
        //<div id="error" style="display:none;">
        //    Login failed
        //</div>

        $("#login").shouldBe(visible);
        $("#login").shouldBe(enabled);
        $("#login").shouldBe(exist);

        $("#username").shouldHave(value("admin"));
        $("#message").shouldHave(text("Login successful"));

        $("#error").shouldNotHave(text("Login failed"));
        $("#error").shouldNotBe(visible);

    }


}
