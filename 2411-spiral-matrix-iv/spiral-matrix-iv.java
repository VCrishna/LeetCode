/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        // Initializing a matrix of size rows x cols
        int[][] matrix = new int[m][n];

        // Setting boundaries for the spiral traversal
        int topBoundary = 0, bottomBoundary = m - 1;
        int leftBoundary = 0, rightBoundary = n - 1;

        // Traversing the matrix in a spiral order
        while (topBoundary <= bottomBoundary && leftBoundary <= rightBoundary) {
            // Filling the top row from left to right
            for (int col = leftBoundary; col <= rightBoundary; col++) {
                matrix[topBoundary][col] = (head != null) ? head.val : -1;
                if (head != null)
                    head = head.next;
            }
            topBoundary++;

            // Filling the right column from top to bottom
            for (int row = topBoundary; row <= bottomBoundary; row++) {
                matrix[row][rightBoundary] = (head != null) ? head.val : -1;
                if (head != null)
                    head = head.next;
            }
            rightBoundary--;

            // Filling the bottom row from right to left, 
            // if we haven't crossed the top boundary
            if (topBoundary <= bottomBoundary) {
                for (int col = rightBoundary; col >= leftBoundary; col--) {
                    matrix[bottomBoundary][col] = (head != null) ? head.val : -1;
                    if (head != null)
                        head = head.next;
                }
                bottomBoundary--;
            }

            // Filling the left column from bottom to top,
            // if we haven't crossed the left boundary
            if (leftBoundary <= rightBoundary) {
                for (int row = bottomBoundary; row >= topBoundary; row--) {
                    matrix[row][leftBoundary] = (head != null) ? head.val : -1;
                    if (head != null)
                        head = head.next;
                }
                leftBoundary++;
            }
        }

        return matrix;
    }

}