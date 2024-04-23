package cpm.Vtiger.LeadsPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatenNewLeadsPage {
	
	@FindBy(name = "lastname")
	private WebElement lastNameTextBox;
	
	@FindBy(name = "company")
	private WebElement companyTextBox;
	@FindBy(name = "firstname")
	private WebElement fnameTextBox;
	@FindBy(name = "designation")
	private WebElement titletextBox;
	@FindBy(name = "salutationtype")
	private WebElement dropDownNameTextBox;
	@FindBy (css = "input[title='Save [Alt+S]']")
	private WebElement savebtn;
	
	public CreatenNewLeadsPage(WebDriver driver) {
	
		PageFactory.initElements(driver,this);
	
	}
	

	public WebElement getLastNameTextBox() {
		return lastNameTextBox;
	}

	public void setLastNameTextBox(WebElement lastNameTextBox) {
		this.lastNameTextBox = lastNameTextBox;
	}

	public WebElement getCompanyTextBox() {
		return companyTextBox;
	}

	public void setCompanyTextBox(WebElement companyTextBox) {
		this.companyTextBox = companyTextBox;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}

	public void setSavebtn(WebElement savebtn) {
		this.savebtn = savebtn;
	}


	public WebElement getFnameTextBox() {
		return fnameTextBox;
	}


	public WebElement getTitletextBox() {
		return titletextBox;
	}


	public WebElement getDropDownNameTextBox() {
		return dropDownNameTextBox;
	}
	

}
