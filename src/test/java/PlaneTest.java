import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class PlaneTest {

    private Plane plane;
    private Passenger passenger;

    @Before
    public void before() {
        plane = new Plane(PlaneType.DREAMLINER, Airline.KLM);
        passenger = new Passenger("Mark", 400);

    }

    @Test
    public void hasType() {
        assertEquals(PlaneType.DREAMLINER, plane.type());
    }

    @Test
    public void hasCapacity() {
        assertEquals(244, plane.capacity());
    }

    @Test
    public void hasAirline() {
        assertEquals("KLM", plane.airline());
    }

    @Test
    public void startsOfEmpty() {
        assertEquals(0, plane.totalPassengers());
    }

    @Test
    public void canAddPassenger() {
        plane.addPassenger(passenger);
        assertEquals(1, plane.totalPassengers());
    }

}
