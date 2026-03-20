class Test { 
    public static void main (String[] args) {
        double m[][] = Tridiagonals.exampleMatrix(5);
        
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++){
                System.out.print(m[i][j] + "");
            }
            System.out.println();
        }

    }
}