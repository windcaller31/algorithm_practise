package Graph;

public class Kruskal {
	//Edge自定义对象，起点、终点、权值
	class Edge{
		public int start;
		public int end;
		public int weight;
	}
	
	//edges根据所有边的权值从小到大排序存放Edge
	public void createMinSpnTreeKruskal(int edgeSize,Edge[] edges){
		//定义一个一维数组，下标为连线的起点，值为连线的终点
		int[] parent = new int[edgeSize];
		for(int i=0;i<edgeSize;i++) {
			parent[i]=0;
		}
		int sum= 0;
		for(Edge edge:edges) {
			//找到起点和终点在临时连线数组中最后连接的点
			int start = find(parent,edge.start);
			int end = find(parent,edge.end);
			//判断start end 是否为同一个点，产生环
			//也可以理解为start到end的路径已经有更短的记录了，该记录被放弃
			if(start!=end) {
				//没有产生环则将临时数组中起点定位下标，终点定位值
				parent[start] = end;
				System.out.println("访问到了节点:"+start+","+end+",权值"+edge.weight);
				sum+=edge.weight;
			}			
		}
		//最小权值
		System.out.println(sum);
	}
	
	//获取集合最后的联通点
	public int find(int parent[],int index) {
		//parent数组下标是连线的起点index，
		// 不断地循环，只要有路可走。
		//根据起点index找到parent中的终点 parent[index]
		while(parent[index]>0) {
			index = parent[index];
		}
		return index;
	}
}
