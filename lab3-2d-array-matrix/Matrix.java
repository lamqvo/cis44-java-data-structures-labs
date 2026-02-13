import java.util.Random;
public class Matrix {
    private int[][] data;
    // Constructor that initializes the matrix with the given dimensions.
    public Matrix(int rows, int cols) {
        data = new int[rows][cols];
    }
    // Constructor that initializes the matrix with a pre-existing 2D array.
    public Matrix(int[][] data){
        int rows = data.length;
        int cols = data[0].length;
        this.data = new int[rows][cols];            // allocate new array
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                this.data[i][j] = data[i][j];       // copy element values over
            }
        }
    }
    // Fills the matrix with random integer values between 1 and 10.
    public void populateRandom(){
        Random rand = new Random();
        for (int i = 0; i < data.length; i++){
            for (int j = 0; j < data[i].length; j++){
                data[i][j] = rand.nextInt(10) + 1;      // rand.nextInt(10) gives numbers from 0 to 9.
            }
        }
    }

    // Adds this matrix to another matrix.
    // Challenge: If the matrices do not have the same dimensions, this method must throw an IllegalArgumentException.
    // Returns a new Matrix object that is the sum of the two.
    public Matrix add(Matrix other){
        if (this.data.length != other.data.length || this.data[0].length != other.data[0].length){
            throw new IllegalArgumentException("Matrices do not have same dimensions");
        }
        int rows = data.length;
        int cols = data[0].length;
        Matrix sumMatrix = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                sumMatrix.data[i][j] = this.data[i][j] + other.data[i][j];
            }
        }
        return sumMatrix;
    }

    // Multiplies this matrix by another matrix.
    // Challenge: If the number of columns in this matrix does not equal the number of rows in the other matrix, throw an IllegalArgumentException.
    // Returns a new Matrix object that is the product.
    public Matrix multiply(Matrix other){
        int rowsA = this.data.length;
        int colsA = this.data[0].length;
        int rowsB = other.data.length;
        int colsB = other.data[0].length;
        if (colsA != rowsB){
            throw new IllegalArgumentException("Columns in first matrix does not equal to the number of rows in second matrix");
        }
        // m1(rA, cA) * m2(rB, cB) = results(rA, cB)
        // k = cA = rB
        Matrix results = new Matrix(rowsA, colsB);
        int sum = 0;
        for (int i = 0; i < rowsA; i++){
            for (int j = 0; j < colsB; j++){
                for (int k = 0; k < colsA; k++){
                    sum = sum + this.data[i][k] * other.data[k][j];
                }
                results.data[i][j] = sum;
                sum = 0;
            }
        }
        return results;
    }

    // @Override public String toString()
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < data.length; i++){
            for (int j = 0; j < data[i].length; j++) {
                sb.append(data[i][j]).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
    // get rows size of the array
    public int getRows(){
        return data.length;
    }
    // get columns size of the array
    public int getCols(){
        return data[0].length;
    }
}
