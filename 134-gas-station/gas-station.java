class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasSum = 0;
        int costSum = 0;
        for (int i = 0; i < gas.length; i++) {
            gasSum += gas[i];
            costSum += cost[i];
        }
        // If the total gas is less than the total cost, 
        // it's impossible to complete the circuit
        if (gasSum < costSum) {
            return -1;
        }
        int total = 0;
        int result = 0;
        for (int i = 0; i < gas.length; i++) {
            // If the gas at the current station is not sufficient to cover the cost,
            // reset the total and update the potential starting station
            total += gas[i] - cost[i];
            if (total < 0) {
                total = 0;
                result = i + 1;
            }
        }

        return result;
    }
}
// gas =  [1,2,3,4,5],
// cost = [3,4,5,1,2]
// diff = [-2,-2,-2,3,3]
//         0,1,2,3,4
