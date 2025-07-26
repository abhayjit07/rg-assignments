import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Predicate<String> startsWithA = s -> s.startsWith("A");
        System.out.println(startsWithA.test("Apple"));   // true
        System.out.println(startsWithA.test("Banana"));  // false
    }
}