package Base;

import Util.Testutil;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import Base.Testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Testbase {

    public static WebDriver driver;
    public static Properties prop;

    public static org.apache.log4j.Logger log = Logger.getLogger(Testbase.class);

    public ExtentReports extentReports = new ExtentReports();
    public ExtentSparkReporter sparkReporter = new ExtentSparkReporter("D:\\intellij_workspace\\React-pom\\Outputfile\\ExtentReport.html");

    String config = "D:\\intellij_workspace\\React-pom\\src\\main\\java\\Config\\Config.properties";

    public  Testbase() {
        try {
            prop = new Properties();

            FileInputStream fis = new FileInputStream(config);
            prop.load(fis);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void Initialization() {
        String browser = prop.getProperty("browser");
        if(browser.equals("chrome")){
            driver = new ChromeDriver();
            log.info("browser name is "+browser);
        }
        driver.manage().window().maximize();
        log.info("url is "+prop.getProperty("url"));
        driver.get(prop.getProperty("url"));

        driver.manage().timeouts().pageLoadTimeout(Testutil.Pageloadtimeout, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Testutil.implicitlywait, TimeUnit.SECONDS);
    }
}
