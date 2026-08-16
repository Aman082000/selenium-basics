import Utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPageUsingWaits {
    private final WaitUtils waitUtils = new WaitUtils();

    private final By username = By.id("username");
    private final By password = By.id("password");
    private final By loginButton = By.id("login");

    public void enterUsername(String name){
        WebElement usernameElement = waitUtils.visibleText(username);
        usernameElement.sendKeys(name);
    }

    public void enterPassword(String passwordValue){
        WebElement passwordElement = waitUtils.visibleText(password);
        passwordElement.sendKeys(passwordValue);
    }

    public void clickLogin(){
        WebElement loginElement = waitUtils.elementClickable(loginButton);
        loginElement.click();
    }

}
