package testHerokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import utils.ScreenshotUtil;

@Listeners(utils.ScreenshotListener.class)
public class testmainpage {

    public WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\selenium webdriver\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
    }

    @Test(priority = 1)
    public void verifyHomePageTitle() {
        System.out.println(driver.getTitle());
    }
    
    // Test Failed case
  //   @Test(priority = 1) 
 //   public void verifyHomePageTitle() {
 //       driver.findElement(By.id("non-existing-id"));
 //   }

    @Test(priority = 2)
    public void verifyABTestingLink() {
        driver.findElement(By.linkText("A/B Testing")).click();

        // Take screenshot after clicking link
        ScreenshotUtil.takeScreenshot(driver, "ABTesting_Clicked");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
        
        driver.navigate().back();

        // Take screenshot after navigating back
        ScreenshotUtil.takeScreenshot(driver, "ABTesting_BackToHome");

        System.out.println("✅ A/B Testing link works and returned to home page");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();   // browser closes ONLY at the end
    }
}