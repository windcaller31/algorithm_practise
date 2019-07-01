package Graph2;

import java.util.LinkedList;

public class DirectGraph {
	private int v; //顶点个数
	private LinkedList<Integer> adj[]; //邻接表
	public DirectGraph(int v) {
		this.v = v;
		adj = new LinkedList[v];
		for(int i=0;i<v;i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}
	
	public void addEdge(int s ,int t) {
		adj[s].add(t);
	}
}
