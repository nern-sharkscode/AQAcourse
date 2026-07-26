import java.lang.reflect.Array;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Java Bank ATM!");
        BankAccount shortName = new BankAccount();
        createAccount(shortName, scanner);
        while (true) {
            System.out.println("Choose an option:\n" +
                    "1. Enter 1 - to check the balance\n" +
                    "2. Enter 2 - to add money\n" +
                    "3. Enter 3 - to withdraw money");
            switch (scanner.nextLine()) {
                case "1":
                    if (verifyPin(shortName, scanner)) {
                        System.out.println("Your balance = " + shortName.getBalance() + "\n");
                    }
                    break;

                case "2":
                    if (verifyPin(shortName, scanner)) {
                        System.out.println("Enter amount of money");
                        double amount = Double.parseDouble(scanner.nextLine());
                        shortName.addMoney(amount);
                    }
                    break;

                case "3":
                    if (verifyPin(shortName, scanner)) {
                        System.out.println("Enter amount of money");
                        double amountForWithdraw = Double.parseDouble(scanner.nextLine());
                        shortName.withdrawMoney(amountForWithdraw);
                    }
                    break;
                default:
                    System.out.println("Incorrect option, try again!");
            }
        }
    }

    public static boolean verifyPin(BankAccount user, Scanner scanner) {
        boolean result;
        while (true) {
            System.out.println("Please enter your PIN code:");

            if (user.checkPin(scanner.nextLine())) {
                result = true;
                break;
            } else {
                System.out.println("Wrong password!\n Enter 1 - to try again\n Enter 2 - for exit to main menu");
                String userSubMenuChoice = scanner.nextLine();
                if (userSubMenuChoice.equals("1")) {
                    continue;
                } else {
                    if (userSubMenuChoice.equals("2")) {
                        result = false;
                        break;
                    }
                }
            }
        }
        return result;
    }

    ;

    public static void createAccount(BankAccount user, Scanner scanner) {
        System.out.println("Creating a new account...");
        System.out.println("Enter the Fullname");
        user.setFullName(scanner.nextLine());
        System.out.println("Create the pin to safety use your data");
        user.setPin(scanner.nextLine());
        System.out.println("Account for " + user.getFullName() + " is created!\n The account number = " + user.getAccountNumber());
        return;
    }
}
