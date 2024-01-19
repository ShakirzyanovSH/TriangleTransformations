public class TriangleValidator {

    public static void validateTriangle(Point v1, Point v2, Point v3) throws InvalidTriangleException {
        double a = distance(v1, v2);
        double b = distance(v2, v3);
        double c = distance(v3, v1);

        if (!(a + b > c && a + c > b && b + c > a)) {
            throw new InvalidTriangleException("Невозможно создать треугольник с данными вершинами");
        }
    }

    private static double distance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p2.getX() - p1.getX(), 2) + Math.pow(p2.getY() - p1.getY(), 2));
    }
}
