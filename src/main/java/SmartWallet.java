public class SmartWallet {
    private double balance;
    private boolean isActive;
    private String userType;

    public SmartWallet() {
        this.balance = 0.0;
        this.isActive = true;
        this.userType = "Standard";
    }

    public double getBalance() {
        return balance;
    }

    public boolean isActive() {
        return isActive;
    }

    public boolean deposit(double amount) {
        if (amount <= 0) return false;

        double cashback = 0;
        if (amount > 100) {
            cashback = amount * 0.01;
        }

        double totalDeposit = amount + cashback;

        if (userType.equals("Standard") && (balance + totalDeposit > 5000)) {
            return false;
        }

        balance += totalDeposit;
        return true;
    }
    
    public boolean withdraw(double amount) {
        if (amount <= 0 || amount > balance) {
            return false;
        }

        balance -= amount;

        if (balance == 0) {
            isActive = false;
        }

        return true;
    }
}