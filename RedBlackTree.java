

/**
 * This is a "generic" Binary Search Tree - know the definition of what a BST is!
 * 
 * NOTE: To allow for our objects to be inserted (and found) properly they have to be COMPARED
 * to the objects in the tree. This is why we have <T extends Comparable<T>> instead of 
 * just <T> : We are effectively saying that the objects which can be stored MUST implement
 * the Comparable interface.
 * 
 * NOTE: Our Node class is an inner class in an inner class at the bottom of the code.
 * 
 * @author dermot.hegarty
 *
 * @param <T>
 */
public class RedBlackTree<T extends Comparable<T>> {
	/**
	 * Reference to the root of the tree
	 */
	public Node root;
	

	/**
	 * This is the public insert method, i.e. the one that the outside world will invoke.
	 * It then kicks off a recursive method to "walk" through down through the tree - this is 
	 * possible because each sub-tree is itself a tree.
	 * @param value Object to insert into the tree
	 */
	public void insert(T value){
		
		Node node = new Node(value); // Create the Node to add

		//Special case that cannot be handled recursively
		if ( root == null ) {
			root = node;
			node.nodeColourRed = false;
            return;
		}

		//Initially we start at the root. Each subsequent recursive call will be to a 
		//left or right subtree.
		insertRec(root, node);
		handleRedBlack(node);

	}

	/**
	 * 
	 * @param subTreeRoot The SubTree to insert into
	 * @param node The Node that we wish to insert
	 */
	private void insertRec(Node subTreeRoot, Node node){

		//Note the call to the compareTo() method. This is only possible if our objects implement
		//the Comparable interface.
		if ( node.value.compareTo(subTreeRoot.value) < 0){
			System.out.println("sasdasd ");
System.out.println(root.value.compareTo(subTreeRoot.value) < 0);
			//This is our terminal case for recursion. We should be going left but there is 
			//no left node there so that is obviously where we must insert
			
			if ( subTreeRoot.left == null ){
				
				subTreeRoot.left = node;
				node.parent=subTreeRoot;
				
			subTreeRoot.left_left_value+=1;
				System.out.println("Left parent "+node.parent.value);
				return; //return here is unnecessary
			}
			else{ // Note that this allows duplicates!
				
				//Now our new "root" is the left subTree
				
				
				insertRec(subTreeRoot.left, node);
				
			}
		}
		//Same logic for the right subtree
		else{
			if (subTreeRoot.right == null){
				subTreeRoot.right = node;
				node.parent=subTreeRoot;
				System.out.println("Right parent "+node.parent.value);
				
				return;
			}
			else{
				
				
				insertRec(subTreeRoot.right, node);
			}
		}

	}
	
	
	/**
	 * Should traverse the tree "in-order." See the notes
	 */
	public void inOrderTraversal()
	{
		//start at the root and recurse
		recInOrderTraversal(root);
	}
	
	public void preOrderTraversal()
	{
		//start at the root and recurse
		recPreOrderTraversal(root);
	}
	
	public void postOrderTraversal()
	{
		//start at the root and recurse
		recPostOrderTraversal(root);
	}
	
	/**
	 * This allows us to recursively process the tree "in-order". Note that it is private
	 * @param subTreeRoot
	 */
	private void recInOrderTraversal(Node subTreeRoot)
	{
		if(subTreeRoot == null) return;
		
		recInOrderTraversal(subTreeRoot.left);
		processNode(subTreeRoot);
		recInOrderTraversal(subTreeRoot.right);
	}
	
	private void recPreOrderTraversal (Node subTreeRoot)
	{
		if(subTreeRoot == null) return;
		
		processNode(subTreeRoot);
		recPreOrderTraversal(subTreeRoot.left);
		recPreOrderTraversal(subTreeRoot.right);
	}
	
	private void recPostOrderTraversal (Node subTreeRoot)
	{
		if(subTreeRoot == null) return;
		
		recPostOrderTraversal(subTreeRoot.left);
		recPostOrderTraversal(subTreeRoot.right);
		processNode(subTreeRoot);
	}
	
