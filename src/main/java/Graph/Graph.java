package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class Graph {
	private int v; //定点个数
	private LinkedList<Integer> adj[]; //邻接表
	public Graph(int v){
		this.v = v;
		adj = new LinkedList[v];
		for(int i =0;i<v;i++){
			adj[i] = new LinkedList<>();
		}
	}
	
	public void addEdge(int s,int t){
		adj[s].add(t);
		adj[t].add(s);
	}
	
	//广度优先
	public void bfs(int s,int t){
		if(s==t){
			return;
		}
		//记录被访问的顶点
		boolean visited[] = new boolean[v];
		//s被访问
		visited[s]=true;
		//队列，记录即将访问层的上一层
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(s);
		int[] prev = new int[v];
		for(int j = 0;j<v;j++){
			prev[j] = -1; 
		}
		//开始广度优先
		while(queue.size()!=0){
			int w = queue.poll();
			for(int i =0;i<adj[w].size();i++){
				int q = adj[w].get(i);
				if(!visited[q]){
					//q访问过了记录之
					visited[q] = true;
					prev[q] = w;
					//已经访问过,入队
					queue.add(q);
					//找到t结束
					if(t==q){
						print(prev,s,t);
						return;
					}
				}
			}
		}
	}
	
	//深度优先遍历
	//针对深度优先遍历是否找到 found
	private boolean found = false;
	public void dfs(int s,int t){
		found = false;
		boolean[] visited=new boolean[v];
		int prev[] = new int[v];
		for(int i=0;i<v;i++){
			prev[i]=-1;
		}
		recurDFS(s,t,visited,prev);
		print(prev,s,t);
	}
	
	private void recurDFS(int w,int t,boolean[] visited,int[] prev){
		if(found==true){
			return;
		}
		visited[w] = true;
		if(w==t){
			found=true;
			return;
		}
		for(int i =0;i<adj[w].size();i++){
			int q = adj[w].get(i);
			if(!visited[q]){
				prev[q] = w;
				recurDFS(q,t,visited,prev);
			}
		}
	}
	
	private void print(int prev[],int s,int t){
		if(prev[t]!=-1&&t!=s){
			print(prev,s,prev[t]);
		}
		System.out.println(t+"->");
	}
	
}
