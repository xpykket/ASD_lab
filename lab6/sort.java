class Sort {
    static void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    static void showResults(int[] a, int[] b) {
        int[] sortedA = a.clone();
        int[] sortedB = b.clone();

        sort(sortedA);
        sort(sortedB);

        int maxSum = 0;
        System.out.println("Пары для максимальной суммы:");
        for (int i = 0; i < sortedA.length; i++) {
            System.out.println("(" + sortedA[i] + ", " + sortedB[i] + ")");
            maxSum += sortedA[i] * sortedB[i];
        }
        System.out.println("Максимальная сумма: " + maxSum);

        int minSum = 0;
        System.out.println("Пары для минимальной суммы:");
        for (int i = 0; i < sortedA.length; i++) {
            int j = sortedB.length - 1 - i;
            System.out.println("(" + sortedA[i] + ", " + sortedB[j] + ")");
            minSum += sortedA[i] * sortedB[j];
        }
        System.out.println("Минимальная сумма: " + minSum);
    }
}
