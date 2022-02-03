/**
 * Users class
 *
 * @author Esra Eryılmaz
 * @since 2020-05-26
 */


public class Users
{

	/**
	 * Searching by author name, method will list all books of the author if there any exist.
	 * @param author
	 */
	public void authorSearch(String author)
	{
		Administrators.authorSearch(author);
	}

	/**
	 * Searching by book name, method will list book's author name and locations if there any exist.
	 * @param book
	 */
	public void bookSearch(String book)
	{
		Administrators.bookSearch(book);
	}

}
