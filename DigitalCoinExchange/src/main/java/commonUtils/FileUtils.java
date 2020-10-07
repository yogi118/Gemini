package commonUtils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class FileUtils {
	
	public static String getProperty(String propertyName) {
		String filePath = "./src/test/resources/ConfigProperties.properties";
		try {
			FileReader reader = new FileReader(filePath);
			Properties properties = new Properties();
			properties.load(reader);
			return properties.getProperty(propertyName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
}
