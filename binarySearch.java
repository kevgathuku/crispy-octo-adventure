import java.util.Arrays;

class Scratch {
    public static void main(String[] args) {
        int[] unsorted = { 19, 64, 5, 9, 12 };
        int needle = 19;

        Scratch sc = new Scratch();
        int[] sorted = sc.selectionSort(unsorted);

        System.out.println("Sorted list: " + Arrays.toString(sorted));
        System.out.println("Looking for element: " + needle);

        sc.binarySearch(needle, sorted, 0, sorted.length - 1);
    }

    public int[] selectionSort(int[] lst) {
        int len = lst.length;
        for (int i = 0; i < len; i++) {
            int smallestIndex = i;
            // Start with the current item as the smallest
            int smallest = lst[i];
            // Find the actual smallest item starting from position i
            for (int j = i; j < len; j++) {
                if (lst[j] < smallest) {
                    smallest = lst[j]; // save the actual smallest number
                    smallestIndex = j; // save position of smallest item
                }
            }
            int temp = lst[i]; // save the number in the current position
            lst[i] = smallest; // set the smallest in the correct position
            lst[smallestIndex] = temp; // set the current number in the smallest position
        }
        return lst;
    }

    public void binarySearch(int needle, int[] lst, int low, int high) {
        int len = lst.length;
        int middleIndex = (low + high) / 2;

        if (low > high) {
            System.out.println("low: " + low + " high: " + high);
            System.out.println("the element is not in the array");
            return;
        }

        if (needle == lst[middleIndex]) {
            System.out.println("found needle! It is at position: " + middleIndex);
            return;
        } else if (needle > lst[middleIndex]) {
            binarySearch(needle, lst, middleIndex + 1, len - 1);
        } else if (needle < lst[middleIndex]) {
            binarySearch(needle, lst, 0, middleIndex - 1);
        }
    }

}
