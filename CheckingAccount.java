package bank;

public class CheckingAccount extends BankAccount {
    private double interestRate;
    private final double overdraftFee = 30.0;

    // Constructor
    public CheckingAccount() {
        super();  // Calls BankAccount constructor
        this.interestRate = 0.0;
    }

    // Getter and Setter for interestRate
    public double getInterestRate() {
        return interestRate;
    }
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    // processWithdrawal allows overdraft and charges a fee
    public void processWithdrawal(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
            return;
        }

        double currentBalance = getBalance();

        if (amount > currentBalance) {
            // Overdraft withdrawal allowed with fee
            double newBalance = currentBalance - amount - overdraftFee;
            System.out.printf("Overdraft! Withdrawal amount: $%.2f plus a $30 overdraft fee charged.\n", amount);
            // Update balance forcibly (needs reflection: balance is private in superclass)
            // So we can use deposit(-value) trick or create protected setter or override methods:
            // Let's add protected setter in BankAccount for balance for subclass to access.

            // Because balance is private, we need a setter or protected method in BankAccount.
            // Let's assume we add a protected method setBalance in BankAccount.

            setBalance(newBalance);

            System.out.printf("New balance (including overdraft fee): $%.2f\n", newBalance);
        } else {
            // Normal withdrawal
            withdrawal(amount);
            System.out.printf("Withdrawal of $%.2f processed.\n", amount);
        }
    }

    // Override displayAccount to show all BankAccount info + interest rate
    public void displayAccount() {
        accountSummary();
        System.out.printf("Interest Rate: %.2f%%\n", interestRate * 100);
    }

    // Need to add a protected setter in BankAccount for balance for this to work
    protected void setBalance(double newBalance) {
        // This method will be overridden by BankAccount, 
        // but since balance is private, this is a workaround to let subclass modify balance
        // We'll implement this in BankAccount as protected
    }
}

