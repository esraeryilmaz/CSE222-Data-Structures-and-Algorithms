/**
 * Main class  (Driver file)
 *
 * @author Esra Eryılmaz
 * @since 2020-06-04
 */

public class Main
{

	public static void main(String[] args)
	{
		System.out.println("\n\t\tTEST STARTING...");
		System.out.println("------------------------------------------------");

		SoftwareStore store = new SoftwareStore();

		store.testSystem();

		System.out.printf("\n------------------------------------------------\n");
		System.out.printf("\t\tTEST FINISHED...\n\n\n");
	}

}
