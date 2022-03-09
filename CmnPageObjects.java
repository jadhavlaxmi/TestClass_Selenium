package com.visionit.automation.pageobjects;


import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.appender.rolling.action.Action;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CmnPageObjects {
	private static final Logger logger = LogManager.getLogger(CmnPageObjects.class);
	WebDriver driver;

	private By nav_link_logo =  By.xpath("//img[@class='logo img-responsive']");
	 private By search_text_box  = By.id("search_query_top");
	 private By search_button  = By.name("submit_search");
	private By nav_link_category =  By.xpath("//div[@id='block_top_menu']/ul/li");
	private By twitter_footer_link =  By.xpath("//*[@target='_blank' and @href='https://twitter.com/seleniumfrmwrk']");
	private By list_of_search =By.xpath("//body/div[2]/ul[1]/li[1]");
	private By twitter_link_name =By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div/div/div/div[2]/div/div/div/div[2]/div[2]/div/div/div[1]/div/span[1]/span");
	

	public CmnPageObjects(WebDriver driver) {
		this.driver = driver;
		
	}

	public void SetSearchTextBox(String text) {
		WebDriverWait webDriverWait = new WebDriverWait(driver,20);
		WebElement elementSearchBox = webDriverWait.until(ExpectedConditions.elementToBeClickable(search_text_box));
		elementSearchBox.clear();
		elementSearchBox.sendKeys(text);
		logger.info("Value entered in search box: " + text);
	}

	public void ClickOnSearchButton() {
		driver.findElement(search_button).click();
		logger.info("Clicked on Search Button");
	}

	

	public void validateLogo(int width,int height) {
		boolean b = driver.findElement(nav_link_logo).isDisplayed();
		Assert.assertEquals("Navigation link logo",true, b);
		
		 width=driver.findElement(nav_link_logo).getSize().getWidth();
	     height=driver.findElement(nav_link_logo).getSize().getHeight();
	      Assert.assertEquals(width, 350);
	      Assert.assertEquals(height, 99);
	}
	
	public void validatePageTitleMatch(String expectedTitle) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		Boolean b = wait.until(ExpectedConditions.titleContains(expectedTitle));
		Assert.assertEquals("Title Validation",true, b);
		logger.info("Page title matched: " + expectedTitle );
	}
	public void ClickOnTheProductLink(){
        //listOfProducts will have all the links displayed in the search box
		List<WebElement> allProduct = driver.findElements(nav_link_category);
		System.out.println(allProduct.size());
        logger.info("Number of products searched: " + allProduct.size());
       

        for(  WebElement product : allProduct){

        	System.out.println(product.getText());
        }
		
        
       

    }
	
	
public void validateSearch(String textToSelect) { 	
	WebElement ele_move=driver.findElement(list_of_search);
	Actions act=new Actions(driver);
	WebDriverWait wait = new WebDriverWait(driver, 30);
	act.moveToElement(ele_move).click().build().perform();
     driver.findElement(search_button).click();
     
}
public void validate_footer() {
	boolean b= driver.findElement(twitter_footer_link).isDisplayed();
	Assert.assertEquals("Title Validation",true, b);
	
}

public void validate_footer_url(String expectedTitle) {
	
	driver.findElement(twitter_footer_link).click();
	logger.info("Clicked on twitter link");
	Set<String> handles = driver.getWindowHandles(); // get all the open windows
    Iterator<String> it = handles.iterator(); // get the iterator to iterate the elements in set
    String original = it.next();//gives the parent window id
    String prodDescp = it.next();//gives the child window id

    driver.switchTo().window(prodDescp); // switch to product Descp

    //Now driver can access new driver window, but can not access the orignal tab
    //Check product title is displayed
   
    //driver.switchTo().window(original);
	WebDriverWait wait = new WebDriverWait(driver, 30);
	Boolean b = wait.until(ExpectedConditions.titleContains(expectedTitle));
	Assert.assertEquals("Title Validation",true, b);
	logger.info("Page title matched: " + expectedTitle );


}
public void validate_footer_name() {
	
    WebElement actual= driver.findElement(twitter_link_name);
    Assert.assertEquals(true,actual.isDisplayed());
    
    logger.info("Page title matched: " + actual);
    


}

	public void validateElementPresentInHeaderSection(String text) throws Exception {
		boolean b=false;

		switch(text.toLowerCase().trim()) {

		
		case "Automation logo":
			b = driver.findElement(nav_link_logo).isDisplayed();
			break;
		case "categories list":
			
			b = driver.findElement(nav_link_category).isDisplayed();
			break;
		case "search button":
		
			b = driver.findElement(search_button).isDisplayed();
			break;
		
		case "search text box":
			b = driver.findElement(search_text_box).isDisplayed();
			break;
			
		case "footer link":
			b = driver.findElement(twitter_footer_link).isDisplayed();
			break;
			
		default:
			logger.fatal("Header Link Description is not present in the case. Please add link description first.");
			throw new Exception("Header Link Description is not present in the case. Please add link description first.");
		}

		if (b) {
			logger.info("Header Link is displayed: " + text);
			Assert.assertEquals("Header Link displayed",true, b);
		}else {
			logger.fatal("Header Link is not displayed: " + text);
			Assert.fail("Header Link is not displayed: " + text);
		}

	}

}
