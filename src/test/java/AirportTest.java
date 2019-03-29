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
        flight = new Flight(plane, "SNT23 22", "London", 50);
        hangarTwo = new Hangar("Green", 3, false);
        hangar = new Hangar("Purple", 4, true);
        hangars = new ArrayList<>();
        hangars.add(hangarTwo);
        hangars.add(hangar);
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
    public void canAllocatePlanesToVacantHangars() {
        airport.parkPlaneInHangar(plane);
        assertEquals(1, hangarTwo.totalPlanes());
    }

    @Test
    public void cannotAllocatePlanesToFullHangar() {
        airport.parkPlaneInHangar(plane);
        airport.parkPlaneInHangar(plane);
        airport.parkPlaneInHangar(plane);
        airport.parkPlaneInHangar(plane);
        assertEquals(3, hangarTwo.totalPlanes());
    }

    @Test
    public void canAllocatePlaneFromHanger() {
        airport.parkPlaneInHangar(plane);
        airport.parkPlaneInHangar(plane);
        Plane plane = airport.chosePlaneForFlight();
        assertEquals("KLM", plane.airline());
    }

    @Test
    public void canCreateFlight() {
        airport.parkPlaneInHangar(plane);
        Flight newFlight = airport.createFlight( "SNT23 22", "Stanstead");
        assertEquals(flight.number(), newFlight.number());
    }

    @Test
    public void canSellTicket() {
        airport.sellTicket(flight, passenger);
        assertEquals(1, flight.ticketsSold());
        assertEquals(350, passenger.totalCash());
    }

    @Test
    public void cannotSellTicketNotEnoughCash() {
        Passenger passenger = new Passenger("Justina", 30);
        airport.sellTicket(flight, passenger);
        assertEquals(0, flight.ticketsSold());
        assertEquals(30, passenger.totalCash());
    }



}
