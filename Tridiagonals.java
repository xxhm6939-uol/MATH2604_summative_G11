import java.lang.Math;

class Tridiagonals
{
    // Tridiagonals part (a)
    static double [][] exampleMatrix(int n) 
    { 
        double m[][] = new double [3][n];
        for (int j = 0 ; j < n ; j++)
        { 
            if (j < n-1)
            { 
                m[0][j] = 1;
            }

            m[1][j] = -(j+1)*(j+1);

            if (j > 0)
            {
                m[2][j] = j+2;
            }
        }
        return m;
    }

}

