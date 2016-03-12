public class Search2DMatrix240 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        if (row == 0) return false;
        int column = matrix[0].length;
        return searchMatrix(matrix, target, 0, 0, row - 1, column - 1);
    }

    private boolean searchMatrix(int[][] matrix, int target, int sR, int sC, int lR, int lC) {
        if (sR == lR && sC == lC) return matrix[sR][sC] == target;
        if (sR > lR || sC > lC) return false;
        int mR = (sR + lR) / 2;
        int mC = (sC + lC) / 2;
        int check = matrix[mR][mC];
        if (target == check) return true;
        if (target < check)
            return searchMatrix(matrix, target, sR, sC, mR - 1, lC) || searchMatrix(matrix, target, mR, sC, lR, mC - 1);
        return searchMatrix(matrix, target, sR, mC + 1, lR, lC) || searchMatrix(matrix, target, mR + 1, sC, lR, mC);
    }

}
