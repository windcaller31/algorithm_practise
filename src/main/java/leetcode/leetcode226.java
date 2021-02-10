package leetcode;

public class leetcode226 {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static TreeNode invertTree(TreeNode root) {
		TreeNode r = null;
		TreeNode l = null;
		if(root==null) {
			return null;
		}
		if (root.left != null) {
			l = root.left;
		}
		if (root.right != null) {
			r = root.right;
		}
		root.right = l;
		root.left = r;
		invertTree(l);
		invertTree(r);
		return root;
	}
}
