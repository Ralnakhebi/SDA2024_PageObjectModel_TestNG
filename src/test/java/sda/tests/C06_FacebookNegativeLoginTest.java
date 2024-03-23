package sda.tests;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import sda.pages.FacebookLoginPage;
import sda.utilities.ConfigReader;
import sda.utilities.Driver;

import java.lang.annotation.Repeatable;

public class C06_FacebookNegativeLoginTest {


    @Test(invocationCount = 25)
    public void loginNegativeScenario(){

        Driver.getDriver().get(ConfigReader.getProperty("facebookUrl"));

        FacebookLoginPage facebookLoginPage=new FacebookLoginPage();
        Faker faker=new Faker();
        facebookLoginPage.fakerLogin(faker.internet().emailAddress(),
                faker.internet().password());

        facebookLoginPage.isErrorMessageDisplayed();
    }


}
