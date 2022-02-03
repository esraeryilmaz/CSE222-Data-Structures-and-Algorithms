import java.util.Scanner;

/**
 * SoftwareStore class
 * (It was implemented by changing from the binary search tree in the book.)
 *
 * @author Esra Eryılmaz
 * @since 2020-06-04
 */

@SuppressWarnings("serial")
public class SoftwareStore <E extends Comparable<E>>
								extends BinaryTree<E>
								implements SearchTree<E>
{
	//Data Fields
	/**
	 * Return value from the public add method
	 */

	protected boolean addReturn;
	/** 
	 * Return value from the public delete method 
	 */
	protected E deleteReturn;

	/**
	 * Admin general password.
	 */
	private final String password = "1234";

	/**
	 * If admin entered the password correctly, it becomes 1.
	 */
	int login = 0;

	public static Scanner scan = new Scanner(System.in);


	/**
	 * No parameter constructor
	 * It automatically creates a data structure including some packages.
	 */
	public SoftwareStore() {

		Packages p1 = new Packages("Adobe Photoshop 6.0", 10, 600);
		Packages p2 = new Packages("Adobe Photoshop 6.2", 20, 700);
		Packages p3 = new Packages("Norton 4.5", 30, 200);
		Packages p4 = new Packages("Norton 5.5", 30, 300);
		Packages p5 = new Packages("Adobe Flash 3.3", 40, 200);
		Packages p6 = new Packages("Adobe Flash 4.0", 35, 400);

		add(p1);
		add(p2);
		add(p3);
		add(p4);
		add(p5);
		add(p6);
	}

	/**
	 * Overridden add method.
	 * It adds new package to the software store system.
	 */
	@Override
	public boolean add(E item) {
		String target;
		int q=0 ,p=0;

		System.out.print("Package name (String) : ");
		target = scan.nextLine();
		System.out.print("Package quantity (int) : ");
		q = scan.nextInt();
		System.out.print("Package price (int) : ");
		p = scan.nextInt();
		scan.nextLine();

		Packages newPack = new Packages(target, q, p);
		add(newPack);

		return true;
	}

	/**
	 * Overridden contains method.
	 */
	@Override
	public boolean contains(E target) {
		E result = find(target);
		return result == target;
	}

	/**
	 * Overridden find method.
	 * It finds package by name ,quantity and price from the software store system.
	 */
	@Override
	public E find(E target) {
		boolean isValid = true;

		while(isValid)
		{
			System.out.println("What do you want to do?");
			System.out.println("1) Search software by name.");
			System.out.println("2) Search software by quantity.");
			System.out.println("3) Search software by price.");
			System.out.println("4) Exit.");
			System.out.print("INPUT : ");

			String choice = scan.nextLine();

			if (choice.equals("1")) {
				String name;
				System.out.print("Package name (String) : ");
				name = scan.nextLine();

				Packages pack = new Packages(name, 0, 0);
				pack = find(root,pack);
				System.out.print("Search Results : ");
				System.out.println("Quantity : " + pack.quantity + " ,  Price : " + pack.price);
			}

			else if (choice.equals("2")) {
				int quantity;
				System.out.print("Package quantity (int) : ");
				quantity = scan.nextInt();
				scan.nextLine();

				Packages pack = new Packages(null, quantity, 0);
				pack = searchQuantity(root,pack);
				System.out.print("Search Results -> ");
				System.out.println("Name : " + pack.name + " ,  Price : " + pack.price);

			}

			else if (choice.equals("3")) {
				int price;
				System.out.print("Package price (int) : ");
				price = scan.nextInt();
				scan.nextLine();

				Packages pack = new Packages(null, 0, price);
				pack = searchPrice(root,pack);
				System.out.print("Search Results -> ");
				System.out.println("Name : " + pack.name + " ,  Quantity : " + pack.quantity);
			}

			else if (choice.equals("4")) {
				System.out.println("Exiting...");
				System.exit(0);
			}

			else {
				System.out.println("Invalid input. Try again!");
			}
			System.out.println();
		}
		return null;
	}

	/**
	 * Overridden remove method.
	 * It removes package from the software store system.
	 */
	@Override
	public boolean remove(E item) {
		String target;
		System.out.print("Package name (String) : ");
		target = scan.nextLine();
		delete(target);

		return true;
	}
	
	/**
	 * For testing whole system.(Menu-driven method)
	 */
	public void testSystem()
	{
		System.out.println("Are you admin or user?");
		System.out.println("'1' for admin");
		System.out.println("'2' for user");
		System.out.print("INPUT : ");

		String input = scan.nextLine();
		while(!input.equals("1") && !input.equals("2"))
		{
			System.out.println("Invalid input.");
			System.out.println("'1' for admin");
			System.out.println("'2' for user");
			System.out.print("INPUT : ");
			input = scan.nextLine();
		}

		if(input.equals("1"))	//FOR ADMÝN
		{
			System.out.print("Enter password : ");
			input = scan.nextLine();

			if(input.equals(password))
			{
				System.out.println("\nAdmin login successful ! \n");
				System.out.println("[Software packages in the store]");
				print();
				boolean isValid = true;
				E obj = null;

				while(isValid) {
					System.out.println("What do you want to do?");
					System.out.println("1) Add package.");
					System.out.println("2) Remove package.");
					System.out.println("3) Update package.");
					System.out.println("4) Exit.");
					System.out.print("INPUT : ");
					String choice = scan.nextLine();

					if (choice.equals("1")) {
						add(obj);
						print();
					}

					else if (choice.equals("2")) {
						remove(obj);
						print();
					}

					else if (choice.equals("3")) {
						System.out.println("\t1) Update sold out packages.");
						System.out.println("\t2) Update new software packages.");
						System.out.print("\tINPUT : ");
						String c = scan.nextLine();

						if (c.equals("1")) {
							remove(obj);
							print();
						}
						else if (c.equals("2")) {
							add(obj);
							print();
						}
						else
						{
							System.out.println("Invalid input. Try again!");
						}

					}

					else if (choice.equals("4")) {
						System.out.println("Exiting...");
						System.exit(0);
					}

					else {
						System.out.println("Invalid input. Try again!");
					}
				}
			}
			else
			{
				System.out.println("Admin login failed !");
			}
		}

		else if(input.equals("2"))	//FOR USER
		{
			System.out.println("\nUser login successful ! \n");
			System.out.println("[Software packages in the store]");
			print();
			E obj = null;

			find(obj);
		}
	}


	/**
	 * It prints tree in preorder traversal
	 * @param root
	 */
	public void printTree(Node<E> root)
	{
		if(root == null)
			return;

		root.printData();
		printTree(root.left);
		printTree(root.right);
	}

	public void print()
	{
		System.out.println("[PRINT] :");
		System.out.println("Name\t\t  Quantity\tPrice");
		printTree(root);
		System.out.println();
	}


	/**
	 * Method add
	 * pre: The object to be inserted must implement the Comparable interface
	 * @param item The item being inserted
	 * @return true if the object is inserted, false if the object already exists in the tree
	 */
	public boolean add(Packages item) {
		root = add(root, item);
		return addReturn;
	}

	/**
	 * Recursive add method
	 * post: The data field addReturn is set to true if the item is added to the tree, false if the item is already in the tree
	 * @param root The local root of the subtree
	 * @param item The object to be inserted
	 * @return The new local root that now contains the inserted item
	 */
	public Node<E> add(Node<E> root, Packages item){

		if(root == null){
			//item is not in the tree - insert it
			addReturn = true;
			return new Node<E>(item);
		}
		else {
			int compare = item.compareTo(root.data);
			if (compare == 0){
				//item is equal to localRoot.data
				addReturn = false;
				return root;
			} else if (compare < 0){
				//item is less than localRoot.data
				root.left = add(root.left, item);
				return root;
			} else {
				//item is greater than localRoot.data
				root.right = add(root.right, item);
				return root;
			}
		}
	}

	
	/**
	 * Recursive find method
	 * It searches tree by name.
	 * @param root The local subtree's root
	 * @param target The object being sought
	 * @return The object, if found, otherwise null
	 */
	private Packages find(Node<E> root, Packages target){
		if(root == null)
			return null;
		//Compare target with the data field at the root
		int compResult = target.compareTo(root.data);
		if(compResult == 0)
			return root.data;
		else if (compResult < 0)
			return find(root.left, target);
		else
			return find(root.right, target);
	}

	/**
	 * Recursive search method
	 * It searches tree by quantity.
	 * @param root
	 * @param target
	 * @return
	 */
	private Packages searchQuantity(Node<E> root, Packages target)
	{
		if(root == null)
			return null;
		//Compare target with the data field at the root
		int compResult = target.compareQuantity(root.data);
		Packages result;
		if(compResult == 0)
			return root.data;
		else
			result = searchQuantity(root.left, target);
			result = searchQuantity(root.right, target);
		return result;
	}

	/**
	 * Recursive search method
	 * It searches tree by price.
	 * @param root
	 * @param target
	 * @return
	 */
	private Packages searchPrice(Node<E> root, Packages target)
	{
		if(root == null)
			return null;
		//Compare target with the data field at the root
		int compResult = target.comparePrice(root.data);
		Packages result;
		if(compResult == 0)
			return root.data;
		else
			result = searchPrice(root.left, target);
			result = searchPrice(root.right, target);
		return result;
	}


	/**
	 * Method delete
	 * post: The object is not in the tree
	 * @param target The object to be deleted
	 * @return The object deleted from the tree or null if the object was not in the tree
	 * @throws ClassCast Exception if target does not implement Comparable
	 */
	public E delete(String target){
		root = delete(root, target);
		return deleteReturn;
	}
	
	/**
	 * Recursive delete method
	 * post: The item is not in the tree;
	 * 		 deleteReturn is equal to the deleted item
	 * 		 as it was stored in the tree or null
	 *		 if the item was not found
	 * @param root The root of the current subtree
	 * @param item The item to be deleted
	 * @return The modified local root that does not contain the item
	 */
	private Node<E> delete(Node<E> root, String item){
		if(root == null){
			//item is not in the tree
			deleteReturn = null;
			return root;
		}
		//search for the item to delete
		int compResult = item.compareTo(root.data.name);
		if(compResult < 0){
			//item is smaller than localRoot.data
			root.left = delete(root.left, item);
			return root;
		} else if (compResult > 0){
			//item is larger than localRoot.data
			root.right = delete(root.right, item);
			return root;
		} else {
			//item is at local root
			deleteReturn = (E) root.data;
			if(root.left == null){
				//if there is no left child, return right child which can also be null
				return root.right;
			} else if (root.right == null){
				//if there is no right child, return left child
				return root.left;
			} else {
				//Node being deleted has 2 children, replace the data with inorder predecessor
				if(root.left.right == null){
					//the left child has no right child. Replace the data with the data in the left child
					root.data = root.left.data;
					root.left = root.left.left; // replace the left child with its left child
					return root;	
				} else {
					//Search for the inorder predecessor and replace deleted node's data with it
					root.data = (Packages) findLargestChild(root.left);
					return root;
				}
			}
		}
	}
	
	/**
	 * Find the node that is the inorder predecessor and replace it with its left child (if any)
	 * post: the inorder predecessor is removed from the tree
	 * warning: only call on nodes with known right children
	 * @param left The parent of possible inorder predecessor
	 * @return The data in the inorder predecessor
	 */
	private E findLargestChild(Node<E> left){
		//if the right child has no right child, it is the inorder predecessor
		if(left.right.right == null){
			E returnValue = (E) left.right.data;
			left.right = left.right.left;
			return returnValue;
		}
		else {
			return findLargestChild(left.right);
		}
	}

}
