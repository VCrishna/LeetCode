class Solution {
    public int[][] imageSmoother(int[][] img) {
        int rows = img.length;
        int columns = img[0].length;
        // Iterating over each pixel in the image
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                int total = 0; // Accumulator for the sum of pixel values in the neighborhood
                int count = 0; // Counter for the number of valid pixels in the neighborhood
                // Iterating over the 3x3 neighborhood around the current pixel
                // row - 1, row, row + 1
                for (int i = row - 1; i < row + 2; i++) {
                    // column - 1, column, column + 1
                    for (int j = column - 1; j < column + 2; j++) {
                        // Checking if the indices are within the bounds of the image
                        if (i >= 0 && i < rows && j >= 0 && j < columns) {
                            // Adding the pixel value to the total
                            total += img[i][j] % 256; // Using modulo 256 to prevent overflow
                            // Incrementing the count of valid pixels
                            count++;
                        }
                    }
                }
                // Updating the original image with the smoothed value using bitwise operations
                img[row][column] = img[row][column] ^ (total / count) << 8; // Storing smoothed value in the upper byte
            }
        }
        // Iterating over each pixel in the image to shift the smoothed value back to the lower byte
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                img[row][column] = img[row][column] >> 8;
            }
        }
        return img;
    }

    public int[][] imageSmoother_BRUTE_FORCE(int[][] img) {
        int rows = img.length;
        int columns = img[0].length;
        int[][] result = new int[rows][columns];
        // Iterating over each pixel in the image
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                int total = 0; // Accumulator for the sum of pixel values in the neighborhood
                int count = 0; // Counter for the number of valid pixels in the neighborhood
                // Iterating over the 3x3 neighborhood around the current pixel
                // row - 1
                // row
                // row + 1
                for (int i = row - 1; i < row + 2; i++) {
                    // column - 1
                    // column
                    // column + 1
                    for (int j = column - 1; j < column + 2; j++) {
                        // Checking if the indices are within the bounds of the image
                        if (i < 0 || i == rows || j < 0 || j == columns) continue;
                        // Adding the pixel value to the total
                        total += img[i][j];
                        // Incrementing the count of valid pixels
                        count++;
                    }
                }
                // Calculating the average value for the current pixel's neighborhood
                result[row][column] = total / count;
            }
        }
        return result;
    }
}
