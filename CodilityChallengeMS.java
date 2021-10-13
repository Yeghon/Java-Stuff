import java.util.*;

public class CodilityChallengeMS {

  public static void main(String[] args) {
    System.out.println("====== Begin execution =====");
    /**
     * Minimum deletions
     *
     */
    System.out.println("Deletions: " + minimumDeletions("aaaabbbbc"));
    System.out.println("===== End of program ======");
  }

  /**
   * Given a binary number, if even divide by 2, if odd subtract 1 S is between 1
   * and 1000000
   */
  public static int operations(String S) {
    int size = S.length(), result = 0, operations = 0;
    if (size < 1 || size > 1000000) return 0;

    // convert a binary to decimal
    S = new StringBuilder(S).reverse().toString();

    for (int i = 0; i < size; i++) {
      if (S.charAt(i) != '0' && S.charAt(i) != '1') return 0; // Check characters other than 0 or 1

      if (S.charAt(i) == '1') result += Math.pow(2, i);
    }

    while (result > 0) {
      if (result % 2 == 0) result /= 2; else result -= 1;
      operations++;
    }

    return operations;
  }

  /**
   * Stable periods within an array of elements
   *
   * @param A
   * @return
   */
  public static int stablePeriods(int[] A) {
    int size = A.length, periods = 0;

    if (size > 0 && size < 100) {
      for (int i = 2; i < size; i++) {
        int value2 = Math.abs(A[i - 2]), value1 = Math.abs(
          A[i - 1]
        ), value = Math.abs(A[i]);

        if (Math.abs(value2 - value1) == Math.abs(value1 - value)) periods += 1;
      }
    }
    return periods < 1000000000 ? periods : -1;
  }

  /**
   * Given a string, delete the maximum number of characters in the string
   *
   * @param nums
   * @return
   */
  public static int minimumDeletions(String S) {
    int response = 0;
    /**
     * pseudocode
     * eeee == 0, given there's only one letter
     * aaaabbbb == 1, given a & b occurs 4 times, remove one on either and you're left with 4as & 3bs or 3as & 4bs
     * ccaaffddecee == 6,
     * example == 4
     * step 1. Store each element's occurrence
     * step 2. Sort the occurence count from above
     * step 3. Begin deductions downwards from step above
     * step 4. When 0, sum deductions from step 3 to what is left
     */
    Map<Character, Integer> occurrences = new HashMap<>();
    for (int i = 0; i < S.length(); i++) {
      if (!occurrences.containsKey(S.charAt(i))) {
        occurrences.put(S.charAt(i), 1);
      } else {
        occurrences.put(S.charAt(i), occurrences.get(S.charAt(i)) + 1);
      }
    }

    List<Integer> counts = new ArrayList<>();
    for (Integer s : occurrences.values()) {
      counts.add(s);
    }

    Collections.sort(counts);
    Collections.reverse(counts);
    System.out.println("Collection: " + counts);

    /**
     * Loop through the ordered list,
     * if current is same as next, check if next is same as next,
     */
    // 1. loop through the sorted list
    // 2. if current value is same as next value,
    // 2.1 if next value is same as 3rd value, deduct the number, else subtract 1
    // finally: if current value is 1, deduct all remaining values

    // capture indexoutofbounds exception
    if (counts.size() < 2) {
      return 0;
    }
    //1
    for (int i = 0; i < counts.size(); i++) {
      //   System.out.println(
      //     "Accessing: " + counts.get(i) + " and: " + counts.get(i + 1)
      //   );
      // capture index out of bounds exception
      if (counts.get(i) == 1) {
        for (int j = i + 1; j < counts.size(); j++) {
          response = response + counts.get(j);
        }
        break;
      } else if (counts.get(i) == counts.get(i + 1)) { // Todo, this bit throws an indexoutofboundsexception
        response = response + 1;
        counts.set(i + 1, counts.get(i + 1) - 1);
      }
    }

    return response;
  }
}
