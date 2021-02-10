package Graph2;

import java.util.LinkedList;

public class Kahn {
	
	public static void main(String args[]) {
		Kahn kahn = new Kahn(6);
		kahn.addEdge(0, 1);
		kahn.addEdge(0, 2);
		kahn.addEdge(1, 3);
		kahn.addEdge(2, 4);
		kahn.addEdge(3, 5);
		kahn.addEdge(4, 3);
		SortByKahn();
	}
	
	private static int v; //顶点个数
	private static LinkedList<Integer> adj[]; //邻接表
	public Kahn(int v) {
		this.v = v;
		adj = new LinkedList[v];
		for(int i=0;i<v;i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}
	
	public void addEdge(int s ,int t) {
		adj[s].add(t);
	}
	
	public static void SortByKahn() {
		//计算入度
		int[] inDegree = new int[v];
		for(int i=0;i<v;i++) {
			for(int j=0;j<adj[i].size();j++) {
				int w = adj[i].get(j); //i->w w入+1
				inDegree[w]++;
			}	
		}
		
		LinkedList<Integer> queue = new LinkedList<Integer>();
		for(int i =0;i<v;i++) {
			if(inDegree[i]==0) {
				queue.add(i);
			}			
		}
		while(!queue.isEmpty()) {
			int i=queue.remove();
			System.out.print("->"+i);
			for(int j=0;j<adj[i].size();j++) {
				int k = adj[i].get(j);
				inDegree[k]--;
				if(inDegree[k]==0) {
					queue.add(k);
				}
			}
		}
	}
}
