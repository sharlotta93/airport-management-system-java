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

    public Hangar findFullestHangar() {
        Hangar fullestHangar = this.hangars.get(0);
        for (int i=1 ; i < this.hangars.size() ; i++) {
            Hangar hangar = this.hangars.get(i);
            if (hangar.totalPlanes() > fullestHangar.totalPlanes()) {
                fullestHangar = hangar;
            }
        }
        return fullestHangar;
    }

    public Plane chosePlaneForFlight() {
        Hangar hangar = findFullestHangar();
            return hangar.planeReadyForBoarding();
    }

    public Flight createFlight(String number, String destination) {
        Plane plane = chosePlaneForFlight();
        return new Flight(plane, number, destination, 50);
    }

    public void sellTicket(Flight flight, Passenger passenger) {
        flight.sellTicket(passenger);
    }
}
