public class Maze490 {

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
        int newSartC = start[1] + direction[1];
        if (newStartR < 0 || newStartR >= maze.length || newSartC < 0 || newSartC >= maze[0].length) {
            return false;
        }

        int[] next = new int[]{start[0] + direction[0], start[1] + direction[1]};
        if (isWall(maze, next)) {
            return false;
        }
        while ()


            if (visited[newStartR][newSartC] != 0) {
                return visited[newStartR][newSartC] == 1;
            }
        if (maze[newStartR][newSartC] == 1) {
            visited[newStartR][newSartC] = -1;
            return false;
        }
        visited[newStartR][newSartC] = -1;
        int[] newStart = {newStartR, newSartC};
        return hasPath(maze, newStart, destination, direction, visited);
        return false;
    }

    private boolean isWall(int[][] maze, int[] position) {
        return position[0] < 0 || position[0] >= maze.length || position[1] < 0 || position[1] > maze[0].length || maze[position[0]][position[1]] == 1;
    }

}
