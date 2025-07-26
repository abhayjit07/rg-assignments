import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Abhayjit", "Srinanda", "Gulati");

        // Using lambda expression
        names.forEach(name -> System.out.println(name));

        // Using method reference (more suitable)
        names.forEach(System.out::println);
    }
}
