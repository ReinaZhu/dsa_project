import java.util.LinkedList;

public class PolynomialTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

LinkedList<Node> polyLink = new LinkedList<Node>();
Polynomial polynm = new Polynomial(polyLink);
for (int i = 0; i <= 200; i+=4) {
Node node = new Node(i, ((double)i)*0.1);
polynm.polyLinkedList.add(node);
}
LinkedList<Node> polyLink2 = new LinkedList<Node>();
Polynomial polynm2 = new Polynomial(polyLink2);
for (int i = 0; i <= 200; i+=6) {
Node node = new Node(i, ((double)i)*0.1);
polynm2.polyLinkedList.add(node);
}
System.out.println(polynm);
System.out.println("The degree of the polynomial is:"+polynm.FindDegree());
System.out.println("The Addition is:");
System.out.println(polynm.Addition(polynm2));
System.out.println("The Subtraction is:");
System.out.println(polynm.Subtraction(polynm2));
System.out.println("The Multiplication is:");
System.out.println(polynm.Multiplication(polynm2));
System.out.println("The Differentiation is:");
System.out.println(polynm.Differentiation());
	}

}
