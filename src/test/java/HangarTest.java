import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HangarTest {

    private Hangar hangar;
    private Plane plane;

    @Before
    public void before() {
        plane = new Plane(PlaneType.DREAMLINER, Airline.KLM);
        hangar = new Hangar("Blue", 5);

    }

    @Test
    public void hasName() {
        assertEquals("Blue", hangar.name());
    }

    @Test
    public void startsOfEmpty() {
        assertEquals(0, hangar.totalPlanes());
    }

    @Test
    public void canAddPlane() {
        hangar.parkPlane(plane);
        assertEquals(1, hangar.totalPlanes());
    }

    @Test
    public void cannotAddPlaneWhenAtCapacity() {
        Hangar hangarTwo = new Hangar("Green", 1);
        hangarTwo.parkPlane(plane);
        hangarTwo.parkPlane(plane);
        assertEquals(1, hangarTwo.totalPlanes());
    }

    @Test
    public void canRemovePlaneFromHangar() {
        Plane planeTwo = new Plane(PlaneType.AIRBUS, Airline.AEROFLOT);
        hangar.parkPlane(planeTwo);
        hangar.parkPlane(plane);
        Plane wantedPlane = hangar.removePlaneFromHangar(244);
        assertEquals(1, hangar.totalPlanes());
        assertEquals(PlaneType.DREAMLINER, wantedPlane.type());
    }



}