	/** 
	 * Do some "work" on the node - here we just print it out 
	 * @param currNode
	 */
	private void processNode(Node currNode)
	{
		System.out.println(currNode.toString());
	}
	
	/**
	 * 
	 * @return The number of nodes in the tree
	 */
	public int countNodes()
	{
		return recCountNodes(root);
	}
	
	
	/**
	 * Note: This is a practical example of a simple usage of pre-order traversal
	 * @param subTreeRoot
	 * @return
	 */
	private int recCountNodes(Node subTreeRoot)
	{
		if (subTreeRoot == null) return 0;
		
		//Look at the pre-order. "Count this node and THEN count the left and right 
		//subtrees recursively
		return 1 + recCountNodes(subTreeRoot.left) + recCountNodes(subTreeRoot.right);
	}
	
	/////////////////////////////////////////////////////////////////
	/**
	 * Our Node contains a value and a reference to the left and right subtrees (initially null)
	 * @author dermot.hegarty
	 *
	 */
	public T FindMaximum()
	{
		return recFindMaximum(root);
	}
private T recFindMaximum(Node subTreeRoot)
	{
		while (subTreeRoot.right==null) { 
			return subTreeRoot.value;
		}
		return recFindMaximum(subTreeRoot.right);
	}

	public T FindMinimum()
	{
		return recFindMinimum(root);
	}
private T recFindMinimum(Node subTreeRoot)
	{
		if ( subTreeRoot.left == null ){
			return subTreeRoot.value; 
		}
		else
		{ 
			return recFindMinimum(subTreeRoot.left);
		}
	}




	public T find(T searchVal)
	{
		//start at the root and recurse
		return recFind(root, searchVal);
	}
	
	private T recFind(Node subTreeRoot, T searchVal)
	{
		if(subTreeRoot == null) 
			return null;
         
		if(subTreeRoot.value.equals(searchVal))
		{
			return subTreeRoot.value;
		}
		else if(subTreeRoot.value.compareTo(searchVal) >0 )
		{
         return recFind(subTreeRoot.left, searchVal);
      }
      else
      {
		   return recFind(subTreeRoot.right, searchVal);
      }
	}

	public void RotateTreeLeft()
	{
		root=RotateSubTreeLeft(root);
	}
	
private Node RotateSubTreeLeft(Node subtreeroot)
	{
		Node pivot =subtreeroot.right;
		Node temp =pivot.left;
		pivot.left =subtreeroot;
		subtreeroot.right=temp;
		return pivot;
	}

