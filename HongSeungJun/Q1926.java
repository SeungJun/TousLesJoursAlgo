import java.util.LinkedList;
import java.util.Queue;

class Q1926 {
    public int nearestExit(char[][] maze, int[] entrance) {
        int rows = maze.length, cols = maze[0].length;
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        // 입구는 출구가 안되므로 '+'로 바꾼다.
        int startRow = entrance[0], startCol = entrance[1];
        maze[startRow][startCol] = '+';

        // bfs를 하기 위해 queue를 선언하고 초기화 해준다.
        // 배열의 마지막 값은 움직인 칸을 세기 위한 변수이다.
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startRow, startCol, 0});

        while (!queue.isEmpty()) {
            // start 지점의 값을 poll 한다.
            int[] currState = queue.poll();
            int currRow = currState[0], currCol = currState[1], currDistance = currState[2];

            // 시작 지점에서 이웃한 지점을 탐색한다.
            for (int[] dir : dirs) {
                int nextRow = currRow + dir[0], nextCol = currCol + dir[1];

                // 방문하지 않은 칸이 있다면
                if (0 <= nextRow && nextRow < rows && 0 <= nextCol && nextCol < cols
                        && maze[nextRow][nextCol] == '.') {

                    // 방문하지 않은 칸이 출구라면 거리를 1 증가 시키고 return
                    if (nextRow == 0 || nextRow == rows - 1 || nextCol == 0 || nextCol == cols - 1)
                        return currDistance + 1;

                    // 방문 했다면 '+'로 변경해주고 다음 칸을 queue에 넣어준다.
                    maze[nextRow][nextCol] = '+';
                    queue.offer(new int[]{nextRow, nextCol, currDistance + 1});
                }
            }
        }

        // 출구를 못찾았다면 -1을 반환
        return -1;
    }
}