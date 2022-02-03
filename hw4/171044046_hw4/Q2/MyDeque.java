import java.util.AbstractCollection;
import java.util.Deque;
import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * Class MyDeque
 * (Implementation of Deque using singly linked list)
 * @author Esra Eryılmaz
 * @param <E>generic
 *
 */

public class MyDeque<E> extends AbstractCollection<E> implements Deque<E>
{
	// Data Fields
	/**
	 * Total number of nodes.
	 */
	private int size;

	/**
	 * Total number of nodes deleted and not reused.
	 */
	private int deletedSize;

	/**
	 * A reference to the head of the singly list.(Also we can say "front")
	 */
	private Node<E> head;

	/**
	 * A reference to the head of the removed elements.(Also we can say "front")
	 */
	private Node<E> deletedHead;


	/**
	 * No parameter constructor
	 */
	public MyDeque()
	{
		this.size = 0;
		this.deletedSize = 0;
		this.head = null;
		this.deletedHead = null;
	}

	/**
	 * This method is equivalent to addLast(E).
	 * @param newData
	 * @return bool
	 */
	@Override
	public boolean add(E newData)
	{
		addLast(newData);
		return true;
	}

	/**
	 * Inserts the specified element at the front of the deque.
	 * If there is a deleted node, it will use that node first.
	 * @param newData
	 */
	@Override
	public void addFirst(E newData)
	{
		if(deletedHead == null)
		{
			head = new Node<E>(newData,head);
			++size;
		}
		else
		{
			deletedHead.data = newData;
			Node<E>temp = deletedHead.next;
			deletedHead.next = head;
			head = deletedHead;
			deletedHead = temp;

			++size;
			--deletedSize;
		}
	}

	/**
	 * Inserts the specified element at the end(rear) of the deque.
	 * If there is a deleted node, it will use that node first.
	 * @param newData
	 */
	@Override
	public void addLast(E newData)
	{
		if(deletedHead == null)
		{
			if(size == 0)
				head = new Node<E>(newData,null);
			else
			{
				Node<E> tempLast = head;
				while(tempLast.next != null)
					tempLast = tempLast.next;

				tempLast.next = new Node<E>(newData,null);
			}

			++size;
		}
		else
		{
			Node<E>tempDelHead = deletedHead.next;

			if(size == 0)
			{
				deletedHead.data = newData;
				deletedHead.next = null;
				head = deletedHead;
				deletedHead = tempDelHead;
			}
			else
			{
				Node<E> tempLast = head;
				while(tempLast.next != null)
					tempLast = tempLast.next;

				deletedHead.data = newData;	//Assigning new data to the old data of the deleted node
				tempLast.next = deletedHead;
				deletedHead.next = null;
				deletedHead = tempDelHead;
			}
			++size;
			--deletedSize;
		}
	}

	/**
	 * This method is equivalent to getFirst().
	 * @return generic data
	 */
	@Override
	public E element()
	{
		return getFirst();
	}

	/**
	 * This method returns the head of the Deque. And throws an exception when the Deque is empty.
	 * @return generic data
	 */
	@Override
	public E getFirst()
	{
		if(size == 0)
			throw new NoSuchElementException();

		return head.data;
	}

	/**
	 * This method returns the end(rear) of the Deque without removing it.
	 * And throws an exception when the Deque is empty.
	 * @return generic data
	 */
	@Override
	public E getLast()
	{
		Node<E>temp = head;

		while(temp.next != null)
			temp = temp.next;

		return temp.data;
	}

	/**
	 * This method is equivalent to offerLast(E).
	 * @param newData
	 * @return bool
	 */
	@Override
	public boolean offer(E newData)
	{
		return offerLast(newData);
	}

	/**
	 * Inserts data at the front of the deque.Returns true if successful; throws exception if the data could not be inserted.
	 * @param newData
	 * @return bool
	 */
	@Override
	public boolean offerFirst(E newData)
	{
		if(newData == null)
			throw new NullPointerException();

		else
		{
			addFirst(newData);
			return true;
		}
	}

