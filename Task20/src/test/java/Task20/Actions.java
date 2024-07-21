package Task20;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Actions {

	public static void main(String[] args) throws Exception {
		// Task-20 Q.1
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://jqueryui.com/datepicker/");
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		
		driver.findElement(By.id("datepicker")).click();
		
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		
		driver.findElement(By.xpath("//a[text()='22']")).click();
		
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		File destinationFile = new File("./scrrenshot/img.png");
		
		FileHandler.copy(screenshot, destinationFile);
		
		Thread.sleep(300);
		
		WebElement element1 = driver.findElement(By.id("datepicker"));
		
		String date = element1.getAttribute("value");
		
		Thread.sleep(300);
		
		System.out.println("Selected date is: " + date);
		
		driver.quit();

	}

}
