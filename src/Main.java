public class Main {


    public static void main(String[] args) {
        int[] arr1 = new int[1];
        int[] arr2 = new int[3];
        arr1[0] = 1;

        arr2[0] = 2;
        arr2[1] = 3;
        arr2[2] = 4;


        System.out.println(LeetCodeArray.findMedianSortedArrays(arr1, arr2));

    }
}