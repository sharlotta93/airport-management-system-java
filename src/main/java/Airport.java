import com.sun.xml.internal.ws.util.HandlerAnnotationInfo;

import java.util.ArrayList;

public class Airport {

    private String code;
    private ArrayList<Hangar> hangars;

    public Airport(String code, ArrayList hangars) {
        this.code = code;
        this.hangars = hangars;
    }

    public int totalHangars() {
        return hangars.size();
    }

    public String code() {
        return code;
    }

    public void parkPlaneInHangar(Plane plane) {
        for (int i=0 ; i < hangars.size() ; i++) {
            Hangar hangar = this.hangars.get(i);
            if (hangar.isVacant()) {
                hangar.parkPlane(plane);
                return;
            }
        }
    }

    public Plane findBestPlaneForFlight(int wantedCapacity) {
        Plane bestPlane = null;
        for (int i = 0; i < this.hangars.size(); i++) {
            Hangar hangar = this.hangars.get(i);
            Plane plane = hangar.removePlaneFromHangar(wantedCapacity);
            if (plane != null) {
               if (bestPlane == null) {
                    bestPlane = plane;
                } else if (plane.capacity() > wantedCapacity && plane.capacity() < bestPlane.capacity()) {
                 return plane;
                }

            }
        }
        return bestPlane;
    }

    public Plane findSecondBestPlaneForFlight(int wantedCapacity) {
        Plane bestPlane = findBestPlaneForFlight(wantedCapacity);
        return findBestPlaneForFlight(bestPlane.capacity() + 1); //will always return the next bigger one, so if there is 2 planes of the same size if will skip it.

    }

    public Flight createFlight(String number, String destination, int size) {
        Plane plane = findBestPlaneForFlight(size);
        return new Flight(plane, number, destination, 50);
    }

    public void sellTicket(Flight flight, Passenger passenger) {
        flight.sellTicket(passenger);
    }

    public int totalTicketsSold(Flight flight) {
        return flight.ticketsSold();
    }
}
