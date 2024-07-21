package Task20;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomateSignup {

	public static void main(String[] args) throws Exception {
		
        WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.guvi.in/");
		
		//To register
		driver.findElement(By.linkText("Sign up")).click();
		
		driver.findElement(By.id("name")).sendKeys("Test User");
		
        driver.findElement(By.id("email")).sendKeys("akshayahari10@gmail.com"); // ID locator to locate email field of login page
		
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("12345"); //Locator to locate password field
		                                                            //using single attribute xpath
		Thread.sleep(300);
		
		driver.findElement(By.id("mobileNumber")).sendKeys("8870653089");
		
		driver.findElement(By.xpath("//a[contains(@id,'signup-btn')]")).click();
		
		driver.findElement(By.xpath("//a[@class='login']"));
		
		//To login
		driver.findElement(By.className("login")).click();
		
		driver.findElement(By.id("email")).sendKeys("akshayahari10@gmail.com");
		
		driver.findElement(By.id("password")).sendKeys("Akshaya@28");
		
		Thread.sleep(300);
		
		driver.findElement(By.className("login-btn")).click();
		
		Thread.sleep(500);
		
		File screenshot1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		File destinationFile = new File("./screenshot2/img.png");
		
		FileHandler.copy(screenshot1, destinationFile);
		
		driver.quit();
	}

}
