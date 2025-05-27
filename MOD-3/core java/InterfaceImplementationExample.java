// InterfaceImplementationExample.java

// Define the interface
interface Playable {
    void play(); // abstract method
}

// Implement the interface in Guitar class
class Guitar implements Playable {
    public void play() {
        System.out.println("Strumming the guitar...");
    }
}

// Implement the interface in Piano class
class Piano implements Playable {
    public void play() {
        System.out.println("Playing the piano...");
    }
}

// Main class to test the implementation
public class InterfaceImplementationExample {
    public static void main(String[] args) {
        // Instantiate Guitar and Piano
        Playable myGuitar = new Guitar();
        Playable myPiano = new Piano();

        // Call play() on both
        myGuitar.play(); // Output: Strumming the guitar...
        myPiano.play();  // Output: Playing the piano...
    }
}
