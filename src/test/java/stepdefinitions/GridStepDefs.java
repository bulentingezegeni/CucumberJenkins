package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import utilities.ConfigurationReader;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class GridStepDefs {

    WebDriver driver;

    @Given("user is on the application_url with chrome")
    public void user_is_on_the_application_url_with_chrome() throws MalformedURLException {
//        1. Crete a driver object using RemoteWebDriver
//        URL is coming from the terminal http://192.168.1.116:4444
//        new ChromeOptions() is used for running on chrome driver
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
        driver = new RemoteWebDriver(new URL("http://localhost:4444/"), new ChromeOptions());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get(ConfigurationReader.getProperty("gmi_login_url"));
    }


    @Then("verify the title of the page is GMIBANK")
    public void verify_the_title_of_the_page_is_gmibank() {
        String title = driver.getTitle();
        Assert.assertEquals("GMIBANK",title);
    }


    @Then("close the remote driver")
    public void close_the_remote_driver() {
     //   driver.quit();

    }

    @Given("user is on the application_url with firefox")
    public void user_is_on_the_application_url_with_firefox() throws MalformedURLException {
        driver = new RemoteWebDriver(new URL("http://localhost:4444/"),new FirefoxOptions());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get(ConfigurationReader.getProperty("gmi_login_url"));
    }


}
