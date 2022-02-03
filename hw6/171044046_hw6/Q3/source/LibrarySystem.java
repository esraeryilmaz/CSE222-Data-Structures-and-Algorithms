import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * LibrarySystem abstract class
 *
 * @author Esra Eryılmaz
 * @since 2020-05-26
 */

public abstract class LibrarySystem <K, V>
{

	protected static Map<String, Map<String, Set<String>>> library = 
										new HashMap<String, Map<String, Set<String>>>();

	
/*	Outer
	   key -> author name
	   	  value -> inner map
  	Inner
  	   key -> book name
  	       value -> (sets) location
*/



	/**
	 * @return the library
	 */
	public static Map<String, Map<String, Set<String>>> getLibrary() {
		return library;
	}



}
