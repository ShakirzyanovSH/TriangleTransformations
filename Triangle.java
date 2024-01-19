public class Triangle {
  private Point vertex1;
  private Point vertex2;
  private Point vertex3;

  public Triangle(Point vertex1, Point vertex2, Point vertex3) throws InvalidTriangleException {
   TriangleValidator.validateTriangle(vertex1, vertex2, vertex3);
   this.vertex1 = vertex1;
   this.vertex2 = vertex2;
   this.vertex3 = vertex3;
  }

  public void move(double dx, double dy) {
   vertex1.move(dx, dy);
   vertex2.move(dx, dy);
   vertex3.move(dx, dy);
  }

  public void scale(double factor) {
   if (factor <= 0) {
    return;
    }
    double centerX = (vertex1.getX() + vertex2.getX() + vertex3.getX()) / 3;
    double centerY = (vertex1.getY() + vertex2.getY() + vertex3.getY()) / 3;

    scalePoint(vertex1, centerX, centerY, factor);
    scalePoint(vertex2, centerX, centerY, factor);
    scalePoint(vertex3, centerX, centerY, factor);
  }

  private void scalePoint(Point p, double centerX, double centerY, double factor) {
   double newX = centerX + (p.getX() - centerX) * factor;
   double newY = centerY + (p.getY() - centerY) * factor;
   p.setX(newX);
   p.setY(newY);
  }

  public void rotate(double angle) {
   double centerX = (vertex1.getX() + vertex2.getX() + vertex3.getX()) / 3;
   double centerY = (vertex1.getY() + vertex2.getY() + vertex3.getY()) / 3;

   rotatePoint(vertex1, centerX, centerY, angle);
   rotatePoint(vertex2, centerX, centerY, angle);
   rotatePoint(vertex3, centerX, centerY, angle);
  }

  private void rotatePoint(Point p, double centerX, double centerY, double angle) {
   double rad = Math.toRadians(angle);
   double newX = centerX + (p.getX() - centerX) * Math.cos(rad) - (p.getY() - centerY) * Math.sin(rad);
   double newY = centerY + (p.getX() - centerX) * Math.sin(rad) + (p.getY() - centerY) * Math.cos(rad);
   p.setX(newX);
   p.setY(newY);
  }
  
  public String toString() {
   return String.format("Треугольник [A(%.1f, %.1f), B(%.1f, %.1f), C(%.1f, %.1f)]", 
    vertex1.getX(), vertex1.getY(), 
    vertex2.getX(), vertex2.getY(), 
    vertex3.getX(), vertex3.getY());
  }
}
