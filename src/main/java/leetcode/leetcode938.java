package leetcode;

import util.TreeNode;

/**
 * @author limengtong
 * @date 2019/11/5 6:16 下午
 */
public class leetcode938 {
    public static void main(String args[]) {
        TreeNode r1 = new TreeNode(10);
        TreeNode r2 = new TreeNode(5);
        TreeNode r3 = new TreeNode(15);
        r1.left = r2;
        r1.right = r3;
        TreeNode r4 = new TreeNode(3);
        TreeNode r5 = new TreeNode(7);
        r2.left = r4;
        r2.right = r5;
        TreeNode r6 = new TreeNode(18);
        r3.right = r6;
        System.out.println(rangeSumBST(r1, 7, 15));
    }

    public static int rangeSumBST(TreeNode root, int L, int R) {
        int sum = 0;
        return subSum(root, L, R, sum);
    }

    public static int subSum(TreeNode root, int L, int R, int sum) {
        if (root.val >= L && root.val <= R) {
            sum += root.val;
        }
        if (root.left != null) {
            sum = subSum(root.left, L, R, sum);
        }
        if (root.right != null) {
            sum = subSum(root.right, L, R, sum);
        }
        return sum;
    }
}
