package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver=driver;
    }
    private By usernameField= By.id("user-name");
    private By passwordField=By.id("password");
    private By loginButton=By.id("login-button");

    public void setUsernameField(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }
    public void setPasswordField(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    public HomePage clickLoginButton(){
        driver.findElement(loginButton).click();
        return new HomePage(driver);
    }
}
