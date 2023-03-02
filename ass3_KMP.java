import java.util.Arrays;
import java.util.LinkedList;

public class ass3_KMP {

	public static void main(String[] args) {
		// computeNextArray样例输入
		int[] next;
		next = computeNextArray("touristrealgod");
		System.out.println(Arrays.toString(next));
		next = computeNextArray("asardasd");
		System.out.println(Arrays.toString(next));
		//现KMPSearchTime样例输入
		String P,S;
		P = "wo";
		S = "chenljnbwowowoo";
		System.out.println(KMPSearchTimes(S,P));
		P = "tourist";
		S = "touristrealgod";
		System.out.println(KMPSearchTimes(S,P));
		// KMPFindLocations 样例输入
		P = "wo";
		S = "chenljnbwowowoo";
		System.out.println(KMPFindLocations(S,P));
		P = "tourist";
		S = "touristrealgod";
		System.out.println(KMPFindLocations(S,P));
	}
	
	public static int[] computeNextArray(String pattern) {
		int[]next=new int[pattern.length()];
		next[0]=-1;
		for(int i=1;i<pattern.length();i++) {
			next[i]=0;
		}		
		for(int i=1;i<pattern.length()-1;i++) {
			String[] front=front_string(i,pattern);
			String[] back=back_string(i,pattern);
			for(int p=0;p<i;p++) {
				if(front[p].equals(back[p])) {
					next[i+1]=p+1;
				}
			}
		}
		return next;
		}
	//实现computeNextArra的时候用到的两个方法。
	public static String[] front_string(int index,String pattern) {
		int len=index;
		String[] front=new String[len];
		String[]all=pattern.split("");
		for(int i=0;i<len;i++) {
			front[i]=all[0];
			for(int j=1;j<i+1;j++) {
				front[i]=front[i]+all[j];
			}
		}
		return front;
	}
	public static String[] back_string(int index,String pattern) {
		int len=index;
		String[] back=new String[len];
		String[]all=pattern.split("");
		for(int i=0;i<len;i++) {
			back[i]=all[len];
			for(int j=1;j<i+1;j++) {
				back[i]=all[len-j]+back[i];
			}
		}
		return back;
	}
	//以上两个方法为computeNextArray时用到，不是要求写的三个方法。
	public static int KMPSearchTimes(String text, String pattern) {
		int time=0;
		char[] altext=text.toCharArray();
		char[] alpattern=pattern.toCharArray();
		int next2[]= {-1,0,-1,0,-1,-1,0,0};
		for(int i=0;i<next2.length;i++) {
			next2[i]=i-next2[i];
		}
		int i=0;
		int j=0;
		while(i<altext.length) {
			j=0;
			while(j!=alpattern.length) {
				if(altext[i]==alpattern[j]) {
					i+=1;
					j+=1;
					if(j==alpattern.length) {
						time+=1;
					}
				}
				else {
					i+=next2[j];
					j=alpattern.length;
				}
			}
		}
		return time;
		}
	
	public static LinkedList<Integer> KMPFindLocations(String text, String
			pattern) {
		 LinkedList<Integer> position=new LinkedList<Integer>();
			char[] altext=text.toCharArray();
			char[] alpattern=pattern.toCharArray();
			int next2[]={-1,0,-1,0,-1,-1,0,0};
			for(int i=0;i<next2.length;i++) {
				next2[i]=i-next2[i];
			}
			int i=0;
			int j=0;
			while(i<altext.length) {
				j=0;
				while(j!=alpattern.length) {
					if(altext[i]==alpattern[j]) {
						i+=1;
						j+=1;
						if(j==alpattern.length) {
							int pos=i-alpattern.length;
							position.add(pos);
						}
					}
					else {
						i+=next2[j];
						j=alpattern.length;
					}
				}
			}		 
		 return position;
			}
}

