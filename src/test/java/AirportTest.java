import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class AirportTest {

    private Flight flight;
    private Plane plane;
    private Hangar hangar;
    private Hangar hangarTwo;
    private ArrayList<Hangar> hangars;
    private Passenger passenger;
    private Airport airport;

    @Before
    public void before() {
        plane = new Plane(PlaneType.DREAMLINER, Airline.KLM);
        passenger = new Passenger("Mark", 400);
        flight = new Flight(plane, "SNT23 22", "London");
        hangar = new Hangar("Purple", 4, true);
        hangarTwo = new Hangar("Green", 3, false);
        hangars = new ArrayList<>();
        hangars.add(hangar);
        hangars.add(hangarTwo);
        airport = new Airport("AMST", hangars);

    }

    @Test
    public void hasHangars() {
        assertEquals(2, airport.totalHangars());
    }

    @Test
    public void hasAirportCode() {
        assertEquals("AMST", airport.code());
    }

    @Test
    public void canCreateFlight() {
        Flight newFlight = airport.createFlight(plane, "SNT23 22", "Stanstead");
        assertEquals(flight.number(), newFlight.number());
    }

}
