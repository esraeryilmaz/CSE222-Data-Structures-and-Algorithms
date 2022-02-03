/**
 * Main class  (Driver file)
 *
 * @author Esra Eryılmaz
 * @since 2020-04-12
 */

public class Main
{

	public static void main(String[] args)
	{
		System.out.println("\n\t\tTEST STARTING...");
		System.out.println("--------------------------------------------------------------");

		try
		{
			RecursiveFunctions obj = new RecursiveFunctions();

			System.out.println("\n...PROBLEM 1...");
			String input = "this function writes the sentence in reverse";
			System.out.println("Given input :\t\"this function writes the sentence in reverse\"");
			System.out.print("Output :\t");
			obj.reverseString(input);


			System.out.println("\n...PROBLEM 2...");
			System.out.println("Is whiteleaf elfish?\t" + obj.isElfishWord("whiteleaf"));
			System.out.println("Is stayhome elfish?\t" + obj.isElfishWord("stayhome"));
			System.out.println("Is unfriendly elfish?\t" + obj.isElfishWord("unfriendly"));
			System.out.println("Is television elfish?\t" + obj.isElfishWord("television"));


			System.out.println("\n...PROBLEM 3...");
			int[] arr = {4, 2, 5, 1, 7};
			obj.selectionSort(arr, arr.length, 0);
			System.out.println("Unsorted array :   4 2 5 1 7");
			System.out.print("Sorted array   :   ");
			//printing sorted array
			for(int temp : arr)
				System.out.print(temp + " ");


			System.out.println("\n\n...PROBLEM 4...");
			String prefix = " + 9 * 20 6";	//result 129
			System.out.println("Prefix expression :  + 9 * 20 6");
			System.out.println("Evaluate prefix  :\t" + obj.evaluatePrefix(prefix, prefix.lastIndexOf(" ")));


			System.out.println("\n...PROBLEM 5...");
			String postfix = "4 50 7 20 + - * ";	//result 92
			System.out.println("Postfix expression : 4 50 7 20 + - * ");
			System.out.println("Evaluate postfix  :\t" + obj.evaluatePostfix(postfix,postfix.indexOf(" ")));


			System.out.println("\n...PROBLEM 6...");
			System.out.println("Input:\n\t1  2  3  4 \n\t5  6  7  8 \n\t9  10 11 12 \n\t13 14 15 16 \n\t17 18 19 20");
			System.out.println("Output:");
			int[][] matrix = {	{1, 2, 3, 4},
								{5, 6, 7, 8},
								{9, 10, 11, 12},
								{13, 14, 15, 16},
								{17, 18, 19, 20}
							  };

			obj.printSpiral(matrix, 5, 4, 0, 0);

		}
		catch(Exception e)
		{
			System.out.print(e);
		}

		System.out.println("\n\n--------------------------------------------------------------");
		System.out.println("\t\tTEST FINISHED...\n\n");

	}


}
