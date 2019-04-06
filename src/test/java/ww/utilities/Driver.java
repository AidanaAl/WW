package ww.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
    private static WebDriver driver;

    private Driver(){

    }

    public static WebDriver getDriver(){
        if(driver == null){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        }
        return  driver;
    }
//    public static WebDriver getDriver(){
//        if(driver == null){
//            WebDriverManager.chromedriver().setup();
//            driver = new ChromeDriver();
//            String browser=ConfigurationReader.getProperty("browser");
//            switch(browser){
//            case "chrome":
//                WebDriverManager.chromedriver().setup();
//                driver=new ChromeDriver();
//                break;
//            case "firefox":
//                WebDriverManager.firefoxdriver().setup();
//                driver = new FirefoxDriver();
//                break;
//            case "ie":
//                WebDriverManager.iedriver().setup();
//                driver = new InternetExplorerDriver();
//                break;
//            default:
//                WebDriverException issue= new WebDriverException();
//                throw issue;
//
//        }
//    }
//    return driver;
//}

    public static void closeDriver(){
        if(driver != null){
            driver.quit();
            driver = null;
        }
    }

}
