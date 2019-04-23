import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class MyStepdefs {

    private static WebDriver driver;

    @BeforeClass
    private void setUp() {
        String pathToDriver = "/Users/maximbutin/Documents/Study/Testing/BDDSite/chromedriver";
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", pathToDriver);
        options.addArguments("--headless");
        driver = new ChromeDriver();
    }

    @AfterClass
    private void setOff() {
        driver.quit();
    }

    @Given("^I have Web Browser$")
    public void iHaveWebBrowser() {
        setUp();
    }

    @When("^I write url into browser \"([^\"]*)\"$")
    public void iWriteUrlIntoBrowser(String arg0) {
        driver.get(arg0);
    }


    @Then("^I go to local web site and check title \"([^\"]*)\" from url$")
    public void iGoToLocalWebSiteAndCheckTitleFromUrl(String arg0) {
        Assert.assertEquals("http://localhost:8080/", driver.getTitle());
    }
}