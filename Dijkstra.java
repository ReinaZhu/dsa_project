import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;
public class Dijkstra {
	public static void main(String[] args) { 
		// TODO Auto-generated method stub
		String filename="src\\test1.txt";//读入文件路径需更改 
		int[][]number=read(filename);
		LinkedList<Integer> vertex= count_vertex(number);
		System.out.print("If the graph is undirected,Enter 1;if it is directed,Enter 0:");//判断是否有向
		Scanner scan = new Scanner(System.in);
		int dir=scan.nextInt();
		int[][] matrix;
		LinkedList<LinkedList<Integer[]>> list=new LinkedList<LinkedList<Integer[]>>();
		if(dir==0) {
	        list= di_getlists(number,vertex);//用linkedlist储存邻接表，二维数组储存邻接矩阵
	        matrix=di_getmatrix(number,vertex);}
		else {
			list= undi_getlists(number,vertex);
			matrix=undi_getmatrix(number,vertex);}//此处无向图的矩阵为对称矩阵
		System.out.println("the Adjacency Matrix:");
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[0].length;j++) {
				System.out.printf("%d ",matrix[i][j]);
			}
			System.out.print("\n");
		}
		System.out.println("the Adjacency List:");
		for(int i=0;i<list.size();i++) {
			for(int j=0;j<list.get(i).size();j++) {
				if(j==0) {
					System.out.printf("[%d,%d]",list.get(i).get(j)[0],list.get(i).get(j)[1]);
				}
				else {
				System.out.printf("->[%d,%d]",list.get(i).get(j)[0],list.get(i).get(j)[1]);
			    }
			}
			System.out.print("\n");
		}
		System.out.print("Enter the vertex to start:");//选择起始点
		int start=scan.nextInt();
		String[][]shortpath=ShortestPath(start,list,vertex);
		System.out.println("Vertex\tKnown\tCost\tPath\tTotalPath");
		for(int i=0;i<shortpath.length;i++) {
			for(int j=0;j<shortpath[0].length;j++) {
				System.out.printf("%s\t", shortpath[i][j]);
			}
			System.out.print("\n");
		}
	}		
	
	public static int[][] read (String filename)  {//读入并存为二维数组
		String str = "";
		try {
		Scanner scanner = new Scanner(System.in);
		BufferedReader bf = new BufferedReader(new FileReader(filename));
		String textLine;
		while ((textLine = bf.readLine()) != null) {
			str += textLine + "&";
		}
		bf.close();
		}	
		catch( IOException e) {}
		String[] numbs = str.split("&");
		int[][] number = new int[numbs.length][3];
		for (int i = 0; i < numbs.length; i++) {
			String[] three=numbs[i].split(" ");
			number[i][0] = Integer.parseInt(three[0]);
			number[i][1] = Integer.parseInt(three[1]);
			number[i][2] = Integer.parseInt(three[2]);
		}			
		return number;		
	}

	public static LinkedList<Integer> count_vertex(int[][]number) {//确定顶点的数目
		LinkedList<Integer> count=new LinkedList<Integer>();
		if(number.length>0) {count.add(number[0][0]);
		if(number[0][1]!=number[0][0]) {
			count.add(number[0][1]);
		}
		}
		for(int i=1;i<number.length;i++) {
			int same=0;
			for(int j=0;j<count.size();j++) {
				if(number[i][0]==count.get(j)) {
					same=1;
				}
			}
			if(same==0) {
				count.add(number[i][0]);
			}
			same=0;
			for(int j=0;j<count.size();j++) {
				if(number[i][1]==count.get(j)) {
					same=1;
				}
			}
			if(same==0) {
				count.add(number[i][1]);
			}
		}//将顶点排序
		for(int i=0;i<count.size();i++) {
			int min=count.get(i);
			for(int j=i+1;j<count.size();j++) {
				if(count.get(j)<min) {
					count.set(i,count.get(j));
					count.set(j, min);
					min=count.get(i);
				}
			}
		}		
		return count;
	}
	
	public static int[][] di_getmatrix(int [][]number,LinkedList<Integer> vertex){
		int [][]matrix=new int[vertex.size()][vertex.size()];
		for(int i=0;i<number.length;i++) {
			matrix[number[i][0]][number[i][1]]=number[i][2];
		}	
		return matrix;
	} 
	
	public static int[][] undi_getmatrix(int [][]number,LinkedList<Integer> vertex){
		int [][]matrix=new int[vertex.size()][vertex.size()];
		for(int i=0;i<number.length;i++) {
			matrix[number[i][0]][number[i][1]]=number[i][2];
			matrix[number[i][1]][number[i][0]]=number[i][2];
		}	
		return matrix;
	}
	
	public static LinkedList<LinkedList<Integer[]>> di_getlists(int [][]number,LinkedList<Integer> vertex){
		LinkedList<LinkedList<Integer[]>>lists=new LinkedList<LinkedList<Integer[]>>();
		for(int i=0;i<vertex.size();i++) {
			LinkedList<Integer[]> one=new LinkedList<Integer[]>();
			Integer [] first= {vertex.get(i),0};
			one.add(first);
			for(int j=0;j<number.length;j++) {
				if(number[j][0]==vertex.get(i)) {
					Integer [] then= {number[j][1],number[j][2]};
					one.add(then);
				}
			}
			lists.add(one);
		}
		return lists;		
	}
	public static LinkedList<LinkedList<Integer[]>> undi_getlists(int [][]number,LinkedList<Integer> vertex){
		LinkedList<LinkedList<Integer[]>>lists=new LinkedList<LinkedList<Integer[]>>();
		for(int i=0;i<vertex.size();i++) {
			LinkedList<Integer[]> one=new LinkedList<Integer[]>();
			Integer [] first= {vertex.get(i),0};
			one.add(first);
			for(int j=0;j<number.length;j++) {
				if(number[j][0]==vertex.get(i)) {
					Integer [] then= {number[j][1],number[j][2]};
					one.add(then);
				}
				if(number[j][1]==vertex.get(i)) {
					Integer [] then= {number[j][0],number[j][2]};
					one.add(then);
				}
			}
			lists.add(one);
		}
		return lists;		
	}
	public static String[][] ShortestPath(int start,LinkedList<LinkedList<Integer[]>> list,LinkedList<Integer> vertex){
		String[][] result=new String[vertex.size()][5];//用5列的二维字符串表示，其中第一列为顶点，
						//第二列为是否可到达，第三列为cost，第四列为上一个顶点，第五列为完整的路径
		int max=list.get(0).get(0)[1];
		for(int i=1;i<list.size();i++) {
			for(int j=0;j<list.get(i).size();j++) {
			if(list.get(i).get(j)[1]>max) {
				max=list.get(i).get(j)[1];
		}//找到最大权重值，并将cost起始值设为一个大于最大可能cost的数字
			}
		}
		for(int i=0;i<vertex.size();i++) {
		result[i][0]=String.valueOf(vertex.get(i));
		result[i][1]="F";
		result[i][2]=String.valueOf(max*vertex.size()+1);
		result[i][3]="-1";
		result[i][4]="No Path";
		
		}
		String lastpath="";
		int next=start;
		int cost=0;
		for(int i=0;i<vertex.size();i++) {
			if(i==0) {
				for(int j=0;j<result.length;j++) {
					if( Integer.parseInt(result[j][0])==start) {//设置起点的值
						 result[j][1]="T";
						 result[j][2]="0";
						 result[j][3]=result[j][0]+" ";
						 result[j][4]=result[j][0]+" ";
						 lastpath=result[j][3];
					}}
				for(int k=0;k<list.size();k++) {
					if(list.get(k).get(0)[0]==start) {
						for(int j=0;j<list.get(k).size();j++) {
							for(int m=1;m<result.length;m++) {
								if( Integer.parseInt(result[m][0])==list.get(k).get(j)[0]) {
									 result[m][1]="T";
									 result[m][2]=String.valueOf(list.get(k).get(j)[1]);
									 result[m][3]=String.valueOf(start)+" ";
									 result[m][4]=lastpath+result[m][0]+" ";}}
						}
					}
				}//找到下一个最小cost的顶点
				int min=max*vertex.size()+1;
				for(int j=0;j<result.length;j++) {
					if(Integer.parseInt(result[j][2])<min&&Integer.parseInt(result[j][2])>0) {
						min=Integer.parseInt(result[j][2]);
						next=Integer.parseInt(result[j][0]);
						lastpath=result[j][4];
					}
				}
				cost=min;
				
			}
			else {
			for(int k=0;k<list.size();k++) {
				if(list.get(k).get(0)[0]==next) {
					for(int j=0;j<list.get(k).size();j++) {
						for(int m=0;m<result.length;m++) {
							if( Integer.parseInt(result[m][0])==list.get(k).get(j)[0]) {
								 result[m][1]="T";
								 if((cost+list.get(k).get(j)[1])<Integer.parseInt(result[m][2])) {
								 result[m][2]=String.valueOf(cost+list.get(k).get(j)[1]);
								 result[m][3]=String.valueOf(next)+" ";
								 result[m][4]=lastpath+result[m][0]+" ";}}}
					}
				}
			}
			int min=max*vertex.size()+1;
			for(int j=0;j<result.length;j++) {
				if(Integer.parseInt(result[j][2])<min&&Integer.parseInt(result[j][2])>cost) {
					min=Integer.parseInt(result[j][2]);
					next=Integer.parseInt(result[j][0]);
					lastpath=result[j][4];
				}
			}
			cost=min;
				
			}			
		}
		for(int k=0;k<result.length;k++) {//更改不可到达点的值
			if(result[k][4].equals("No Path")) {
				result[k][2]="INF";
			}
		}
		
		
		return result;
	}
}
