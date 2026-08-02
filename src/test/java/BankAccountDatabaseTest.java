import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BankAccountDatabaseTest {
    private BankAccountsDatabase db;
    private BankAccount testAccount;

    @BeforeMethod
    public void setUp(){
        db = new BankAccountsDatabase();
        testAccount = new BankAccount();
        testAccount.setPin("7890");
    }

    @Test(groups = "database")
    public void testInitialDatabaseSize(){
        Assert.assertEquals(db.getDatabaseSize(), 0, "Database already has some data!");
    }

    @Test(groups = "database")
    public void OneAccountDatabaseSizeTest(){
        db.addAccount(testAccount);
        Assert.assertEquals(db.getDatabaseSize(), 1, "Database size is not equal 1");
    }

    @Test(groups = "database")
    public void databaseHasAccountTest(){
        db.addAccount(testAccount);
        Assert.assertTrue(db.containsAccount(testAccount), "Database doesn't have that account");
    }

    @Test(groups = "database")
    public void getDatabaseSizeAfterRemoveAccountTest(){
        db.addAccount(testAccount);
        db.removeAccount(testAccount);
        Assert.assertEquals(db.getDatabaseSize(), 0, "Account wasn't removed from Database");
    }

    @Test(groups = "database")
    public void DatabaseNotContainsRemovedAccountTest(){
        db.addAccount(testAccount);
        db.removeAccount(testAccount);
        Assert.assertFalse(db.containsAccount(testAccount), "Database still contain account");
    }

}
