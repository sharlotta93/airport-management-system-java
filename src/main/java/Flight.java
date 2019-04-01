import java.util.ArrayList;

public class Flight {

    private Plane plane;
    private String number;
    private String destination;
    private ArrayList<Integer> tickets;
    private int price;

    public Flight(Plane plane, String number, String destination, int price) {
        this.plane = plane;
        this.number = number;
        this.destination = destination;
        this.tickets = new ArrayList<>();
        this.price = price;
    }

    public PlaneType assignedPlane() {
        return plane.type();
    }

    public String number() {
        return this.number;
    }

    public String destination() {
        return destination;
    }

    public int ticketsSold() {
        return tickets.size();
    }

    public int totalSeatsAvailable() {
        int ticketsAvailable = plane.capacity();
        return ticketsAvailable;
    }

    public void sellTicket(Passenger passenger) {
        if (ticketsSold() < totalSeatsAvailable()) {
            if (passenger.totalCash() > this.price) {
                tickets.add(1);
                plane.addPassenger(passenger);
                passenger.pay(this.price);
            }
        }
    }
}

