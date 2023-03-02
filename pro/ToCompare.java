package pro;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class ToCompare {
	int times;
	LinkedList<Integer> locations;
	String content;
	
	
	public ToCompare(int nums1,LinkedList<Integer> nums2,String content) {
		times=nums1;
		locations=nums2;
		this.content=content;
/*		
		Arrays.sort(pairs,new PairsComparator());*/
	}
	
	
}

class ToComparator implements Comparator<ToCompare>{
@Override
	public int compare(ToCompare o1, ToCompare o2) {
		if(o1.times<o2.times)
			return 1;
		else if(o1.times>o2.times)
			return -1;
		else {
			if(o1.locations.get(0)==0)
				return -1;
			else if(o1.locations.get(0)!=0&&o2.locations.get(0)==0)
				return 1;
			else return 0;
		}
	}
	

}
