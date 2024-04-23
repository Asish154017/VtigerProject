package OrgPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewOrgPage {
	
	@FindBy(name = "accountname")
	private WebElement orgNameTextBox;
	
	@FindBy(css = "input[title='Save [Alt+S]']")
	private WebElement saveBtn;
 
	@FindBy(css = "img[title='Select']")
	private WebElement memPlusBtn;
	
	public CreateNewOrgPage(WebDriver driver) {
	
		PageFactory.initElements(driver,this);
	
	}
	
	public WebElement getOrgNameTextBox() {
		return orgNameTextBox;
	}

	
	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getMemPlusBtn() {
		return memPlusBtn;
	}

	

}
