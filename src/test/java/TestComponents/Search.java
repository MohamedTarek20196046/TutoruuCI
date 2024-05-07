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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Search {
	@Test
	public void Search() throws InterruptedException {
		ChromeOptions o = new ChromeOptions();
		o.addArguments("headless");
		WebDriver driver = new ChromeDriver(o);
		driver.manage().window().setSize(new Dimension(1440, 900));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://www.tutoruu.com/");
		SearchByDay(driver);
		SearchByPrice(driver);
		SearchByName(driver);
		SearchByNameAndPrice(driver);
		System.out.println("Search tests was successfull");
		driver.quit();
	}

	public void SearchByDay(WebDriver driver) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.findElement(By.cssSelector("a[href=\"/tutors\"] p")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.bg-primary-500")));
		driver.findElements(By.cssSelector("span.icon-chevron-down")).get(0).click();
		driver.findElements(By.cssSelector("div.shrink-0 span.icon-check")).get(2).click();
		driver.findElements(By.cssSelector("a.bg-primary-500")).get(0).click();
		List<WebElement> days = driver.findElements(By.cssSelector("button.snap-start p"));
		boolean x = false;
		for (int i = 0; i < days.size(); i++) {
			if (days.get(i).getText().equals("Wednesday")) {
				x = true;
			}
		}
		if (x == false) {
			System.out.println("SearchByPrice testcase failed");
			Assert.assertTrue(false);
		} else {
			System.out.println("SearchByDay testcase Passed");
		}
	}

	public void SearchByPrice(WebDriver driver) throws InterruptedException {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.findElement(By.cssSelector("a[href=\"/tutors\"] p")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.bg-primary-500")));
		driver.findElements(By.cssSelector("span.icon-chevron-down")).get(1).click();
		driver.findElements(By.cssSelector("div.shrink-0 div.bg-current")).get(3).click();
		Thread.sleep(2000);
		String fee = driver.findElements(By.cssSelector("div.place-self-stretch div.px-4 p.text-base")).get(0)
				.getText();
		String[] parts = fee.split("/");
		String num = parts[0];
		int price = Integer.parseInt(num);
		if (price >= 200 && price <= 250) {
			System.out.println("SearchByPrice testcase passed");
		} else {
			System.out.println("SearchByPrice testcase failed");
			Assert.assertTrue(false);
		}
	}

	public void SearchByName(WebDriver driver) throws InterruptedException {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.findElement(By.cssSelector("a[href=\"/tutors\"] p")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.bg-primary-500")));
		driver.findElement(By.cssSelector("input#search")).sendKeys("tutor1");
		Thread.sleep(2000);
		String name = driver.findElements(By.cssSelector("p.line-clamp-1")).get(0).getText();
		if (!name.equals("tutor1")) {
			System.out.println("SearchByPrice testcase failed");
			Assert.assertTrue(false);
		} else {
			System.out.println("SearchByName testcase passed");
		}
	}

	public void SearchByNameAndPrice(WebDriver driver) throws InterruptedException {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.findElement(By.cssSelector("a[href=\"/tutors\"] p")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.bg-primary-500")));
		driver.findElement(By.cssSelector("input#search")).sendKeys("Nour");
		Thread.sleep(2000);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.bg-primary-500")));
		driver.findElements(By.cssSelector("span.icon-chevron-down")).get(1).click();
		driver.findElements(By.cssSelector("div.shrink-0 div.bg-current")).get(3).click();
		Thread.sleep(3000);
		String name = driver.findElements(By.cssSelector("p.line-clamp-1")).get(0).getText();
		if (!name.equals("Nour Hazem")) {
			System.out.println("SearchByNameAndPrice testcase failed");
			Assert.assertTrue(false);
		} else {
			System.out.println("SearchByNameAndPrice testcase passed");
		}

	}
}
