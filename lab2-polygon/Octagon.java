public class Octagon implements Polygon{
    private double side;

    public Octagon(double side){
        this.side = side;
    }

    @Override
    public double perimeter() {
        return side * 8;
    }

    @Override
    public double area() {
        return (Math.sqrt(2) + 1) * 2 * side * side;
    }
}
