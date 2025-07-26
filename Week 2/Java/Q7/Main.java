import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("abhayjit", "srinanda", "gulati");

        List<String> upperNames = names.stream()
                                       .map(String::toUpperCase) // or name -> name.toUpperCase()
                                       .collect(Collectors.toList());

        upperNames.forEach(System.out::println);
    }
}
