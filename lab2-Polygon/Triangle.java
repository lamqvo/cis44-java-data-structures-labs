public class Triangle implements Polygon{
    protected double side1;
    protected double side2;
    protected double side3;

    public Triangle(double side1, double side2, double side3){
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    @Override
    public double perimeter(){
        return side1 + side2 + side3;
    }
    @Override
    public double area(){
        // Heron's formula
        double semi_perimeter = perimeter() / 2;
        return Math.sqrt(semi_perimeter * (semi_perimeter - side1) * (semi_perimeter - side2) * (semi_perimeter - side3));
    }

}
