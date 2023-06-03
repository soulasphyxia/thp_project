package model;

import model.Aircraft;

public abstract class Plane extends Aircraft {
    private String model;
    protected int fuelStatus;
    private String pilot;

    public Plane(int seatingCapacity,String model) {
        super(seatingCapacity);
        this.model = model;
    }
    public void refuel(){}
    public void getConnectionToOperator(){}

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return this.model + " capacity: " + this.getSeatingCapacity();
    }
}
