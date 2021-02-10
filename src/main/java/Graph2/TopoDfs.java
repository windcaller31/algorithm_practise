package Graph2;

import java.util.LinkedList;

public class TopoDfs {
	public static void main(String args[]) {
		TopoDfs topoDfs = new TopoDfs(6);
		topoDfs.addEdge(0, 1);
		topoDfs.addEdge(0, 2);
		topoDfs.addEdge(1, 3);
		topoDfs.addEdge(2, 4);
		topoDfs.addEdge(3, 5);
		topoDfs.addEdge(4, 3);
		sort();
	}
	
	private static int v; //顶点个数
	private static LinkedList<Integer> adj[]; //邻接表
	public TopoDfs(int v) {
		this.v = v;
		adj = new LinkedList[v];
		for(int i=0;i<v;i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}
	
	public void addEdge(int s ,int t) {
		adj[s].add(t);
	}
	
	public static void sort() {
		//构建逆邻接表,边s->t表示s依赖于t，t先于s执行
		LinkedList<Integer>[] inverseAdj = new LinkedList[v];
		for(int i=0;i<v;i++) {
			inverseAdj[i]= new LinkedList<Integer>();
		}		
		//根据邻接表adj生成逆邻接表inverseAdj
		for(int i=0;i<v;i++) {
			for(int j=0;j<adj[i].size();j++) {
				int w= adj[i].get(j);	//i->w w依赖i
				inverseAdj[w].add(i);	//w->i
			}			
		}
		//深度优先遍历
		boolean[] visited = new boolean[v];
		for(int i=0;i<v;i++) {
			if(visited[i]==false) {
				visited[i] = true;
				dfs(i,inverseAdj,visited);
			}
		}
	}
	
	public static void dfs(int vertex,LinkedList<Integer> inverseAdj[],boolean[] visited) {
		for(int i=0;i<inverseAdj[vertex].size();i++) {
			int w = inverseAdj[vertex].get(i);
			if(visited[w]==true) {
				continue;
			}
			visited[w] = true;
			dfs(w,inverseAdj,visited);
		}
		System.out.print("->"+vertex);
	}
}
