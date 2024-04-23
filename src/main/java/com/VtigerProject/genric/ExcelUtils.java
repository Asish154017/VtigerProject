package com.VtigerProject.genric;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils {
	FileInputStream fis;
	Workbook book;
	DataFormatter df;
	
	public String singleDataFetch(String path,int row,int cell,String sheetName) throws Throwable
	{
		df= new DataFormatter();
		fis= new FileInputStream(path);
		book = WorkbookFactory.create(fis);
		return df.formatCellValue(book.getSheet(sheetName).getRow(row).getCell(cell));
	}
	
	public List<String> dataFetchInRowWise(String path,int cell,String sheetName) throws Throwable
	{
		List<String> l = new ArrayList<String>();
		df= new DataFormatter();
		fis= new FileInputStream(path);
		book=WorkbookFactory.create(fis);
		Sheet sh = book.getSheet(sheetName);
		for(int i=0;i<=sh.getLastRowNum();i++)
		{
			String s= df.formatCellValue(sh.getRow(i).getCell(cell));
			l.add(s);
		}
		return l;
	}
	
	


}
