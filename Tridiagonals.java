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
                m[0][i] = 1; // all entries in upper diagonal = 1
            }

            m[1][i] = - (i + 1) * (i + 1); // entries in main diagonal

            if (i > 0)
            {
                m[2][i] = i + 2; // all entried in lower diagonal
            }
        }
        m[0][n - 1] = 0; // last element in upper diagonal
        m[2][n - 1] = 0; // last element in lower diagonal

        return m;
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
     static double m[][] productWithDiagonal(double d[], double t[][])
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
}

