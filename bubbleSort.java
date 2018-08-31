import java.util.Arrays;

class Scratch {
    public static void main(String[] args) {
        int[] unsorted = { 19, 64, 5, 9, 12 };
        Scratch sc = new Scratch();
        sc.bubbleSort(unsorted);
    }
    public void bubbleSort(int[] lst) {
        int len = lst.length;
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < len - 1; i++) {
                if (lst[i] > lst[i + 1]) {
                    int temp = lst[i];
                    lst[i] = lst[i + 1];
                    lst[i + 1] = temp;
                    swapped = true;
                } else {
                    // no swapping to do
                    // swapped variable remains false and loop ends
                }
            }
        } while (swapped == true);
        System.out.println(Arrays.toString(lst));
    }

}
