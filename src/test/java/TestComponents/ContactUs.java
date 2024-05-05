package TestComponents;
import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ContactUs {
	@Test
	public void Contact() {
		ChromeOptions o = new ChromeOptions();
		o.addArguments("headless");
		WebDriver driver = new ChromeDriver(o);
		driver.manage().window().setSize(new Dimension(1440,900));
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		Actions a = new Actions(driver);
		driver.manage().window().maximize();
		driver.get("https://www.tutoruu.com/");
		driver.findElement(By.cssSelector("a[href=\"/contact\"] p")).click();
		driver.findElement(By.cssSelector("input[id=\"name\"]")).sendKeys("test");
		driver.findElement(By.cssSelector("input[id=\"email\"]")).sendKeys("emailtest@test.com");
		driver.findElement(By.cssSelector("input[id=\"phone\"]")).sendKeys("012132156123");
		driver.findElement(By.cssSelector("textarea[id=\"message\"]")).sendKeys("This an automation test for the contact us form");
		a.scrollToElement(driver.findElement(By.cssSelector("button[type=\"submit\"]"))).build().perform();
		driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-title=\"\"]")));
		if (driver.findElement(By.cssSelector("div[data-title=\"\"]")).isDisplayed()) {
			System.out.println("success");
			driver.quit();
		} else {
			Assert.assertTrue(false);
		}
	}
	
}
