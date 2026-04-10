import static java.lang.Math.*;
public class Diagonals

{
/**
* Part(a)-exampleMatrix
* Implement a function exampleMatrix, with no parameters
* The diagonal entries are 10, 8, 5, -10, and 7
*/
    public static double[] exampleMatrix(){
        double[] diagonal =new double[]{10,8,5,-10,7};
        return diagonal;
    }



    // Part(b) - Sum of 2 Diagonal Matrices
    public static double[] sum(double a[], double b[]) 
    {
        if (a == null || b == null) // checks if any array parameters of the function are null
        {
            return null; // returns null if true
        }

        int n = a.length // set n equal to the length of array parameters in matrix a 
        int m = b.length // set m equal to the length of array parameters in matrix b 

        if (n != m) // checks if lengths of arrays don't match 
        {
            return null; // returns null if true
        }

        if (n == 0) // checks if input parameters are of length 0
        {
            return new double[0]; // returns empty array if true
        }

        double[] result = new double[n];
        for (int i = 0; i < n; i++) // runs through each position in the matrix
        {
            result[i] = a[i] + b[i]; // sums the diagonal entries of both matrices 
        }
        return result;
    }
    

    // Part(c) - Product of 2 Diagonal Matrices
    public static double[] product(double a[], double b[])
    {
        if (a == null || b == null)
        {
            return null;
        }

        int n = a.length;
        int m = b.length;

        if (n != m)
        {
            return null;
        }

        if (n == 0)
        {
            return new double[0];
        }

        double[] result = new double[n]
        for (int i = 0; i < n; i++)
        {
            result[i] = a[i] * b[i] // multiplies the diagonal entries of both matrices 
        }
        return result;
    }

    // Part(d) - Inverse of a Diagonal Matrix
    public static double[] inverse(double[] a)
    {
        if (a == null)
        {
            return null;
        }

        int n = a.length;

        if (n == 0)
        {
            return new double[0];
        }

        double[] result = new double[n];

        for (int i = 0; i < n; i++)
        {
            result[i] = 1.0 /a[i];
        }
        return result;
    }
}
