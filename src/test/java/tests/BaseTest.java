package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.Links;

public class BaseTest {
WebDriver driver;
    
    @BeforeMethod
    public void setUp() {
    	WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(Links.URL_INDEX);
		driver.findElement(By.cssSelector("a[href$='task=user']")).click();
    }
    
    @AfterMethod
	public void tearDown() {
		driver.quit();
	} 
}
