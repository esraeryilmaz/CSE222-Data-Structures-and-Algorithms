import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 * Main class  (Driver file)
 *
 * @author Esra Eryılmaz
 * @since 2020-04-01
 */
public class Main
{

//		I create "file1.txt" and read from these file for testing program.

	public static void main(String[] args)
	{
		File file1 = new File("file1.txt");

		System.out.println("Console output is written to log.txt file.");
		try
		{
			List<Character> arraylist = new ArrayList<Character>();
			SimpleTextEditor test1 = new SimpleTextEditor(arraylist);

			List<Character> linkedlist = new LinkedList<Character>();
			SimpleTextEditor test2 = new SimpleTextEditor(linkedlist);

			long start, end;

			File f = new File("log.txt"); //Your file
			FileOutputStream fos = new FileOutputStream(f);
			PrintStream ps = new PrintStream(fos);
			System.setOut(ps);

			System.out.println("I tested the iterator functions with arraylist and loop functions with linkedlist for not to read the same file two times.");

			System.out.printf("\n\t\tTEST STARTING...\n\n");
			System.out.printf("------------------------------------------------------------------------------------------\n");

			System.out.println("\tARRAYLIST\n");

			start = System.nanoTime();

			System.out.println("READ WITH ITER");
			test1.readWithIterator(file1);
			System.out.println(test1.print() + "\n");

			System.out.println("ADD WITH ITER\nAdd \"SHORT\" at the 12. index");
			test1.addWithIterator(12, "SHORT ");
			System.out.println(test1.print() + "\n");

			System.out.print("FIND WITH ITER\nFind \"test\" at the ");
			System.out.println(test1.findWithIterator("test") + " index.\n");

			System.out.println("REPLACE WITH ITER\nReplace 'i' with '*' ");
			test1.replaceWithIterator('*', 'i');
			System.out.println(test1.print() + "\n\n");

			end = System.nanoTime() - start;

			System.out.println("Running Time for iterator: " + (double)(end) / 1000000000.0 + " second");


			System.out.printf("---------------------------------------------------------------------------------\n");

			start = System.nanoTime();
			System.out.println("\n\tLINKEDLIST\n");

			System.out.println("READ WITH LOOP");
			test2.readWithLoop(file1);
			System.out.println(test2.print() + "\n");


			System.out.println("ADD WITH LOOP\nAdd \"SHORT\" at the 12. index");
			test2.addWithLoop(12, "SHORT ");
			System.out.println(test2.print() + "\n");


			System.out.println("FIND WITH LOOP\nFind \"test\" at the ");
			System.out.println(test2.findWithIterator("test") + " index.\n");


			System.out.println("REPLACE WITH LOOP\nReplace 'i' with '*' ");
			test2.replaceWithLoop('*', 'i');
			System.out.println(test2.print() + "\n\n");
			
			end = System.nanoTime() - start;


			System.out.println("Running Time for loop: " + (double)(end) / 1000000000.0 + " second");

		}
		catch(Exception e)
		{
			System.out.print(e);
		}

		System.out.printf("------------------------------------------------------------------------------------------\n");
		System.out.printf("\t\tTEST FINISHED...\n\n\n");
	}

}
