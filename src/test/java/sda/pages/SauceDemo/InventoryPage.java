package sda.pages.SauceDemo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import sda.utilities.Driver;

public class InventoryPage {
    public InventoryPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(tagName = "select")
    public WebElement filterDropDown;

    @FindBy(xpath = "//*[@class='active_option']")
    public WebElement selectedOption;
    public void selectByIndex(int index){
        Select select = new Select(filterDropDown);
        select.selectByIndex(index);
    }

    public void selectByVisibleText(String text){
        Select select = new Select(filterDropDown);
        select.selectByVisibleText(text);
    }

    public String getTextOfSelectedOption(){
        return selectedOption.getText();
    }
}

