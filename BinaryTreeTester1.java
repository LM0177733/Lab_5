public class BinaryTreeTester1 {

	public static void main(String[] args) {
		BinarySearchTree < Integer > myTree = new BinarySearchTree < Integer > ();

		myTree.insert(50);//Note the use of primitive ints - they are auto-boxed into Integer objects.
		myTree.insert(31);
		myTree.insert(69);
		myTree.insert(57);
		myTree.insert(90);
		myTree.insert(99);

		/*myTree.insert(40);//Note the use of primitive ints - they are auto-boxed into Integer objects.
		myTree.insert(32);
		myTree.insert(37);
		myTree.insert(34);
		myTree.insert(26);
		myTree.insert(29);
		myTree.insert(18);
		myTree.insert(20);
		myTree.insert(10);
		myTree.insert(49);
		myTree.insert(60);
		myTree.insert(70);
		myTree.insert(80);
		myTree.insert(75);
		myTree.insert(55);*/
		
	
		/*
		BinarySearchTree<String> myTree = new BinarySearchTree<String>();
		myTree.insert("adc");
		myTree.insert("qwe");
		myTree.insert("wer");
		myTree.insert("ert");
		myTree.insert("rty");
		myTree.insert("tyu");
		myTree.insert("yui");
		myTree.insert("uio");
		myTree.insert("iop");
		*/

		/*BinarySearchTree<Person> myTree = new BinarySearchTree<Person>();
		myTree.insert(new Person("Amelia", "Quinn", 20));
		myTree.insert(new Person("Olivia", "McLoone", 12));
		myTree.insert(new Person("Emily", "Thompson", 26));
		myTree.insert(new Person("Isla", "Wright", 30));
		myTree.insert(new Person("Ava", "Jackson", 60));
		myTree.insert(new Person("Jack", "Gallagehr", 55));
		myTree.insert(new Person("Oliver", "Browne", 42));
		myTree.insert(new Person("Charlie", "Hardinge", 8));
		myTree.insert(new Person("Jacob", "Twist", 19));
		*/

		System.out.println("In-order Traversal:");
		myTree.inOrderTraversal();
		System.out.println();

		System.out.println("Pre-order Traversal:");
		myTree.preOrderTraversal();
		System.out.println();

		System.out.println("Post-order Traversal:");
		myTree.postOrderTraversal();
		System.out.println();

		System.out.println("Tree contains " + myTree.countNodes() + " nodes");
		System.out.println();
System.out.println("the maximum is " + myTree.FindMaximum() );
		System.out.println();
		System.out.println("the Minimum is " + myTree.FindMinimum() );
		System.out.println();
System.out.println("The value is " + myTree.find(90) );
		System.out.println();


		myTree.RotateTreeLeft();

	System.out.println("In-order Traversal With tree rotated left:");
		myTree.preOrderTraversal();
		System.out.println();
		//System.out.println("Find Minimum: "+myTree.findMinimum());
      

		//System.out.println(myTree.find(80));
	}

}