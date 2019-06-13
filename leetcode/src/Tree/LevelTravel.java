package Tree;

import java.util.LinkedList;
import java.util.Queue;

import util.Node;

public class LevelTravel {
	public static void main(String args[]){
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		n1.left=n2;
//		n1.right=n3;
		n2.left=n4;
		n2.right=n5;
		n4.left=n6;
		Queue<Node> queue = new LinkedList<Node>();
		travel(n1,queue);
	}
	
	public static void travel(Node n,Queue<Node> queue){
		queue.offer(n);
		while(!queue.isEmpty()){
			Node n0 = queue.poll();
			System.out.println(n0.val);
			if(n0.left!=null){
				queue.offer(n0.left);
			}
			if(n0.right!=null){
				queue.offer(n0.right);
			}
		}
	}
}
