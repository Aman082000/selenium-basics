import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.security.Key;

public class PerformAdvancedActions {
    static WebDriver driver = new ChromeDriver();

//    @BeforeTest
//    public static void beforeMethod{
//    }

    public static void actions(){

        Actions actions = new Actions(driver);

        //Mouse Hover
        // <div class="products">
        //   <a href="#">Laptops</a>
        //   <a href="#">Mobiles</a>
        //   <a href="#">Accessories</a>
        //</div>
        WebElement productElement = driver.findElement(By.className("products"));
        WebElement laptop = driver.findElement(By.className("laptop"));

        actions.moveToElement(productElement, 10, 20)
                .click(laptop)
                .perform();

        //Assignment
        //<div id="menu">
        //    Products
        //
        //    <div id="submenu">
        //        <a id="laptop">Laptop</a>
        //        <a id="mobile">Mobile</a>
        //        <a id="tablet">Tablet</a>
        //    </div>
        //</div>

        WebElement productEl = driver.findElement(By.id("menu"));
        WebElement laptopEl = driver.findElement(By.id("laptopEl"));
        actions.moveToElement(productEl)
                .click(laptopEl)
                .perform();
        System.out.println("Laptop clicked");


        //Drag and drop
        WebElement source = driver.findElement(By.id("source"));
        WebElement target = driver.findElement(By.id("target"));

        actions.dragAndDrop(source, target)
                .perform();

        //alt
        actions.clickAndHold(source)
                .moveToElement(target)
                .release()
                .perform();

        //using coordinates
        actions.clickAndHold(source)
                .moveByOffset(100,50)
                .release()
                .perform();

        //specific amount
        actions.moveToElement(source)
                .clickAndHold()
                .moveByOffset(100,200)
                .release()
                .perform();

        //<div id="product">Laptop</div>
        //<div id="cart">Shopping Cart</div>
        WebElement product = driver.findElement(By.id("product"));
        WebElement cart = driver.findElement(By.id("cart"));
        actions.dragAndDrop(product, cart)
                .perform();

        actions.clickAndHold(product)
                .moveToElement(cart)
                .release()
                .perform();


        //Assignment
        WebDriver driver2 = new ChromeDriver();
        driver2.get("drag_and_drop_demo_page");

        WebElement source2 = driver2.findElement(By.id("source"));
        WebElement target2 = driver2.findElement(By.id("target"));

        Actions actions2 = new Actions(driver2);

        actions2.dragAndDrop(source2, target2)
                .perform();

        WebElement result = driver2.findElement(By.id("target2"));
        Assert.assertTrue(result.isDisplayed(),"Target not dragged successfully.");

        actions2.clickAndHold(source2)
                .moveToElement(target2)
                .release()
                .perform();
        Assert.assertTrue(result.isDisplayed(),"Target not dragged successfully.");
        driver2.quit();

    }

    public static void doubleClickContextClick(){
        WebElement button = driver.findElement(By.id("button"));
        Actions actions = new Actions(driver);
        actions.doubleClick(button)
                .perform();

        actions.moveToElement(button)
                .doubleClick(button)
                .perform();

        actions.moveToElement(button)
                .click()
                .click()
                .perform();

        //Assignment
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("doubleClick_demo_page");

        WebElement buttonElement = webDriver.findElement(By.id("buttonElement"));

        Actions actions1 = new Actions(webDriver);
        actions1.doubleClick(buttonElement)
                .perform();

        WebElement verify = webDriver.findElement(By.id("verify"));
        Assert.assertEquals(verify.getText(), "Double click","Double click wasn't successful");
        Assert.assertTrue(verify.isDisplayed(), "Double click wasn't successful");

        //Context click
        actions.contextClick(
                webDriver.findElement(By.id("context"))
        ).perform();

        webDriver.quit();




    }

    public static void keyboardActions(){
        WebElement username = driver.findElement(By.id("username"));

        Actions action = new Actions(driver);
        action.click(username)
                .sendKeys("aman")
                .sendKeys(Keys.TAB)
                .sendKeys("password")
                .sendKeys(Keys.ENTER)
                .perform();


        //Assignment
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("keyboard_action_demo_page_url");

        WebElement textbox = webDriver.findElement(By.id("username"));
        Actions action1 = new Actions(webDriver);

        action1.click(textbox)
                .sendKeys("Selenium")
                .keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .sendKeys(Keys.BACK_SPACE)
                .sendKeys("Actions API")
                .sendKeys(Keys.ENTER)
                .perform();

        Assert.assertEquals(textbox.getAttribute("value"), "Actions API", "Failed to enter keyboard values");
        webDriver.quit();
    }

    public static void navigation(){
        driver.get("url1");
        driver.navigate().to("url2");

        driver.navigate().back();
        Assert.assertEquals(driver.getCurrentUrl(), "url1", "Url isn't right");

        driver.navigate().forward();
        Assert.assertEquals(driver.getCurrentUrl(), "url2", "Url isn't right");

        driver.navigate().refresh();
        Assert.assertEquals(driver.getCurrentUrl(), "url2", "Url isn't right");

        driver.quit();
    }

}
