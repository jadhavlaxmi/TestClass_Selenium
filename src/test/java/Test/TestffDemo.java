package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestffDemo {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/chromedriver.exe");//dont give actual path of driver
		//System.out.println(System.getProperty("user.dir")); hardcode the path
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
	
		
		driver.manage().deleteAllCookies();
		
		driver.get("https://www.google.co.in");
		String titleOfPage=driver.getTitle();
		System.out.println(" title of page  "+titleOfPage);
		
		if(titleOfPage.equals("Google"))
		{
			System.out.println("Title of page is correct test pass");
		}else {
			System.out.println("Title of page is incorrect test Fail");
		}
		 WebElement searchBox=driver.findElement(By.name("q"));
		 searchBox.sendKeys("Selenium"+Keys.ENTER);
		 WebElement searchButton=driver.findElement(By.name("btnk"));
		 //searchButton.click();
		// Thread.sleep(4000);
		 if(driver.getTitle().equals("Selenium - Google Search"))
		 {
			 System.out.println("Test Pass");
		 }
		 else {
			 System.out.println("Test fail");
		 }
		driver.quit();

	}

}
