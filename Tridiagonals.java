import java.lang.Math;

class Tridiagonals
{
    // Part(a) - Example of a Tridiagonal Matrix
    static double [][] exampleMatrix(int n) 
    { 
        double m[][] = new double [3][n]; 
        for (int i = 0; i < n; i++) // running through each position
        { 
            if (i < n - 1) 
            { 
                m[0][i] = 1; // all entries in superdiagonal = 1
            }

            m[1][i] = - (i + 1) * (i + 1); // entries in main diagonal

            if (i > 0)
            {
                m[2][i] = i + 2; // all entried in subdiagonal
            }
        }
        m[0][n - 1] = 0; // last element in superdiagonal
        m[2][n - 1] = 0; // last element in subdiagonal

        return m;
    }
/**
*Part (b)-Checks if the input is a valid tridiagonal matrix
*@ parameter a is input matrix
*@return true if valid, false otherwise
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

    // Part(c) - Sum of Two Tridiagonal Matrices
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
    
    // Part(d) - Product of a Diagonal Matrix with Tridiagonal Matrix
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
                m[0][i] = d[i] * t[0][i]; // entries in superdiagonal
            }

            m[1][i] = d[i] * t[1][i]; // main diagonal

            if (i > 0)
            {
                m[2][i - 1] = d[i] * t[2][i - 1]; // entried in subdiagonal
            }
        } 
        m[0][n - 1] = 0; // entries in superdiagonal
        m[2][n - 1] = 0; // entries in subdiagonal

        return m;
    }


/**
 * Part (e) - Implement a function linearSolve, solve Tx = v
 * @ tridiagonal n × n matrix T and a vector v
 * @return x such that Tx = v
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

