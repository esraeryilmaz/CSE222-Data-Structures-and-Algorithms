import java.util.Iterator;

/**
 * Main class  (Driver file)
 *
 * @author Esra Eryılmaz
 * @since 2020-04-11
 */

public class Main
{
	public static void print(MyDeque<?> test)
	{
		System.out.printf("[PRINT DEQUE]\t: ");
		Iterator<?> iter = test.iterator();

		while(iter.hasNext())
			System.out.print(iter.next() + "  ");

		System.out.println("\n");
	}


	public static void main(String[] args)
	{
		System.out.printf("\n\t\tTEST STARTING...\n");
		System.out.printf("---------------------------------------------\n");

		try
		{
			MyDeque<Integer> test = new MyDeque<Integer>();

			System.out.println("add(4)");		test.add(4);
			System.out.println("addFirst(1)");	test.addFirst(1);
			System.out.println("addLast(7)");	test.addLast(7);
			print(test);

			System.out.println("element()\t" + test.element()); 
			System.out.println("getFirst()\t" + test.getFirst());
			System.out.println("getLast()\t" + test.getLast());
			print(test);

			System.out.println("offer(5)  \t" + test.offer(5));
			System.out.println("offerFirst(2)\t" + test.offerFirst(2));
			System.out.println("offerLast(3)\t" + test.offerLast(3));
			print(test);

			System.out.println("peek()  \t" + test.peek());
			System.out.println("peekFirst()\t" + test.peekFirst());
			System.out.println("peekLast()\t" + test.peekLast());
			print(test);

			System.out.println("poll()  \t" + test.poll());
			System.out.println("pollFirst()\t" + test.pollFirst());
			System.out.println("pollLast()\t" + test.pollLast());
			print(test);
			test.printDeleted();

			System.out.println("addLast(8)");	test.addLast(8);
			print(test);
			test.printDeleted();

			System.out.println("pop()   \t" + test.pop());
			System.out.println("push(9)");	  test.push(9);
			print(test);

			System.out.println("remove()\t" + test.remove());
			System.out.println("removeFirst()\t" + test.removeFirst());
			System.out.println("removeLast()\t" + test.removeLast());
			print(test);

			System.out.println("size()  \t" + test.size());

			System.out.println("\n[I used iterator while printing deque.]");


		}
		catch(Exception e)
		{
			System.out.print(e);
		}

		System.out.printf("\n\n---------------------------------------------\n");
		System.out.printf("\t\tTEST FINISHED...\n\n\n");
	}

}
