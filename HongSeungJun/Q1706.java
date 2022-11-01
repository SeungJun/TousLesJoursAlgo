public class Q1706 {
    public int[] findBall(int[][] grid) {
        int r_size = grid.length;
        int c_size = grid[0].length;

        int[] result = new int[c_size];
        for (int i = 0; i < c_size; i++) {
            result[i] = DFS(grid,0,i);
        }
        return result;
    }

    public static int DFS(int[][] grid, int depth, int index) {
        if (depth == grid.length) return index;
        int nextIndex = index + grid[depth][index];

        if (nextIndex < 0 || nextIndex > grid[0].length - 1
                || grid[depth][index] != grid[depth][nextIsndex])
            return -1;

        return DFS(grid, depth + 1, nextIndex);
    }
}

