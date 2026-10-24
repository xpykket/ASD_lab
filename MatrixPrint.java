public class MatrixPrint {
    public static void printAll(Matrix matrix) {
        System.out.println("Исходная матрица:");
        printMatrix(matrix);

        System.out.println("\nИзменённая матрица в ленточном столбцовом формате:");
        pringgroupmartix(matrix);

        System.out.println("\nПорядок обхода, вариант 6:");
        printVariantSix(matrix);
    }

    private static void printMatrix(Matrix matrix) {
        for (int row = 0; row < matrix.size; row++) {
            for (int column = 0; column < matrix.size; column++) {
                System.out.print(matrix.get(row, column));
            }
            System.out.println();
        }
    }

    private static void pringgroupmartix(Matrix matrix) {
        int groupHeight = matrix.p + matrix.q + 1;
        for (int k = 1; k <= groupHeight; k++) {
            for (int column = 0; column < matrix.size; column++) {
                System.out.print(matrix.getElement(k, column));
            }
            System.out.println();
        }
    }

    private static void printVariantSix(Matrix matrix) {
        for (int column = 0; column < matrix.size; column++) {
            int first = matrix.firstRow[column];
            int last = Math.min(matrix.size - 1, column + matrix.p);
            boolean bottomToTop = column % 2 == 0;

            if (bottomToTop) {
                for (int row = last; row >= first; row--) {
                    printelement(matrix, row, column);
                }
            } else {
                for (int row = first; row <= last; row++) {
                    printelement(matrix, row, column);
                }
            }
        }
    }

    private static void printelement(Matrix matrix, int row, int column) {
        int value = matrix.get(row, column);
        if (value != 0) {
            System.out.println("A[" + (row + 1) + "][" + (column + 1) + "] = " + value);
        }
    }
}
