import java.util.Arrays;
import java.util.Date;
public class AirCompany {
    private String director;
    private int annualIncome;
    private Plane[] listOfPlanes;


    public int getTotalCapacity(){
        int s = 0;
        for(Plane plane : listOfPlanes){
            s += plane.getSeatingCapacity();
        }
        return s;
    }

    public AirCompany(String director, int annualIncome, Plane[] listOfPlanes) {
        this.director = director;
        this.annualIncome = annualIncome;
        this.listOfPlanes = listOfPlanes;
    }

    public void BookAPlane(Plane plane, Date date){}


    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getAnnualIncome() {
        return annualIncome;
    }

    public void setAnnualIncome(int annualIncome) {
        this.annualIncome = annualIncome;
    }

    public Plane[] getListOfPlanes() {
        return listOfPlanes;
    }

    public void setListOfPlanes(Plane[] listOfPlanes) {
        this.listOfPlanes = listOfPlanes;
    }
}
