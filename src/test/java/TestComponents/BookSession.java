package TestComponents;
import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class BookSession {
	@Test
	public void Book() {
		//aa
		ChromeOptions o = new ChromeOptions();
		o.addArguments("headless");
		WebDriver driver = new ChromeDriver(o);
		driver.manage().window().setSize(new Dimension(1440,900));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Actions a = new Actions(driver);
		driver.manage().window().maximize();
		driver.get("https://www.tutoruu.com/");
		driver.findElement(By.cssSelector("a[href=\"/tutors\"] p")).click();
		driver.findElements(By.cssSelector("a.bg-primary-500")).get(0).click();
		driver.findElement(By.cssSelector("input[id=\"name\"]")).sendKeys("test");
		driver.findElement(By.cssSelector("input[id=\"email\"]")).sendKeys("test@test.com");
		driver.findElement(By.cssSelector("input[id=\"phone\"]")).sendKeys("123123123213123");
		driver.findElements(By.cssSelector("button.text-gray-900 span.icon")).get(1).click();
		driver.findElement(By.cssSelector("div.cursor-pointer")).click();
		a.scrollToElement(driver.findElement(By.cssSelector("button[value=\"0\"]"))).build().perform();
		driver.findElement(By.cssSelector("button[value=\"0\"]")).click();
		a.scrollToElement(driver.findElement(By.xpath("(//div[@class='flex flex-wrap items-center'])[8]/button"))).build().perform();
		driver.findElement(By.xpath("(//div[@class='flex flex-wrap items-center'])[8]/button")).click();
		a.scrollToElement(driver.findElement(By.tagName("textarea"))).build().perform();
		driver.findElement(By.tagName("textarea")).sendKeys("this is an automation test booking");
		driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
		if(driver.findElement(By.cssSelector("div.json-formatter-container")).isDisplayed()) {
			System.out.println("Navigated to Payment test successfully");
			driver.quit();
		}else {
			Assert.assertTrue(false);
		}
		
	}
	
}
