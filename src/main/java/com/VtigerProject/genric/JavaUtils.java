package com.VtigerProject.genric;

import java.util.Date;
import java.util.Random;

import org.testng.annotations.Test;

public class JavaUtils {
	
	public int randomNumber(int range)
	{
		Random r = new Random();
		return r.nextInt(range);
	}
	
	public String dateGenrate()
	{
	   Date d = new Date();
	  
	   String fullData=d.toString();
	   String[] s = fullData.split(" ");
	   String date=s[2]+"-"+s[1]+"-"+s[5];
	   return date;
	}
	
	public String currentTimeGenrate()
	{
	   Date d = new Date();
	  
	   String fullData=d.toString();
	   String[] s = fullData.split(" ");
	   String date=s[3].replace(":", "-");
	   
	   return date;
	}
	
	@Test
	public void m1()
	{
	   System.out.println(dateGenrate());
	   System.out.println(currentTimeGenrate());
		
	}
	
	

}
