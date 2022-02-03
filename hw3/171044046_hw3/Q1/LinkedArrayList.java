import java.util.AbstractList;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;


/**
 * Class LinkedArrayList
 * @author Esra Eryılmaz
 * @param <E>generic
 *
 */
public class LinkedArrayList<E> extends AbstractList<E> implements List<E>
{
	// Data Fields

	/**
	 * Total number of elements in all nodes
	 */
	private int totalSize;
	/**
	 * A reference to the head of the list.
	 */
	private Node<E> head;
	/**
	 * A reference to the end of the list.
	 */
	private Node<E> tail;
	/**
	 * The default initial capacity
	 */
	private static final int NODE_INITIAL_CAPACITY = 4;

	/**
	 * No parameter constructor
	 */
	public LinkedArrayList()
	{
		totalSize = 0;
		head = null;
		tail = null;
	}


	/**
	 * Prints the list on the screen.
	 */
	public void print()
	{
		System.out.print("[PRINT LIST] : ");
		for (Node<E> t = head ; t != null ; t=t.next)
		{
			for(int i=0 ; i<t.used ; i++)
			{
				System.out.print(t.getArray(i));
				System.out.print(" ");
			}
			System.out.print(" -  ");
		}
		System.out.println();
	}

	/**
	 * Adds the specified element to the end of this list.
	 * @param e
	 */
	public boolean add(E e)
	{
		if(head == null)
		{
			head = new Node<E>(e,null,null);
			tail = head;
		}
		else
		{
			Node<E> temp = head;
			while(temp.next != null)
				temp = temp.next;

			if(temp.used < NODE_INITIAL_CAPACITY)
			{
				temp.array[temp.getUsed()] = e;
				++temp.used;
			}
			else
			{
				tail = new Node<E>(e,null,temp);
				temp.next = tail;
			}
		}
		++totalSize;
		return true;
	}

	/**
	 * Adds the specified element at the specified position in this list.
	 * @param index
	 * @param element
	 */
	public void add(int index, E element)
	{
		if(index == totalSize)
		{
			add(element);
		}
		else if(index < 0 || index > totalSize)
			throw new IndexOutOfBoundsException(Integer.toString(index));

		else if(head == null)
		{
			add(element);
		}
		else
		{
			int tempIndex=index;
			int count=0;

			Node<E> temp = head;

			while(count+3 < index)
			{
				count += temp.used;
				tempIndex = tempIndex-temp.used;
				temp = temp.next;
			}

			if(tempIndex<0)
			{
				tempIndex = NODE_INITIAL_CAPACITY+tempIndex;
			}

			E tmp;

			if(temp.used<NODE_INITIAL_CAPACITY)
			{

				for(int i=temp.used ; i>=0 ; --i)
				{
					if(i==tempIndex)
					{
						tmp = temp.array[i];
						temp.array[i] = element;
						temp.array[i+1] = tmp;
					}
					else if(i>tempIndex)
					{
						tmp = temp.array[i-1];
						temp.array[i] = tmp;
					}
				}
				++temp.used;
			}
			else if(temp.used == NODE_INITIAL_CAPACITY)
			{
				Node<E> addNode = new Node<E>(element,temp,temp.prev);
				temp.prev.next = addNode;
				temp.prev = addNode;

				for(int i=0 ; i<NODE_INITIAL_CAPACITY ; ++i)
				{
					if(i<tempIndex)
					{
						addNode.array[i] = temp.array[i];
					}
					else if(i==tempIndex)
					{
						addNode.array[i] = element;
					}
					else if(i>tempIndex)
					{
						addNode.array[i] = temp.array[i-1];
					}
				}

				temp.array[0] = temp.array[3];
				for(int i=1 ; i<NODE_INITIAL_CAPACITY ; i++)
				{
					temp.array[i] = null;
				}
				addNode.used = NODE_INITIAL_CAPACITY;
				temp.used = 1;
				++totalSize;
			}
		}
	}

	/**
	 * Removes the element at the specified position in this list.
	 * @param index
	 */
	public E remove(int index)
	{
		E returnValue = null;
		if(index < 0 || index > totalSize-1 )
			throw new IndexOutOfBoundsException(Integer.toString(index));

		else
		{
			int tempIndex=index;
			int count=0;

			Node<E> temp = head;

			while(count+3 < index)
			{
				count += temp.used;
				tempIndex = tempIndex-temp.used;
				temp = temp.next;
			}


			if(tempIndex<0)
			{
				tempIndex = NODE_INITIAL_CAPACITY+tempIndex;
			}

			returnValue = temp.array[tempIndex];

			if(temp.used == 1)			//node silincek
			{
				if(temp.next != null)
					temp.next.prev = temp.prev;
				if(temp.prev != null)
					temp.prev.next = temp.next;

			}
			else if(temp.used != 1)
			{
				int k=0;
				for(int i=0 ; i<temp.used ; ++i)
				{
					if(i != tempIndex)
					{
						temp.array[k] = temp.array[i];
						++k;
					}
				}
				temp.array[k] = null;

				--temp.used;
			}
			--totalSize;
		}

		return returnValue;
	}

