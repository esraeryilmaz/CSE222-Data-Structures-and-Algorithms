import java.util.LinkedList;
import java.util.ListIterator;

/**
 * MyMergeSort class
 *
 * @author Esra Eryılmaz
 * @since 2020-05-24
 */

public class MyMergeSort
{
	/**
	 * Merge two sequences.
	 * @param <T>
	 * @param outputSequence
	 * @param leftSequence
	 * @param rightSequence
	 */
	private static <T extends Comparable<T>> void merge(LinkedList<T> outputSequence,
														LinkedList<T> leftSequence,
														LinkedList<T> rightSequence)
	{
		ListIterator<T> left = leftSequence.listIterator();
		ListIterator<T> right = rightSequence.listIterator();

		while (left.hasNext() && right.hasNext())
		{
			T tmpLeft = left.next();
			T tmpRight = right.next();
			if (tmpLeft.compareTo(tmpRight)<0)
			{
				outputSequence.add(tmpLeft);
                right.previous();
			}
			else
            {
            	outputSequence.add(tmpRight);
                left.previous();
            }
		}

		while (left.hasNext())
        	outputSequence.add(left.next());

        while (right.hasNext())
        	outputSequence.add(right.next());
	}

	/**
	 * Sort the linked list using merge sort algorithm
	 * @param <T>
	 * @param table
	 */
	public static <T extends Comparable<T>> void sort(LinkedList<T> table)
	{
		if (table.size()>1)
		{
			int halfSize = table.size()/2;
			LinkedList<T> leftTable = new LinkedList<>();
			LinkedList<T> rightTable = new LinkedList<>();

			ListIterator<T> it = table.listIterator();

			for(int i=0 ; i<halfSize ; ++i)
				leftTable.add(it.next());

			while (it.hasNext())
				rightTable.add(it.next());

			sort(leftTable);
			sort(rightTable);

			merge(table,leftTable,rightTable);
        }
    }

}
