import model.AirCompany;
import model.CargoPlane;
import model.PassengerPlane;
import model.Plane;

import java.util.ArrayList;
import java.util.List;

public class AircompanyFactory {
    private static final ArrayList<Plane> planes = new ArrayList<>(List.of(
            new PassengerPlane(
                    100,
                    "Boeing-747"),
            new CargoPlane(
                    10,
                    "AN-26")
    ));
    public static AirCompany createAirCompany() {
        return new AirCompany("Ivanov I.I", 10000,planes);
    }

}
