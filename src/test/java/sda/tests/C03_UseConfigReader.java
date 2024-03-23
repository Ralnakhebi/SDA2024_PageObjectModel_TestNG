package sda.tests;

import org.testng.annotations.Test;
import sda.utilities.ConfigReader;
import sda.utilities.Driver;

public class C03_UseConfigReader {

    @Test
    public void ConfigReaderTest(){
        // Go to Amazon https://www.amazon.com
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        // Go to google https://www.google.com
        Driver.getDriver().get(ConfigReader.getProperty("googleUrl"));
        // Use configReader class
        Driver.closeDriver();
    }
}
