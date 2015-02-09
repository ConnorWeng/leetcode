/*
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * For example,
 * Given input array A = [1,1,2],
 * Your function should return length = 2, and A is now [1,2].
 *
 * Runtime: 250 ms
 *
 * 思路：循环数组，当遇到重复的时候，jumpCount就加1，然后不重复的元素往前跳jumpCount个位置(A[i-jumpCount] = A[i])，时间复杂度为O(n)
 *      第一次做这题的时候用了最笨的暴力方法，就是遇到重复，count加1，然后遇到不重复元素立刻将后续的元素全往前挪count个位置，这样时间复杂度是O(n^2)
 */
public class Solution {
    public int removeDuplicates(int[] A) {
        if (A.length == 0) return 0;
        int jumpCount = 0, prev = A[0];
        for (int i = 1; i < A.length; i++) {
            if (prev == A[i]) {
                jumpCount++;
            } else {
                A[i - jumpCount] = A[i];
            }
            prev = A[i];
        }
        return A.length - jumpCount;
     }
 }
