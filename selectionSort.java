import java.util.Arrays;

class Scratch {
    public static void main(String[] args) {
        int[] unsorted = {19, 64, 5, 9, 12};
        Scratch sc = new Scratch();
        sc.selectionSort(unsorted);
    }

    public void selectionSort(int[] lst) {
        int len = lst.length;
        for (int i = 0; i < len; i++ ) {
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
        System.out.println(Arrays.toString(lst));
    }
}
