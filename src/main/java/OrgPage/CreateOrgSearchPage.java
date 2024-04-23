package OrgPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrgSearchPage {
	@FindBy(id = "search_txt")
	private WebElement searchTextBox;
	
	@FindBy(name = "search")
	private WebElement searchBtn;
	
	public CreateOrgSearchPage(WebDriver driver) {
	
		PageFactory.initElements(driver,this);
	
	}

	public WebElement getSearchTextBox() {
		return searchTextBox;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}
	

}
