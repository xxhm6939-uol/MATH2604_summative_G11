import static java.lang.Math.*;

class ODE
{
    public static double solve(double a, int n)
    {
        if (n <= 0)
        {
            return 0.0;
        }

        double h = 1.0 / (n + 1);

        double[][] M = new double[3][n]; // Build tridiagonal matrix M (3 x n)

        for (int i = 0; i < n; i++)
        {
            double xi = (i + 1) * h;

            M[1][i] = 2.0 + h * h * Math.cos(xi); // diagonal

            if (i < n - 1) // upper diagonal
            {
                M[0][i] = -1.0;
            }

            if (i > 0) // lower diagonal
            {
                M[2][i - 1] = -1.0;
            }
        }

        double[] v = new double[n]; // Build vector v
        for (int i = 0; i < n; i++)
        {
            double xi = (i + 1) * h;
            v[i] = a * xi * xi;
        }

        double[] rhs = new double[n]; // Compute rhs = -h^2 * v
        for (int i = 0; i < n; i++)
        {
            rhs[i] = -h * h * v[i];
        }

        double[] w = Tridiagonals.linearSolve(M, rhs); // Solve Mw = rhs using provided method

        if (w == null)
        {
            return 0.0;
        }

        double target = 0.5; // Find approximation for f(0.5)
        int closestIndex = -1; // Find closest indices
        double minDiff = Double.MAX_VALUE;

        for (int i = 0; i < n; i++)
        {
            double xi = (i + 1) * h;
            double diff = Math.abs(xi - target);

            if (diff < minDiff)
            {
                minDiff = diff;
                closestIndex = i;
            }
        }

        double xi = (closestIndex + 1) * h; // If exact match
        if (Math.abs(xi - target) < 1e-12)
        {
            return w[closestIndex];
        }

        if (xi < target && closestIndex < n - 1) // Otherwise average nearest neighbours
        {
            return 0.5 * (w[closestIndex] + w[closestIndex + 1]);
        }
        else if (xi > target && closestIndex > 0)
        {
            return 0.5 * (w[closestIndex] + w[closestIndex - 1]);
        }

        return w[closestIndex];
    }
}