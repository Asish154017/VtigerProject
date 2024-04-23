package com.VtigerProject.LeadsTestCases;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Vtiger.HomePagePOM.HomePage;
import com.VtigerProject.genric.BaseClass;
import com.VtigerProject.genric.Driver;
import com.VtigerProject.genric.ExcelUtils;
import com.VtigerProject.genric.Iconstant;
import com.fasterxml.jackson.databind.deser.Deserializers.Base;

import cpm.Vtiger.LeadsPOM.CreatenNewLeadsPage;
import cpm.Vtiger.LeadsPOM.LeadsPage;
@Listeners(com.VtigerProject.genric.ListnerClass.class)
public class CreateLeadsWithValidCredentialsTest extends BaseClass{
	LeadsPage lp;
	CreatenNewLeadsPage cnp;
	@Test
	public void CreateLeadsWithValidCredentialsTest1() throws Throwable
	{
		eu= new ExcelUtils();
		hp= new HomePage(Driver.getDriver());
		lp= new LeadsPage(Driver.getDriver());
		cnp= new CreatenNewLeadsPage(Driver.getDriver());
		hp.getLeadsBtn().click();
		lp.getPlusBtn().click();
		
		cnp.getLastNameTextBox().sendKeys(eu.singleDataFetch(Iconstant.excelPath, 1, 3,"Leads"));
		cnp.getCompanyTextBox().sendKeys(eu.singleDataFetch(Iconstant.excelPath, 1, 4,"Leads"));
		Driver.getDriver().findElement(By.xpath("vdfdf")).sendKeys("2212");
	
		cnp.getSavebtn().click();
	}

}
