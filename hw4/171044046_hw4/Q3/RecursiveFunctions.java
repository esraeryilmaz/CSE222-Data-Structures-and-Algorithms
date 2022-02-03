import java.util.Stack;

/**
 * RecursiveFunctions class
 *
 * @author Esra Eryılmaz
 * @since 2020-04-12
 */

public class RecursiveFunctions
{

/****************	Q1	****************/

	/**
	 * Reversing a string function
	 * @param input
	 */
	public void reverseString(String input)
	{
		if((input==null) || (input.indexOf(" ") == -1) )
			System.out.println(input);
		else
		{
			System.out.print(input.substring(input.lastIndexOf(" ")+1 ,input.length()) + " ");
			reverseString(input.substring(0,input.lastIndexOf(" ")));
		}
	}

/****************	Q2	****************/

	/**
	 * To call recursive function and determining elfish word.
	 * @param word
	 * @return bool
	 */
	public boolean isElfishWord(String word)
	{
		if(controlElfish("elf", word, 0) == 3)
			return true;
		else
			return false;
	}

	/**
	 * Function determines whether a word is elfish or not.
	 * @param control
	 * @param word
	 * @param num
	 * @return int
	 */
	public int controlElfish(String control, String word, int num)
	{
		if(control.length() < 1)
			return 0;

		if(word.contains(control.substring(0, 1)))
			num = 1;

		return num + controlElfish(control.substring(1), word, 0);
	}

/****************	Q3	****************/

	/**
	 * Sorting an array of elements using selection sort algorithm with recursion.
	 * @param arr
	 * @param size
	 * @param index
	 */
	public void selectionSort(int[] arr, int size, int index)
	{
		if (index == size)
			return;

		// calling minimum index function to find minimum index
		int minIndex = findMinIndex(arr, size-1, index);

		// Swapping when index nd minimum index are not same
		if (minIndex != index)
		{
			swap(arr, minIndex, index);
		}
		// Recursive call
		selectionSort(arr, size, index + 1);
	}

	/**
	 * Helper recursive function
	 * @param arr
	 * @param size
	 * @param index
	 * @return int
	 */
	public int findMinIndex(int[] arr, int size, int index) 
	{ 
		if (index == size)
			return index;

		// Find minimum of remaining elements
		int min = findMinIndex(arr, size , index+1);

		// Return minimum of current and remaining.
		return (arr[index] < arr[min])? index : min;
	}

	/**
	 * Helper swap function
	 * @param arr
	 * @param i
	 * @param j
	 */
	public void swap(int[] arr, int i, int j)
	{
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}


/****************	Q4	****************/

	/**
	 * Data Field for evaluate prefix
	 */
	private Stack<Integer> stack1 = new Stack<>();

	/**
	 * Evaluating a Prefix expression with recursion.
	 * @param exp
	 * @param i
	 * @return int
	 */
	public int evaluatePrefix(String exp, int i)
	{
		// At this point, the stack have only one element and that is result
		if(exp.indexOf(" ") == -1)
			return stack1.pop();

		else
		{
			// if current char is an operand, push it to the stack
			if(exp.length() - i>=1 && Character.isDigit(exp.charAt(i+1)))
				stack1.push(Integer.parseInt(exp.substring(i+1)));

			else
			{
				// Operator encountered
				// Pop two elements from Stack
				int x = stack1.pop();
				int y = stack1.pop();

				// evaluate the expression, and push back to the stack
				switch (exp.charAt(i+1))
				{ 
					case '+':
						stack1.push(x + y);
						break;
					case '-':
						stack1.push(x - y);
						break;
					case '*':
						stack1.push(x * y);
						break;
					case '/':
						stack1.push(x / y);
						break;
					default:
						throw new RuntimeException("Illegal operator ");
				}
			}

			exp = exp.substring(0, exp.lastIndexOf(" "));

			return evaluatePrefix(exp, exp.lastIndexOf(" "));
		}
	}

/****************	Q5	****************/

	/**
	 * Data Field for evaluate postfix
	 */
	private Stack<Integer> stack2 = new Stack<>();

	/**
	 * Evaluating a Postfix expression with recursion.
	 * @param exp
	 * @param i
	 * @return int
	 */
	public int evaluatePostfix(String exp, int i)
	{
		// At this point, the stack have only one element and that is result
		if(exp.indexOf(" ") == -1)
			return stack2.pop();

		else
		{
			// if current char is an operand, push it to the stack
			if(i>=1 && Character.isDigit(exp.charAt(0)))
				stack2.push(Integer.parseInt(exp.substring(0, i)));

			// if current char is an operator
			else
			{
				// pop top two elements from the stack
				int x = stack2.pop();

				int y = stack2.pop();

				// evaluate the expression, and push back to the stack
				switch (exp.charAt(0))
				{ 
					case '+':
						stack2.push(y + x);
						break;
					case '-':
						stack2.push(y - x);
						break;
					case '*':
						stack2.push(y * x);
						break;
					case '/':
						stack2.push(y / x);
						break;
					default:
						throw new RuntimeException("Illegal operator ");
				}
			}
			exp = exp.substring(exp.indexOf(" ")+1);

			return evaluatePostfix(exp, exp.indexOf(" "));
		}

	}

/****************	Q6	****************/

	/**
	 * Helper function
	 */
	public void printTop(int[][] arr,int column,int r,int c)
	{
		// Print the first row from the remaining rows
		for (int i = c; i < column; ++i)
			System.out.print(arr[r][i] + " ");
	}
	/**
	 * Helper function
	 */
	public void printRight(int[][] arr,int row,int column,int r)
	{
		// Print the last column from the remaining columns
		for (int i = r; i < row; ++i)
			System.out.print(arr[i][column - 1] + " ");
	}
	/**
	 * Helper function
	 */
	public void printBottom(int[][] arr,int row,int column,int c)
	{
		for (int i = column - 1; i >= c; --i)
			System.out.print(arr[row - 1][i] + " ");
	}
	/**
	 * Helper function
	 */
	public void printLeft(int[][] arr,int row,int r,int c)
	{
		for (int i = row - 1; i >= r; --i)
			System.out.print(arr[i][c] + " ");
	}


	/**
	 * Printing the elements of an array in spiral form.
	 */
	public void printSpiral(int[][] arr, int row, int column, int r, int c)
	{
		if(r==row+1)
			return ;

		else
		{
			printTop(arr,column,r,c);
			++r;

			printRight(arr,row,column,r);
			--column;

			// Print the last row from the remaining rows
			if (r < row)
			{
				printBottom(arr,row,column,c);
				--row;
			}

			// Print the first column from the remaining columns
			if (c < column)
			{
				printLeft(arr,row,r,c);
				++c;
			}

			printSpiral(arr, row, column, r, c);
		}
	}
}
