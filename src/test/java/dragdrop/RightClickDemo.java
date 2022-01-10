package dragdrop;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RightClickDemo {

	

		public static void main(String[] args) throws InterruptedException {
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			driver.get("https://demo.guru99.com/test/simple_context_menu.html");
			
			WebElement rightClickBtn=driver.findElement(By.xpath("//span[text()='right click me']"));
			
			//Thread.sleep(2000);
			Actions act=new Actions(driver);
			act.contextClick(rightClickBtn).build().perform();
			Thread.sleep(2000);
			
			driver.quit();
			
	}

}
