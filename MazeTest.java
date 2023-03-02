import java.util.Scanner;

public class MazeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int width=0;
		int height=0;
		int endx=-1;
		int endy=-1;
		int startx=-1;
		int starty=-1;
		while(width==0||height==0||endx==-1||endy==-1||startx==-1||starty==-1) {
			try {
	    System.out.print("please input the height of the maze:");
		Scanner scanner1 = new Scanner(System.in);
	    height= scanner1.nextInt();
		System.out.print("please input the width of the maze:");
		Scanner scanner = new Scanner(System.in);
	    width= scanner.nextInt();
	    System.out.print("please input the start point,separated by a comma:");
		Scanner scanner4 = new Scanner(System.in);
	    String b= scanner4.nextLine();
	    String []bb=b.split(",");
	    startx=Integer.parseInt(bb[0]);
	    starty=Integer.parseInt(bb[1]);
	    System.out.print("please input the end point,separated by a comma:");
		Scanner scanner2 = new Scanner(System.in);
	    String c= scanner2.nextLine();
	    String []cc=c.split(",");
	    endx=Integer.parseInt(cc[0]);
	    endy=Integer.parseInt(cc[1]);    
	    }
			catch(Exception e){//捕获输入异常
		 		 System.out.println("the input is not available,please input again");
		 	  }	
			if(startx<0||startx>height-1||endx<0||endx>height-1) {
				System.out.print("x axis should between 0 to");
				System.out.print(height-1);
				System.out.println("please input again");
				startx=-1;
			}
			if(starty<0||starty>width-1||endy<0||endy>width-1) {
				System.out.print("y axis should between 0 to");
				System.out.print(width-1);
				System.out.println("please input again");
				starty=-1;
			}
		}
		int[][] mazeMatrix = new int[height][width];
		// initialize the matrix

	String start="again";
	String done="done";
	while(start.equals(done)==false) {
			try {
				System.out.println("Please enter the maze, press Space between two numbers and press Enter every line (Where 1 means the background is passable, "
						+ "0 means the obstacle is not passable, and the searched path will be marked as 2):");
			for(int i=0;i<height;i++) {
				Scanner scanner = new Scanner(System.in);
		        String aa = scanner.nextLine();
		        String[] a= aa.split(" ");
			for(int j=0;j<width;j++) {
				mazeMatrix[i][j]=Integer.parseInt(a[j]);
			}}
	        start="done";
			}
	 	   catch(java.lang.ArrayIndexOutOfBoundsException e){//捕获输入异常
	 		  System.out.println("the number of one line should equal to width,please input again,from the first one");
	 	   }
		   catch(Exception e) {
			   System.out.println("the input is not available,please input again,from the first one");
		   }
	}
		Maze maze = new Maze(mazeMatrix, width, height);
		System.out.print(maze);
		maze.DFSearchPath(startx, starty, endx, endy);
		System.out.println("the path is: ");
		System.out.print(maze);
		}

}
