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
        hangarTwo = new Hangar("Green", 3);
        hangar = new Hangar("Purple", 4);
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
    public void canAllocateBestPlaneFromHanger() {
        Plane newPlane = new Plane(PlaneType.BOEING, Airline.BRITISHAIRWAYS);
        airport.parkPlaneInHangar(newPlane);
        airport.parkPlaneInHangar(plane);
        airport.parkPlaneInHangar(plane);
        Plane plane = airport.findBestPlaneForFlight(244);
        assertEquals("KLM", plane.airline());
    }

    @Test
    public void canAllocateSecondBestPlaneFromHanger() {
        Plane newPlane = new Plane(PlaneType.BOEING, Airline.BRITISHAIRWAYS);
        airport.parkPlaneInHangar(plane);
        airport.parkPlaneInHangar(newPlane);
        Plane wantedPlane = airport.findSecondBestPlaneForFlight(244);
        assertEquals(366, wantedPlane.capacity());
    }

    @Test
    public void canCreateFlight() {
        airport.parkPlaneInHangar(plane);
        Flight newFlight = airport.createFlight( "SNT23 22", "Stanstead", 244);
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

    @Test
    public void canTrackTicketsSold() {
        airport.sellTicket(flight, passenger);
        airport.sellTicket(flight, passenger);
        airport.sellTicket(flight, passenger);
        assertEquals(3, airport.totalTicketsSold(flight));
    }

    @Test
    public void canTrackTicketsSoldForIndividualFlights() {
        Flight flightTwo = new Flight(plane, "BRS23 00", "Brussels", 100);
        airport.sellTicket(flightTwo, passenger);
        airport.sellTicket(flightTwo, passenger);
        airport.sellTicket(flight, passenger);
        assertEquals(1, airport.totalTicketsSold(flight));
        assertEquals(2, airport.totalTicketsSold(flightTwo));
    }

    @Test
    public void cannotSellTicketsForFullFlight() {
        Plane privateJet = new Plane(PlaneType.TEST, Airline.NORWEGIANAIRSHUTTLE);
        Flight newFlight = new Flight(privateJet, "NYC6 66", "NYC", 30000);
        Passenger passenger = new Passenger("Mr Robot", 50000);
        airport.sellTicket(newFlight, passenger);
        airport.sellTicket(newFlight, passenger);
        assertEquals(1, airport.totalTicketsSold(newFlight));
    }

}
