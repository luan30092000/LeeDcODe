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

    /**
     * There are n vertical lines drawn such that the two endpoints
     * of the ith line are (i, 0) and (i, height[i]).
     *
     * Find two lines that together with the x-axis form a container,
     * such that the container contains the most water.
     *
     * @param height array height of length n
     * @return the maximum amount of water a container can store.
     */
    public static int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int volumn = 0;
        while (start < end) {
            int water = (end - start) * Math.min(height[start], height[end]);
            if (water > volumn) {
                volumn = water;
            }

            if (height[start] <= height[end]) {
                start++;
            } else {
                end--;
            }
        }
        return volumn;
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return nums.length;
        }

        int fixIndex = 1;
        int compareValue = nums[0];
        int runIndex = 1;
        while(runIndex < nums.length) {
            if (nums[runIndex] != compareValue) {
                nums[fixIndex] = nums[runIndex];
                compareValue = nums[runIndex];
                runIndex++;
            }
            runIndex++;
        }
        return fixIndex;
    }
}
