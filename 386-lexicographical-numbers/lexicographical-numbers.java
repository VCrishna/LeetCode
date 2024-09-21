class Solution {
    /**
        The idea is pretty simple. 
        If we look at the order we can find out 
        we just keep adding digit from 0 to 9 to every digit 
        And make it a tree.
        Then we visit every node in pre-order. 
            1        2        3    ...
            /\        /\       /\
        10 ...19  20...29  30...39   ....
     */
    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            solveRec(i, n, list); // DFS on each starting digit (1-9)
        }
        return list;
    }
    private void solveRec(int start, int n, List<Integer> list) {
        // Base case: If the number exceeds n, stop
        if (start > n) {
            return;
        }

        // Adding current valid number to the list
        list.add(start);

        // Explore the next level by adding digits 0 to 9 
        // at the end of the current number
        for (int i = 0; i < 10; i++) {
            int temp = start * 10 + i; // Generating new number
            if (temp > n) // Stop if the generated number exceeds n
                return;
            else
                solveRec(temp, n, list); // Recursive call for the next number
        }
    }

}