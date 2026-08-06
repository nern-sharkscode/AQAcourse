public class BankAccount {

    long min = 1_000_000_000_000_000L;
    long max = 9_999_999_999_999_999L;
    private Long accountNumber = min + (long) (Math.random() * (max - min + 1));
    private String fullName;
    private double balance = 0.0;
    private String pin;

    public void addMoney(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("Deposit amount must be positive!");
        }
    }

    public void withdrawMoney(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("You don't have enough money on your balance");
        }
    }

    public boolean checkPin(String userUncheckedPin) {
        if (userUncheckedPin.equals(this.pin)) {
            return true;
        } else
            return false;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public double getBalance() {
        return balance;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }
}
