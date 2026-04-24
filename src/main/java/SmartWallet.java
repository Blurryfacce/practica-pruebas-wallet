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
}