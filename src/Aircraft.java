public abstract class Aircraft {
    private String type;
    private int seatingCapacity;
    private int weightLifting;

    public void fly(){}

    public Aircraft(String type, int seatingCapacity, int weightLifting) {
        this.type = type;
        this.seatingCapacity = seatingCapacity;
        this.weightLifting = weightLifting;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

    public int getWeightLifting() {
        return weightLifting;
    }

    public void setWeightLifting(int weightLifting) {
        this.weightLifting = weightLifting;
    }
}
