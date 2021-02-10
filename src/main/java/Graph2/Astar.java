package Graph2;

import java.util.LinkedList;

public class Astar {
	private static int v;// 定点个数
	private static Vertex[] vertexes;
	private static LinkedList<Edge> adj[];// 邻接表

	static class Edge {
		private int sid; // 边的起始节点
		private int tid; // 边的终止节点
		private int w; // 边的权值

		Edge(int sid, int tid, int w) {
			this.sid = sid;
			this.tid = tid;
			this.w = w;
		}
	}

	static class Vertex {
		int id;// 顶点编号
		int dist; // gi
		int f;// fi=gi+hi
		int x, y;// 坐标xy

		public Vertex(int id, int x, int y) {
			this.id = id;
			this.x = x;
			this.y = y;
			this.f = Integer.MAX_VALUE;
			this.dist = Integer.MAX_VALUE;
		}
	}

	public static void addVertex(int id, int x, int y) {
		vertexes[id] = new Vertex(id, x, y);
	}

	public Astar(int v) {
		this.v = v;
		Vertex[] vertexes = new Vertex[this.v];
	}

	public static void astar(int s, int t) {
		int[] predecessor = new int[v];
		//按照vertex的 fi为最短值
		PriorityQueue queue = new PriorityQueue(v);
		boolean[] inqueue=new boolean[v]; //记录已经如果队的节点
		vertexes[s].dist = 0;
		vertexes[s].f = 0;
		queue.add(vertexes[s]);
		inqueue[s] = true;
		while(!queue.isEmpty()) {
			Vertex minVertex = queue.poll(); 
			for(int j=0;j<adj[minVertex.id].size();j++) {
				Edge e = adj[minVertex.id].get(j);//取出一条相连的边
				Vertex nextVertex = vertexes[e.tid];
				if(minVertex.dist+e.w<nextVertex.dist) {
					nextVertex.dist = minVertex.dist+e.w;
					nextVertex.f = nextVertex.dist;// + Manhatten(nextVertex,vertexes[t]); 这个地方应当增加曼哈顿距离
					predecessor[nextVertex.id] = minVertex.id;
					if(inqueue[nextVertex.id]==true) {
						queue.update(nextVertex);
					}else {
						queue.add(nextVertex);
						inqueue[nextVertex.id] = true;
					}
				}
				if(nextVertex.id==t) {
//					queue.clear(); 这个地方清空queue退出循环
					break;
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
	
	static class PriorityQueue {
		private static Vertex[] nodes;
		private static int v;
		private static int count = 0;

		PriorityQueue(int v) {
			this.nodes = new Vertex[v];
			this.v = v;
		}

		public static boolean isEmpty() {
			if (count == 0) {
				return true;
			} else {
				return false;
			}
		}

		public static void update(Vertex vertex) {
			for (int i = 0; i < nodes.length; i++) {
				if (nodes[i].id == vertex.id) {
					nodes[i].dist = vertex.dist;
				}
			}
			buildHeap(count - 1);
		}

		public static void buildHeap(int n) {
			for (int i = (n - 1) / 2; i >= 0; i--) {
				heapify(nodes, i, n);
			}
		}

		public static void add(Vertex vertex) {
			if (count >= v) { // 堆满了
				return;
			}
			nodes[count] = vertex;
			int i = count;
			while ((i - 1) / 2 >= 0 && nodes[(i - 1) / 2].dist > nodes[i].dist) {
				swap(nodes, (i - 1) / 2, i);
			}
			++count;
		}

		public static Vertex poll() {
			if (count == 0) {
				return null;
			}
			count--;
			Vertex result = nodes[0];
			nodes[0] = nodes[count];
			heapify(nodes, 0, count);
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
