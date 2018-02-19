import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Streams {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Wiktor Eriksson", "John Doe", "Agent 007", "Henrik Eriksson");
        Stream<String> stream = names.stream();
        Stream<String> stream1 = stream.filter(s -> s.contains("Eriksson"));
        stream=names.stream();
        Stream<String> stream2 = stream.filter(s -> !s.contains("Eriksson"));
        System.out.println("Printing stream1:");
        stream1.forEach(System.out::println);
        System.out.println("\nPrinting stream2:");
        stream2.forEach(System.out::println);
    }
}
