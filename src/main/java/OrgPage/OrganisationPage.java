package OrgPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationPage {
	
	@FindBy(css = "img[title='Create Organization...']")
    private WebElement plusBtnOrg;
	
	public OrganisationPage(WebDriver driver) {
	
		PageFactory.initElements(driver,this);
	
	}

	public WebElement getPlusBtnOrg() {
		return plusBtnOrg;
	}
	
	


}
