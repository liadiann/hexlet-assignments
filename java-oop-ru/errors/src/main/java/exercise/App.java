package exercise;

// BEGIN
public class App {
    public static void printSquare(Circle circle) {
        double square;
        try {
            square = circle.getSquare();
            System.out.println(Math.round(square));
        } catch (NegativeRadiusException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Вычисление окончено");
        }
    }
}
// END
