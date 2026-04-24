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
}