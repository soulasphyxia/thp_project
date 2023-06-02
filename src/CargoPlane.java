public class CargoPlane extends Plane {
    private String[] listOfCargo;
    public CargoPlane(String type, int seatingCapacity, int weightLifting, String model) {
        super(type, seatingCapacity, weightLifting, model);
    }

    public void load(){}

    public void unload(){}

    public String[] getListOfCargo() {
        return listOfCargo;
    }

    public void setListOfCargo(String[] listOfCargo) {
        this.listOfCargo = listOfCargo;
    }
}
