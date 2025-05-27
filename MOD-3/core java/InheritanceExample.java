// InheritanceExample.java

// Base class
class Animal {
    public void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

// Subclass that inherits from Animal
class Dog extends Animal {
    // Overriding the makeSound() method
    @Override
    public void makeSound() {
        System.out.println("Bark");
    }
}

// Main class to test the inheritance
public class InheritanceExample {
    public static void main(String[] args) {
        // Instantiate Animal and Dog objects
        Animal genericAnimal = new Animal();
        Dog myDog = new Dog();

        // Call makeSound() on both
        genericAnimal.makeSound();  // Output: Animal makes a sound
        myDog.makeSound();          // Output: Bark
    }
}
