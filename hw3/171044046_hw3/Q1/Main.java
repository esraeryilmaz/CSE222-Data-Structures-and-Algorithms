/**
 * Main class  (Driver file)
 *
 * @author Esra Eryılmaz
 * @since 2020-03-30
 */

public class Main
{
	public static void main(String[] args)
	{
		System.out.printf("\n\t\tTEST STARTING...\n\n");
		System.out.printf("--------------------------------------------------------------\n");

		try
		{
			LinkedArrayList<Integer> intTest = new LinkedArrayList<Integer>();
			LinkedArrayList<String> stringTest = new LinkedArrayList<String>();


			System.out.printf("\t(Integer List)\n");

			System.out.printf("\nAdd 4,1,7,2,3,9,6,8 to list\n");
			intTest.add(4);
			intTest.add(1);
			intTest.add(7);
			intTest.add(2);
			intTest.add(3);
			intTest.add(9);
			intTest.add(6);
			intTest.add(8);
			intTest.print();
			
			System.out.printf("\nAdd \"5\" at the 4. index\n");
			intTest.add(4,5);
			intTest.print();

			System.out.printf("\nRemove 2. index\n");
			intTest.remove(2);
			intTest.print();

			System.out.printf("\nAdd \"7\"\n");
			intTest.add(7);
			intTest.print();

			System.out.printf("\nAdd \"0\" at the 6. index\n");
			intTest.add(6, 0);
			intTest.print();

			System.out.printf("\n-----------------------------------------------\n");

			System.out.printf("\n\t(String List)\n");

			System.out.printf("\nAdd Esra, Fatma, Ahmet, Mehmet, Ayse, Mustafa, Ali to list\n");
			stringTest.add("Esra");
			stringTest.add("Fatma");
			stringTest.add("Ahmet");
			stringTest.add("Mehmet");
			stringTest.add("Ayse");
			stringTest.add("Mustafa");
			stringTest.add("Ali");
			stringTest.print();

			System.out.printf("\nAdd \"Meryem\" at the 4. index\n");
			stringTest.add(4,"Meryem");
			stringTest.print();

			System.out.printf("\nRemove 1. index\n");
			stringTest.remove(1);
			stringTest.print();

			System.out.printf("\nAdd \"Emine\"\n");
			stringTest.add("Emine");
			stringTest.print();

			System.out.printf("\nRemove 4. index\n");
			stringTest.remove(4);
			stringTest.print();
			
		}
		catch(Exception e)
		{
			System.out.print(e);
		}

		System.out.printf("--------------------------------------------------------------\n");
		System.out.printf("\t\tTEST FINISHED...\n\n\n");
	}

}
