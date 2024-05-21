package Test;

import Base.Testbase;
import Page.Cart;
import Page.Dashboard;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(Listener.TestListener.class)
public class CartTest extends Testbase {
    Cart cart;
    Dashboard das;

    public CartTest() {
        super();
    }

    @BeforeMethod
    public void setup() {
        Initialization();
        cart = new Cart();
        das = new Dashboard();
        das.checkcart();
    }

    @Test
    public void addtocart() throws InterruptedException {
        cart.Startaddsome();
        Thread.sleep(3000);
        cart.setClickonaddtocartlogo();
    }


}
