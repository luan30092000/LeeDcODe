public class LeetCodeArray {

    public static void arrayPrint(int[] arr) {
        System.out.print("[");
        for (int j : arr) {
            System.out.print(j + ", ");
        }
        System.out.println("]");
        System.out.println("Size: " + arr.length);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int lengthSum = nums1.length + nums2.length;
        int[] mergeArray = new int[lengthSum / 2 + 1];  // New array is big enough to contain median's components
        int nums1Index = 0;
        int nums2Index = 0;
        int mergeIndex = 0;

        // Merge sort
        while (nums1Index < nums1.length && nums2Index < nums2.length && mergeIndex < mergeArray.length) {
            if (nums1[nums1Index] <= nums2[nums2Index]) {
                mergeArray[mergeIndex] = nums1[nums1Index];
                nums1Index++;
            } else {
                mergeArray[mergeIndex] = nums2[nums2Index];
                nums2Index++;
            }
            mergeIndex++;
        }

        // Continue to merge sort if mergeArray has not reached the end
        if (mergeIndex < mergeArray.length) {
            if (nums1Index < nums1.length) {
                for (; nums1Index < nums1.length && mergeIndex < mergeArray.length; nums1Index++, mergeIndex++) {
                    mergeArray[mergeIndex] = nums1[nums1Index];
                }
            }
            if (nums2Index < nums2.length) {
                for (; nums2Index < nums2.length && mergeIndex < mergeArray.length; nums2Index++, mergeIndex++) {
                    mergeArray[mergeIndex] = nums2[nums2Index];
                }
            }
        }

        if (lengthSum % 2 == 0) {   // lengthSum is even then median is average of 2 middle number
            return ((double)(mergeArray[mergeArray.length - 1] + mergeArray[mergeArray.length - 2]) / 2.0);
        } else {                    // lengthSum is odd then median is the middle element which is last element of merge arr in this problem.
            return mergeArray[mergeArray.length - 1];
        }
    }
}
