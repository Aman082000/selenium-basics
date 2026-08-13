import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

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

}


