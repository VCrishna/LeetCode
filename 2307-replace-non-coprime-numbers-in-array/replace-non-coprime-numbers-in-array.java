class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> stk = new ArrayList<>();
        // stack-like structure to hold final numbers after merging

        for (int x : nums) {
            stk.add(x);
            // add the current number

            while (stk.size() > 1) {
                x = stk.get(stk.size() - 1); // top element
                int y = stk.get(stk.size() - 2); // second top element
                int g = gcd(x, y); // compute GCD

                if (g == 1) {
                    // if coprime, stop merging
                    break;
                }

                // otherwise, merge into LCM
                stk.remove(stk.size() - 1); // remove top
                stk.set(stk.size() - 1, (int) ((long) x * y / g));
            }
        }
        return stk;
        // final stable list
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b); // Euclidean algorithm
    }
}