	/**
	 * Returns a list iterator over the elements in this list.
	 */
	public MyIterator listIter()
	{
		return new MyIterator(0);
	}

	/**
	 * Returns a list iterator over the elements in this list, starting at the specified position.
	 */
	public MyIterator listIter(int index)
	{
		return new MyIterator(index);
	}

	@Override
	public E get(int index)
	{
//		I didn't need to implement these method.
		return null;
	}

	/**
	 * Returns the number of elements in this list.
	 */
	@Override
	public int size()
	{
		return totalSize;
	}



	/**
	 * Inner class
	 * A Node is the building block for a LinkedArrayList.
	 */
	private static class Node<E>
	{
	    /**
	     * The data value.
	     */
		private E[] array;
		/**
		 * The number of used elements in the array.
		 */
		private int used = 0;
	    /**
	     * The link to the previous node.
	     */
		private Node<E> next = null;
	    /**
	     * The link to the previous node.
	     */
		private Node<E> prev = null;


		/**
		 * Constructor
		 * @param newElement
		 * @param newNext
		 * @param newPrev
		 */
		private Node(E newElement, Node<E> newNext, Node<E> newPrev)
		{
			array = (E[])new Object[NODE_INITIAL_CAPACITY];
			array[0] = newElement;

			this.next = newNext;
			this.prev = newPrev;
			++used;
		}

		/**
		 * Returns the element in the array according to the given index.
		 * @param a
		 * @return array
		 */
		private E getArray(int a)
		{
			return array[a];
		}

		/**
		 * @return the used
		 */
		public int getUsed()
		{
			return used;
		}

	}



	/**
	 * Inner class to implement the ListIterator interface.
	 */
	private class MyIterator implements ListIterator<E>
	{
		/** 
		 * A reference to the next node.
		 */
		private Node<E> nextNode;
		/** 
		 * A reference to the last node returned.
		 */
		private Node<E> lastNodeReturned;
		/**
		 * The index of the current node.
		 */
		private int index = 0;


		/**
		 * Constructor
		 * @param i
		 */
		public MyIterator(int i)
		{
			if(i<0 || i>totalSize)
				throw new IndexOutOfBoundsException("Invalid index " + i);

			// No item returned yet.
			lastNodeReturned = null;

			nextNode = head;
			for(index = 0 ; index < i ; ++index)
			{
				System.out.println("fcx");
				nextNode = nextNode.next;
			}
		}

		@Override
		public void add(E e)
		{
//			I didn't need to implement these method.
		}

		/**
		 * Indicate whether movement forward is defined.
		 */
		@Override
		public boolean hasNext()
		{
			return nextNode != null;
		}

		/**
		 * Indicate whether movement backward is defined.
		 */
		@Override
		public boolean hasPrevious()
		{
			return (nextNode == null && totalSize != 0) || nextNode.prev != null;
		}

		/**
		 * Move the iterator forward and return the next nodes first element.
		 */
		@Override
		public E next()
		{
			if (!hasNext()){
				throw new NoSuchElementException();
			}
			lastNodeReturned = nextNode;
			nextNode = nextNode.next;
			index++;
			return lastNodeReturned.getArray(0);
		}

		/**
		 * Return the index of the next node to be returned by next
		 */
		@Override
		public int nextIndex()
		{
			return index;
		}

		/**
		 * Move the iterator backward and return the previous nodes first element.
		 */
		@Override
		public E previous()
		{
			if (!hasPrevious())
				throw new NoSuchElementException();

			if (nextNode == null)// Iterator past the last element
				nextNode = tail;

			else
				nextNode = nextNode.prev;

			lastNodeReturned = nextNode;
			index--;

			return lastNodeReturned.getArray(0);
		}

		/**
		 * Return the index of the next node to be returned by previous.
		 */
		@Override
		public int previousIndex()
		{
			return index-1;
		}

		@Override
		public void remove()
		{
			//I didn't need to implement these method.
		}

		@Override
		public void set(E e)
		{
			//I didn't need to implement these method.
		}
	}

}
