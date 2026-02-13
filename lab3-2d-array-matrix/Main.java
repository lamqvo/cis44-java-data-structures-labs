public class Main {
    public static void main(String[] args){

        // Add operation
        Matrix m1 = new Matrix(new int[][]{{1,2,3},{4,5,6}});   // m1 uses constructor Matrix(int[][] data) - literal assignment
        Matrix m2 = new Matrix(2, 3);        // uses constructor Matrix(int rows, int cols), then populate randoms
        m2.populateRandom();                            // random assignment for m2
//        m1.add(m2);                                     // perform add operation m1 + m2
        System.out.println("m1: \n" + m1);
        System.out.println("m2: \n" + m2);
        System.out.println("Addition (m1 + m2): \n" + m1.add(m2));

        // Multiply operation
        Matrix m3 = new Matrix(2, 3);       // uses constructor Matrix(int rows, int cols), then populate randoms
        Matrix m4 = new Matrix(3, 4);       // uses constructor Matrix(int rows, int cols), then populate randoms
        m3.populateRandom();                           // random assignment for m3
        m4.populateRandom();                          // random assignment for m4
        System.out.println("m3: \n" + m3);
        System.out.println("m4: \n" + m4);
        System.out.println("Multiply (m3 * m4): \n" + m3.multiply(m4));

        // Exception handling
        try {
            // Exception for addition
            m3.add(m4);
        } catch (IllegalArgumentException e){
            System.out.println("\nm3: [" + m3.getRows() + "][" + m3.getCols() + "]");
            System.out.println("m4: [" + m4.getRows() + "][" + m4.getCols() + "]");
            System.out.println("Adding exception: " + e.getMessage());
        }

        try {
            // Exception for multiply
            m1.multiply(m2);
        } catch (IllegalArgumentException e){
            System.out.println("\nm1: [" + m1.getRows() + "][" + m1.getCols() + "]");
            System.out.println("m2: [" + m2.getRows() + "][" + m2.getCols() + "]");
            System.out.println("Multiply exception: " + e.getMessage());
        }
    }
}
