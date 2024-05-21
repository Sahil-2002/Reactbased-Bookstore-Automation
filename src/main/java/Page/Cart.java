package Page;

import Base.Testbase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Cart extends Testbase {

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div[3]/div/a/span[2]")
    WebElement checkout;
    @FindBy(xpath = "//div[@class='MuiToolbar-root MuiToolbar-regular MuiToolbar-gutters']")
    WebElement clickonaddtocartlogo;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/h6/a")
    WebElement startaddsome;
    @FindBy(name = "firstName")
    WebElement firstname;
    @FindBy(name = "lastName")
    WebElement lastname;
    @FindBy(name = "address1")
    WebElement address;
    @FindBy(name = "email")
    WebElement email;
    @FindBy(name = "city")
    WebElement city;

    public Cart() {
        PageFactory.initElements(driver, this);
    }

    public void Startaddsome() {
        startaddsome.click();
    }

    public void setClickonaddtocartlogo() {
        clickonaddtocartlogo.click();
    }

    public void clickcheckout() {
        checkout.click();
    }

    public void fname() {
        firstname.sendKeys("Sahil");
    }

    public void lname() {
        lastname.sendKeys("Khandekar");
    }

    public void setAddress() {
        address.sendKeys("abc");
    }

    public void setEmail() {
        email.sendKeys("sahil@gmail.com");
    }

    public void setCity() {
        city.sendKeys("Mumbai");
    }


}
