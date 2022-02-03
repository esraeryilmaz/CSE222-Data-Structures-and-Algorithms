import java.util.LinkedList;
import java.util.Random;

/**
 * Main class  (Driver file)
 *
 * @author Esra Eryılmaz
 * @since 2020-05-24
 */

public class Main
{
	/**
	 * It creates sorted array
	 * @param n
	 * @return
	 */
	public static Integer[] sortedArray(int n)
	{
		Integer[] arr = new Integer[n];
		for(int i = 0 ; i < n ; i++)
			arr[i] = i;
		return arr;
	}

	/**
	 * It creates sorted linked list
	 * @param n
	 * @return
	 */
	public static LinkedList<Integer> sortedList(int n)
	{
		LinkedList<Integer> ll = new LinkedList<>();
		for(int i=0 ; i<n ; i++)
			ll.add(i);
		return ll;
	}

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

	/**
	 * It creates random linked list
	 * @param n
	 * @return
	 */
	public static LinkedList<Integer> randomList(int n)
	{
		LinkedList<Integer> ll = new LinkedList<>();
		Random r = new Random();
		for (int i=0 ; i<n ; ++i)
			ll.add(r.nextInt(10000));
		return ll;
	}

	/**
	 * @param arr
	 */
	public static void selectionTime(Integer[] arr)
	{
		SelectionSort selec = new SelectionSort();
		long before = System.nanoTime();
		selec.sort(arr);
		System.out.print((System.nanoTime() - before) / 1000000 +"\t"); //nanosecond to millisecond
	}

	/**
	 * @param arr
	 */
	public static void bubbleTime(Integer[] arr)
	{
		BubbleSort bubble = new BubbleSort();
		long before = System.nanoTime();
		bubble.sort(arr);
		System.out.print((System.nanoTime() - before) / 1000000 +"\t");
	}

	/**
	 * @param arr
	 */
	public static void insertionTime(Integer[] arr)
	{
		InsertionSort inser = new InsertionSort();
		long before = System.nanoTime();
		inser.sort(arr);
		System.out.print((System.nanoTime() - before) / 1000000 +"\t");
	}

	/**
	 * @param arr
	 */
	public static void shellTime(Integer[] arr)
	{
		ShellSort shell = new ShellSort();
		long before = System.nanoTime();
		shell.sort(arr);
		System.out.print((System.nanoTime() - before) / 1000000 +"\t");
	}

	/**
	 * @param arr
	 */
	public static void mergeTime(Integer[] arr)
	{
		MergeSort merge = new MergeSort();
		long before = System.nanoTime();
		merge.sort(arr);
		System.out.print((System.nanoTime() - before) / 1000000 +"\t");
	}

	/**
	 * @param arr
	 */
	public static void heapTime(Integer[] arr)
	{
		HeapSort heap = new HeapSort();
		long before = System.nanoTime();
		heap.sort(arr);
		System.out.print((System.nanoTime() - before) / 1000000 +"\t");
	}

	/**
	 * @param arr
	 */
	public static void quickTime(Integer[] arr)
	{
		QuickSort quick = new QuickSort();
		long before = System.nanoTime();
		quick.sort(arr);
		System.out.print((System.nanoTime() - before) / 1000000 +"\t");
	}

	/**
	 * @param list
	 */
	public static void myQuickTime(LinkedList<Integer> list)
	{
		MyQuickSort myQuick = new MyQuickSort();
		long before = System.nanoTime();
		myQuick.sort(list);
		System.out.print((System.nanoTime() - before) / 1000000 +"\t");
	}

	/**
	 * @param list
	 */
	public static void myMergeTime(LinkedList<Integer> list)
	{
		MyMergeSort myMerge = new MyMergeSort();
		long before = System.nanoTime();
		myMerge.sort(list);
		System.out.print((System.nanoTime() - before) / 1000000 +"\t");
	}


	public static void main(String[] args)
	{
		int[] size = {10000,40000,100000,150000,180000};
		Integer[] random;
		Integer[] sorted;
		LinkedList<Integer> randomList;
		LinkedList<Integer> sortedList;

		System.out.println("\n\t\tTEST STARTING...");
		System.out.println("-------------------------------------------------------------------------");


		System.out.println("\n****** FOR RANDOM ******\n");

		for(int i=0 ; i<5 ; ++i)
		{
			System.out.println("\t\t____SIZE " + size[i] + "____");
			System.out.println("\tMyQuick | MyMerge|Select|Bubble|Insertion|Shell| Merge | Heap | Quick");

			for(int j=0 ; j<20 ; ++j)
			{
				System.out.print("Test " + (j+1) + ") ");

				randomList = randomList(size[i]);
				myQuickTime(randomList);

				randomList = randomList(size[i]);
				myMergeTime(randomList);

				random = randomArray(size[i]);
				selectionTime(random);

				random = randomArray(size[i]);
				bubbleTime(random);

				random = randomArray(size[i]);
				insertionTime(random);

				random = randomArray(size[i]);
				shellTime(random);

				random = randomArray(size[i]);
				mergeTime(random);

				random = randomArray(size[i]);
				heapTime(random);

				random = randomArray(size[i]);
				quickTime(random);

				System.out.println();
			}
			System.out.println("-------------------------------------------------------------------------");
		}

		System.out.println("\n****** FOR SORTED ******\n");
		for(int i=0 ; i<5 ; ++i)
		{
			System.out.println("\t\t____SIZE " + size[i] + "____");
			System.out.println("MyQuick|MyMerge|Select| Bubble|Insertion| Shell| Merge| Heap| Quick");

			sortedList = sortedList(size[i]);
			myQuickTime(sortedList);
			myMergeTime(sortedList);

			sorted = sortedArray(size[i]);
			selectionTime(sorted);
			bubbleTime(sorted);
			insertionTime(sorted);
			shellTime(sorted);
			mergeTime(sorted);
			heapTime(sorted);
			quickTime(sorted);

			System.out.println();
			System.out.println("-------------------------------------------------------------------------");
		}

		System.out.println("\n\t\tTEST FINISHED...\n\n");
	}

}
