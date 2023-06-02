public class Main {
    public static void main(String[] args) {
        AirCompany airCompany = AircompanyFactory.createAirCompany();
        System.out.println("Общая вместимость авиакомпании: " + airCompany.getTotalCapacity());
    }
}
