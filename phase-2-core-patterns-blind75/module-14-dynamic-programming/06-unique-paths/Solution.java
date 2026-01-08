import java.util.Arrays;

public class Solution {
    public int uniquePaths(int m, int n) {
        int[] row = new int[n];
        // Initialize bottom row with 1s
        Arrays.fill(row, 1);

        // Go through all other rows
        for (int i = 0; i < m - 1; i++) {
            int[] newRow = new int[n];
            Arrays.fill(newRow, 1); // Rightmost column is always 1 path
            for (int j = n - 2; j >= 0; j--) {
                newRow[j] = newRow[j + 1] + row[j];
            }
            row = newRow;
        }

        return row[0];
    }
}
