public class Main {
    public static void main(String[] args) {
        int[][] sourceMatrix = {
                {1, 2, 3, 0, 0},
                {4, 5, 6, 7, 0},
                {0, 8, 9, 1, 2},
                {0, 0, 3, 4, 5},
                {0, 0, 0, 6, 7}
        };

        Matrix matrix = Matrix.Count(sourceMatrix);
        MatrixPrint.printAll(matrix);
    }
}
