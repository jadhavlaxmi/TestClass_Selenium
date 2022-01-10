package JunitDemo;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import junit.framework.Assert;

public class JunitintroDemo {
	WebDriver driver;
	Actions act;
	@Before
	public void setup() {
		 driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://demo.guru99.com/test/simple_context_menu.html");
		
	}
	
	@Test
	public void rightClick() throws InterruptedException
	{
		//Thread.sleep(2000);
		WebElement rightClickBtn=driver.findElement(By.xpath("//span[text()='right click me']"));
		
	 act=new Actions(driver);
		act.contextClick(rightClickBtn).build().perform();
		Thread.sleep(2000);
		WebElement rightClickBox=driver.findElement(By.xpath("//ul[@class='context-menu-list context-menu-root']"));
		boolean lisiShouldDisplayed=true;
		Assert.assertEquals(lisiShouldDisplayed, rightClickBox.isDisplayed());
		Thread.sleep(2000);
	}
	@Test
	public void doubleClick() throws InterruptedException {
		
		
		 act=new Actions(driver);
		
		WebElement doubleClickBtn=driver.findElement(By.xpath("//button[text()='Double-Click Me To See Alert']"));
		
		
		act.doubleClick(doubleClickBtn).build().perform();
		Thread.sleep(2000);
	}
	
	@After
	public void  tearDown() {
		driver.quit();
	}
	
}
