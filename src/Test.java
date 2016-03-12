/**
 * Created by qiqu on 2/1/16.
 */
public class Test {

    public static void main(String[] args) {
        int[][] maze = new int[][]{
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {1, 1, 0, 1, 1},
                {0, 0, 0, 0, 0}
        };
        int[] start = new int[]{0, 4};
        int[] destinaiton = new int[]{3, 2};
        System.out.println(new MazePath().hasPath(maze, start, destinaiton));
    }

}
