public abstract class Plane extends Aircraft {
    private String model;
    protected int fuelStatus;
    private String pilot;

    public Plane(String type, int seatingCapacity, int weightLifting, String model) {
        super(type, seatingCapacity, weightLifting);
        this.model = model;
    }
    public void refuel(){}
    public void getConnectionToOperator(){}
}
