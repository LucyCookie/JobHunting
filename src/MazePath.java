public class MazePath {

    private static int[][] directions = new int[][]{
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0}
    };

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int[][] visited = new int[maze.length][maze[0].length];
        visited[start[0]][start[1]] = -1;
        for (int[] direction : directions) {
            if (hasPath(maze, start, destination, direction, visited)) {
                return true;
            }
        }

        return false;
    }

    private boolean hasPath(int[][] maze, int[] start, int[] destination, int[] direction, int[][] visited) {
        if (start[0] == destination[0] && start[1] == destination[1]) {
            return true;
        }
        int newStartR = start[0] + direction[0];
        int newStartC = start[1] + direction[1];
        if (newStartR < 0 || newStartR >= maze.length || newStartC < 0 || newStartC >= maze[0].length) {
            return false;
        }
        if (visited[newStartR][newStartC] != 0) {
            return visited[newStartR][newStartC] == 1;
        }
        if (maze[newStartR][newStartC] == 1) {
            visited[newStartR][newStartC] = -1;
            return false;
        }
        visited[newStartR][newStartC] = -1;
        int[] newStart = {newStartR, newStartC};
        for (int[] newDirection : directions) {
            if (hasPath(maze, newStart, destination, newDirection, visited)) {
                return true;
            }
        }
        return false;
    }

}
