import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class time {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String filename="E:\\data.txt";
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
		int[][] number = new int[numbs.length][6];
		for (int i = 0; i < numbs.length; i++) {
			String[] three=numbs[i].split(",");
			number[i][0] = Integer.parseInt(three[1]);
			number[i][1] = Integer.parseInt(three[2]);
			number[i][2] = Integer.parseInt(three[3]);
			number[i][3] = Integer.parseInt(three[4]);
			number[i][4] = Integer.parseInt(three[5]);
			number[i][5] = Integer.parseInt(three[6]);
		}
		
		
		
	}

}
