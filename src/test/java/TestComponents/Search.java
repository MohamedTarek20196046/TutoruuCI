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

public class Search {
	@Test
	public void Search() throws InterruptedException {
		ChromeOptions o = new ChromeOptions();
		o.addArguments("headless");
		WebDriver driver = new ChromeDriver(o);
		driver.manage().window().setSize(new Dimension(1440,900));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://www.tutoruu.com/");
		driver.findElement(By.cssSelector("a[href=\"/tutors\"] p")).click();
		driver.findElements(By.cssSelector("span.icon-chevron-down")).get(0).click();
		driver.findElements(By.cssSelector("div.shrink-0 span.icon-check")).get(2).click();
		driver.findElements(By.cssSelector("a.bg-primary-500")).get(0).click();
		List <WebElement> days = driver.findElements(By.cssSelector("button.snap-start p"));
		boolean x= false;
		for(int i=0;i<days.size();i++)
		{
			if(days.get(i).getText().equals("Wednesday")) {
				x=true;
			}
		}
		if(x==false)
		{
			Assert.assertTrue(false);
		}
		driver.findElement(By.cssSelector("a[href=\"/tutors\"] p")).click();
		driver.findElements(By.cssSelector("span.icon-chevron-down")).get(1).click();
		driver.findElements(By.cssSelector("div.shrink-0 div.bg-current")).get(3).click();
		Thread.sleep(4000);
		String fee = driver.findElements(By.cssSelector("div.place-self-stretch div.px-4 p.text-base")).get(0).getText();
		String[] parts = fee.split("/"); 
		String num = parts[0];
		int price= Integer.parseInt(num);
		System.out.println(price);
		if(price>=200 && price<=250)
		{
			System.out.println(price);
		}else {
			Assert.assertTrue(false);
		}
		driver.findElement(By.cssSelector("input#search")).sendKeys("tutor1");
		Thread.sleep(2000);
		String name= driver.findElements(By.cssSelector("p.line-clamp-1")).get(0).getText();
		if(!name.equals("tutor1"))
		{
			Assert.assertTrue(false);
		}
		System.out.println("success");
		driver.quit();
	}
	

}
