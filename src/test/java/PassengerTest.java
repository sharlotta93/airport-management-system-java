import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PassengerTest {

    private Passenger passenger;

    @Before
    public void before() {
        passenger = new Passenger("Bob", 300);
    }

    @Test
    public void hasName() {
        assertEquals("Bob", passenger.name());
    }

    @Test
    public void hasWallet() {
        assertEquals(300, passenger.totalCash());
    }

    @Test
    public void canPay() {
        passenger.pay(50);
        assertEquals(250, passenger.totalCash());
    }

}
