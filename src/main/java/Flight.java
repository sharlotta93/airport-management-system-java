import java.util.ArrayList;

public class Flight {

    private Plane plane;
    private String number;
    private String destination;
    private ArrayList tickets;

    public Flight(Plane plane, String number, String destination) {
        this.plane = plane;
        this.number = number;
        this.destination = destination;
        this.tickets = new ArrayList<>();
    }

    public PlaneType assignedPlane() {
        return plane.type();
    }

    public String number() {
        return this.number;
    }

    public String destination() {
        return this.destination;
    }

    public int ticketsSold() {
        return this.tickets.size();
    }

    public int totalSeatsAvailable() {
        int ticketsAvailable = plane.capacity();
        return ticketsAvailable;
    }

    public void sellTicket() {
        if (ticketsSold() < totalSeatsAvailable()) {
            this.tickets.add(1);
        }
    }
}

