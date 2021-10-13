import java.util.*;

public class CodilityReverseFragments {

  public static void main(String[] args) {
    // you can write to stdout for debugging purposes, e.g.
    //in: 45, 67, 32, 8, 0, 22, 21, 0, 25, 0, 32, 56 =>
    //out:8, 32, 67, 45, 0, 21, 22, 0, 25, 0, 56, 32
    int[] nums = { 45, 67, 32, 8, 0, 22, 21, 0, 25, 0, 32, 56 };
    loopThenReverse(nums);
    assert nums[0] == 8;
  }

  /**
   * Loop through array to create fragements
   * Start value begins at 0 by default, end value should be the next instance we spot a zero, then one index behind
   * Next start value should be the last index we spotted a zero, increment index by 1
   * Eventualy, reverse the last remaining section of array till end of array
   * @param nums
   */
  static void loopThenReverse(int[] nums) {
    // loop through the elements
    int start = 0, end = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 0) {
        end = i - 1;
        reverseFragment(nums, start, end);
        start = i + 1;
      }
    }
    reverseFragment(nums, start, nums.length - 1);
  }

  /**
   * Continously swap values as this is a reversal process,
   * last value swaps with first value and so on untill there are no more swaps to be done
   * @param nums
   * @param start
   * @param end
   */
  static void reverseFragment(int[] nums, int start, int end) {
    while (start < end) {
      int temp = nums[start];
      nums[start] = nums[end];
      nums[end] = temp;
      start++;
      end--;
    }
  }
}
