public class TestDataHelper {
    public static void addAccountToDB(BankAccount account, BankAccountsDatabase db){
        db.addAccount(account);
    }

    public static String generateRandomPin() {
        int randomInt = (int) (Math.random() * 9000) + 1000;
        return String.valueOf(randomInt);
    }
}
