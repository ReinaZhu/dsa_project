

import java.util.Scanner;
import java.util.Stack;


public class Maze {
private int[][] mazeMat;
private int width;
private int height;
public Maze(int[][] mazeMatrix, int width, int height) {
this.mazeMat = mazeMatrix;
this.width = width;
this.height = height;
}
public void DFSearchPath(int startX, int startY, int endX, int endY) {
	Stack<Integer> wayX = new Stack<Integer>();
	Stack<Integer> wayY = new Stack<Integer>();
	int[][] mazeMat1=new int[height+2][width+2];
	for(int p=1;p<width+1;p++) {
		for(int q=1;q<height+1;q++) {
			mazeMat1[q][p]=mazeMat[q-1][p-1];
		}
	}
	for(int q=0;q<height+2;q++) {
		mazeMat1[q][0]=0;
		mazeMat1[q][width+1]=0;
	}
	for(int p=0;p<width+2;p++) {
		mazeMat1[0][p]=0;
		mazeMat1[height+1][p]=0;
	}//在迷宫外面加一圈0防止index超过。
	startX=startX+1;
	startY=startY+1;
	endX=endX+1;
	endY=endY+1;
	wayX.push(startX);
	wayY.push(startY);
	int x=startX;
	int y=startY;
	while(x!=endX||y!=endY) {
		if(mazeMat1[x][y+1]==1) {
		
				mazeMat1[x][y]=2;
			y=y+1;
			wayX.push(x);
			wayY.push(y);
		}
		else if(mazeMat1[x+1][y]==1) {
		
				mazeMat1[x][y]=2;
			x=x+1;
			wayX.push(x);
			wayY.push(y);
			
		}
		else if(mazeMat1[x][y-1]==1) {
			mazeMat1[x][y]=2;
		y=y-1;
		wayX.push(x);
		wayY.push(y);
		}
		else if(mazeMat1[x-1][y]==1) {
				mazeMat1[x][y]=2;
			x=x-1;
			wayX.push(x);
			wayY.push(y);
			
		}
		else {
			if(wayX.peek()==startX&&wayY.peek()==startY) {
			System.out.println("No Path");
			x=endX;
			y=endY;
			}
	
			else if(mazeMat1[x+1][y]!=1&&mazeMat1[x-1][y]!=1&&mazeMat1[x][y+1]!=1&&mazeMat1[x][y-1]!=1) {
	   mazeMat1[x][y]=3;
		wayX.pop();
		wayY.pop();
		x=wayX.peek();
	   y=wayY.peek();


	} 
		    }
	}
	mazeMat1[startX][startY]=2;
    mazeMat1[endX][endY]=2;
	for(int p=0;p<width;p++) {
		for(int q=0;q<height;q++) {
			mazeMat[q][p]=mazeMat1[q+1][p+1];
		}
	}
}
@Override
public String toString() {
String ResultString = "";
for (int i = 0; i < height; i++) {
for (int j = 0; j < width; j++) {
ResultString += mazeMat[i][j]+" ";
}
ResultString += "\n";
}
return ResultString;
}




}