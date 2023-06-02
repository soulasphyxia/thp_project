public class AircompanyFactory {
    public static AirCompany createAirCompany() {
        Plane[] planes = {
                new PassengerPlane("passenger",
                        100,
                        150,
                        "Boeing-747"),
                new CargoPlane("cargo",
                        10,
                        5000,
                        "AN-26")
        };

        return new AirCompany("Ivanov I.I", 10000,planes);
    }
}
