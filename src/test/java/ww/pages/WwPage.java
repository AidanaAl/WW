package ww.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ww.utilities.ConfigurationReader;
import ww.utilities.Driver;

public class WwPage {

    public WwPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[@class='find-a-meeting']")
    public WebElement findAStudio;

    @FindBy(id = "meetingSearch")
    public WebElement searhBox;

    @FindBy(xpath = "//button[@type='button']")
    public WebElement searchButton;

    @FindBy(xpath = "(//span[@ng-if='!linkName'])[1]")
    public WebElement firstResult;

    @FindBy(xpath = "(//div[@class='location__distance'])[1]")
    public WebElement firstDistance;




    //Open browser and go to url:
    public void openUrl(){
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }
}
