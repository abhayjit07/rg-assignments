interface Vehicle {
    void start();

    default void fuelType() {
        System.out.println("Fuel type is Petrol");
    }

    // Static method in interface
    static void company() {
        System.out.println("Company: Generic Motors");
    }
}
public class Car implements Vehicle {
    public void start() {
        System.out.println("Car has started.");
    }

    public static void main(String[] args) {
        Car car = new Car();
        car.start();
        car.fuelType();
        Vehicle.company();
    }
}
