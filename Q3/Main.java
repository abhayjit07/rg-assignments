import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        // Example 1: Creating an Optional with a non-null value
        Optional<String> name = Optional.of("Abhayjit");

        // Example 2: Handling a potentially null value
        String input = null;
        Optional<String> possibleValue = Optional.ofNullable(input);

        // Example 3: Safe access using orElse
        String output = possibleValue.orElse("Default Name");
        System.out.println("Output: " + output);  // Output: Default Name

        // Example 4: ifPresent to run a block only when value exists
        name.ifPresent(n -> System.out.println("Hello, " + n));  // Hello, Abhayjit
    }
}
