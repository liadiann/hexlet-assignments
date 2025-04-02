package exercise;

// BEGIN
public interface Home {
    double getArea();
    default int compareTo(Home home) {
        var area1 = getArea();
        var area2 = home.getArea();
        if (area1 == area2) {
            return 0;
        }
        return area1 > area2 ? 1 : -1;
    }
}
// END
