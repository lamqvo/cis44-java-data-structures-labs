import java.util.Scanner;
public class PolygonCalculator {
    public static void main (String[] args){
        Polygon polygon = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Create a polygon:");
//        menu();
//        String choice = scanner.nextLine().trim();
//        System.out.println("Selected: " + choice);
//        boolean running = true;
        while (true){
            menu();
            String choice = scanner.nextLine().trim();
            System.out.println("Selected: " + choice);
            switch (choice){
                case "1": {
                    double width = readSide(scanner, "Rectangle width");
                    double length = readSide(scanner, "Rectangle length");
                    polygon = new Rectangle(length, width);
                    break;
                }
                case "2": {
                    double side = readSide(scanner, "Square side");
                    polygon = new Square(side);
                    break;
                }
                case "3": {
                    double side1 = readSide(scanner, "Triangle side1");
                    double side2 = readSide(scanner, "Triangle side2");
                    double side3 = readSide(scanner, "Triangle side3");
                    if (((side1 + side2) <= side3) || ((side1 + side3) <= side2) || ((side2 + side3) <= side1)){
                        System.out.println("Invalid Triangle!");
                        break;
                    } else {
                        polygon = new Triangle(side1, side2, side3);
                        break;
                    }
                }
                case "4": {
                    double equalSide = readSide(scanner, "Isosceles Triangle's equal side");
                    double base = readSide(scanner, "base");
                    if (2 * equalSide <= base) {
                        System.out.println("Invalid Isosceles Triangle!");
                        break;
                    } else {
                        polygon = new IsoscelesTriangle(equalSide, base);
                        break;
                    }
                }
                case "5": {
                    double side = readSide(scanner,"Equilateral Triangle side");
                    polygon = new EquilateralTriangle(side);
                    break;
                }
                case "6": {
                    double side = readSide(scanner,"Pentagon side");
                    polygon = new Pentagon(side);
                    break;
                }
                case "7": {
                    double side = readSide(scanner, "Hexagon side");
                    polygon = new Hexagon(side);
                    break;
                }
                case "8":{
                    double side = readSide(scanner, "Octagon side");
                    polygon = new Octagon(side);
                    break;
                }
                case "9":{
                    System.out.println("Exiting Program!");
                    scanner.close();
                    return;
                }
                default: {
                    System.out.println("Invalid selection!");
                    break;
                }
            }
            if (polygon != null) {
                System.out.println("Area = " + String.format("%.2f", polygon.area()));
                System.out.println("Perimeter = " + String.format("%.2f", polygon.perimeter())+"\n");
            } else {
                System.out.println("Polygon is not created due to invalid input!\n");
            }
        }
    }
    private static double readSide(Scanner scanner, String msg){
        while (true){
            System.out.println("Enter "+msg + " value: ");
            String input = scanner.nextLine();
            try{
                double value = Double.parseDouble(input);
                if (value > 0){
                    return value;
                } else {
                    System.out.println("Value must be more than 0");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input number!");
            }
        }
    }
    private static void menu(){
        System.out.println("Select polygon from menu: ");
        System.out.println("1. Rectangle");
        System.out.println("2. Square");
        System.out.println("3. Triangle");
        System.out.println("4. Isosceles Triangle");
        System.out.println("5. Equilateral Triangle");
        System.out.println("6. Pentagon");
        System.out.println("7. Hexagon");
        System.out.println("8. Octagon");
        System.out.println("9. Exit");
    }
}
