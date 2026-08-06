import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BankAccountDatabaseTest {
    private BankAccountsDatabase db;
    private BankAccount testAccount;

    @BeforeMethod
    public void setUp() {
        db = new BankAccountsDatabase();
        testAccount = new BankAccount();
        testAccount.setPin("7890");
    }

    @AfterMethod
    public void testFinish() {
        System.out.println("The test is finished");
    }

    @Test(groups = "positive")
    public void testInitialDatabaseSize() {
        Assert.assertEquals(db.getDatabaseSize(), 0, "Database already has some data!");
    }

    @Test(groups = "positive")
    public void oneAccountDatabaseSizeTest() {
        TestDataHelper.addAccountToDB(testAccount, db);
        Assert.assertEquals(db.getDatabaseSize(), 1, "Database size is not equal 1");
    }

    @Test(groups = "positive")
    public void databaseHasAccountTest() {
        TestDataHelper.addAccountToDB(testAccount, db);
        Assert.assertTrue(db.containsAccount(testAccount), "Database doesn't have that account");
    }

    @Test(groups = "positive")
    public void getDatabaseSizeAfterRemoveAccountTest() {
        TestDataHelper.addAccountToDB(testAccount, db);
        db.removeAccount(testAccount);
        Assert.assertEquals(db.getDatabaseSize(), 0, "Account wasn't removed from Database");
    }

    @Test(groups = "positive")
    public void databaseNotContainsRemovedAccountTest() {
        TestDataHelper.addAccountToDB(testAccount, db);
        db.removeAccount(testAccount);
        Assert.assertFalse(db.containsAccount(testAccount), "Database still contain account");
    }
}
