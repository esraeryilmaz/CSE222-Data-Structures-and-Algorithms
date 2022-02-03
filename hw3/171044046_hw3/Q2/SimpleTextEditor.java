import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;


/**
 * Class SimpleTextEditor
 * @author Esra Eryılmaz
 */
public class SimpleTextEditor
{
	// Data Fields

	/**
	 * List of characters
	 */
	private List<Character>list;
	/**
	 * Total number of characters.
	 */
	private int size = 0;


	/**
	 * Constructor
	 * @param newList
	 */
	public SimpleTextEditor(List<Character> newList)
	{
		this.list = newList;
	}


	/**
	 * Prints the list on the screen.
	 */
	public String print()
	{
		String temp = new String();
		for(Character element : list)
		{
			temp = temp + element;
		}
		System.out.print("[PRINT] : ");
		return temp;
	}

	/**
	 * Reading file using iterator and construct the text.
	 * @param file
	 * @throws FileNotFoundException
	 */
	public void readWithIterator(File file) throws FileNotFoundException
	{
		String str;
		Scanner sc = new Scanner(file);
		while (sc.hasNextLine())
		{
			str = sc.nextLine();
			CharacterIterator it = new StringCharacterIterator(str);

			// Iterates character sets from the beginning to the last character
	        for (char ch = it.first(); ch != CharacterIterator.DONE; ch = it.next())
	        {
	        	list.add(ch);
	        	++size;
	        }
		}
		sc.close();
	}

	/**
	 * Reading file using loop and construct the text.
	 * @param file
	 * @throws IOException 
	 */
	public void readWithLoop(File file) throws IOException
	{
		FileReader F = new FileReader(file);
		int a;

		//This loop will read characters and found character will be stored in a.
		while((a=F.read())!=-1)
			list.add((char)a);

		// This will close the opened file. 
		F.close();
	}

	/**
	 * Adds one or more characters at the specified position with iterator.
	 * @param index
	 * @param str
	 */
	public void addWithIterator(int index, String str)
	{
		int count = 0;
		for (ListIterator<Character> iter = list.listIterator() ; iter.hasNext() ; ++count, iter.next())
		{
			if(count == index)
			{
				for(int i=0 ; i<str.length() ; ++i)
					iter.add(str.charAt(i));	// Copy character by character into list
			}
		}
	}

	/**
	 * Adds one or more characters at the specified position with loop.
	 * @param index
	 * @param str
	 */
	public void addWithLoop(int index, String str)
	{
		for(int i=0 ; i<str.length() ; ++i, ++index)
			list.add(index, str.charAt(i));
	}

	/**
	 * Finds the start index of the first occurrence of the searched group of characters and returns.With using iterator.
	 * @param str
	 * @return
	 */
	public int findWithIterator(String str)
	{
		int count = 0, k=0, i=0;

		while(count != str.length() && i != size)
		{
			i=0;
			for (ListIterator<Character> iter = list.listIterator(); iter.hasNext() ; iter.next())//sona ekle ,iter.next()
			{
				if(list.get(i) == str.charAt(0))
				{
					count = 0;
					k=i;
					for(int j=0 ; j<str.length() ; ++j,++k)
					{
						if(list.get(k) == str.charAt(j))
							++count;
						if(count == str.length())
							return i;
					}
				}
				i++;
			}
		}
		return -1;
	}

	/**
	 * Finds the start index of the first occurrence of the searched group of characters and returns.With using loop.
	 * @param str
	 * @return
	 */
	public int findWithLoop(String str)
	{
		char[] ch = new char[str.length()]; 
		int count = 0 , i=0,k=0;

		// Copy character by character into array 
		for (i = 0; i < str.length(); ++i)
			ch[i] = str.charAt(i);

		while(count != str.length() && i != size)
		{
			for(i=0 ; i<size ; ++i)
			{
				if(list.get(i) == str.charAt(0))
				{
					count = 0;
					k=i;
					for(int j=0 ; j<str.length() ; ++j,++k)
					{
						if(list.get(k) == str.charAt(j))
							++count;
						if(count == str.length())
							return i;
					}
				}
			}
		}
		return -1;
	}

	/**
	 * Replaces all occurrences of a character with another character.It uses iterator.
	 * @param addingChar
	 * @param removingChar
	 */
	public void replaceWithIterator(Character addingChar, Character removingChar)
	{
		Character count = ' ';

		for (ListIterator<Character> iter = list.listIterator() ; iter.hasNext() ; count = iter.next())
		{
			if(count == removingChar)
			{
				iter.remove();
				iter.add(addingChar);
			}
		}
	}

	/**
	 * Replaces all occurrences of a character with another character.It uses loop.
	 * @param addingChar
	 * @param removingChar
	 */
	public void replaceWithLoop(Character addingChar, Character removingChar)
	{
		for(int i=0 ; i<size ; ++i)
		{
			if(i == list.indexOf(removingChar))
			{
				list.remove(i);
				list.add(i, addingChar);
			}
		}
	}

}
