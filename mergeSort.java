import java.util.Arrays;

class Scratch {
    public static void main(String[] args) {
        int[] unsorted = { 19, 64, 5, 9, 12 };
        Scratch sc = new Scratch();
        int[] merged = sc.mergeSort(unsorted);
        System.out.println(Arrays.toString(merged));
    }

    public int[] mergeSort(int[] lst) {
        int len = lst.length;
        int[] left;
        int[] right;

        if (len < 2) {
            // already sorted
            return lst;
        }

        // create space for left and right sub-arrays
        if (len % 2 == 0) {
            left = new int[len / 2];
            right = new int[len / 2];
        } else {
            left = new int[len / 2];
            right = new int[len / 2 + 1];
        }

        // fill up left and right sub-arrays
        for (int i = 0; i < len; i++) {
            if (i < len / 2) {
                left[i] = lst[i];
            } else {
                right[i - len / 2] = lst[i];
            }
        }

        // recursively split the lists again
        // overwrite the previous left/right variables
        left = mergeSort(left);
        right = mergeSort(right);

        // return the result of merging the split lists
        return merge(left, right);
    }

    public int[] merge(int[] left, int[] right) {
        // create space for the merged array
        int[] result = new int[left.length + right.length];

        // running indices
        int i = 0; // left
        int j = 0; // right
        int index = 0; // index of position to insert element in result

        // add until one subarray is empty
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                result[index] = left[i];
                // increment the indexes
                index += 1;
                i += 1;
            } else {
                result[index] = right[j];
                index += 1;
                j += 1;
            }
        }

        // add every leftover element from the non-empty sub-array
        while (i < left.length) {
            // use the current value of index & i before incrementing it
            result[index++] = left[i++];
        }

        // only one of these two while loops will be executed
        while (j < right.length) {
            result[index++] = right[j++];
        }

        return result;
    }
}
