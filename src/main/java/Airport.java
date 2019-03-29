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

    public Flight createFlight(Plane plane, String number, String destination) {
        return new Flight(plane, number, destination);
    }
}


