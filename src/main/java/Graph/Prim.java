package Graph;


public class Prim {
	//定义一个二维数组为邻接表
	int[][] matrix = new int[10][10];
	
	//vertexSize是邻接数组中一行的长度
	public void createMinSpanTreePrim(int vertexSize) {
		//定义一维数组，存放用于比较最小权值得最小顶点的权值，0代表已经比较过了
		int[] lowcost = new int[vertexSize];
		//初始化数组为邻接表的第一个顶点
		System.arraycopy(matrix[0], 0, lowcost, 0, vertexSize);
		int sum = 0;
		//循环比较
		for(int i = 0;i<vertexSize;i++) {
			//先比较找出最小的权值节点，然后遍历该节点的每个边，选出权值最小边的下标j
			int min = -1;
			//找到当前节点邻接边中权值最小,然后将权值最小对应的点记录到min
			for(int j=0;j<vertexSize;j++) {
				if(lowcost[j]>0) {
					if(min!=-1||lowcost[min]>lowcost[j]) {
						min = j;
					}else if(min==-1) {
						min = j;
					}
				}
			}
			//当前节点没有邻接节点,它的邻接边权值全是0，说明已经到头了
			if(min==-1) {
				break;
			}
			//找到当前节点邻接边中权值最小的边，打印之
			System.out.println("访问到了节点"+min+"权值"+lowcost[min]);
			sum+=lowcost[min];
			//找到最小节点后，在最小节点的邻接边中找到最小权值的位置j，替换lowcost[j]的值
			//相当于走到下一个最小节点找到更小的边替换到lowcost 继续遍历lowcost
			for(int j=0;j<vertexSize;j++) {
				if(matrix[min][j]>lowcost[j]) {
					lowcost[j]=matrix[min][j];
				}
			}
		}
		System.out.println("最小生成树:"+sum);
	}
}
