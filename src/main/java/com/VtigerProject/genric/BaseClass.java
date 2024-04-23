package com.VtigerProject.genric;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Vtiger.HomePagePOM.HomePage;
import com.Vtiger.loginPOM.LoginPages;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	//public static WebDriver driver; 
	public WebDriverUtils wdu;
	public PropertyUtils pu;
	public LoginPages lp;
	public HomePage hp;
	public ExcelUtils eu;
	public JavaUtils ju;
	Driver d;
	
	@BeforeClass
	public void setUp() throws Throwable
	{
		wdu = new WebDriverUtils();
		pu= new PropertyUtils();
		d= new Driver();
		d.driverLaunch(Iconstant.chromeLaunch);
		//WebDriverManager.chromedriver().setup();
		//driver = new ChromeDriver();
		wdu.implicit_wait(Driver.getDriver(),10);
		wdu.MaximizeBrowser(Driver.getDriver());
		wdu.openapp(Driver.getDriver(),pu.fetchDataFromProperty(Iconstant.pathPropVtiger,"url"));
	}
	@BeforeMethod
	public void loginApp() throws Throwable
	{
		wdu = new WebDriverUtils();
		pu= new PropertyUtils();
		lp=new LoginPages(Driver.getDriver());
		lp.getUn().sendKeys(pu.fetchDataFromProperty(Iconstant.pathPropVtiger,"un"));
		lp.getPwd().sendKeys(pu.fetchDataFromProperty(Iconstant.pathPropVtiger,"pwd"));
		lp.getLogin().click();
		
	}
	
	
	@AfterMethod
	public void logout()
	{
		wdu = new WebDriverUtils();
		pu= new PropertyUtils();
		hp=new HomePage(Driver.getDriver());
		
		wdu.moveTheCursor(Driver.getDriver(),hp.getAdminImg());
		hp.getSignOut().click();
		
	}
	@AfterClass
	public void tearUp()
	{
		Driver.getDriver().close();
	}
	
	
	
	
	

}











