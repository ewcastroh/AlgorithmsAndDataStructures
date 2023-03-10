package arrays;

import java.util.ArrayList;
import java.util.List;

/*
 * Given a sorted array nums,remove the duplicates in-place such that each element
 * appears only once and returns the new length
 */
public class RemoveDuplicatesFromSortedArray {

    public static List<Integer> removeDuplicates(int[] nums) {
        List<Integer> newArray = new ArrayList<>();
        if (nums.length == 0) {
            return newArray;
        }
        int index = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[index] != nums[j]) {
                index++;
                nums[index] = nums[j];
                newArray.add(nums[index]);
            }
        }
        return newArray;
    }

    public static void main(String[] args) {

        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        //int newLength = removeDuplicates(nums);
        //System.out.println("New length: " + newLength);
        //System.out.println("Elements in new array: ");
        //for (int i = 0; i < newLength; i++) {
        //    System.out.println(nums[i]);
        //}
        removeDuplicates(nums).stream().forEach(System.out::println);
    }
	/*
	Example:
		nums =  [0,0,1,1,1,2,2,3,3,4]
		output: [0,1,2,3,4,2,2,3,3,4]
		newLength: 5
	*/
}
