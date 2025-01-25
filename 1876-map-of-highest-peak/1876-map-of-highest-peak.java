class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int rows = isWater.length;
        int cols = isWater[0].length;
        int[][] heights = new int[rows][cols];
        for (int[] row : heights) {
            Arrays.fill(row, -1); // Mark all cells as unvisited initially
        }

        Queue<int[]> queue = new LinkedList<>();

        // Initialize the queue with all water cells
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (isWater[i][j] == 1) {
                    queue.offer(new int[] { i, j });
                    heights[i][j] = 0; // Set height of water cells to 0
                }
            }
        }

        // Directions for moving up, down, left, right
        int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

        // Perform BFS
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                // Check bounds and if the cell is unvisited
                if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && heights[newX][newY] == -1) {
                    heights[newX][newY] = heights[x][y] + 1;
                    queue.offer(new int[] { newX, newY });
                }
            }
        }

        return heights;
    }
}