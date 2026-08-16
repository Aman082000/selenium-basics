import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

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
}
