package pro;

import java.util.Arrays;
import java.util.LinkedList;

public class KMP {
	
	public static int[] computeNextArray(String pattern) { 
		int [] next;
		if(pattern.length()==1) {
			next=new int[1];
			next[0]=-1;
		}else if(pattern.length()==2) {
			next=new int[2];
			next[0]=-1;next[1]=0;
		}else {
			next=new int[pattern.length()];
			next[0]=-1;next[1]=0;
			for(int i=2;i<pattern.length();i++) {
				for(int j=0,k=i-1;j<i-1&&k>0;j++,k--) {
					String prefix=pattern.substring(0, j+1);
					String lastfix=pattern.substring(k, i);
					if(prefix.equals(lastfix)) {
						next[i]=j+1;
					}
				}
			}
		}
		return next;
	}
	
	public static int KMPSearchTimes(String text, String pattern) { 
		int[]array = computeNextArray(pattern);int times=0;
		outer:for(int i=0;i<text.length()-pattern.length()+1;i++) {
			for(int j=0;j<pattern.length();j++) {
				if(pattern.charAt(j)==text.charAt(i)) {
					if(j==pattern.length()-1) {
						times++;continue outer;
					}i++;continue;
				}else {
					i+=((j-array[j])-1-j);continue outer;
				}
			}
		}return times;
	}
	
	public static LinkedList<Integer> KMPFindLocations(String text, String pattern) { 
		int[]array = computeNextArray(pattern);
		LinkedList<Integer> list=new LinkedList<>();
		outer:for(int i=0;i<text.length()-pattern.length()+1;i++) {
			for(int j=0;j<pattern.length();j++) {
				if(pattern.charAt(j)==text.charAt(i)) {
					if(j==pattern.length()-1) {
						list.add(i+1-pattern.length());continue outer;
					}i++;continue;
				}else {
					i+=((j-array[j])-1-j);continue outer;
				}
			}
		}return list;	
	}

}
