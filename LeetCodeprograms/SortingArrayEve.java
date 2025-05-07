public import java.util.Arrays;

public class SortingArrayEve {
    public static void main(String[] args) {
        int[] array = {5, 3, 8, 6, 1, 9, 2, 7, 4};

        // Partition the array into even and odd numbers
        int[] sortedArray = sortEvenOdd(array);

        // Print the sorted array
        System.out.println("Sorted array (evens first, then odds): " + Arrays.toString(sortedArray));
    }

    public static int[] sortEvenOdd(int[] array) {
        // Separate the even and odd numbers
        int[] evens = Arrays.stream(array).filter(n -> n % 2 == 0).toArray();
        int[] odds = Arrays.stream(array).filter(n -> n % 2 != 0).toArray();

        // Sort the even and odd arrays
        Arrays.sort(evens);
        Arrays.sort(odds);

        // Merge the sorted arrays
        int[] result = new int[array.length];
        int index = 0;

        for (int even : evens) {
            result[index++] = even;
        }
        for (int odd : odds) {
            result[index++] = odd;
        }

        return result;
    }
}
