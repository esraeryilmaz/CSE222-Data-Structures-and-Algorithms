import java.util.Scanner;

/**
 * Main class  (Driver file)
 *
 * @author Esra Eryılmaz
 * @since 2020-05-26
 */

public class Main
{

	public static <V, K> void main(String[] args)
	{
		System.out.println("\n\t\tTEST STARTING...");
		System.out.println("------------------------------------------------");
		
		Administrators<K, V> admin = new Administrators<K, V>("1234");
		Users user = new Users();

		System.out.println("\n\tAdmin -> adds books ...");
		admin.addBook("Oguz Atay", "Tutunamayanlar", "c4s3.2312");
		admin.addBook("Tolkien", "Hobbit", "c1s1.1111");
		admin.addBook("Tolkien", "Hobbit", "c1s2.2222");
		admin.addBook("Yasar Kemal", "Ince Memed", "c7s7.3221");
		admin.addBook("Dostoyevsky", "Crime and Punishment", "c5s4.3222");
		admin.addBook("Dostoyevsky", "Pool Folk", "c6s7.1332");
		Administrators.print();

		System.out.println("\tAdmin -> deleteBook(Yasar Kemal,Ince Memed)");
		admin.deleteBook("Yasar Kemal", "Ince Memed");
		Administrators.print();

		System.out.println("\tUser -> bookSearch(Hobbit)");
		user.bookSearch("Hobbit");

		System.out.println("\tUser -> authorSearch(Dostoyevsky)");
		admin.authorSearch("Dostoyevsky");

		System.out.println("\tAdmin -> updateInfo()");
		admin.updateInfo();

		Administrators.print();

		System.out.printf("\n------------------------------------------------\n");
		System.out.printf("\t\tTEST FINISHED...\n\n\n");
	}

}
