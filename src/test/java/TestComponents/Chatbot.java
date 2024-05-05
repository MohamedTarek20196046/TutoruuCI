package TestComponents;
import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Chatbot {
	@Test
	public void chat() {
		ChromeOptions o = new ChromeOptions();
		o.addArguments("headless");
		WebDriver driver = new ChromeDriver(o);
		driver.manage().window().setSize(new Dimension(1440,900));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://www.tutoruu.com/");
		driver.findElement(By.cssSelector("img[src=\"/images/ruu-ai-mascot.png\"]")).click();
		boolean x = false;
		List<WebElement> elements = driver.findElements(By.cssSelector("div.hidden div.bg-white p.font-semibold"));
		for (int i = 0; i < elements.size(); i++) {
			if (elements.get(i).getText().contains("3")) {
				x = true;
				break;
			}
		}
		if (x == false) {
			Assert.assertTrue(false);
		}
		for(int i=0; i<3;i++)
		{
			driver.findElement(By.tagName("input")).sendKeys("hi");
			
			if(driver.findElement(By.cssSelector("button.bg-primary-500:nth-child(2)")).isEnabled()) {
				driver.findElement(By.cssSelector("button.bg-primary-500:nth-child(2)")).click();
				
			}
		}
		if(driver.findElements(By.cssSelector("h2.text-current")).get(1).isDisplayed())
		{
			System.out.println("success");
			driver.quit();
		}else {
			Assert.assertTrue(false);
		}
		
	}
	

}
