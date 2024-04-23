package com.Vtiger.loginPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPages {
	@FindBy (name="user_name")
	private WebElement un;
	@FindBy(name="user_password")
	private WebElement pwd;
	@FindBy(id = "submitButton")
	private WebElement login;
	public LoginPages(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	public WebElement getUn() {
		return un;
	}
	public WebElement getPwd() {
		return pwd;
	}
	public WebElement getLogin() {
		return login;
	}
	
	

}
