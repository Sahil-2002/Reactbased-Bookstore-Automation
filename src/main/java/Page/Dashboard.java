package Page;

import Base.Testbase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboard extends Testbase {

    @FindBy(xpath = "//input[@placeholder='Which book are you looking for?']")
    WebElement search;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/main/div[2]/img")
    WebElement img;
    @FindBy(xpath = "//div[@class='makeStyles-buttonSection-64']//div[1]//a[1]")
    WebElement biography;
    @FindBy(xpath = "//div[@class='makeStyles-buttonSection-64']//div[1]//a[1]")
    WebElement fiction;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/main/div[3]/div/div[1]/a/button")
    WebElement manga;
    @FindBy(xpath = "//span[@class='MuiBadge-root']//*[name()='svg']")
    WebElement cart;
    @FindBy(xpath = "//div[@class='MuiToolbar-root MuiToolbar-regular MuiToolbar-gutters']")
    WebElement addtocart;


    public Dashboard() {
        PageFactory.initElements(driver, this);
    }

    public WebElement setSearch(String bookname) {
        search.click();
        search.sendKeys(bookname);
        return search;
    }

    public boolean checkimg() {
        boolean result = img.isDisplayed();
        return result;
    }

    public void checkbiography() {
        biography.click();

    }

    public void checkfiction() {
        fiction.click();
    }

    public void checkmanga() {
        manga.click();

    }

    public Cart checkcart() {
        cart.click();
        return new Cart();
    }

    public void addcart() throws InterruptedException {
        addtocart.click();


    }

}
