package SupplyHouse.com;

import java.util.Arrays;

/**
 * Created by qiqu on 2/1/16.
 * The graph is divided into 3 parts:
 * upper part where it's a full oval part,
 * the upper half of the lower part where the right of x is increasing by 2 from bottom to top,
 * the lower half of the lower part where the right of x is decreasing by 1 from bottom to top.
 * The left of x is mirrored for upper half and lower half of the graph.
 */
public class Swoosh {
    //Question 1
    public void drawSwoosh(int width) {
        if (width < 5) {//too small for a swoosh
            System.out.println("The width is too small for a swoosh.");
            return;
        }

        //h: the height of the graph; upH: the height of the upper part; cutH: the height of the lower part;
        // upC: the height of the upper half of the lower part; lowC: the height of the lower half of the lower part
        int h, upH, cutH, upC, lowC, i;
        if (width > 12) {//big enough swoosh that falls into partition rules
            h = (width + 1) / 2;
            upH = (h - 1) / 2;
        } else if (width < 11) {//swoosh with 6 lines as height
            h = (width + 1) / 2;
            upH = 2;
        } else {//swoosh with 3 to 5 lines as height and 2 lines as the upper part
            h = 6;
            upH = 3;
        }
        cutH = h - upH;
        upC = cutH / 2;
        lowC = cutH - upC;

        char[][] matrix = new char[h][width];
        for (i = 0; i < h; i++) Arrays.fill(matrix[i], '-');//initially fill the graph

        //Fill the upper part as a full oval part. The upper part shrink by 4 per line as it goes up,
        // other than the line next to the full 'x' line who shrinks by 2
        Arrays.fill(matrix[upH - 1], 'x');
        Arrays.fill(matrix[upH - 2], 1, width - 1, 'x');
        for (i = 1; i < upH - 1; i++) Arrays.fill(matrix[upH - 2 - i], 2 * i + 1, width - 2 * i - 1, 'x');

        //Fill the lower half of the lower part.
        // The right of the line shrink by 1 as it goes up; the left of the line is mirrored with the upper half.
        for (i = 0; i < lowC && i < upH - 2; i++)
            Arrays.fill(matrix[h - i - 1], upH * 2 - 3 - 2 * i, width / 2 - i, 'x');
        if (i < lowC) {//reached the line where the left of the line shrink by 1 but haven't finished shrinking the right of the line
            Arrays.fill(matrix[h - upH + 1], 1, width / 2 - upH + 2, 'x');
            i++;
            for (; i < lowC; i++) Arrays.fill(matrix[h - i - 1], 0, width / 2 - i, 'x');
        } else {//finished shrinking the right of the line
            //fill the upper half of the lower part by filling the part where the left shrinks and where the left is 0
            //the left shrinks by 2
            for (i = lowC; i < upH - 2; i++)
                Arrays.fill(matrix[h - i - 1], upH * 2 - 3 - 2 * i, width / 2 + 2 * i - 3 * lowC + 3, 'x');
            Arrays.fill(matrix[h - upH + 1], 1, width / 2 + 2 * upH - 3 * lowC - 1, 'x');//the left shrinks by 1
            i++;
        }
        //fill the upper half of the lower part where the left is 0
        for (; i < cutH; i++) Arrays.fill(matrix[h - i - 1], 0, width / 2 + 2 * i - 3 * lowC + 3, 'x');
        for (char[] line : matrix) System.out.println(String.valueOf(line));//print out the graph
    }
}
