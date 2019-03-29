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
        return name;
    }

    public int capacity() {
        return capacity;
    }

    public int totalPlanes() {
        return planes.size();
    }

    public boolean isVacant() {
        return (capacity() > totalPlanes()); //shortcut for if statement
    }

    public void parkPlane(Plane plane) {
        if (isVacant() == true) {
            planes.add(plane);
        }
    }


}
