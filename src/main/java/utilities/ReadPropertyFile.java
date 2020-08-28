package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import base.BaseClass;

public class ReadPropertyFile {
	
	public static Properties loadPropertyFile(String filepath) throws IOException {
	
		File src = new File(filepath);
		FileInputStream fis = new FileInputStream(src);
		Properties testDataprop=new Properties();
		try
		{
			
		testDataprop.load(fis);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return testDataprop;
	
	}

}
