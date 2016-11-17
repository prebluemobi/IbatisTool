package org.roundface.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class GenerateReader {
	private Properties properties = null;
	private static GenerateReader instance = null;

	public static synchronized GenerateReader getInstance() {
		if (instance == null) {
			instance = new GenerateReader();
		}
		return instance;
	}

	private GenerateReader() {
		try {
			properties = new Properties();
			FileInputStream is = null;
	        StringBuffer fileName = new StringBuffer();
	        fileName.append(".");
	        fileName.append(File.separatorChar);
	        fileName.append("resource");
	        fileName.append(File.separatorChar);
	        fileName.append("generate.properties");
	        try
	        {
	            is = new FileInputStream(fileName.toString());
	        }
	        catch (FileNotFoundException e)
	        {
	            System.out.println("File generate.properties not found");
	        }
			properties.load(is);
		} catch (IOException e) {
			System.err.println("读取属性文件失败，请确认文件是否存在！");
		}
	}

	public String getProperty(String key) {
		return properties.getProperty(key);
	}

	public static void main(String[] args) {
		System.out.println(GenerateReader.getInstance().getProperty("database.url"));
	}
}
