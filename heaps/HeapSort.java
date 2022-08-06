import java.util.Arrays;

class HeapSorter {
    public void heapify(int[] nums, int heapSize, int rootIndex) {
        int temp;
        int childIndex = 2 * rootIndex + 1;
        int i = 0, maxValue = nums[rootIndex], maxIndex = rootIndex;

        while (i < 2 && i + childIndex < heapSize) {
            if (nums[i+childIndex] > maxValue) {
                maxIndex = i + childIndex;
                maxValue = nums[i+childIndex];
            }
            i++;
        }

        if (maxValue == nums[rootIndex]) {
            return;
        }

        // swap
        temp = nums[maxIndex];
        nums[maxIndex] = nums[rootIndex];
        nums[rootIndex] = temp;

        heapify(nums, heapSize, maxIndex);
    }

    public void sort(int[] nums) {
        int swapIndex, temp;
        int size = nums.length, m = size / 2 - 1;

        // heapify the unsorted array
        while (m >= 0) { 
            heapify(nums, size, m--);
        }

        // sort the array
        swapIndex = nums.length - 1;
        
        while (swapIndex > 0) {
            temp = nums[0];
            nums[0] = nums[swapIndex];
            nums[swapIndex] = temp; 
            swapIndex--;

            size--;

            heapify(nums, size, 0);
        }
    }

    public static void main(String[] args) {
        int[] arrayToSort = {23, 33, 1, 1776, 2020, 1111, 14, 76, 34, 0, 77, 43, 100, 1223, 2, 18, 78, 52, 101};
        HeapSorter heapsort = new HeapSorter();

        System.out.println("Unsorted: " + Arrays.toString(arrayToSort));
        heapsort.sort(arrayToSort);
        System.out.println("Sorted: " + Arrays.toString(arrayToSort));
    }
}