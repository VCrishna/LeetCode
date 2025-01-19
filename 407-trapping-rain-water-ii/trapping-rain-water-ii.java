class Solution {
    public int trapRainWater(int[][] heightMap) {
        int trappedSnow = 0;
        int[][] snowLevelMap = new int[heightMap.length][heightMap[0].length];

        // Copy the heights from the original heightMapay to the snow level map
        for (int i = 1; i < heightMap.length - 1; i++) {
            for (int j = 1; j < heightMap[i].length - 1; j++) {
                snowLevelMap[i][j] = 20_000;
            }
        }

        // Copy heights from boundaries
        for (int i = 0; i < heightMap[0].length; i++) {
            snowLevelMap[0][i] = heightMap[0][i];
            snowLevelMap[heightMap.length - 1][i] = heightMap[heightMap.length - 1][i];
        }
        for (int i = 0; i < heightMap.length; i++) {
            snowLevelMap[i][0] = heightMap[i][0];
            snowLevelMap[i][heightMap[0].length - 1] = heightMap[i][heightMap[0].length - 1];
        }

        // Start draining process
        boolean drain = true;
        while (drain) {
            drain = false;
            for (int i = 1; i < heightMap.length - 1; i++) {
                for (int j = 1; j < heightMap[i].length - 1; j++) {
                    if (snowLevelMap[i][j] > heightMap[i][j]) {
                        if (snowLevelMap[i][j] > snowLevelMap[i][j - 1])
                            snowLevelMap[i][j] = Integer.max(snowLevelMap[i][j - 1], heightMap[i][j]);
                        if (snowLevelMap[i][j] > snowLevelMap[i - 1][j])
                            snowLevelMap[i][j] = Integer.max(snowLevelMap[i - 1][j], heightMap[i][j]);
                        if (snowLevelMap[i][j] > snowLevelMap[i][j + 1])
                            snowLevelMap[i][j] = Integer.max(snowLevelMap[i][j + 1], heightMap[i][j]);
                        if (snowLevelMap[i][j] > snowLevelMap[i + 1][j])
                            snowLevelMap[i][j] = Integer.max(snowLevelMap[i + 1][j], heightMap[i][j]);
                        if (snowLevelMap[i][j] < snowLevelMap[i][j - 1] && snowLevelMap[i][j - 1] > heightMap[i][j - 1]
                                || snowLevelMap[i][j] < snowLevelMap[i][j + 1] && snowLevelMap[i][j + 1] > heightMap[i][j + 1]
                                || snowLevelMap[i][j] < snowLevelMap[i - 1][j] && snowLevelMap[i - 1][j] > heightMap[i - 1][j]
                                || snowLevelMap[i][j] < snowLevelMap[i + 1][j] && snowLevelMap[i + 1][j] > heightMap[i + 1][j])
                            drain = true;
                    }
                }
            }
        }

        // Calculate trapped snow
        for (int i = 1; i < snowLevelMap.length - 1; i++) {
            for (int j = 1; j < snowLevelMap[i].length - 1; j++) {
                trappedSnow += snowLevelMap[i][j] - heightMap[i][j];
            }
        }

        return trappedSnow;
    }
}