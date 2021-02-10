package Graph2;

import java.util.LinkedList;
import java.util.Queue;

public class Graph {
	private static int v;// 定点个数
	private static LinkedList<Integer> adj[];// 邻接表

	public static void main(String args[]) {
		Graph graph=new Graph(4);
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
//		bfs(0,3);
		dfs(0, 3);
	}
	
	public Graph(int v) {
		this.v = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}

	public void addEdge(int s, int t) {
		adj[s].add(t);
		adj[t].add(s);
	}

	//深度优先搜索
	private static boolean found = false;
	public static void dfs(int s,int t) {
		found = false;
		boolean[] visited = new boolean[v];
		int prev[] = new int[v];
		for(int i=0;i<v;i++) {
			prev[i] = -1;
		}
		recurDfs(s,t,visited,prev);
		print(prev,s,t);
	}
	
	public static void recurDfs(int s,int t,boolean[] visited,int[] prev) {
		if(found==true) {
			return;
		}
		visited[s] = true;
		if(s==t) {
			found=true;
			return;
		}
		//选中s顶点
		for(int i =0;i<adj[s].size();i++) {
			//获取s的邻接顶点q
			int q = adj[s].get(i);
			//没有访问过q，则记录q然后递归q
			if(!visited[q]) {
				prev[q]=s;
				recurDfs(q,t,visited,prev);
			}
		}
	}
	
	// 广度优先搜索
	public static void bfs(int s, int t) {
		if (s == t) {
			return;
		}
		boolean visited[] = new boolean[v];
		visited[s] = true;
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(s);
		//prev记录访问节点
		int[] prev = new int[v];
		for(int j = 0;j<v;j++){
			prev[j] = -1; 
		}
		//开始广度优先
		while(q.size()!=0) {
			int w =q.poll();
			for(int i=0;i<adj[w].size();i++) {
				int k = adj[w].get(i);
				if(!visited[k]) {
					prev[k]=w;
					if(t==k) {
						print(prev,s,t);
						return;
					}
					q.add(k);
					visited[k] = true;
				}
			}
		}
	}
	
	private static void print(int prev[],int s,int t){
		if(prev[t]!=-1&&t!=s){
			print(prev,s,prev[t]);
		}
  		System.out.print(t+"->");
	}
}
