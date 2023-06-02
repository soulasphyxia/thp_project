public class PassengerPlane extends Plane {
    private String[] crew;
    private String[] classes;
    private boolean restaurant;

    public PassengerPlane(String type, int seatingCapacity, int weightLifting, String model) {
        super(type, seatingCapacity, weightLifting, model);

    }


    public void makeReservation(){}

    public void callStewardess(){}

    public boolean hasRestaraunt() {
        return restaurant;
    }

    public String[] getCrew() {
        return crew;
    }

    public void setCrew(String[] crew) {
        this.crew = crew;
    }

    public String[] getClasses() {
        return classes;
    }

    public void setClasses(String[] classes) {
        this.classes = classes;
    }
}
