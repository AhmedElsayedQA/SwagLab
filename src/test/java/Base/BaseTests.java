package Base;

import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class BaseTests {
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected HomePage homePage;

    @BeforeClass
    public void setUp(){
        driver=new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.navigate().to("https://www.saucedemo.com/");
        loginPage=new LoginPage(driver);




    }

    @AfterClass
    public void tearDown(){
       driver.quit();
    }

}
