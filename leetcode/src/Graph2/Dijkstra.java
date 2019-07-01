package Graph2;

import java.util.LinkedList;

public class Dijkstra {
	
	public static void main(String args[]) {
//		Vertex v1=new Vertex(1, 4);
//		Vertex v2=new Vertex(2, 2);
//		Vertex v3=new Vertex(3, 1);
//		Vertex v4=new Vertex(4, 3);
//		PriorityQueue queue = new PriorityQueue(4);
//		queue.add(v1);
//		queue.add(v2);
//		queue.add(v3);
//		queue.add(v4);
//		queue.poll();
//		v4.dist=1;
//		queue.update(v4);
		
		Dijkstra dij = new Dijkstra(5);
		dij.addEdge(0, 1, 4);
		dij.addEdge(1, 2, 3);
		dij.addEdge(0, 2, 2);
		dij.addEdge(1, 3, 5);
		dij.addEdge(3, 4, 4);
		dij.addEdge(1, 4, 6);
		dij.addEdge(2, 4, 7);
		dij.dijkstra(0, 4);
	}
	
	private static int v;// 定点个数
	private static LinkedList<Edge> adj[];// 邻接表
	
	public Dijkstra(int v) {
		this.v = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			adj[i] = new LinkedList<Edge>();
		}
	}
	
	static class Edge{
		private int sid;  //边的起始节点
		private int tid; //边的终止节点
		private int w; //边的权值
		Edge(int sid,int tid,int w){
			this.sid = sid;
			this.tid = tid;
			this.w = w;
		}
	}

	public void addEdge(int s, int t,int w) {
		adj[s].add(new Edge(s,t, w));
	}
	
	public static void  dijkstra(int s,int t) {
		int[] predecessor = new int[v];//最终结果，记录路径用
		Vertex[] vertexes = new Vertex[v];
		for(int i =0;i<v;i++) {// 初始化dijk专用节点数组。每个值初始化为最大，比较大小用
			vertexes[i] = new Vertex(i,Integer.MAX_VALUE);
		}
		PriorityQueue queue = new PriorityQueue(v); //刚刚实现的小顶堆
		boolean[] inqueue = new boolean[v]; //标记是否入过队列 priorityqueue
		vertexes[s].dist=0;
		queue.add(vertexes[s]);
		inqueue[s]=true;
		while(!queue.isEmpty()) {
			Vertex minVertex = queue.poll();
			if(minVertex.id==t) {  //单源路径已经产生
				break;
			}
			for(int i=0;i<adj[minVertex.id].size();i++) {
				Edge e = adj[minVertex.id].get(i);//取出一条minVertex相连的边
				Vertex nextVertex = vertexes[e.tid];
				if(minVertex.dist+e.w<nextVertex.dist) {
					nextVertex.dist=minVertex.dist+e.w;
					predecessor[nextVertex.id] = minVertex.id;
					if(inqueue[nextVertex.id]==true) {
						queue.update(nextVertex);
					}else {
						queue.add(nextVertex);
						inqueue[nextVertex.id]= true;
					}
				}
			}
		}
		System.out.print(s);
		Print(s,t,predecessor);
	}
	
	public static void Print(int s,int t,int[] predecessor) {
		if(s==t) {
			return;
		}
		Print(s,predecessor[t],predecessor);
		System.out.print("->"+t);
	}
	
	//dijkstra 专用 顶点
	static class Vertex{
		int id;	//顶点、编号ID
		int dist; //从起始点到这个点的距离
		Vertex(int id,int dist){
			this.id=id;
			this.dist=dist;
		}
	}
	
	static class PriorityQueue{
		private static Vertex[] nodes;
		private static int v;
		private static int count=0;
		
		PriorityQueue(int v){
			this.nodes = new Vertex[v];
			this.v = v;
		}
		
		public static boolean isEmpty() {
			if(count==0) {
				return true;
			}else {
				return false;
			}
		}
		
		public static void update(Vertex vertex) {
			for(int i = 0;i<nodes.length;i++) {
				if(nodes[i].id==vertex.id) {
					nodes[i].dist=vertex.dist;
				}
			}
			buildHeap(count-1);
		}
		
		public static void buildHeap(int n){
			for (int i = (n - 1) / 2; i >= 0; i--) {
				heapify(nodes,i,n);
			}
		}
		
		public static void add(Vertex vertex) {
			if(count>=v) { //堆满了
				return;
			}			
			nodes[count] = vertex;
			int i = count;
			while((i-1)/2>=0&&nodes[(i-1)/2].dist>nodes[i].dist) {
				swap(nodes,(i-1)/2,i);
			}
			++count;
		}
		
		public static Vertex poll () {
			if(count==0) {
				return null;
			}
			count--;
			Vertex result = nodes[0];
			nodes[0] = nodes[count];
			heapify(nodes,0,count);
			return result;
		}

		public static void heapify(Vertex[] a, int i, int n) {
			while (true) {
				int maxPos = i;
				if (i * 2 + 1 <= n && a[i * 2 + 1].dist < a[i].dist) {
					maxPos = i * 2 + 1;
				}
				if (i * 2 + 2 <= n && a[i * 2 + 2].dist < a[maxPos].dist) {
					maxPos = i * 2 + 2;
				}
				if (maxPos == i) {
					break;
				}
				swap(a, i, maxPos);
				i = maxPos;
			}
		}

		public static void swap(Vertex[] a, int i, int j) {
			Vertex temp = a[i];
			a[i] = a[j];
			a[j] = temp;
		}		
	}

}
