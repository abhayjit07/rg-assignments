import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Zara", "Abhay", "Mira", "Dev");

        Collections.sort(names, (a, b) -> a.compareTo(b));

        names.forEach(name -> System.out.println(name));
    }
}