	/**
	 * Inserts data at the rear of the deque.Returns true if successful; throws exception if the data could not be inserted.
	 * @param newData
	 * @return bool
	 */
	@Override
	public boolean offerLast(E newData)
	{
		if(newData == null)
			throw new NullPointerException();

		else
		{
			addLast(newData);
			return true;
		}
	}

	/**
	 * This method is equivalent to peekFirst().
	 * @return generic data
	 */
	@Override
	public E peek()
	{
		return peekFirst();
	}

	/**
	 * Returns the data at the front of the deque without removing it; returns null if the deque is empty.
	 * @return generic data
	 */
	@Override
	public E peekFirst()
	{
		if(size == 0)
			return null;
		else
			return head.data;
	}

	/**
	 * Returns the data at the rear of the deque without removing it; returns null if the deque is empty.
	 * @return generic data
	 */
	@Override
	public E peekLast()
	{
		if(size == 0)
			return null;

		else
		{
			Node<E> temp = head;
			while(temp.next != null)
				temp = temp.next;

			return temp.data;
		}
	}

	/**
	 * This method is equivalent to pollFirst().
	 * @return generic data
	 */
	@Override
	public E poll()
	{
		return pollFirst();
	}

	/**
	 * Removes the data at the front of the deque and returns it; returns null if the deque is empty.
	 * @return generic data
	 */
	@Override
	public E pollFirst()
	{
		if(size == 0)
			return null;

		else
		{
			Node<E>tempHead = head.next;

			if(deletedSize == 0)
			{
				head.next = null;		//break connection between head and head.next
				deletedHead = head;		//connect to the deletedhead for reusing another time
				head = tempHead;		//update old head of deque
				++deletedSize;
				--size;

				return deletedHead.data;
			}
			else
			{
				Node<E>tempDel = deletedHead;
				while(tempDel.next != null)
					tempDel = tempDel.next;

				head.next = null;
				tempDel.next = head;
				head = tempHead;
				++deletedSize;
				--size;

				return tempDel.next.data;
			}
		}
	}

	/**
	 * Prints deleted linked list (for debugging)
	 */
	public void printDeleted()
	{
		System.out.print("[PRINT DELETED NODES: ");
		Node<E>t = deletedHead;
		while(t.next != null)
		{
			System.out.print(t.data + "  ");
			t = t.next;
		}
		System.out.println(t.data + "]\n");
	}

	/**
	 * Removes the data at the rear of the deque and returns it; returns null if the deque is empty.
	 * @return generic data
	 */
	@Override
	public E pollLast()
	{
		if(size == 0)
			return null;

		else
		{
			Node<E>tempHead = head;

			while(tempHead.next.next != null)
				tempHead = tempHead.next;

			Node<E>tempPrev = tempHead;
			tempHead = tempHead.next;

			if(deletedSize == 0)
			{
				deletedHead = tempHead;
				tempPrev.next = null;

				++deletedSize;
				--size;

				return deletedHead.data;
			}
			else
			{
				Node<E>tempDel = deletedHead;

				while(tempDel.next != null)
					tempDel = tempDel.next;

				tempDel.next = tempHead;
				tempPrev.next = null;
	 
				++deletedSize;
				--size;

				return tempHead.data;
			}
		}
	}

	/**
	 * Removes and returns the first element of this deque.
	 * This method is equivalent to removeFirst().
	 * @return generic data
	 */
	@Override
	public E pop()
	{
		return removeFirst();
	}

	/**
	 * Pushes a data at the head of this deque.
	 * This method is equivalent to addFirst(E).
	 * @param newData
	 */
	@Override
	public void push(E newData)
	{
		addFirst(newData);
	}

	/**
	 * This method is equivalent to removeFirst().
	 * @return generic data
	 */
	@Override
	public E remove()
	{
		return removeFirst();
	}

