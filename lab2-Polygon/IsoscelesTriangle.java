public class IsoscelesTriangle extends Triangle{
    protected double equalSide;
    protected double base;

    public IsoscelesTriangle(double equalSide, double base){
        super(equalSide, equalSide, base);
        this.equalSide = equalSide;
        this.base = base;
    }
}
