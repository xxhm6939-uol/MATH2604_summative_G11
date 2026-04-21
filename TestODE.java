public class TestODE
{
    public static void main(String[] args)
    {
        // Test different values of a and n
        double[] aValues = {0.0, 1.0, -1.0};
        int[] nValues = {10, 50, 100,200,500};

        for (double a : aValues)
        {
            for (int n : nValues)
            {
                double result = ODE.solve(a, n);
                System.out.println("a = " + a + ", n = " + n + " -> f(0.5) ≈ " + result);
            }
            System.out.println("-----------------------------");
        }
    }
}