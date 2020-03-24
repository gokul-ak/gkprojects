package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigReaders {

	Properties prop ;
	
	public ConfigReaders () {
		
		File file = new File("D:\\API Automation\\rbs-automation\\Config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(file);
			
			prop = new Properties();
			
			prop.load(fis);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
	}
	
	public String getUrl() {
		
		String url = prop.getProperty("url");
		
		return url;
	}
	
	public String getChromeDriver() {
		
		String ChromeDriver = prop.getProperty("ChromeDriver");
		
		return ChromeDriver;
	}

	public String getUsername() {
		
		String username = prop.getProperty("username");
		
		return username;
	}
	
	public String getPassword() {
		
		String password = prop.getProperty("password");
		
		return password;
	}
	
	public String getFirstName() {
		
		String firstName = prop.getProperty("firstName");
		
		return firstName;
	}
	
	public String getCurrentPassword() {
		
		String currentPassword = prop.getProperty("currentpassword");
		
		return currentPassword;
	}
}
