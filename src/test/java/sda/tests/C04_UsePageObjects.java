package sda.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import sda.pages.SauceDemo.InventoryPage;
import sda.pages.SauceDemo.LoginPage;
import sda.utilities.ConfigReader;
import sda.utilities.Driver;

public class C04_UsePageObjects {


    @Test
    public void pageObjectTest(){
        //Navigate to https://www.saucedemo.com/
        Driver.getDriver().get(ConfigReader.getProperty("sauceDemoUrl"));
        LoginPage loginPage =new LoginPage();

        //Enter the username as standard_user
        //loginPage.passwordField.sendKeys(ConfigReader.getProperty("SauceDemoUsername"));
        //Enter the password as secret_sauce
        //loginPage.passwordField.sendKeys(ConfigReader.getProperty("SauceDemoPassword"));
        //Click on login button
        //loginPage.loginButton.click();
        loginPage.login(ConfigReader.getProperty("SauceDemoUsername"),
                ConfigReader.getProperty("SauceDemoPassword"));

        //- Choose price low to high with soft Assert.
        InventoryPage inventoryPage = new InventoryPage();
        inventoryPage.selectByIndex(2);

        //- Verify item prices are sorted from low to high with hard Assert.
        SoftAssert sa = new SoftAssert();
        Assert.assertTrue(inventoryPage.getTextOfSelectedOption()
                .contains("Price (low to high)"));
        sa.assertTrue(inventoryPage.getTextOfSelectedOption()
                .contains("Price (low to high)"));
        sa.assertAll();
        Driver.closeDriver();
    }
}
