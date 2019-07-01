package Graph2;

public class DirectValueGraph {
	private int v;//顶点个数
	private int[][] matrix; //带权有向邻接表
	public DirectValueGraph(int v) {
		this.v= v;
		matrix = new int[v][v];
	}
	
	public void addEdge(int s, int t,int w) {//s->t 权值w
		matrix[s][t]=w;
	}
}
