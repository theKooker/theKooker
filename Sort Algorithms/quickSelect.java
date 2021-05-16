public class MyClass {
    public static void main(String[] args) {
        int array[] = new int[]{3, 1, 4, 1, 5, 9, 6, 5, 3, 5, 8, 9};
        System.out.println(quickSelect(array, 7));
    }


    /**
     * @param array
     * @param k
     * @return element
     */
    public static int quickSelect(int[] array, int k) {
        assert (k <= array.length);
        int pivot = array[(int) (Math.random() * (array.length - 1))];

        int numberLowerElements = (int) Arrays.stream(array).filter(e -> e < pivot).count();
        int a[] = new int[numberLowerElements];
        int counter = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < pivot) {
                a[counter] = array[i];
                counter++;
            }
        }

        if (a.length >= k)
            return quickSelect(a, k);

        int[] temp = array;
        int numberEqualElements = (int) Arrays.stream(temp).filter(e -> e == pivot).count();
        int b[] = new int[numberEqualElements];
        counter = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == pivot) {
                b[counter] = array[i];
                counter++;
            }
        }
        if (a.length + b.length >= k)
            return pivot;
        int[] tempC = array;
        int numberBiggerElements = (int) Arrays.stream(tempC).filter(e -> e > pivot).count();
        int c[] = new int[numberBiggerElements];
        counter = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > pivot) {
                c[counter] = array[i];
                counter++;
            }
        }
        return quickSelect(c, k - a.length - b.length);


    }
}