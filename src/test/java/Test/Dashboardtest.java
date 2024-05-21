package Test;

import Base.Testbase;
import Page.Dashboard;
import Util.Testutil;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.awt.*;
@Listeners(Listener.TestListener.class)
public class Dashboardtest extends Testbase {
    Dashboard das;
    Robot sc;

    public Dashboardtest() {
        super();
    }

    @BeforeMethod
    public void setup() throws AWTException {
        Initialization();
        das = new Dashboard();
        sc = new Robot();
    }

    @DataProvider
    public Object[][]getdata(){
Object[][] data = Testutil.getbookname("Books");
return data;
    }

    @Test(dataProvider = "getdata")
    public void search(String Bookname) throws InterruptedException {
        log.info("search for the desired book...");
        Thread.sleep(5000);
       das.setSearch(Bookname);
    }

    @Test
    @Description("Checking Image is displayed or not")
    @Severity(SeverityLevel.CRITICAL)
    @Feature("Search the image")
    @Story("Checking image is displayed or not ")
    public void checkimage() throws InterruptedException {
        log.info("check if image being displayed or not... ");
        Thread.sleep(5000);
        Boolean res = das.checkimg();
        Assert.assertTrue(res);
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    public void checkbio() throws InterruptedException {
        log.info("Navigation to Biography section...");
        sc.mouseWheel(3);
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@class='MuiGrid-root makeStyles-contentFeatured-61 MuiGrid-container MuiGrid-spacing-xs-1 MuiGrid-justify-content-xs-center']//div[1]//div[1]//div[2]//button[1]")).click();

    }

    @Test
    public void cart() throws InterruptedException {
        log.info("Add product into the cart ...");
        Thread.sleep(3000);
        das.checkcart();
    }

    @Test
    public void addtocart() throws InterruptedException {
        log.warn("Check product added into the cart");
        das.addcart();

    }


    @AfterMethod
    public void teardown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}