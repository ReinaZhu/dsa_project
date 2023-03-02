
public class BinarySearchTreeTest {
	public static void main(String[] args) {
		int[] nums1 = {10,20,30,40,50,60,70};
		BinarySearchTree bst1 = new BinarySearchTree(nums1);
		int[] nums2 = {40,20,10,30,60,50,70}; 
		BinarySearchTree bst2 = new BinarySearchTree(nums2);
		bst1.insert(25);bst1.Print();System.out.println(bst1.TraversalInOrder());
		bst2.insert(25);bst2.Print();System.out.println(bst2.TraversalInOrder());
		bst1.insert(55);//bst1.Print();System.out.println(bst1.TraversalInOrder());
		bst2.insert(55);//bst2.Print();System.out.println(bst2.TraversalInOrder());
		bst1.insert(15);//bst1.Print();System.out.println(bst1.TraversalInOrder());
		bst2.insert(15);//bst2.Print();System.out.println(bst2.TraversalInOrder());
		bst1.insert(75);//bst1.Print();System.out.println(bst1.TraversalInOrder());
		bst2.insert(75);//bst2.Print();System.out.println(bst2.TraversalInOrder());
		bst1.insert(5);//bst1.Print();System.out.println(bst1.TraversalInOrder());
		bst2.insert(5);//bst2.Print();System.out.println(bst2.TraversalInOrder());
		bst1.insert(65);//bst1.Print();System.out.println(bst1.TraversalInOrder());
		bst2.insert(65);//bst2.Print();System.out.println(bst2.TraversalInOrder());
        bst1.delete(30);//bst1.Print();System.out.println(bst1.TraversalInOrder());
		bst2.delete(30);//bst2.Print();System.out.println(bst2.TraversalInOrder());
		bst1.delete(40);//bst1.Print();System.out.println(bst1.TraversalInOrder());
		bst2.delete(40);//bst2.Print();System.out.println(bst2.TraversalInOrder());
		bst1.delete(50);//bst1.Print();System.out.println(bst1.TraversalInOrder());
		bst2.delete(50);//bst2.Print();System.out.println(bst2.TraversalInOrder());
		bst1.delete(55);//bst1.Print();//System.out.println(bst1.TraversalInOrder());
		bst2.delete(55);//bst2.Print();//System.out.println(bst2.TraversalInOrder());
		bst1.delete(60);bst1.Print();System.out.println(bst1.TraversalInOrder());
		bst2.delete(60);bst2.Print();System.out.println(bst2.TraversalInOrder());
		}

}
