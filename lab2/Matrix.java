public class Matrix {
    int size;
    int p;
    int q;
    int[] firstRow;
    int[] columnStart;
    int[] values;

    public static Matrix Count(int[][] matrixData) {
        int size = matrixData.length;
        int p = 0;
        int q = 0;
        for (int row = 0; row < size; row++) {
            for (int column = 0; column < size; column++) {
                if (matrixData[row][column] != 0) {
                    if (row > column) {
                        p = Math.max(p, row - column);
                    } else if (column > row) {
                        q = Math.max(q, column - row);
                    }
                }
            }
        }

        int cnt = 0;
        for (int column = 0; column < size; column++) {
            int first = Math.max(0, column - q);
            int last = Math.min(size - 1, column + p);
            cnt += last - first + 1;
        }

        int[] value = new int[cnt];
        int index = 0;
        for (int column = 0; column < size; column++) {
            int first = Math.max(0, column - q);
            int last = Math.min(size - 1, column + p);
            for (int row = first; row <= last; row++) {
                value[index] = matrixData[row][column];
                index++;
            }
        }

        return new Matrix(size, p, q, value);
    }

    private Matrix(int size, int p, int q, int[] values) {
        this.size = size;
        this.p = p;
        this.q = q;
        this.values = values;
        firstRow = new int[size];
        columnStart = new int[size];

        int index = 0;
        for (int column = 0; column < size; column++) {
            firstRow[column] = Math.max(0, column - q);
            columnStart[column] = index;
            int last = Math.min(size - 1, column + p);
            index += last - firstRow[column] + 1;
        }
    }

    public int get(int row, int column) {
        int lastRow = Math.min(size - 1, column + p);
        if (row < firstRow[column] || row > lastRow) {
            return 0;
        }
        int index = columnStart[column] + row - firstRow[column];
        return values[index];
    }

    public int getElement(int k, int column) {
        int rowIndex = k + column - q - 1;
        if (rowIndex < 0 || rowIndex >= size) {
            return 0;
        }
        return get(rowIndex, column);
    }
}
