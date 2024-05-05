package TestComponents;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class SocialPages {
	@Test
	public void CheckPages()
	{
		ChromeOptions o = new ChromeOptions();
		o.addArguments("headless");
		WebDriver driver = new ChromeDriver(o);
		driver.manage().window().setSize(new Dimension(1440,900));
		Actions a = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://www.tutoruu.com/");
		a.scrollToElement(driver.findElement(By.cssSelector("a[href=\"https://www.instagram.com/tutoruu.eg/\"]"))).build().perform();
		driver.findElement(By.cssSelector("a[href=\"https://www.instagram.com/tutoruu.eg/\"]")).click();
		driver.findElement(By.cssSelector("a[href=\"https://eg.linkedin.com/company/tutoruu\"]")).click();
		driver.findElement(By.cssSelector("a[href=\"https://www.facebook.com/Tutoruu/\"]")).click();
		System.out.println(driver.getTitle());
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> itr=windows.iterator();
		String parent = itr.next();
		String child;
		for(int i=1; i< windows.size();i++)
		{
			child = itr.next();
			driver.switchTo().window(child);
			System.out.println(driver.getTitle());
			if(driver.getTitle().equals("Tutoruu | LinkedIn")||driver.getTitle().equals("Tutoruu (@tutoruu.eg) • Instagram photos and videos")||driver.getTitle().equals("Tutoruu | Facebook")) {
				continue;
			}else {
				Assert.assertTrue(false);
			}
		}
		System.out.println("success");
		driver.quit();
	}
	
	
}
