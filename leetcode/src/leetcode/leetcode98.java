package leetcode;

import java.util.List;

public class leetcode98 {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	public static void main(String args[]) {
		TreeNode n1 = new TreeNode(10);
		TreeNode n2 = new TreeNode(5);
		TreeNode n3 = new TreeNode(15);
		TreeNode n4 = new TreeNode(6);
		TreeNode n5 = new TreeNode(20);
		
		n1.left=n2;
		n1.right=n3;
		n3.left=n4;
		n3.right=n5;
		
		System.out.print(isValidBST(n1));
	}

	public static boolean isValidBST(TreeNode root) {
		return test(root,null,null);
	}
	
	public static boolean test(TreeNode root,Integer min,Integer max) {
		if(root==null) {
			return true;
		}
		if(min!=null&&root.val<=min) {
			return false;
		}
		if(max!=null&&root.val>=max) {
			return false;
		}
		return (test(root.right,root.val,max))&&(test(root.left,min,root.val));
	}
}
