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
}

