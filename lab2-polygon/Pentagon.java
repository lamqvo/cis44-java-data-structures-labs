public class Pentagon implements Polygon{
    protected double side;
    public Pentagon(double side){
        this.side = side;
    }

    @Override
    public double perimeter(){
        return 5 * side;
    }

    @Override
    public double area(){
        return (Math.sqrt(25 + 10 * Math.sqrt(5)) * side * side / 4);
    }
}
