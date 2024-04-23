package com.VtigerProject.LeadsTestCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Vtiger.HomePagePOM.HomePage;
import com.VtigerProject.genric.BaseClass;
import com.VtigerProject.genric.Driver;
import com.VtigerProject.genric.WebDriverUtils;
import com.fasterxml.jackson.databind.deser.Deserializers.Base;

import cpm.Vtiger.LeadsPOM.CreatenNewLeadsPage;
import cpm.Vtiger.LeadsPOM.LeadsPage;
//@Listeners(com.VtigerProject.genric.ListnerClass.class)

public class LeadsMultipleDataTest extends BaseClass {
	LeadsPage lp;
	CreatenNewLeadsPage cnp;
	@Test(dataProvider = "Leads",dataProviderClass =com.VtigerProject.genric.DataProviderClass.class )
public void createLeadsWithMultipleData(String fname,String lname,String cname,String title)
{
	hp=new HomePage(Driver.getDriver());
	lp= new LeadsPage(Driver.getDriver());
	cnp= new CreatenNewLeadsPage(Driver.getDriver());
	wdu= new WebDriverUtils();
	hp.getLeadsBtn().click();
	lp.getPlusBtn().click();
	wdu.selectByValue(cnp.getDropDownNameTextBox(),"Ms.");
	cnp.getFnameTextBox().sendKeys(fname);
	cnp.getLastNameTextBox().sendKeys(lname);
	cnp.getTitletextBox().sendKeys(title);
	cnp.getCompanyTextBox().sendKeys(cname);
	cnp.getSavebtn().click();
	
}

}
