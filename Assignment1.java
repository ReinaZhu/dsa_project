


public class Assignment1 {
	private int[] intArray;
	private int len; //元素总数
	public static int index; //上一次搜索某个元素的位置
	public Assignment1(int[] arr) {
	this.intArray = arr;
	len = arr.length;
	}
	public void search(int value) {
		int count=0;
		for (int i=0;i<len;i++) {
			if (intArray[i]==value) {
				System.out.printf("%d%n",i);
				index=i;
				count++;
				break;
			}
		}
		if(count==0) {
			System.out.println("element not found");
		}
	}
	public void delete(int value) {
		for(int i=0;i<intArray.length;i++) {
			if (intArray[i]==value) {
				len--;
			}
		}
		if (len==intArray.length) {
			System.out.println("element not found");
		}
		else {
		for (int i=0;i<intArray.length;i++) {/*?*/
			if(intArray[i]==value) {
				for(int j=i;j<intArray.length-1;j++) {
				intArray[j]=intArray[j+1];
				}
				
			}
		}
		System.out.println(toString());}
	}
	public void insert(int value, int index) {
		if(len==intArray.length) {
			System.out.println("no room");
		}
		else if(index>len||index<0) {
			System.out.println("the index is out of boundary");
		}
		else {  
			len++;
			for (int i=index;i<len-index;i++) {
				intArray[len-i]=intArray[len-i-1];
				
			}
			intArray[index]=value;


			System.out.println(toString());}
	}
	public void sorting() {
		int max;
		for (int i=0;i<len;i++) {
			max=intArray[1];
			for(int j=i;j<len;j++) {
				if(intArray[i]>intArray[j]) {
					max=intArray[j];
					intArray[j]=intArray[i];
					intArray[i]=max;
				}
			}
		}
		System.out.println(toString());
	}
	@Override
	public String toString() {
	String str="";
	for(int i = 0; i < len; i++) {
	str = str + intArray[i] + " ";}
	return str;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Assignment1 a = new Assignment1(new int[] { 6, 0, 72, 15, -89, 0 });
		System.out.println(a);
		a.insert(7, 0);
		a.search(0);
		a.delete(0);
		a.insert(7, a.index);
		a.sorting();
		a.search(99);

	}

}
