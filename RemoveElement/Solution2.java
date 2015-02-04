/*
 * Given an array and a value, remove all instances of that value in place and return the new length.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 *
 * Runtime: 188 ms
 *
 * 思路：用top指针追踪elem个数，top初始指向数组尾部，i从数组头部迭代，遇到elem，top就向前走一步，如果此时top等于elem，则i退一步，如此重复尝试，直到top指向非elem，
 *      交换A[i]和top所指，直到i和top重合（此时必定指向一个非elem元素），返回top+1即是数组长度
 */
public class Solution {
    public int removeElement(int[] A, int elem) {
        int top = A.length - 1;
        for (int i = 0; i < top + 1; i++) {
            if (A[i] == elem) {
                if (A[top] != elem) {
                    A[i] = A[top];
                } else {
                    i--;
                }
                top--;
            }
        }
        return top + 1;
    }
}
