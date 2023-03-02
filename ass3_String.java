import java.util.LinkedList;
import java.util.Queue;

public class ass3_String {

	public static void main(String[] args) {
		String num1, num2;
		//addStrings输入样例
		num1 = "2";
		num2 = "3";
		System.out.println(addStrings(num1,num2));
		num1 = "123";
		num2 = "456";
		System.out.println(addStrings(num1,num2));
		//multiply输入样例
		num1 = "2";
		num2 = "3";
		System.out.println(multiply(num1,num2));
		num1 = "123";
		num2 = "456";
		System.out.println(multiply(num1,num2));


	}
	public static String addStrings(String num1, String num2){
		String add;
		//考虑0的情况
		if(num1.equals("0")) {
			add=num2;
		}
		else if(num2.equals("0")) {
			add=num1;
		}
		//考虑非0
		else{
			//调整两个String的长度为一致。
			if(num1.length()>num2.length()) {
		}
			for(int i=0;i<num1.length()-num2.length();i++) {
				num2="0"+num2;
			}
		if(num1.length()<num2.length()) {
			for(int i=0;i<num2.length()-num1.length();i++) {
				num1="0"+num1;
			}
		}
		//开始相加
		Queue<Integer> que = new LinkedList<Integer>();
		int addition=0;
		for(int i=0;i<num1.length();i++) {
			addition = addition+((num1.charAt(i)-'0') + (num2.charAt(i)-'0'))*tenpower(num1.length()-i-1);
		}
		que.offer(addition);
		add=que.peek().toString();
	}
		return add;
		}

	public static String multiply(String num1, String num2){
		String multiply;
		//考虑0的情况
		if(num2.equals("0")||num1.equals("0")) {
			multiply="0";
		}
		//考虑非0
		else {
		int mul=0;
		for(int i=0;i<num1.length();i++) {
			for(int j=0;j<num2.length();j++) {
				mul=mul+(num1.charAt(i)-'0') * (num2.charAt(j)-'0')*tenpower(num1.length()+num2.length()-i-j-2);
			}
		}
		Queue<Integer> que = new LinkedList<Integer>();
		que.offer(mul);
		multiply=que.peek().toString();
		}
		return multiply;
		}
	//得到10的n次方且返回为int的方法。
	public static int tenpower(int power) {
		int result=1;
		for(int i=0;i<power;i++) {
			result*=10;
		}
		return result;
	}
}
