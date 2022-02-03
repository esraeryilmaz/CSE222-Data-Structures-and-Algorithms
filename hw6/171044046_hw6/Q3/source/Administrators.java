import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

/**
 * Administrators class
 *
 * @author Esra Eryılmaz
 * @since 2020-05-26
 */

public class Administrators<K, V> extends LibrarySystem<K, V>
{
	private final String password = "1234";	//Admin general password.
	int login;	//If admin entered the password correctly, it becomes 1.

	/**
	 * Constructor
	 */
	public Administrators(String pw)
	{
		super();
		if(pw.equals(password))
		{
			System.out.println("Admin login successful");
			login=1;
		}
		else
		{
			System.out.println("Admin login failed");
			login=0;
		}
	}

	/**
	 * Prints the informations in the library.
	 */
	public static void print()
	{
		System.out.println("[PRINT]:");
		for(Entry<String, Map<String, Set<String>>> entry : library.entrySet())
			System.out.println(entry.getKey() + " = " + entry.getValue());
		System.out.println();
	}

	/**
	 * Administrators can add books to the library
	 * @param author
	 * @param book
	 * @param location
	 */
	public void addBook(String author, String book, String location)
	{
		if(this.login == 1)	// If login successful
		{
			if(library.containsKey(author))	// If author exist
			{
				if(library.get(author).containsKey(book))	// If book exist
				{
					library.get(author).get(book).add(location);
				}

				else	// If book does not exist
				{
					Set<String> set = new HashSet<String>();
					set.add(location);
					library.get(author).put(book, set);
				}

			}
			else	// If author does not exist
			{
				Set<String> set = new HashSet<String>();
				set.add(location);

				Map<String, Set<String>>inner = new HashMap<String, Set<String>>();
				inner.put(book, set);

				library.put(author, inner);
			}
		}
		else
		{
			System.out.println("You entered the wrong password !");
		}
	}

	/**
	 * Administrators can delete books in the library.
	 * @param author
	 * @param book
	 */
	public void deleteBook(String author, String book)
	{
		if(login == 1 )	// If login successful
		{
			if(library.containsKey(author))	// If author exist
			{
				if(library.get(author).containsKey(book))	// If book exist
					library.get(author).remove(book);

				else	// If book does not exist
					System.out.println("This author has no such book. !");
			}
			else
			{
				System.out.println("There is no such author. !");
			}
		}
		else
		{
			System.out.println("You entered the wrong password !");	
		}
	}

	/**
	 * Administrators can update informations in the library.
	 */
	public void updateInfo()
	{
		Scanner sc = new Scanner(System.in);  // Create a Scanner object
		System.out.println("What do you want to do ?");
		System.out.println("1)Add book");
		System.out.println("2)Remove book");
		System.out.print("Choice 1 or 2 : ");

		String choice = sc.nextLine();  // Read user input

		if(choice.equals("1"))
		{
			System.out.print("Author name: ");
			String author = sc.nextLine();
			System.out.print("Book name: ");
			String book = sc.nextLine();
			System.out.print("Location: ");
			String location = sc.nextLine();

			addBook(author, book, location);
		}
		else if(choice.equals("2"))
		{
			System.out.print("Author name: ");
			String author = sc.nextLine();
			System.out.print("Book name: ");
			String book = sc.nextLine();

			deleteBook(author, book);
		}
		else
		{
			System.out.println("You made the wrong choice !\n");
		}
		System.out.println();
	}

	/**
	 * Searching by author name, method will list all books of the author if there any exist.
	 * @param author
	 */
	public static void authorSearch(String author)
	{
		if(library.containsKey(author))	// If author exist
		{
			System.out.print("All books of the author : ");
			System.out.println(library.get(author).keySet());

			Scanner sc = new Scanner(System.in);  // Create a Scanner object
			System.out.print("Enter book name: ");

			String bookName = sc.nextLine();  // Read user input

			if(library.get(author).containsKey(bookName))
			{
				System.out.println("The location of the book of your choice:");
				System.out.println(library.get(author).get(bookName) + "\n");
			}
			else
			{
				System.out.println("This author has no such book. !\n");
			}

		}
		else	// If author does not exist
		{
			System.out.println("There is no such author. !\n");
		}
		
	}

	/**
	 * Searching by book name, method will list book's author name and locations if there any exist.
	 * @param book
	 */
	public static void bookSearch(String book)
	{
		int flag = 0;

		for(Entry<String, Map<String, Set<String>>> temp : library.entrySet())
		{
			if(temp.getValue().containsKey(book))
			{
				System.out.println("Author name: " + temp.getKey());
				System.out.println("Book locations: " + temp.getValue().values() + "\n");
				flag = 1;
				break;
			}
			else
				flag = 0;
		}
		if(flag==0)
			System.out.println("There is no such book. !");

	}


}
