import java.io.Serializable;

/**
 * Class for a binary tree that stores type E objects
 * (It was implemented by changing from the binary tree in the book.)
 * 
 * @author Esra Eryılmaz
 * @since 2020-06-04
 * @param <E> The type of data to be stored
 */

@SuppressWarnings("serial")
public class BinaryTree<E> implements Serializable 
{

	/**
	 * Root of the Binary Tree
	 */
	public Node<E> root;


	/**
	 * No parameter constructor
	 */
	public BinaryTree(){
		root = null;
	}

	/*
	 * Constructor
	 */
	protected BinaryTree(Node<E> root){
		this.root = root;
	}

	/**
	 * Determine whether this tree is a leaf
	 * @return true if the root has no children
	 */
	public boolean isLeaf(){
		return root == null || (root.left == null && root.right == null);
	}


	/**
	 * Node class to encapsulate a tree node
	 *
	 * @param <E> The type of data stored
	 */
	protected static class Node<E> implements Serializable
	{
		//Data Fields
		/**
		 * The information stored in this node
		 */
		protected Packages data;

		/**
		 * Reference to the left child
		 */
		protected Node<E> left;

		/**
		 * Reference to the right child
		 */
		protected Node<E> right;


		/**
		 * Construct a node with given data and no children
		 * @param data The data to store in this node
		 */
		public Node(Packages data){
			this.data = data;
			left = null;
			right = null;
		}

		/**
		 * It prints the package with name,quantity and price
		 */
		public void printData()
		{
			data.print();
		}

	}

}
