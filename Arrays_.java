import java.util.*;

public class Arrays_ {

  public static void main(String[] args) {
    //
  }

  static void operations() {
    // Declare an array
    Integer[] ages = new Integer[10]; // declare an array with size
    int[] ages2 = { 12, 34, 2 }; // instantiate an array

    // sort an array
    Arrays.sort(ages2);

    // Reverse an array
    Collections.reverse(Arrays.asList(ages2));
    // alternatively, bubblesort
    bubbleSort(ages2);

    // convert an array to a list
    List<Integer> ages3 = Arrays.asList(ages);

    // Loop through a map values putting them into a list
    Map<String, Integer> cities = new HashMap<>();
    cities.put("Nairobi", 23);
    cities.put("Kisumu", 234);

    for (Integer integer : cities.values()) {
      ages3.add(integer);
    }
  }

  static void bubbleSort(int[] ages) {
    boolean sorted = false; // stop flag
    while (!sorted) {
      sorted = true; // terminate loop
      for (int i = 0; i < ages.length; i++) {
        if (ages[1] > ages[i + 1]) {
          int temp = ages[i];
          ages[i] = ages[i + 1];
          ages[i + 1] = temp;
          sorted = false; // reset flag to loop through till all is sorted
        }
      }
    }
  }

  protected static void sort_2(int[] nums) {
    // int temp;
    boolean sorted = false; // control flag { 9, 0, -8, 4, 1, 7, 2 };
    while (!sorted) {
      sorted = true;
      for (int i = 0; i < nums.length - 1; i++) {
        if (nums[i + 1] < nums[i]) { // 9, 0 swap the next value if less than current value
          int temp = nums[i]; // 9
          nums[i] = nums[i + 1]; // 0
          nums[i + 1] = temp;
          sorted = false;
        }
      }
    }
  }
}
