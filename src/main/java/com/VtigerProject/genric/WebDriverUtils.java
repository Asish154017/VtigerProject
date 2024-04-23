package com.VtigerProject.genric;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.google.common.io.Files;

/**
 * 
 * @author Abhi
 * This class will store all the WebDriver Opertions
 * Here we will perfrom the Resuble methods which will help you to optimize your code
 *
 */
public class WebDriverUtils {
	/**
	 * here it will store the current id of the webpage
	 * this method is use to launch the web application
	 */
	public void openapp(WebDriver driver,String url)
	{
		driver.get(url);
	}
	/**
	 * 
	 * this method is use to maximize the current browser.
	 */
	public void MaximizeBrowser(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	/**
	 * this method use to minimize the current browser
	 */
	public void MinimizeBrowser(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	/**
	 * this method is use to refresh the webpage
	 */
	public void Refreshpage(WebDriver driver)
	{
		driver.navigate().refresh();
	}
	/**
	 * this method is use to back the webpage
	 */
	public void backPage(WebDriver driver)
	{
		driver.navigate().back();
	}
	/**
	 * this method is use to resize the browser
	 * @param hight 
	 * @param width 
	 *
	 */
	public void resizeBrowser(WebDriver driver, int width,  int hight)
	{
		driver.manage().window().setSize(new Dimension( width, hight));
	}
	/**
	 * this method will help to change the position of browser
	 * @param x 
	 * @param y 
	 */
	public void chnagePosition(WebDriver driver, int x, int y)
	{
		driver.manage().window().setPosition(new Point(x, y));
	}
	/**
	 * this method is use to forward the page
	 */
	public void forwardBrowser(WebDriver driver)
	{
		driver.navigate().forward();
	}
	/**
	 * this method is use to get the current addres of webpage
	 */
	public void Openbynavigate(WebDriver driver,String url)
	{
		driver.navigate().to(url);
	}
	/**
	 * it is use to find the address of the locator 
	 */
	public void locator(WebDriver driver,By locator)
	{
		driver.findElement(locator);
	}
	/**
	 * this method is use to find the address of elements
	 * @return 
	 */
	public List<WebElement> multipleElements(By locator,WebDriver driver)
	{
		return driver.findElements(locator);
	}
	/**
	 * this method is used to validate the data.
	 * @return 
	 */
	public boolean validate_CheckBox_And_RadioButton(WebElement ele)
	{
		return ele.isSelected();
	}
	/**
	 * this method is used for messege displayed or not .
	 * @return 
	 */
	public boolean messege_display(WebElement ele)
	{
		return ele.isDisplayed();
	}
	/**
	 * this method is used to check html attribute is enabled or not
	 * @return 
	 */
	public boolean html_enabled(WebElement ele)
	{
		return ele.isEnabled();
	}
	/**
	 * this method is used to get the title of url
	 */
	public void Title(WebDriver driver)
	{
		driver.getTitle();
	}
	/**
	 *this method is used to handel the single window
	 * @return 
	 */
	public  String single_window_handle(WebDriver driver)
	{
		return driver.getWindowHandle();
	}
	/**
	 *this method is used to handel the multiple windows
	 * @return 
	 */
	public  void multiple_window_handle(WebDriver driver,String expUrl)
	{
	       Set<String> mulId= driver.getWindowHandles();
	       for(String i:mulId)
	       {
	    	  String url=  driver.switchTo().window(i).getCurrentUrl();
	    	  if(url.contains(expUrl))
	    	  {
	    		  break;
	    	  }
	       }
	}
	
	/**
	 * this method is used right click with out using mouse 
	 */
	public void right_click(WebDriver driver,WebElement ele)
	{
		Actions act=new Actions(driver);
		act.contextClick().perform();
	}
	/**
	 * this method is used to perform double click
	 */
	public void double_click(WebDriver driver,WebElement ele)
	{
		Actions act=new Actions(driver);
		act.doubleClick().perform();
	}
	/**
	 * this method is used to perform drag and drop by
	 * @param x 
	 * @param y 
	 */
	public void drag_and_drop_by(WebDriver driver,WebElement ele, int x, int y)
	{
		Actions act=new Actions(driver);
		act.dragAndDropBy(ele, x, y).perform();
	}
	/**
	 * this method is used to perform drag and drop 
	 * 
	 *
	 */
	public void drag_and_drop(WebDriver driver,WebElement ele)
	{
		Actions act=new Actions(driver);
		act.dragAndDrop(ele, ele).perform();
	}
	public void moveTheCursor(WebDriver driver,WebElement ele)
	{
		Actions act=new Actions(driver);
		act.moveToElement(ele).perform();
	}
	/**
	 * this method is used to perform synchronization
	 * @param TimeUnit 
	 */
	public void implicit_wait(WebDriver driver, long TimeUnit)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TimeUnit));
	}
	/**
	 * this method is used to perform select  in dropdown elements .
	 * @param x 
	 */
	public void selectByWebElement(WebElement ele, int x)
	{
		Select s=new Select(ele);
		s.selectByIndex(x);
	}
	public void selectByValue(WebElement ele,String s1)
	{
		Select s=new Select(ele);
		s.selectByValue(s1);
	}
	/**
	 * this method is used to deselect all the selected dropdown
	 */
	public void deselect(WebElement ele)
	{
		Select s=new Select(ele);
		s.deselectAll();
	}
	/**
	 * this method is used to take the screenshot purpose
	 * @param path 
	 * @return 
	 * @throws IOException 
	 */
	public String screenshot(WebDriver driver, String path) throws IOException
	{
		TakesScreenshot sh=(TakesScreenshot)driver;
		File src=sh.getScreenshotAs(OutputType.FILE);
		File dist=new File(path);
		Files.copy(src, dist);
		return dist.getAbsolutePath();
	}
	/**
	 * These methods are used to handle the popups
	 * ok
	 * write messege 
	 * @param str 
	 */
	public void popup(WebDriver driver)
	{
		Alert alt=driver.switchTo().alert();
		alt.accept();
		
		
	}
	/**this method is used to cancel the popup
	 * 
	 */
	public void cancelPopup(WebDriver driver)
	{
		Alert alt=driver.switchTo().alert();
		alt.dismiss();
	}
	/**
	 * this method is used to fetch the messege
	 */
	public void fetchMessege(WebDriver driver)
	{
		Alert alt=driver.switchTo().alert();
		alt.getText();
	}
	/**
	 * this method is used to write the messege
	 * @param str 
	 */
	public void writeMessege(WebDriver driver, String str)
	{
		Alert alt=driver.switchTo().alert();
		alt.sendKeys(str);
	}
	/**
	 * this method is used to handel the frame
	 * by 3 ways.
	 * @param str 
	 */
	public void frame(WebDriver driver,WebElement ele)
	{
		
		
		driver.switchTo().frame(ele);
	}
	/**
	 * this method is use to handle the frame
	 * @param str 
	 */
	public void frame1(WebDriver driver, String str)
	{
		driver.switchTo().frame(str);
	}
	/**
	 * this is method is use to handel the frame
	 * @param index 
	 * @param index 
	 */
	public void frame2(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	/**
	 * this method is used to perform the parentframe
	 */
	public void parent_frame(WebDriver driver)
	{
		driver.switchTo().parentFrame();
	}
	/**
	 * this method is used to perform nested frame
	 * @param index 
	 */
	public void nested_frame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index).switchTo().frame(index);
	}
	
	/**
	 * this method is used to perfom open new tab
	 */
	public void new_tab(WebDriver driver)
	{
		driver.switchTo().newWindow(WindowType.TAB);
	}
	
		/**
	 * this method is use to handle the scrolling
	 */
	public void scrolling(WebElement ele,WebDriver driver)
	{
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView(true)", ele);
		//jse.executeScript("window.scrollBy(0,250)", ele);
		
	}
	/**
	 * Handling Multiple Windows
	 */
      public void handleMultipleTabs(WebDriver driver,String matchingTitle)
      {
    	  Set<String > str= driver.getWindowHandles();
    	  
    	  for(String s:str)
    	  { 
    		  String title= driver.switchTo().window(s).getTitle();
    		  if(title.equals(matchingTitle))
    		  {
    			  break;
    		  }
    	  }
      }
      
      
      public String screenShot(WebDriver driver,String pathSS) throws Throwable
      {
    	  TakesScreenshot sh = (TakesScreenshot)driver;
    	  File src = sh.getScreenshotAs(OutputType.FILE);
    	  File dist = new File(pathSS);
    	  Files.copy(src,dist);
    	  //It will fetch the path where we will store the SS
    	   return dist.getAbsolutePath();
    			  
      }
    	  
    	  
    	  
      
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
