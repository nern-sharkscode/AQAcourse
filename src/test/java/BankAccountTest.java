import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BankAccountTest {
    private BankAccount testAccount;

    @BeforeMethod
    public void setUp(){
        testAccount = new BankAccount();
        testAccount.setPin(TestDataHelper.generateRandomPin());
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

    @DataProvider(name = "depositData")
    public Object[][] provideDepositData(){
        return new Object[][]{
                {100.00, 100.00},
                {758, 758.00},
                {0.01, 0.01},
                {999.99, 999.99}
        };
    }

    @Test(dataProvider = "depositData", groups = "positive")
    public void testAddMoneyWithProvider(double amount, double expectedBalance){
        testAccount.addMoney(amount);
        Assert.assertEquals(testAccount.getBalance(), expectedBalance, "The rel balance doesn't match the expected one!");
    }
}