	/**
	 * Removes the data at the front of the deque and returns it if the deque is not empty.
	 * This method differs from pollFirst only in that it throws an exception if this deque is empty.
	 * @return generic data
	 */
	@Override
	public E removeFirst()
	{
		if(size == 0)
			throw new NoSuchElementException();
		else
			return pollFirst();
	}

	/**
	 * This function should not be done by Deque ADT so it throws exception
	 */
	@Override
	public boolean removeFirstOccurrence(Object arg0)
	{
		throw new UnsupportedOperationException();
	}

	/**
	 * Removes the data at the rear of the deque and returns it if the deque is not empty.
	 * This method differs from pollLast only in that it throws an exception if this deque is empty.
	 * @return generic data
	 */
	@Override
	public E removeLast()
	{
		if(size == 0)
			throw new NoSuchElementException();
		else
			return pollLast();
	}

	/**
	 * This function should not be done by Deque ADT so it throws exception
	 */
	@Override
	public boolean removeLastOccurrence(Object arg0)
	{
		throw new UnsupportedOperationException();
	}


	/**
	 * Returns the number of elements in this deque.
	 * @return int
	 */
	@Override
	public int size()
	{
		return size;
	}


	/**
	 * Returns an iterator over the elements in this deque in proper sequence.
	 * @return Iterator
	 */
	@Override
	public Iterator<E> iterator()
	{
		return new MyIterator(0);
	}

	/**
	 * Returns an iterator over the elements in this deque in reverse sequential order.
	 * @return Iterator
	 */
	@Override
	public Iterator<E> descendingIterator()
	{
		return new MyIterator(size);
	}

	/**
	 * This function should not be done by Deque ADT so it throws exception
	 */
	@Override
	public boolean contains(Object o)
	{
		throw new UnsupportedOperationException();
	}

	/**
	 * This function should not be done by Deque ADT so it throws exception
	 */
	@Override
	public boolean remove(Object o)
	{
		throw new UnsupportedOperationException();
	}



	/**
	 * Inner class
	 * A Node is the building block for a MyDeque.
	 */
	private static class Node<E>
	{
		/**
		 * The data value.
		 */
		private E data;

		/**
		 * The link to the previous node.
		 */
		private Node<E> next = null;

		/**
		 * Constructor
		 * @param newData
		 * @param newNext
		 */
		public Node(E newData, Node<E> newNext)
		{
			this.data = newData;
			this.next = newNext;
		}
	}



	/**
	 * Inner class to implement the Iterator interface.
	 */
	private class MyIterator implements Iterator<E>
	{
		/**
		 *	A reference to the next item.
		 */
		private Node<E> nextItem;
		/**
		 * A reference to the last item returned.
		 */
		private Node<E> lastItemReturned;
		/**
		 * The index of the current node.
		 */
		private int index = 0;


		/**
		 * No parameter constructor
		 */
		private MyIterator()
		{
			this(0);
		}

		/**
		 * Constructor
		 * @param index 
		 */
		private MyIterator(int index)
		{
			if(index < 0 || index > size)
				throw new IndexOutOfBoundsException("Invalid Index : " + index);

			lastItemReturned = null;
			nextItem = head;
			for(int i = 0 ; i < index ; ++i)
				nextItem = nextItem.next;

			this.index = index;
		}

		/**
		 * Indicate whether movement forward is defined.
		 * @return bool
		 */
		@Override
		public boolean hasNext()
		{
			return nextItem != null;
		}

		/**
		 * Returns the next element in the iteration.
		 * @return generic data
		 */
		@Override
		public E next()
		{
			if(!hasNext())
				throw new NoSuchElementException();
			lastItemReturned = nextItem;
			nextItem = nextItem.next;
			++index;

			return lastItemReturned.data;
		}

		/**
		 * This function should not be done by Deque ADT so it throws exception
		 */
		@Override
		public void remove()
		{
			throw new UnsupportedOperationException();
		}

	}

}
