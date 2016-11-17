package org.roundface.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ProReader {
	private Properties properties = null;
	private static ProReader instance = null;

	public static synchronized ProReader getInstance() {
		if (instance == null) {
			instance = new ProReader();
		}
		return instance;
	}

	private ProReader() {
		try {
			properties = new Properties();
			FileInputStream is = null;
	        StringBuffer fileName = new StringBuffer();
	        fileName.append(".");
	        fileName.append(File.separatorChar);
	        fileName.append("resource");
	        fileName.append(File.separatorChar);
	        fileName.append("config.properties");
	        try
	        {
	            is = new FileInputStream(fileName.toString());
	        }
	        catch (FileNotFoundException e)
	        {
	            System.out.println("File config.properties not found");
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
		System.out.println(ProReader.getInstance().getProperty("database.url"));
	}
}
