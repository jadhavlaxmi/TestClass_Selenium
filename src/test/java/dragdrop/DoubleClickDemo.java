package dragdrop;



	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.interactions.Actions;

	public class DoubleClickDemo {
		

			public static void main(String[] args) throws InterruptedException {
				WebDriver driver=new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				
				driver.get("https://demo.guru99.com/test/simple_context_menu.html");
				
				//Thread.sleep(2000);
				
				Actions act=new Actions(driver);
				
				WebElement doubleClickBtn=driver.findElement(By.xpath("//button[text()='Double-Click Me To See Alert']"));
				
				
				act.doubleClick(doubleClickBtn).build().perform();
				
				Thread.sleep(2000);
				
				driver.quit();
				
		}

	}