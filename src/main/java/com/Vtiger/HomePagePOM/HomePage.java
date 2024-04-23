package com.Vtiger.HomePagePOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	@FindBy (linkText = "Calendar")
	private WebElement calendatBtn;

	@FindBy (linkText = "Leads")
	private WebElement leadsBtn;
	
	@FindBy (linkText = "Organizations")
	private WebElement  orgbtn;

	@FindBy (linkText = "Contacts")
	private WebElement ctnsbtn;
	
	@FindBy (xpath ="//span[text()=' Administrator']/../following-sibling::td[1]/img")
	private WebElement adminImg;
	
	
	@FindBy (linkText = "Sign Out")
	private WebElement signOut;
	public HomePage(WebDriver driver) {
	
		PageFactory.initElements(driver,this);
	
	}
	public WebElement getCalendatBtn() {
		return calendatBtn;
	}
	public void setCalendatBtn(WebElement calendatBtn) {
		this.calendatBtn = calendatBtn;
	}
	public WebElement getLeadsBtn() {
		return leadsBtn;
	}
	public void setLeadsBtn(WebElement leadsBtn) {
		this.leadsBtn = leadsBtn;
	}
	public WebElement getOrgbtn() {
		return orgbtn;
	}
	public void setOrgbtn(WebElement orgbtn) {
		this.orgbtn = orgbtn;
	}
	public WebElement getCtnsbtn() {
		return ctnsbtn;
	}
	public void setCtnsbtn(WebElement ctnsbtn) {
		this.ctnsbtn = ctnsbtn;
	}
	public WebElement getAdminImg() {
		return adminImg;
	}
	public void setAdminImg(WebElement adminImg) {
		this.adminImg = adminImg;
	}
	public WebElement getSignOut() {
		return signOut;
	}
	public void setSignOut(WebElement signOut) {
		this.signOut = signOut;
	}
	

}
