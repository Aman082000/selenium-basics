import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class Handling {

    static WebDriver driver = new ChromeDriver();

    public static void dropDowns(){

        //<select id="country">
        //    <option value="india">India</option>
        //    <option value="usa">United States</option>
        //    <option value="uk">United Kingdom</option>
        //    <option value="canada">Canada</option>
        //</select>

        WebElement dropDown = driver.findElement(By.id("country"));
        Select country = new Select(dropDown);

        country.selectByVisibleText("India");
        country.selectByValue("india");
        country.selectByIndex(0);

        //Get first selected option
        WebElement selected = country.getFirstSelectedOption();
        System.out.println(selected.getText());

        //Get all options
        List<WebElement> options = country.getOptions();
        System.out.println(options.size());

        for(WebElement option : options){
            System.out.println(option.getText());
        }

        //<div class="dropdown">
        //    <button id="countryDropdown">Select Country</button>
        //
        //    <div class="dropdown-options">
        //        <div class="option">India</div>
        //        <div class="option">USA</div>
        //        <div class="option">UK</div>
        //    </div>
        //</div>
        driver.findElement(By.id("countryDropdown")).click();

        driver.findElement(
                By.xpath("//div[@class='option' and text()='India']")
        ).click();




    }

    public static void checkBoxes(){

        //<input type="checkbox" id="terms">
        WebElement checkbox = driver.findElement(By.id("terms"));
        if(!checkbox.isSelected()){
            checkbox.click();
        }

        //Get all the checkboxes
        //<input type="checkbox" id="java" name="skill">
        //<label for="java">Java</label>
        //
        //<input type="checkbox" id="selenium" name="skill">
        //<label for="selenium">Selenium</label>
        //
        //<input type="checkbox" id="api" name="skill">
        //<label for="api">API Testing</label>

        List<WebElement> elements = driver.findElements(By.cssSelector("input[type='checkbox'"));
        for(WebElement element : elements){
            if(!element.isSelected()){
                element.click();
            }
        }

        //Practise
        List<WebElement> elements1 = driver.findElements(By.cssSelector("input[type='checkbox']"));
        System.out.println(elements1.size());

        for(WebElement element : elements1){
            System.out.println(element.isSelected());
        }

        WebElement javaElement = driver.findElement(By.xpath("//input[@id='java']"));
        if(!javaElement.isSelected()){
            javaElement.click();
        }

        WebElement seleniumElement = driver.findElement(By.xpath("//input[@id='selenium']"));
        if(!seleniumElement.isSelected()){
            seleniumElement.click();
        }

        WebElement apiElement = driver.findElement(By.xpath("//input[@id='api']"));
        if(apiElement.isSelected()){
            apiElement.click();
        }

        Assert.assertTrue(javaElement.isSelected(),"Java isn't selected");
        Assert.assertTrue(seleniumElement.isSelected(), "Selenium isn't selected");
        Assert.assertFalse(apiElement.isSelected(), "Api is selected");

    }

    public static void radioButton(){
        //<input type="radio" name="gender" id="male" value="male">
        //<label for="male">Male</label>
        //
        //<input type="radio" name="gender" id="female" value="female">
        //<label for="female">Female</label>

        WebElement maleElement = driver.findElement(By.id("male"));
        if(!maleElement.isSelected()){
            maleElement.click();
        }

        Assert.assertTrue(maleElement.isSelected(), "Male radio button isn't selected");

        //Get all radio buttons
        //<input type="radio" name="payment" id="creditCard">
        //<label for="creditCard">Credit Card</label>
        //
        //<input type="radio" name="payment" id="debitCard">
        //<label for="debitCard">Debit Card</label>
        //
        //<input type="radio" name="payment" id="upi">
        //<label for="upi">UPI</label>

        List<WebElement> radioButtons = driver.findElements(By.xpath("//input[@type='radio']"));
        for(WebElement radioButton : radioButtons){
            System.out.println(radioButton.isSelected());
        }
        System.out.println(radioButtons.size());

        //To get text from label
        for(WebElement radioButton : radioButtons){
            String id = radioButton.getAttribute("id");
            WebElement label = driver.findElement(By.cssSelector("label[for=" + id + "]"));
            System.out.println(label.getText());
        }

        //Iterating over elements to select one
        for(WebElement radioButton : radioButtons){
            if(radioButton.getAttribute("value").equals("upi")){
                radioButton.click();
                break;
            }
        }

        //Practise
        //<input type="radio" name="browser" id="chrome" value="chrome">
        //<label for="chrome">Chrome</label>
        //
        //<input type="radio" name="browser" id="firefox" value="firefox">
        //<label for="firefox">Firefox</label>
        //
        //<input type="radio" name="browser" id="edge" value="edge">
        //<label for="edge">Edge</label>

        List<WebElement> radioButtons1 = driver.findElements(By.xpath("//input[@type='radio']"));
        System.out.println(radioButtons1.size());

        for(WebElement radioButton: radioButtons1){
            String value = radioButton.getAttribute("value");
            String text = driver.findElement(By.xpath("//label[@for='" + value + "']")).getText();
            System.out.println(text + ".." + radioButton.isSelected());
        }

        WebElement firefoxRadio = driver.findElement(By.id("firefox"));
        if(!firefoxRadio.isSelected()) {
            firefoxRadio.click();
        }
        Assert.assertTrue(firefoxRadio.isSelected(), "FireFox button isn't selected");

        WebElement edgeRadio = driver.findElement(By.id("edge"));
        Assert.assertFalse(edgeRadio.isSelected(), "Edge shouldn't be selected");

        WebElement chromeRadio = driver.findElement(By.id("chrome"));
        Assert.assertFalse(chromeRadio.isSelected(), "Chrome shouldn't be selected");

    }

    public static void alerts(){

        //Simple message alert
        //<button onclick="alert('Login successful')">
        //    Login
        //</button>

        driver.findElement(By.tagName("button")).click();

        Alert alert = driver.switchTo().alert();
        String message = alert.getText();
        Assert.assertEquals(message, "Login successful", "Invalid alert message");
        alert.accept();

        //Confirmation alert
        //<button onclick="confirm('Are you sure you want to delete?')">
        //    Delete
        //</button>
        driver.findElement(By.tagName("button")).click();
        Alert alert1 = driver.switchTo().alert();
        alert1.accept();

        //Prompt alert
        try{
            driver.findElement(By.tagName("button")).click();
            Alert alert3 =  driver.switchTo().alert();
            alert3.sendKeys("DTDL");
            alert3.accept();
        }catch(Exception e){
            System.out.println("No alert");
        }

        //Practise
        driver.findElement(By.tagName("button")).click();
        Alert alert4 = driver.switchTo().alert();

        Assert.assertEquals(alert4.getText(), "login success", "alert not visible");
        alert.accept();

        driver.findElement(By.tagName("button")).click();
        Alert alert5 = driver.switchTo().alert();
        Assert.assertEquals(alert5.getText(), "Confirmation alert", "No confirmation alert");
        alert5.dismiss();

        driver.findElement(By.className("value")).click();
        //alert8 = driver.switchTo().alert();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Alert alert8 = wait.until(
                ExpectedConditions.alertIsPresent()
        );
        alert8.sendKeys("Aman");
        alert8.accept();

    }


}


