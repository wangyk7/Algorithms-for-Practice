/**
 * Created by John on 3/2/16.
 */
import java.io.*;
import java.util.*;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = {234,23,45,643,24,45};
        quickSort(array, 0, array.length-1);
        System.out.println(Arrays.toString(array));
    }

    private static void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = partition(nums, left, right);
        quickSort(nums, left, pivot-1);
        quickSort(nums, pivot+1, right);
    }

    private static int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        while(left < right){
            while(nums[left] < pivot){
                left++;
            }
            while(nums[right] > pivot){
                right--;
            }
            swap(nums, left, right);
            left++;
            right--;
        }
        return left;
    }

    private static void swap(int[] nums, int a, int b) {
        int tmp = nums[b];
        nums[b] = nums[a];
        nums[a] = tmp;
    }
}

