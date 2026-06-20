class Solution {

    public int maxBuilding(int n, int[][] restrictions) {

        /*
         * Intuition:
         *
         * A building's height can change by at most 1 between adjacent positions.
         *
         * We first make every restriction consistent with all other restrictions.
         * Then, for every pair of consecutive restricted buildings, we compute the
         * maximum height achievable between them.
         */

        List<int[]> restrictionsList = new ArrayList<>();

        // Building 1 always has height 0.
        restrictionsList.add(new int[] {1, 0});

        // Add all given restrictions.
        for (int[] restriction : restrictions) {
            restrictionsList.add(restriction);
        }

        // Sort restrictions by building index.
        Collections.sort(restrictionsList, (a, b) -> a[0] - b[0]);

        /*
         * Left-to-right pass
         *
         * Suppose previous restricted building has height h.
         * Since height can increase by at most 1 per building,
         * current height cannot exceed h + distance.
         *
         * Tighten every restriction using its left neighbor.
         */
        for (int i = 1; i < restrictionsList.size(); i++) {

            int distance =
                restrictionsList.get(i)[0] - restrictionsList.get(i - 1)[0];

            restrictionsList.get(i)[1] = Math.min(
                restrictionsList.get(i)[1],
                restrictionsList.get(i - 1)[1] + distance
            );
        }

        /*
         * Right-to-left pass
         *
         * Similarly, every restriction is also bounded by the
         * restriction on its right.
         *
         * After both passes, every restriction is globally consistent.
         */
        for (int i = restrictionsList.size() - 2; i >= 0; i--) {

            int distance =
                restrictionsList.get(i + 1)[0] - restrictionsList.get(i)[0];

            restrictionsList.get(i)[1] = Math.min(
                restrictionsList.get(i)[1],
                restrictionsList.get(i + 1)[1] + distance
            );
        }

        int maximumHeight = 0;

        /*
         * For every consecutive pair of restrictions:
         *
         * (position1, height1)
         * (position2, height2)
         *
         * The tallest possible building is obtained by increasing from
         * the smaller side until meeting the decreasing slope from
         * the other side.
         *
         * Maximum peak:
         *
         * (height1 + height2 + distance) / 2
         */
        for (int i = 1; i < restrictionsList.size(); i++) {

            int position1 = restrictionsList.get(i - 1)[0];
            int height1 = restrictionsList.get(i - 1)[1];

            int position2 = restrictionsList.get(i)[0];
            int height2 = restrictionsList.get(i)[1];

            int distance = position2 - position1;

            maximumHeight = Math.max(
                maximumHeight,
                (height1 + height2 + distance) / 2
            );
        }

        /*
         * After the last restricted building, there are no more constraints.
         *
         * Height can simply increase by 1 for every remaining building.
         */
        int lastRestrictedPosition =
            restrictionsList.get(restrictionsList.size() - 1)[0];

        int lastRestrictedHeight =
            restrictionsList.get(restrictionsList.size() - 1)[1];

        maximumHeight = Math.max(
            maximumHeight,
            lastRestrictedHeight + (n - lastRestrictedPosition)
        );

        return maximumHeight;
    }
}