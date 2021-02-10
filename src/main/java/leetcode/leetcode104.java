package leetcode;

public class leetcode104 {
	public int maxDepth(TreeNode root) {
		if(root==null) {
			return 0;
		}
		int leftLen = 1;
		int rightLen = 1;
		if(root.left!=null) {
			leftLen += maxDepth(root.left);
		}
		if(root.right!=null) {
			rightLen += maxDepth(root.right);
		}
		return Math.max(leftLen, rightLen);
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}
