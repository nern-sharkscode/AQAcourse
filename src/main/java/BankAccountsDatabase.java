import java.util.ArrayList;
import java.util.List;

public class BankAccountsDatabase {
    private List<BankAccount> accounts = new ArrayList<>();

    public void addAccount(BankAccount account){
        accounts.add(account);
    }

    public void removeAccount(BankAccount account){
        accounts.remove(account);
    }

    public boolean containsAccount(BankAccount account){
       return accounts.contains(account);
    }

    public int getDatabaseSize(){
        return accounts.size();
    }
}
