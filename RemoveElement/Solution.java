/*
 * Given an array and a value, remove all instances of that value in place and return the new length.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 *
 * Runtime: 188 ms
 *
 * 思路：j指针从数组尾往前寻找第一个不等于elem的元素，i从数组头迭代往后寻找等于elem的元素，然后交换i和j所在位置的元素，直至i = j结束
 */
public class Solution {
    public int removeElement(int[] A, int elem) {
        if (A.length == 0) return 0;
        int i = 0, j = A.length - 1;
        while (i < j) {
            while (i < j) {
                if (A[j] != elem) break;
                j--;
            }
            if (A[i] == elem && A[j] != elem) {
                A[i] = A[j];
                A[j] = elem;
            }
            if (i != j) {
                i++;
            }
        }
        if (A[i] != elem) {
            return i+1;
        } else {
            return i;
        }
    }
}
