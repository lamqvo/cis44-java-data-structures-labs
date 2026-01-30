/**
 * A simple calculator with operation from left to right
 * @author  Lam Vo
 */
import java.util.Scanner;
public class Calculator {
    /**
     * Calculation
     * @param num1 first number
     * @param operator operator such as + - * / =
     * @param num2 second number
     * @return results from the operation
     */
    private static Double calculate(double num1, String operator, double num2) {
        switch (operator) {
            case "+" -> {
                return (num1 + num2);
            }
            case "-" -> {
                return (num1 - num2);
            }
            case "*" -> {
                return (num1 * num2);
            }
            case "/" -> {
                return (num1 / num2);
            }
        }
        return num1;
    }

    /**
     * check if string operator is one of the operators
     * @param operator operator such as + - * /
     * @return true if match or false if not matched
     */
    private static Boolean isOperator(String operator){
        return (operator.equals("+") ||
                operator.equals("-") ||
                operator.equals("*") ||
                operator.equals("/") ||
                operator.equals("="));
    }

    /**
     * check if the number is double
     * @param number number to check
     * @return true if number is double or false if not matched
     */
    private static Boolean isDouble(String number){
        Scanner sc = new Scanner(number);
        return sc.hasNextDouble();
    }
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Calculator with operation from left to right.");
        System.out.println("Enter 'E' to exit. \n" +
                "Enter a number or an operator (+,-,*,/,=), then hit 'Enter' each time: ");
        String line = null;
        double total = 0.0;                         // initial the result value on the screen
        boolean hasNumYet = false;                  // no input number yet
        String operator = null;                     // operator has not been selected yet
        boolean waitingForNextNumber = false;       // waiting for next number after an operator selected
        int sign = 1;                               // sign for the positive (1) and negative number (-1).

        while (true){
            line = input.nextLine().trim();
            if (line.equalsIgnoreCase("E")){
                System.out.println("Exit!");
                break;
            }
            // check if input is operator
            if (isOperator(line)){
                if (line.equals("=")){
                    System.out.println(line);
                    System.out.println("Total: " + total);
                    waitingForNextNumber = false;
                    operator = null;
                    continue;
                }
                // overwrite the operator
                if (waitingForNextNumber && operator != null){
                    operator = line;
                    System.out.println(line);
                    System.out.println("Total: " + total);
                    continue;
                }

                if (hasNumYet){
                    operator = line;
                    waitingForNextNumber = true;
                    System.out.println(line);
                    System.out.println("Total: " + total);
                    continue;
                }

                if(!hasNumYet){
                    if (line.equals("-")) {
                        sign = -1;
                    }
                    if (line.equals("+")){
                        sign = 1;
                    }
                    System.out.println(line);
                    System.out.println("Total: " + total);
                    continue;
                }
            }
            // check if input is number
            if (isDouble(line)){
                double num = Double.parseDouble(line) * sign;
                sign = 1;

                if (!hasNumYet){                                    // if no number input yet
                    total = num;
                    hasNumYet = true;
                }
                else {                                             // already has an input number
                    if (operator != null) {                             // if the operator was selected
                        total = calculate(total, operator, num);            // perform the calculation
                        operator = null;                                    // reset operator to null
                    } else {                                            // if the operator was not selected
                        total = num;
                    }
                }
                waitingForNextNumber = false;
//                System.out.println("Num: " + num);
                System.out.println("Total: " + total);
                continue;
            }
            System.out.println("Invalid input! Enter 'E' to exit.  Enter a number or an operator (+,-,*,/,=):  ");
            System.out.println();
        }
        input.close();
    }
}
