

import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.LinkedList;
public class Polynomial{
DecimalFormat    df   = new DecimalFormat("######0.00"); 
LinkedList<Node> polyLinkedList = new LinkedList<Node>();
public Polynomial() {
polyLinkedList = null;
}
public Polynomial(LinkedList<Node> pLinkedList) {
polyLinkedList = pLinkedList;
}
public String toString() {
String resultString = "";

Node pNode1;
for(Iterator<Node> iter = polyLinkedList.iterator(); iter.hasNext();)
{
pNode1 = iter.next();
String aaa = df.format(pNode1.a);

resultString += "<" + pNode1.e + ", " + aaa + ">";
}
return resultString;
}

public int FindDegree() {
	Node a;
	int max=0;
	int degree;
	for(int i=0;i<polyLinkedList.size();i++) {
		a=polyLinkedList.get(i);
	degree=a.e;
	if(degree>max) {
		max=degree;
	}
	}
	return max;	
}
public Polynomial Addition(Polynomial a) {
	Node node2_1;
	Node node1;
	Node node2_2;
	int degree2_1;
	int degree1;
	int degree2_2;	
	int count=0;
	LinkedList<Node> poly = new LinkedList<Node>();
	Polynomial polynmm = new Polynomial(poly);
	for(int i=0;i<a.polyLinkedList.size();i++) {
		polynmm.polyLinkedList.add(a.polyLinkedList.get(i));
	}
	for (int j=0;j<polyLinkedList.size();j++) {
	for(int i=0;i<a.polyLinkedList.size()-1;i++) {
		node1=polyLinkedList.get(j);
		node2_1=a.polyLinkedList.get(i);
		node2_2=a.polyLinkedList.get(i+1);
		degree2_1=node2_1.e;
		degree2_2=node2_2.e;
		degree1=node1.e;
		if(degree1 ==degree2_1) {
			Node newone=new Node(degree2_1, node1.a+node2_1.a);
			polynmm.polyLinkedList.set(i+count, newone);
		}
		if(degree1>degree2_1&&degree1<degree2_2) {
			polynmm.polyLinkedList.add(i+count+1, node1);
			count++;
		}
	
	}
	if(polyLinkedList.get(j).e==a.polyLinkedList.getLast().e) {
		Node newone=new Node(a.polyLinkedList.getLast().e, a.polyLinkedList.getLast().a+polyLinkedList.get(j).a);
		polynmm.polyLinkedList.set(polynmm.polyLinkedList.size()-1, newone);
	}
	if(polyLinkedList.get(j).e>a.polyLinkedList.getLast().e) {
		polynmm.polyLinkedList.add(polyLinkedList.get(j));
	}
	if(polyLinkedList.get(j).e<a.polyLinkedList.getFirst().e) {
		polyLinkedList.add(0,a.polyLinkedList.getFirst());
	}
	}
	for(int i=0;i<polynmm.polyLinkedList.size();i++) {
	if(polynmm.polyLinkedList.get(i).a==0) {
		polynmm.polyLinkedList.remove(i);
	}
	}
	return polynmm;
}
public Polynomial Subtraction(Polynomial a) {
	Node node2_1;
	Node node1;
	Node node2_2;
	int degree2_1;
	int degree1;
	int degree2_2;	
	int count=0;
	LinkedList<Node> poly = new LinkedList<Node>();
	Polynomial polynmm = new Polynomial(poly);
	for(int i=0;i<a.polyLinkedList.size();i++) {
		Node negative=new Node(a.polyLinkedList.get(i).e,-a.polyLinkedList.get(i).a);
		polynmm.polyLinkedList.add(negative);
	}
	for (int j=0;j<polyLinkedList.size();j++) {
	for(int i=0;i<a.polyLinkedList.size()-1;i++) {
		node1=polyLinkedList.get(j);
		node2_1=a.polyLinkedList.get(i);
		node2_2=a.polyLinkedList.get(i+1);
		degree2_1=node2_1.e;
		degree2_2=node2_2.e;
		degree1=node1.e;
		if(degree1 ==degree2_1) {
			Node newone=new Node(degree2_1, node1.a-node2_1.a);
			polynmm.polyLinkedList.set(i+count, newone);
		}
		if(degree1>degree2_1&&degree1<degree2_2) {
			polynmm.polyLinkedList.add(i+count+1, node1);
			count++;
		}
	
	}
	if(polyLinkedList.get(j).e==a.polyLinkedList.getLast().e) {
		Node newone=new Node(a.polyLinkedList.getLast().e, a.polyLinkedList.getLast().a+polyLinkedList.get(j).a);
		polynmm.polyLinkedList.set(polynmm.polyLinkedList.size()-1, newone);
	}
	if(polyLinkedList.get(j).e>a.polyLinkedList.getLast().e) {
		polynmm.polyLinkedList.add(polyLinkedList.get(j));
	}
	if(polyLinkedList.get(j).e<a.polyLinkedList.getFirst().e) {
		polyLinkedList.add(0,a.polyLinkedList.getFirst());
	}
	}
	for(int i=0;i<polynmm.polyLinkedList.size();i++) {
		if(polynmm.polyLinkedList.get(i).a==0) {
			polynmm.polyLinkedList.remove(i);
		}
		}
	return polynmm;
}
public Polynomial Multiplication(Polynomial a) {
	
	LinkedList<Node> poly = new LinkedList<Node>();
	Polynomial polynmm = new Polynomial(poly);
	LinkedList<Node> poly1 = new LinkedList<Node>();
	Polynomial polynmm1 = new Polynomial(poly1);
	for (int j=0;j<polyLinkedList.size();j++) {
		for(int i=0;i<a.polyLinkedList.size();i++) {
			Node newone=new Node(polyLinkedList.get(j).e+a.polyLinkedList.get(i).e, polyLinkedList.get(j).a*a.polyLinkedList.get(i).a);
			polynmm1.polyLinkedList.add(newone);
	    }
	}
	int max=polynmm1.FindDegree();//合并相同次方的系数
	for(int i=0;i<=max;i++) {
		double aa=0;
		for(int j=0;j<polynmm1.polyLinkedList.size();j++) {
			if(polynmm1.polyLinkedList.get(j).e==i) {
				aa=aa+polynmm1.polyLinkedList.get(j).a;
				Node newnew=new Node(-1,-1);
				polynmm1.polyLinkedList.set(j, newnew);
			}
		}
		if(aa==0) {}
		else {
			Node newone=new Node(i,aa);
			polynmm.polyLinkedList.add(newone);
		}
		
	}
	return polynmm;
}
public Polynomial Differentiation() {
	LinkedList<Node> poly = new LinkedList<Node>();
	Polynomial polynmm = new Polynomial(poly);
	for(int i=0;i<polyLinkedList.size();i++) {
		if(polyLinkedList.get(i).e==0) {}
		else {
		Node newone=new Node(polyLinkedList.get(i).e-1,polyLinkedList.get(i).e*polyLinkedList.get(i).a);
		polynmm.polyLinkedList.add(newone);
		}
	}
	for(int i=0;i<polynmm.polyLinkedList.size();i++) {
		if(polynmm.polyLinkedList.get(i).a==0) {
			polynmm.polyLinkedList.remove(i);
		}
		}
	return polynmm;
}

}