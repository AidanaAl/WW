package ww.utilities;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class TestBase {

    public WebDriver driver;
    public Faker fake = new Faker();
    protected SoftAssert softAssert;
    protected Actions actions;

    public final String fakeEmail = fake.internet().emailAddress();
    public final String fakeName = fake.name().firstName();
    public final String fakeLastName = fake.name().lastName();
    public final String fakePassword = fake.internet().password();
    public final String fakeAddress = fake.address().streetAddress();
    public final String fakeCity = fake.address().city();
    public final String fakeState = fake.address().state();
    public final String US = "United States";
    public final String fakeZipcode = fake.address().zipCode();
    public final String fakePhone = fake.phoneNumber().cellPhone();
    public final String fakeAddr = fake.address().streetAddress();

    public final double RandomNumber = Math.random();
    public final int DAY = fake.number().numberBetween(1, 31);
    public final int MONTH = fake.number().numberBetween(1, 12);
    public final int YEAR = fake.number().numberBetween(1950, 2000);


    @BeforeMethod
    public void setUpMethod() {
        driver = Driver.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        actions = new Actions(driver);
        softAssert = new SoftAssert();
    }

    @AfterMethod
    public void quite() {
        Driver.closeDriver();
        softAssert.assertAll();
    }

}

