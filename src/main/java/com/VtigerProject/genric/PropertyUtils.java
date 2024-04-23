package com.VtigerProject.genric;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyUtils {
	public String fetchDataFromProperty(String path,String key) throws Throwable
	{
		FileInputStream fis = new FileInputStream(path);
		Properties pobj = new Properties();
		pobj.load(fis);
		return pobj.getProperty(key);
		
	}

}
