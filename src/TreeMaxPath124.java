public class TreeMaxPath124 {

    public int maxPathSum(TreeNode root) {
        return calculateNodeCount(root)[0];
    }

    private int[] calculateNodeCount(TreeNode node) {
        if (node == null) {
            return new int[]{Integer.MIN_VALUE, 0};
        }
        int[] left = calculateNodeCount(node.left);
        int leftMax = left[0];
        int leftMaxPath = left[1];
        int[] right = calculateNodeCount(node.right);
        int rightMax = right[0];
        int rightMaxPath = right[1];
        int maxPath = Math.max(node.val + (leftMaxPath > rightMaxPath ? leftMaxPath : rightMaxPath), 0);
        int max = Math.max(Math.max(leftMax, rightMax), leftMaxPath + node.val + rightMaxPath);
        return new int[]{max, maxPath};
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}