package TestComponents;
import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class NavigateToApp {
		@Test
		public void navigate() {
			// TODO Auto-generated method stub
			ChromeOptions o = new ChromeOptions();
			o.addArguments("headless");
			WebDriver driver = new ChromeDriver(o);
			driver.manage().window().setSize(new Dimension(1440,900));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.manage().window().maximize();
			driver.get("https://www.tutoruu.com/");
			driver.findElement(By.cssSelector("button[text=\"Download the App now\"]")).click();
			if (driver.findElement(By.xpath("(//img[@alt='logo'])[3]")).isDisplayed() == true) {
				System.out.println("qr code appears");
				driver.quit();
			} else
			{
				System.out.println("qr code didn't appear");
				Assert.assertTrue(false);
			}
		}
		
		
	

}
