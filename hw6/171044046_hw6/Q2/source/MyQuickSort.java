import java.util.LinkedList;

/**
 * MyQuickSort class
 *
 * @author Esra Eryılmaz
 * @since 2020-05-24
 */

public class MyQuickSort
{
	public <T extends Comparable<T>> void sort(LinkedList<T> table)
	{
		if(table.indexOf(0) == 0)
			return ;
		quickSort(table, 0, table.size() - 1);
	}

	private <T extends Comparable<T>> void quickSort(LinkedList<T> table, int first, int last)
	{
		if (first < last) { // There is data to be sorted.
			// Partition the table.
			int pivIndex = partition(table, first, last);
			// Sort the left half.
			quickSort(table, first, pivIndex - 1);
			// Sort the right half.
			quickSort(table, pivIndex + 1, last);
		}
	}

	private <T extends Comparable<T>> int partition(LinkedList<T> table, int first, int last)
	{
		// Select the first item as the pivot value.
		T pivot = table.get(first);
		int up = first; int down = last;
		do {

			while ((up < last) && (pivot.compareTo(table.get(up)) >= 0))
			{
				up++;
			}

			while (pivot.compareTo(table.get(down)) < 0)
			{
				down--;
			}

			if (up < down)
			{
				swap(table, up, down);
			}
		} while (up < down);

		swap(table, first, down);

		return down;
	}

	private static <T extends Comparable<T>> void swap(LinkedList<T> table, int i, int j) {

		if(i==j)
			return ;
		T temp = table.get(i);
		table.remove(i);
		table.add(i, table.get(j-1));
		table.remove(j);
		table.add(j, temp);

	}
}
