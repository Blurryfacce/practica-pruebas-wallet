import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SmartWalletTest {
    private SmartWallet wallet;

    @BeforeEach
    void setUp() {
        wallet = new SmartWallet();
    }

    @Test
    void testDepositStandard() {
        assertTrue(wallet.deposit(50));
        assertEquals(50.0, wallet.getBalance());
    }

    @Test
    void testWithdrawValid() {
        wallet.deposit(100);
        assertTrue(wallet.withdraw(50));
        assertEquals(50.0, wallet.getBalance());
    }

    @Test
    void testDepositCashbackLimit() {
        // Exactamente 100 no debería dar cashback
        wallet.deposit(100);
        assertEquals(100.0, wallet.getBalance());
        
        // 101 debería dar 1.01 de cashback
        wallet.deposit(100); // Reset mental: saldo ahora es 100
        SmartWallet wallet2 = new SmartWallet();
        wallet2.deposit(200);
        assertEquals(202.0, wallet2.getBalance());
    }

    @Test
    void testMaxBalanceStandard() {
        // Intentar depositar más de 5000
        assertFalse(wallet.deposit(5001));
    }

    @Test
    void testWithdrawAllInactivates() {
        wallet.deposit(100);
        wallet.withdraw(100);
        assertFalse(wallet.isActive());
        assertEquals(0, wallet.getBalance());
    }

    @Test
    void testWithdrawInsufficientFunds() {
        wallet.deposit(50);
        assertFalse(wallet.withdraw(60));
    }

    @Test
    void testNegativeDeposit() {
        assertFalse(wallet.deposit(-10));
    }

    @Test
    void testNegativeWithdraw() {
        wallet.deposit(100);
        assertFalse(wallet.withdraw(-5));
    }
}