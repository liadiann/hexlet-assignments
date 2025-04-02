package exercise;

import java.util.List;

// BEGIN
public class App {
    public static List<String> buildApartmentsList(List<Home> homes, int count) {
        return homes.stream()
                .sorted(Home::compareTo)
                .map(Home::toString)
                .limit(count)
                .toList();
    }
}
// END
