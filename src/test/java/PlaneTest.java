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
//
//    @Test
//    public void canFindPassenger() {
//        Passenger passenger2 = new Passenger("Vivian", 6000);
//        Passenger passenger3 = new Passenger("Bob", 300);
//        Passenger passenger4 = new Passenger("Daniel", 300);
//        plane.addPassenger(passenger2);
//        plane.addPassenger(passenger3);
//        plane.addPassenger(passenger3);
//        plane.addPassenger(passenger2);
//        plane.addPassenger(passenger4);
//        Passenger wantedPassenger = plane.findPassenger("Mark");
//        assertEquals("Mark", wantedPassenger);
//    }

}
