import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BankAccountTest {
    private BankAccount testAccount;

    @BeforeMethod
    public void setUp() {
        testAccount = new BankAccount();
        testAccount.setPin(TestDataHelper.generateRandomPin());
    }

    @AfterMethod
    public void tearDown() {
        testAccount = null;
        System.out.println("The test is finished!");
    }

    @Test(groups = "positive")
    public void testAddMoney() {
        testAccount.addMoney(555.55);
        Assert.assertEquals(testAccount.getBalance(), 555.55, "The balance doesnt charged");
    }

    @Test(groups = "negative")
    public void addNegativeValueOfMoneyTest() {
        testAccount.addMoney(-199.75);
        Assert.assertEquals(testAccount.getBalance(), 0, "Deposit amount must be positive!");
    }

    @Test(groups = "negative")
    public void addZeroMoneyTest() {
        testAccount.addMoney(0);
        Assert.assertEquals(testAccount.getBalance(), 0, "Method doesn't support zero amount of money");
    }

    @Test(groups = "negative")
    public void addBigAmountTest() {
        testAccount.addMoney(999999999.9999);
        Assert.assertEquals(testAccount.getBalance(), 999999999.9999, "Method doesn't accept big amount of money");
    }

    @Test(dataProvider = "depositData", groups = "positive")
    public void testAddMoneyWithProvider(double amount, double expectedBalance) {
        testAccount.addMoney(amount);
        Assert.assertEquals(testAccount.getBalance(), expectedBalance, "The real balance doesn't match the expected one!");
    }

    @DataProvider(name = "depositData")
    public Object[][] provideDepositData() {
        return new Object[][]{
                {100.00, 100.00},
                {758, 758.00},
                {0.01, 0.01},
                {999.99, 999.99}
        };
    }
}
