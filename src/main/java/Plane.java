import java.util.ArrayList;

public class Plane {

    private PlaneType type;
    private Airline airline;
    private ArrayList<Passenger> passengers;

    public Plane(PlaneType type, Airline airline) {
        this.type = type;
        this.airline = airline;
        this.passengers = new ArrayList<>();

    }

    public PlaneType type() {
        return type;
    }

    public int capacity() {
        return this.type.getCapacity();
    }

    public String airline() {
        return airline.getName();
    }

    public int totalPassengers() {
        return passengers.size();
    }

    public void addPassenger(Passenger passenger) {
        if (capacity() > totalPassengers()) {
            this.passengers.add(passenger);
        }
    }


}


