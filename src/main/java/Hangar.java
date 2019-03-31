import java.util.ArrayList;

public class Hangar {

    private int capacity;
    private String name;
    private ArrayList<Plane> planes;

    public Hangar(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
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
        if (isVacant()) {
            planes.add(plane);
        }
    }

    public Plane removePlaneFromHangar(int size) {
        if (planes.size() == 0) return null; //if hangar is empty return null

        Plane bestPlane = null;

        for (int i = 0; i < planes.size(); i++) {
            Plane currentPlane = planes.get(i);
            if (currentPlane.capacity() >= size) {
                if (bestPlane == null || currentPlane.capacity() < bestPlane.capacity()) {
                    bestPlane = currentPlane;
                }
            }
        }
        planes.remove(bestPlane);
        return bestPlane;
    }

}





