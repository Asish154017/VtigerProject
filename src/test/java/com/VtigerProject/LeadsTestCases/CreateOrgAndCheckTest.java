package com.VtigerProject.LeadsTestCases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Vtiger.HomePagePOM.HomePage;
import com.VtigerProject.genric.BaseClass;
import com.VtigerProject.genric.Driver;
import com.VtigerProject.genric.ExcelUtils;
import com.VtigerProject.genric.Iconstant;
import com.VtigerProject.genric.JavaUtils;
import com.VtigerProject.genric.WebDriverUtils;

import OrgPage.CreateNewOrgPage;
import OrgPage.CreateOrgSearchPage;
import OrgPage.OrgInfoPage;
import OrgPage.OrganisationPage;
@Listeners(com.VtigerProject.genric.ListnerClass.class)

public class CreateOrgAndCheckTest extends BaseClass {
	CreateNewOrgPage cno;
	OrganisationPage op;
	OrgInfoPage oip;
	CreateOrgSearchPage cosp;
	
	
	@Test
	public void createaOrgAndCheckInMemberIsPresntOrNot() throws Throwable
	{
		wdu = new WebDriverUtils();
		hp= new HomePage(Driver.getDriver());
		cno= new CreateNewOrgPage(Driver.getDriver());
		op = new OrganisationPage(Driver.getDriver());
		oip= new OrgInfoPage(Driver.getDriver());
		eu= new ExcelUtils();
		ju= new JavaUtils();
		cosp= new CreateOrgSearchPage(Driver.getDriver());
		hp.getOrgbtn().click();
		op.getPlusBtnOrg().click();
		String randomString= eu.singleDataFetch(Iconstant.excelPath,2, 3,"Org")+ju.randomNumber(10000);
		cno.getOrgNameTextBox().sendKeys(randomString);
		cno.getSaveBtn().click();
		String actData=oip.getValidateOrgTitle().getText();
		//Assert.assertEquals(actData,randomString+eu.singleDataFetch(Iconstant.excelPath, 2, 4,"Org"));
		Assert.assertTrue(actData.contains(randomString),"My Organistion Page is Not Created");
		
		Reporter.log(randomString);
		
		wdu.backPage(Driver.getDriver());
		
		cno.getMemPlusBtn().click();
		
		wdu.multiple_window_handle(Driver.getDriver(),"http://localhost:8888/index.php?module=Accounts&action=Popup&popuptype=specific_account_address&form=TasksEditView&form_submit=false&fromlink=&recordid=");
		
		cosp.getSearchTextBox().sendKeys("AAA");
		
		
		
		
		
		
		
	}

}
