package leetcode;

public class leetcode112 {
	
//	5
//    / \
//   4   8
//  /   / \
// 11  13  4
///  \      \
//7    2      1
	
	public static void main(String args[]) {
		TreeNode n1 = new TreeNode(5);
		TreeNode n2 = new TreeNode(4);
		TreeNode n3 = new TreeNode(8);
		TreeNode n4 = new TreeNode(11);
		TreeNode n5 = new TreeNode(13);
		TreeNode n6 = new TreeNode(4);
		TreeNode n7 = new TreeNode(7);
		TreeNode n8 = new TreeNode(2);
		TreeNode n9 = new TreeNode(1);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n4.left=n7;
		n4.right=n8;
		n3.left=n5;
		n3.right=n6;
		n6.right=n9;
		
		System.out.print(hasPathSum(n1,22));
	}

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static boolean hasPathSum(TreeNode root, int sum) {
		if(root==null) {
			return false;
		}
		if(hasPathSum(root.left, sum-root.val)) {
			return true;
		}
		if(hasPathSum(root.right, sum-root.val)) {
			return true;
		}
		if(root.left==null&&root.right==null) {
			return sum == root.val;	
		}
		return false;
	}
}