	public void RotateTreeRight()
	{
		root=RotateSubTreeRight(root);
	}
	
private Node RotateSubTreeRight(Node subtreeroot)
	{
		Node pivot =subtreeroot.left;
		Node temp =pivot.right;
		
		pivot.right =subtreeroot;
		subtreeroot.left=temp;
		return pivot;
	}


void handleRedBlack(Node newNode)
{
//terminating case for "back" recursion - e.g. case 3 (video)
if(newNode == root)
{
	newNode.nodeColourRed = false;
	return;
}
Node uncle;
Node parent = newNode.parent;
Node grandParent = parent.parent;
//Now that it's inserted we try to ensure that it's a RedBlack Tree
//Check if parent is red. This is a violation. I (the new node) am red
//so my parent cannot also be red!
if (parent!=null&&parent.nodeColourRed) {
	newNode.nodeColourRed=false;
}
else if (parent!=null&&parent.nodeColourRed==false) {
	newNode.nodeColourRed=true;
}
if (grandParent!=null&&grandParent==root) {
	parent.nodeColourRed=true;
	newNode.nodeColourRed=false;
}
if (parent!=null&&grandParent!=null&&grandParent.nodeColourRed) {
	parent.nodeColourRed=false;
	newNode.nodeColourRed=true;
}
else if (parent!=null&&grandParent!=null&&grandParent.nodeColourRed==false) {
	parent.nodeColourRed=true;
	newNode.nodeColourRed=false;
}

if(parent.nodeColourRed)
{
//important that we figure out where the uncle is
//relative to the current node
if(uncleOnRightTree(newNode))
{
	uncle = getRightUncle(newNode);
}
else
{
	uncle = getLeftUncle(newNode);
}
//Now we need to check if x's uncle is RED (Grandparent must
//have been black)
//This is case 3 according to the video
//(https://www.youtube.com/watch?v=g9SaX0yeneU)
if((uncle != null) && (uncle.nodeColourRed&&grandParent!=root&&grandParent.nodeColourRed!=false))
{
//this case is not too bad.
//it involves recolouring and then recursing
//CODE OMITTED - it's only 4 lines!

	parent.nodeColourRed=false;
uncle.nodeColourRed=false;
grandParent.nodeColourRed=true;
handleRedBlack(parent);
handleRedBlack(uncle);
handleRedBlack(grandParent);
System.out.println("Yeah the uncle is coloured Red");
	
}
else if((uncle == null) || (uncle.nodeColourRed==false))
{
	if (parent==grandParent.left&&newNode==parent.left) {
	newNode.left_left=true;
	RotateSubTreeRight(grandParent);
	if (grandParent.nodeColourRed==false) {
		grandParent.nodeColourRed=true;
	}
	else if(grandParent.nodeColourRed==true) {
		grandParent.nodeColourRed=false;
	}
	if (parent.nodeColourRed==false) {
		parent.nodeColourRed=true;
	}
	else if(parent.nodeColourRed==true) {
		parent.nodeColourRed=false;
	}
	
	}
	else if (parent==grandParent.left&&newNode==parent.right) {
	newNode.left_right=true;
	RotateSubTreeLeft(parent);
	RotateSubTreeRight(grandParent);
	
	}
		else if (parent==grandParent.right&&newNode==parent.left) {
	newNode.right_right=true;
RotateSubTreeLeft(grandParent);
if (grandParent.nodeColourRed==false) {
		grandParent.nodeColourRed=true;
	}
	else if(grandParent.nodeColourRed==true) {
		grandParent.nodeColourRed=false;
	}
	if (parent.nodeColourRed==false) {
		parent.nodeColourRed=true;
	}
	else if(parent.nodeColourRed==true) {
		parent.nodeColourRed=false;
	}
	

	}
}
	else if (parent==grandParent.right&&newNode==parent.left) {
	newNode.right_left=true;
	RotateSubTreeLeft(grandParent);
	}
}
}


    private Node getLeftUncle(Node newNode) {
		if(newNode.grandParent!=null){
		if(newNode.grandParent!=null&newNode.grandParent.left!=null)
		{
        return newNode.grandParent.left;
		}
		else{
		return null;
		}
	}
	return null;
    }

    private Boolean uncleOnRightTree(Node newNode) {
        if (newNode==root.right) {
			return true;
		}
		else{
		return false;
		}
    }

    private Node getRightUncle(Node newNode) {
			if(newNode.grandParent!=null){	
		if(newNode.grandParent!=null&newNode.grandParent.right!=null)
		{
        return newNode.grandParent.right;
			}
		else{
		return null;
		}
    }
	return null;
}



	private class Node {
		public T value; //value is the actual object that we are storing
		public Node left;
		public Node right;
        public Node parent;
		public Node grandParent;
		public Boolean nodeColourRed;
		public String colour="";
		public int left_left_value = 0;
		public int right_right_value=0;
		public boolean left_left;
		public boolean right_right;
		public boolean left_right;
		public boolean right_left;
	
		public Node(T value) {
			this.value = value;
			
		}
/*if (newNode.left_left_value>newNode.right_right_value+2) {
					newNode.left_left=true;
				}
				else if(newNode.right_right_value>newNode.left_left_value+2) {
					newNode.right_right=true;
				}/* */
		@Override
		public String toString() {
			if (nodeColourRed==false) {
				colour="Black";
			}
			else if(nodeColourRed)
			{colour="Red";}

				
			return "Node [value = " + value + " Colour= "+colour+" is it right right "+right_right+" is it left left "+left_left+"]";
		}
		
		

	}
}