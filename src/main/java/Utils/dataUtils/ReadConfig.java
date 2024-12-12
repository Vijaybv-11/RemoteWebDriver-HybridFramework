package Utils.dataUtils;

import Utils.FrameworkConstants;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig implements FrameworkConstants {

	/**
	 * This method read the properties and return the value based on key
	 *
	 * @par key @ value
	 * @throws Throwable
	 */
	public static Properties properties;

	public String getValueProperty(String key) {
		try {
			FileInputStream file = new FileInputStream(propertyPath);
			properties = new Properties();
			properties.load(file);

		} catch (Throwable e) {
			e.printStackTrace();
		}
		return properties.getProperty(key);
	}

	public void writeProperty(String key, String value) {

		try (FileInputStream fis = new FileInputStream(propertyPath)) {
			properties.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}

		properties.setProperty(key, value);

		try (FileOutputStream fos = new FileOutputStream(propertyPath)) {
			properties.store(fos, "Updated properties file");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
