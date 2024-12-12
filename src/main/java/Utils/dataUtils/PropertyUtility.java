package Utils.dataUtils;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertyUtility {

    /**
     * Reads properties from a file and returns them as a Map.
     *
     * @param filePath the path to the properties file
     * @return a Map containing the properties
     */
    public static Map<String, Object> loadPropertiesAsMaps(String filePath) {
        Properties properties = new Properties();
        Map<String, Object> propertiesMap = new HashMap<>();

        try (InputStream inputStream = new FileInputStream(filePath)) {
            properties.load(inputStream);
            for (String key : properties.stringPropertyNames()) {
                propertiesMap.put(key, properties.getProperty(key)); // Store as Object (String)
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to load properties from " + filePath, e);
        }
        return propertiesMap;
    }

    public static Map<String, Object> loadLambdaTestConfig() {
        String filePath = System.getProperty("user.dir")+"/src/main/resources/LambdaTestConfig/lambdatestconfig.properties";
        return loadPropertiesAsMaps(filePath);
    }


}