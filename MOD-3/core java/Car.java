// Car.java

public class Car {
    // Attributes
    String make;
    String model;
    int year;

    // Constructor to initialize the car's attributes
    public Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    // Method to display car details
    public void displayDetails() {
        System.out.println("Car Details:");
        System.out.println("Make : " + make);
        System.out.println("Model: " + model);
        System.out.println("Year : " + year);
        System.out.println();
    }

    // Main method to create objects and call displayDetails()
    public static void main(String[] args) {
        // Creating Car objects
        Car car1 = new Car("Toyota", "Camry", 2022);
        Car car2 = new Car("Honda", "Civic", 2020);

        // Display details for each car
        car1.displayDetails();
        car2.displayDetails();
    }
}
