import java.util.Arrays;
import java.util.Random;
public class DotProduct {
    public static void main(String[] args){
        Random rand = new Random();
        int n = 5;                          // set n = 5
        int[] a = new int[n];               // create a new array object a with size n = 5
        int[] b = new int[n];               // create a new array object b with size n = 5
        int[] c = new int[n];               // create a new array object c with size n = 5
        for (int i=0;i<n; i++){
            a[i]=rand.nextInt(n);           // fills array a with randomly generated integer values
            b[i]=rand.nextInt(n);           // fills array b with randomly generated integer values
            c[i]=a[i]*b[i];                 // computes third array c such that c[i]=a[i]xb[i],for i=0,1,..,n-1
        }
        System.out.println("a[] = " + Arrays.toString(a));      // print original array a
        System.out.println("b[] = " + Arrays.toString(b));      // print original array b
        System.out.println("c[] = " + Arrays.toString(c));      // print resulting array c
    }
}
