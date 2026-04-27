import static java.lang.Math.*;

/**
 * This class provides methods for working with diagonal matrices.
 * 
 * A diagonal matrix is represented as a one-dimensional array,
 * where each element corresponds to a diagonal entry.
 */

public class Diagonals

{

    /**
     * Part(a) - exampleMatrix function
     * Returns an example diagonal matrix with fixed entries, with no parameters
     *
     * The matrix has diagonal entries: 10, 8, 5, -10, 7.
     *
     * @return an array representing the diagonal matrix
     */
    public static double[] exampleMatrix(){
        double[] diagonal =new double[]{10,8,5,-10,7};
        return diagonal;
    }

    /**
     * Part(b) - sum function
     * Computes the sum of two diagonal matrices.
     *
     * @param a the first diagonal matrix
     * @param b the second diagonal matrix
     * @return a new array representing the sum of a and b,
     *         or null if either input is null or their lengths differ
     */
    public static double[] sum(double a[], double b[]) 
    {
        if (a == null || b == null) // checks if any array parameters of the function are null
        {
            return null; // returns null if true
        }

        int n = a.length; // set n equal to the length of array parameters in matrix a 
        int m = b.length ;// set m equal to the length of array parameters in matrix b 

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
    
    /**
     * Part(c) - product function
     * Computes the product of two diagonal matrices.
     *
     * @param a the first diagonal matrix
     * @param b the second diagonal matrix
     * @return a new array representing the product of a and b,
     *         or null if either input is null or their lengths differ
     */
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

        double[] result = new double[n];
        for (int i = 0; i < n; i++)
        {
            result[i] = a[i] * b[i]; // multiplies the diagonal entries of both matrices
        }
        return result;
    }

    /**
     * Part(d) - inverse function
     * Computes the inverse of a diagonal matrix.
     *
     * Each diagonal entry is replaced by its reciprocal.
     * Assumes that all entries are non-zero (matrix is invertible).
     *
     * @param a the diagonal matrix
     * @return a new array representing the inverse of a,
     *         or null if the input is null
     */
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
