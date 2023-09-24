class Solution {
    // this champagne tower is like a pascals triangle
    public double champagneTower(int poured, int query_row, int query_glass) {
        // base case
        if (poured == 0) return 0;
        List<Double> lst = new ArrayList<>();
        lst.add((double) poured); // top glass gets poured amount of champagne
        // no matter how much we pour in the top glass it can hold only 1 glass of champagne
        // so we add total poured into the list and start claculating for the remaining
        // we iterate until the query_row is greater than zero
        // query_row and query_glass are zero indexed
        while (query_row-- > 0) {
            // calculating champagne after pouring in the first cup
            // if n is poured in the first cup then (n-1)/2 is flowed from left and right of the cup
            // n-1 is because the top cup hold 1 cup of champagne
            // so it can be max of 0 or (n-1)/2
            // for next row it will be (((n-1)/2)-1)/2
            Double champagneInEnd = Math.max(0, (lst.get(0) - 1) / 2); // min champagne can be 0
            // currentrow holds the amount of champagne each glass holds in that row
            // adding champagneInEnd to current row at the begining and ending of that row just like pascals triangle 
            List<Double> currentRow = new ArrayList<>(Arrays.asList(champagneInEnd)); // adding first to the row
            for (int i = 1; i < lst.size(); i++) {
                currentRow.add(
                    Math.max(0, (lst.get(i - 1) - 1) / 2) + // flow from top-left glass
                    Math.max(0, (lst.get(i) - 1) / 2) // flow from top-right glass
                );
            }
            currentRow.add(currentRow.get(0)); // last glass in the row
            // as there is no need to hold all the rows so we only care about current row and previous row
            // updating lst with current row
            lst = new ArrayList<>(currentRow);
        }
        return Math.min(1, lst.get(query_glass)); // max champagne can be 1
    }
}

// public class Solution {
//     public double champagneTower(int poured, int query_row, int query_glass) {
//         double[][] tower = new double[query_row + 1][query_row + 1];
//         tower[0][0] = (double) poured;

//         for (int row = 0; row < query_row; row++) {
//             for (int glass = 0; glass <= row; glass++) {
//                 double excess = (tower[row][glass] - 1.0) / 2.0;
//                 if (excess > 0) {
//                     tower[row + 1][glass] += excess;
//                     tower[row + 1][glass + 1] += excess;
//                 }
//             }
//         }

//         return Math.min(1.0, tower[query_row][query_glass]);
//     }
// }