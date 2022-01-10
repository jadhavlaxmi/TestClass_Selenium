package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PageLocator {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/chromedriver.exe");//dont give actual path of driver
		//System.out.println(System.getProperty("user.dir")); hardcode the path
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		
		driver.get("http://demo.automationtesting.in/index.html");
		String titleOfPage=driver.getTitle();
		System.out.println(" title of page  "+titleOfPage);
		
		if(titleOfPage.equals("Index"))
		{
			System.out.println("Title of page is correct test pass");
		}else {
			System.out.println("Title of page is incorrect test Fail");
		}
		WebElement emailIdTextBox=driver.findElement(By.id("email"));
		emailIdTextBox.sendKeys("test@Sgmail.com");
		
		WebElement submitButton=driver.findElement(By.id("enterimg"));
		submitButton.click();
		Thread.sleep(4000);
		//register
		if(driver.getTitle().equals("Register")) {
			System.out.println("new page for registration is displayed");
		}else {
			System.out.println("Test Fail");
		}
		driver.quit();
	}

}
