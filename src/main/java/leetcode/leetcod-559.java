package leetcode;

import java.util.ArrayList;
import java.util.List;

class leetcode559 {

	public static void main(String args[]){
		Node r5 = new Node(5,null);
		Node r6 = new Node(6,null);
		List<Node> children1 = new ArrayList<Node>();
		children1.add(r5);
		children1.add(r6);
		Node r3 = new Node(3,children1);
		Node r2 = new Node(2,null);
		Node r4 = new Node(4,null);
		List<Node> children2 = new ArrayList<Node>();
		children2.add(r3);
		children2.add(r2);
		children2.add(r4);
		Node r = new Node(1, children2);
		System.out.println(maxDepth(r));
	}

	public static int maxDepth(Node root) {
		if(root == null){
			return 0 ;
		}
		return get_Max_depth(root);
	}

	public static int get_Max_depth(Node node){
		List<Integer> depth_list = new ArrayList<Integer>();
		if(node.children!=null && node.children.size()!=0){
			for(Node n : node.children){
				depth_list.add(get_Max_depth(n));
			}
		}
		return (getMax(depth_list)+1);
	}

	public static int getMax(List<Integer> int_list){
		int max = 0;
		for(Integer i : int_list){
			if(max<i){
				max = i;
			}
		}
		return max;
	}

}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
