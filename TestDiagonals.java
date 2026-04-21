public class TestDiagonals
{
    public static void main(String[] args)
    {
        // ===== Test exampleMatrix =====
        System.out.println("Testing exampleMatrix:");
        double[] ex = Diagonals.exampleMatrix();
        printArray(ex);

        // ===== Test sum =====
        System.out.println("\nTesting sum:");
        double[] a = {1, 2, 3};
        double[] b = {4, 5, 6};
        double[] sum = Diagonals.sum(a, b);
        printArray(sum);

        // Edge case: different sizes
        double[] c = {1, 2};
        System.out.println("Sum with different sizes (should be null):");
        System.out.println(Diagonals.sum(a, c));

        // Edge case: null input
        System.out.println("Sum with null (should be null):");
        System.out.println(Diagonals.sum(null, b));

        // ===== Test product =====
        System.out.println("\nTesting product:");
        double[] prod = Diagonals.product(a, b);
        printArray(prod);

        // ===== Test inverse =====
        System.out.println("\nTesting inverse:");
        double[] inv = Diagonals.inverse(a);
        printArray(inv);

        // Edge case: empty array
        System.out.println("\nTesting empty array:");
        double[] empty = {};
        double[] invEmpty = Diagonals.inverse(empty);
        printArray(invEmpty);

        // ===== Check original arrays unchanged =====
        System.out.println("\nChecking original arrays unchanged:");
        printArray(a); // should still be {1,2,3}
        printArray(b);
    }

    public static void printArray(double[] arr)
    {
        if (arr == null)
        {
            System.out.println("null");
            return;
        }

        System.out.print("[ ");
        for (double x : arr)
        {
            System.out.print(x + " ");
        }
        System.out.println("]");
    }
}