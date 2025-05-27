import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LambdaSortExample {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();

        // Add some strings to the list
        names.add("Charlie");
        names.add("Alice");
        names.add("Bob");
        names.add("Diana");

        System.out.println("Before sorting: " + names);

        // Sort using a lambda expression (alphabetical order)
        Collections.sort(names, (s1, s2) -> s1.compareTo(s2));

        System.out.println("After sorting: " + names);
    }
}
