import java.util.ArrayList;

public class Hangar {

    private int capacity;
    private String name;
    private boolean vacant;
    private ArrayList<Plane> planes;

    public Hangar(String name, int capacity, boolean vacant) {
        this.name = name;
        this.capacity = capacity;
        this.vacant = vacant;
        this.planes = new ArrayList<>();
    }

    public String name() {
        return this.name;
    }

    public int capacity() {
        return this.capacity;
    }

    public int totalPlanes() {
        return this.planes.size();
    }

    public boolean isVacant() {
        if (capacity() > totalPlanes()) {
            return true;
        }
        return false;
    }


}
