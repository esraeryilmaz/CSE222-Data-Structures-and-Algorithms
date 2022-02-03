import java.util.Random;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * Main class  (Driver file)
 *
 * @author Esra Eryılmaz
 * @since 2020-06-01
 */

public class Main
{
	/**
	 * It creates random array
	 * @param n
	 * @return
	 */
	public static Integer[] randomArray(int n)
	{
		Integer[] arr = new Integer[n];
		Random r = new Random();
		for (int i = 0 ; i < n ; i++)
			arr[i] = r.nextInt(10000);
		return arr;
	}

	public static void insertBST(Integer[] arr)
	{
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		long before = System.nanoTime();

		for(int i=0 ; i<arr.length ; ++i)
			bst.add(arr[i]);

		System.out.print("  "+(System.nanoTime() - before) / 1000000 +"\t");

//		System.out.println(bst.inorder());
	}

	public static void deleteBST(Integer[] arr)
	{
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		for(int i=0 ; i<arr.length ; ++i)
			bst.add(arr[i]);

		long before = System.nanoTime();
		for(int i=0 ; i<10 ; i++)
			bst.remove(arr[i]);
		System.out.print("  "+(System.nanoTime() - before) / 1000 +"\t");
	}

	public static void insertRedBlackBook(Integer[] arr)
	{
		RedBlackTree<Integer> rb = new RedBlackTree<Integer>();
		long before = System.nanoTime();

		for(int i=0 ; i<arr.length ; ++i)
			rb.add(arr[i]);

		System.out.print("  "+(System.nanoTime() - before) / 1000000 +"\t");
	}

	public static void deleteRedBlackBook(Integer[] arr)
	{
		RedBlackTree<Integer> rb = new RedBlackTree<Integer>();
		for(int i=0 ; i<arr.length ; ++i)
			rb.add(arr[i]);

		long before = System.nanoTime();
		for(int i=0 ; i<10 ; i++)
			rb.remove(arr[i]);
		System.out.print("  "+(System.nanoTime() - before) / 1000 +"\t");
	}

	public static void insertRedBlackJava(Integer[] arr)
	{
		TreeSet<Integer> red = new TreeSet<Integer>();
		long before = System.nanoTime();

		for(int i=0 ; i<arr.length ; ++i)
			red.add(arr[i]);

		System.out.print("\t"+(System.nanoTime() - before) / 1000000 +"\t");
	}

	public static void deleteRedBlackJava(Integer[] arr)
	{
		TreeSet<Integer> red = new TreeSet<Integer>();
		for(int i=0 ; i<arr.length ; ++i)
			red.add(arr[i]);

		long before = System.nanoTime();
		for(int i=0 ; i<10 ; i++)
			red.remove(arr[i]);
		System.out.print("\t"+(System.nanoTime() - before) / 1000 +"\t");
	}

	public static void insertBTree(Integer[] arr)
	{
		BTree<Integer> btree = new BTree<Integer>(4);
		long before = System.nanoTime();

		for(int i=0 ; i<arr.length ; ++i)
			btree.add(arr[i]);

		System.out.print("   "+(System.nanoTime() - before) / 1000000 +"\t");

	}

	public static void deleteBTree(Integer[] arr)
	{
		System.out.print("   - \t\t");
	}

	public static void insertSkipListBook(Integer[] arr)
	{
		SkipList<Integer> skip = new SkipList<Integer>();
		long before = System.nanoTime();

		for(int i=0 ; i<arr.length ; ++i)
			skip.add(arr[i]);

		System.out.print("\t" + (System.nanoTime() - before) / 1000000 +"\t");
	}

	public static void deleteSkipListBook(Integer[] arr)
	{
		SkipList<Integer> skip = new SkipList<Integer>();
		for(int i=0 ; i<arr.length ; ++i)
			skip.add(arr[i]);

		long before = System.nanoTime();
		for(int i=0 ; i<10 ; ++i)
			skip.remove(arr[i]);
		System.out.print("  "+(System.nanoTime() - before) / 1000 +"\t");
	}

	public static void insertSkipListJava(Integer[] arr)
	{
		ConcurrentSkipListSet<Integer> skip = new ConcurrentSkipListSet<Integer>();
		long before = System.nanoTime();

		for(int i=0 ; i<arr.length ; ++i)
			skip.add(arr[i]);

		System.out.print("\t" + (System.nanoTime() - before) / 1000000 +"\t");
	}

	public static void deleteSkipListJava(Integer[] arr)
	{
		ConcurrentSkipListSet<Integer> skip = new ConcurrentSkipListSet<Integer>();
		for(int i=0 ; i<arr.length ; ++i)
			skip.add(arr[i]);

		long before = System.nanoTime();
		for(int i=0 ; i<10 ; ++i)
			skip.remove(arr[i]);
		System.out.print("  "+(System.nanoTime() - before) / 1000 +"\t");
	}

	public static void main(String[] args)
	{
		int[] size = {10000,20000,40000,80000};
		Integer[] random;

		System.out.println("\n\t\tTEST STARTING...");
		System.out.println("\nINSERTION (run-time in milliseconds)\n");

		System.out.println("--------------------------------------------------------------------------------");

		for(int i=0 ; i<4 ; ++i)
		{
			System.out.println("\t\t____SIZE " + size[i] + "____");
			System.out.println("\t BST |Red-Bl(book)| Red-Bl(java)| B-TREE | Skip-L(book)| Skip-L(java)");

			for(int j=0 ; j<10 ; ++j)
			{
				System.out.print("Test " + (j+1) + ") ");

				random = randomArray(size[i]);
				insertBST(random);

				random = randomArray(size[i]);
				insertRedBlackBook(random);

				random = randomArray(size[i]);
				insertRedBlackJava(random);

				random = randomArray(size[i]);
				insertBTree(random);

				random = randomArray(size[i]);
				insertSkipListBook(random);

				random = randomArray(size[i]);
				insertSkipListJava(random);

				System.out.println();
			}
			System.out.println("--------------------------------------------------------------------------------");
		}
		System.out.println("\n\nDELETION(run-time in microseconds)\n");

		for(int i=0 ; i<4 ; ++i)
		{
			System.out.println("\t\t____SIZE " + size[i] + "____");
			System.out.println("\t BST |Red-Bl(book)| Red-Bl(java)| B-TREE | Skip-L(book)| Skip-L(java)");

			for(int j=0 ; j<10 ; ++j)
			{
				System.out.print("Test " + (j+1) + ") ");

				random = randomArray(size[i]);
				deleteBST(random);

				random = randomArray(size[i]);
				deleteRedBlackBook(random);

				random = randomArray(size[i]);
				deleteRedBlackJava(random);

				random = randomArray(size[i]);
				deleteBTree(random);

				random = randomArray(size[i]);
				deleteSkipListBook(random);

				random = randomArray(size[i]);
				deleteSkipListJava(random);

				System.out.println();
			}
			System.out.println("--------------------------------------------------------------------------------");
		
		}
		System.out.printf("\t\tTEST FINISHED...\n\n\n");


	}

}
