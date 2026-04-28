import java.lang.Math;

/**
 * This class provides methods for working with tridiagonal matrices.
 *
 * A tridiagonal matrix is stored as a 2D array of size 3 × n:
 * row 0 = upper diagonal,
 * row 1 = main diagonal,
 * row 2 = lower diagonal.
 */
class Tridiagonals
{
    /**
<<<<<<< HEAD
     * Part(a) - exampleMatrix function
     * Generates an example tridiagonal matrix of size n × n.
     *
     * @param n the size of the matrix (n > 0)
     * @return a 3 × n array representing the tridiagonal matrix
     */    
=======
     * Part(a) - Example of a Tridiagonal Matrix
     * Runs through each position - upper diagonal, main diagonal and lower diagonal
     */

>>>>>>> 4556416 (pulling changes)
    static double [][] exampleMatrix(int n) 
    { 
        double m[][] = new double [3][n]; 
        for (int i = 0; i < n; i++) 
        { 
            if (i < n - 1) 
            { 
                m[0][i] = 1; 
            }

            m[1][i] = - (i + 1) * (i + 1); 

            if (i > 0)
            {
                m[2][i] = i + 2; 
            }
        }
        m[0][n - 1] = 0; 
        m[2][n - 1] = 0; 

        return m;
    }

    /**
    * Part (b) - isValidTridiagonal function
    * Checks if the input is a valid tridiagonal matrix
    *
    * @param a is input matrix
    * @return true if valid, false otherwise
    */
    public static boolean isValidTridiagonal(double[][] a) {
    // check if array is null
        if (a==null){
            return false;
        }
    // check if it has exactly 3 rows
        if (a.length !=3){
            return false;
        }
    // check if any rows is null
        if (a[0] == null || a[1] == null || a[2] == null) {
            return false;
        }
    //get length of first row
        int n = a[0].length;
        if (n<1){
            return false;
        }
    //check if any rows have difference length
        if (a[0].length != a[1].length||a[1].length != a[2].length){
            return false;
        }
        return true;
    }

    /**
     * Part(c) - sum function
     * Computes the sum of two tridiagonal matrices.
     *
     * @param A the first matrix
     * @param B the second matrix
     * @return a new tridiagonal matrix representing A + B,
     *         or null if inputs are invalid or incompatible
     */
    public static double[][] sum(double[][] A, double[][] B)
    {
        if (A == null || B == null) // Check for null inputs
        {
            return null;
        }

        if (!isValidTridiagonal(A) || !isValidTridiagonal(B)) // Check if both are valid tridiagonal matrices
        {
            return null;
        }

        int n = A[0].length;

        if (B[0].length != n) // Check size compatibility
        {
            return null;
        }

        double[][] result = new double[3][n]; // Create result matrix

        for (int i = 0; i < 3; i++) // Add corresponding elements
        {
            for (int j = 0; j < n; j++)
            {
                result[i][j] = A[i][j] + B[i][j];
            }
        }

        return result;
    }
    
    /**
<<<<<<< HEAD
     * Part(d) - productWithDiagonal
     * Computes the product of a diagonal matrix and a tridiagonal matrix.
     *
     * @param d the diagonal matrix (as an array)
     * @param t the tridiagonal matrix
     * @return the resulting tridiagonal matrix,
     *         or null if inputs are invalid or incompatible
     */
=======
     * Part(d) - Product of a Diagonal Matrix with Tridiagonal Matrix
     * Returns null if any entries are null
     * Null if number of diagonals doesn't match 3
     * Returns null if diagonals don't match in size
     * Entries in upper diagonal, main diagonal and lower diagonal
     */
     
>>>>>>> 4556416 (pulling changes)
     static double [][] productWithDiagonal(double d[], double t[][])
    {
        if (d == null || t == null) // returns null if any entries are null
        {
            return null;
        }

        int n = d.length;

        if (t.length != 3) // null if number of diagonals doesn't match 3
        {
            return null;
        }

        if (t[0].length != n || t[1].length != n || t[2].length != n) // returns null if diagonals don't match in size
        {
            return null;
        }

        double m[][] = new double[3][n];
        for (int i = 0; i < n; i++)
        {
            if (i < n - 1)
            {
                m[0][i] = d[i] * t[0][i]; // entries in upper diagonal
            }

            m[1][i] = d[i] * t[1][i]; // main diagonal

            if (i > 0)
            {
                m[2][i] = d[i + 1] * t[2][i]; // entried in lower diagonal
            }
        } 
        m[0][n - 1] = 0; // entries in upper diagonal
        m[2][n - 1] = 0; // entries in lower diagonal

        return m;
    }

/**
 * Part (e) - linearSolve function
 * Solves the linear system Tx = v using the Thomas algorithm.
 *
 * @param T the tridiagonal matrix
 * @param v the right-hand side vector
 * @return x such that Tx = v, or null if inputs are invalid
 */
    public static double[] linearSolve(double[][] T, double[]v){
        if (isValidTridiagonal(T)==false||v==null){
            return null;
        }
        int n = T[0].length;
        if (v.length != n){
            return null;
        }
        double[] a = new double[n];
        double[] b = new double[n];
        double[] c = new double[n];
        double[] d = new double[n];
        for (int i=0; i<n; i=i+1){
            // upper diagonal
            a[i]=T[0][i];
            // main diagonal
            b[i]=T[1][i];
            //lower diagonal
            c[i]=T[2][i];
            // vector v
            d[i]=v[i];
        }
        // elimination, letting  lower diagonal be 0
        for (int i=1; i<n; i=i+1){
            //elementary row operation
            double m = c[i]/b[i-1];
            b[i] = b[i] - m*a[i-1];
            d[i] = d[i] - m*d[i-1];
            c[i] = 0; // lower diagonal becomes 0
    }
        //back subsitution, solving for x
        double[]x= new double[n];
        x[n-1] = d[n-1]/b[n-1];
        for (int i=n-2; i>=0; i=i-1){
            x[i] = (d[i] - a[i]*x[i+1])/b[i];
        }
        return x;
    }    
    
}

