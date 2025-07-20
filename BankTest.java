package bank;

public class BankTest {

    public static void main(String[] args) {
        // Test BankAccount
        BankAccount ba = new BankAccount();
        ba.setFirstName("John");
        ba.setLastName("Doe");
        ba.setAccountID(1001);
        ba.deposit(500);
        ba.withdrawal(100);
        ba.accountSummary();

        System.out.println();

        // Test CheckingAccount
        CheckingAccount ca = new CheckingAccount();
        ca.setFirstName("Jane");
        ca.setLastName("Smith");
        ca.setAccountID(2002);
        ca.setInterestRate(0.02);  // 2%
        ca.deposit(300);

        ca.displayAccount();

        System.out.println("\nAttempting normal withdrawal of $100:");
        ca.processWithdrawal(100);  // Normal withdrawal

        System.out.println("\nAttempting overdraft withdrawal of $250:");
        ca.processWithdrawal(250);  // Overdraft withdrawal with fee

        System.out.println();
        ca.displayAccount();
    }
}
