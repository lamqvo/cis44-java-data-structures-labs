public class Hexagon implements Polygon{
    protected double side;
    public Hexagon(double side){
        this.side =  side;
    }

    @Override
    public double perimeter() {
        return side * 6;
    }

    @Override
    public double area() {
//        return (Math.sqrt(3) / 24 ) * perimeter() * perimeter();
        return ((Math.sqrt(3) * 3) / 2 ) * side * side;
    }
}
