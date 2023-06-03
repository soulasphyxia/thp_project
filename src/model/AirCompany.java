package model;

import java.util.ArrayList;

public class AirCompany {
    private String director;
    private int annualIncome;
    private final ArrayList<Plane> listOfPlanes;


    public int getTotalCapacity(){
        int s = 0;
        for(Plane plane : listOfPlanes){
            s += plane.getSeatingCapacity();
        }
        return s;
    }

    public AirCompany(String director, int annualIncome, ArrayList<Plane> listOfPlanes) {
        this.director = director;
        this.annualIncome = annualIncome;
        this.listOfPlanes = listOfPlanes;
    }


    public Plane[] getPlanes() {
        return listOfPlanes.toArray(new Plane[0]);
    }

    public void addPlane(Plane plane) {
        listOfPlanes.add(plane);
    }

    public void deletePlane(int index) {
        listOfPlanes.remove(index);
    }

    public Plane getPlane(int index) {
        return listOfPlanes.get(index);
    }
}
