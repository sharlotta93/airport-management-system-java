import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FlightTest {

    private Flight flight;
    private Plane plane;
    private Passenger passenger;

    @Before
    public void before() {
        plane = new Plane(PlaneType.DREAMLINER, Airline.KLM);
        passenger = new Passenger("Mark", 400);
        flight = new Flight(plane, "ENV34 120", "London");

    }

    @Test
    public void hasPlane() {
        assertEquals(PlaneType.DREAMLINER, flight.assignedPlane());
    }

    @Test
    public void hasFlightNumber() {
        assertEquals("ENV34 120", flight.number());
    }

    @Test
    public void hasDestination() {
        assertEquals("London", flight.destination());
    }

    @Test
    public void startsOfWithNoTicketsSold() {
        assertEquals(0, flight.ticketsSold());
    }

    @Test
    public void canHaveSoldTickets() {
        flight.sellTicket();
        assertEquals(1, flight.ticketsSold());
    }
}
