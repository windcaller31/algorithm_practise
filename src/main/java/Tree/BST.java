package Tree;

import util.Node;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BST {
	private static Node theRoot = null;

	public static void main(String args[]) {
		insert(4);
		insert(2);
		insert(6);
		insert(3);
		insert(5);
		insert(7);
		insert(9);
//		delete(6);
//		preVist();
//		backVist();
//		midVisit();
//		levelVisit();
		System.out.print(findPre(6).val);
		System.out.print(findNext(6).val);
	}

	public static Node findPre(int data) {
		Node p = find(data);
		while(p.left!=null) {
			p = p.left;
		}
		return p;
	}
	
	public static Node findNext(int data) {
		Node p = find(data);
		if(p.right==null) {
			return null;
		}
		p=p.right;
		while(p.left!=null) {
			p = p.left;
		}
		return p;
	}
	
	//层次遍历
	public static void levelVisit() {
		Queue<Node> q = new LinkedList<Node>();
		q.add(theRoot);
		while(!q.isEmpty()) {
			Node p = q.poll();
			System.out.print(p.val);
			if(p.left!=null) {
				q.add(p.left);
			}
			if(p.right!=null) {
				q.add(p.right);
			}
		}
	}
	
	public static void midVisit() {
		Stack<Node> s = new Stack<Node>();
		Node p = theRoot;
		while (!s.isEmpty()||p!=null) {
			//一直找到最左节点
			while(p!=null) {
				s.push(p);
				p = p.left;
			}
			//最左节点出栈，继续右节点
			if(!s.isEmpty()) {
				p = s.pop();
				System.out.print(p.val);
				p = p.right;
			}
		}
	}

	public static void backVist() {
		Stack<Node> s = new Stack<Node>();
		s.push(theRoot);
		// 最后一个访问节点
		Node last = null;
		while (!s.isEmpty()) {
			Node p = s.peek();
			if (p.left == null && p.right == null) {
				last = p;
				s.pop();
				System.out.print(p.val);
			} else if ((p.right == null && last == p.left) || last == p.right) {
				last = p;
				s.pop();
				System.out.print(p.val);
			} else {
				if (p.right != null && last != p.right) {
					s.push(p.right);
				}
				if (p.left != null && last != p.left) {
					s.push(p.left);
				}
			}
		}
	}

	public static void preVist() {
		Stack<Node> s = new Stack<Node>();
		s.push(theRoot);
		while (!s.isEmpty()) {
			Node p = s.pop();
			System.out.print(p.val);
			if (p.right != null) {
				s.push(p.right);
			}
			if (p.left != null) {
				s.push(p.left);
			}
		}
	}

	public static void insert(int data) {
		if (theRoot == null) {
			theRoot = new Node(data);
			return;
		}
		Node root = theRoot;
		while (root != null) {
			if (data > root.val) {
				if (root.right == null) {
					root.right = new Node(data);
					return;
				}
				root = root.right;
			} else if (data <= root.val) {
				if (root.left == null) {
					root.left = new Node(data);
					return;
				}
				root = root.left;
			}
		}
	}

	public static void delete(int data) {
		Node p = theRoot;
		Node pp = null; // 父节点
		// 寻找
		while (p != null && p.val != data) {
			pp = p;
			if (p.val < data) {
				p = p.right;
			} else {
				p = p.left;
			}
		}
		// 没找到要删除节点
		if (p == null) {
			return;
		}

		// 双子节点
		if (p.left != null && p.right != null) {
			Node minP = p.right; // 右子树中的最小节点
			Node minPp = p; // minpp表示minP的父节点
			while (minP.left != null) {
				minPp = minP;
				minP = minP.left;
			}
			p.val = minP.val;
			p = minP;
			pp = minPp;
		}

		// 单子节点,让child替换要删除节点p
		Node child;
		if (p.left != null) {
			child = p.left;
		} else if (p.right != null) {
			child = p.right;
		} else {
			child = null;
		}
		// 定位child 将child和父节点pp关联上
		if (pp == null) {
			theRoot = child;
		} else if (pp.left == p) {
			pp.left = child;
		} else {
			pp.right = child;
		}
	}

	public static Node find(int data) {
		Node p = theRoot;
		while (p != null) {
			if (p.val == data) {
				return p;
			}
			if (data < p.val) {
				p = p.left;
			} else if (data > p.val) {
				p = p.right;
			}
		}
		return null;
	}
}
