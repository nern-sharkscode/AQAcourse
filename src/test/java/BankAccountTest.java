import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BankAccountTest {
    private BankAccount testAccount;

    @BeforeMethod
    public void setUp(){
        testAccount = new BankAccount();
        testAccount.setPin("7777");
    }

    @AfterMethod
    public void tearDown(){
        testAccount = null;
        System.out.println("The test is finished!");
    }

    @Test(groups = "positive")
    public void testAddMoney(){
        testAccount.addMoney(555.55);
        Assert.assertEquals(testAccount.getBalance(), 555.55, "The balance doesnt charged");
    }
}
