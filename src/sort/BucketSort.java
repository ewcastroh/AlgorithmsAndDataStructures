package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class BucketSort {

    public static void bucketSortAsc(int[] nums) {
        int numberOfBuckets = (int) Math.ceil(Math.sqrt(nums.length));
        int maxValue = Integer.MIN_VALUE;
        int minValue = Integer.MAX_VALUE;

        //Find max value from the nums array
        for (int value : nums) {
            if (value < minValue) {
                minValue = value;
            } else if (value > maxValue) {
                maxValue = value;
            }
        }

        //Create an array of buckets
        ArrayList<Integer>[] buckets = new ArrayList[numberOfBuckets];

        //initializing empty buckets
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (int value : nums) {
            int bucketNumber = (int) Math.ceil((value * numberOfBuckets) / maxValue);
            // exception: for value = 0, we have to insert to the first bucket
            if (bucketNumber == 0) {
                bucketNumber = 1;
            }
            buckets[bucketNumber - 1].add(value);
        }

        //Sort Each Bucket
        for (ArrayList<Integer> bucket : buckets) {
            Collections.sort(bucket);
        }

        //Merge all buckets
        int index = 0;
        for (ArrayList<Integer> bucket : buckets) {
            for (int value : bucket) {
                nums[index] = value;
                index++;
            }
        }
    }


    public static void main(String[] args) {
        int[] nums ={80, 50, 30, 10, 90, 60, 0, 70, 40, 20, 50};

        System.out.println("Before sorting:");
        String unSortedArrayAsc = Arrays.stream(nums)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println(unSortedArrayAsc);

        System.out.println("After sorting Asc:");
        bucketSortAsc(nums);
        String sortedArrayAsc = Arrays.stream(nums)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println(sortedArrayAsc);
    }
}
