import java.io.BufferedReader;

/**
 * Main class  (Driver file)
 *
 * @author Esra Eryılmaz
 * @since 2020-04-30
 */

public class Main
{

	public static void main(String[] args)
	{
		System.out.printf("\n\t\tTEST STARTING...\n");
		System.out.printf("---------------------------------------\n");

		//Create a tree for preorder expression
		ExpressionTree<String> testPrefix = new ExpressionTree<String>("+ + 10 * 5 15 20");
		ExpressionTree<String> testPrefix2 = new ExpressionTree<String>("+ 9 * 2 6");

		//Create a tree for postorder expression
		ExpressionTree<String> testPostfix = new ExpressionTree<String>("10 5 15 * + 20 +");
		ExpressionTree<String> testPostfix2 = new ExpressionTree<String>("9 2 6 * +");

		//Evaluate expressions
		int resPre = testPrefix.eval(testPrefix.getRoot());
		int resPre2 = testPrefix2.eval(testPrefix2.getRoot());
		int resPost = testPostfix.eval(testPostfix.getRoot());
		int resPost2 = testPostfix2.eval(testPostfix2.getRoot());


		System.out.println("\t[PREFIX TEST]\n");

		System.out.println("Prefix exp =  + + 10 * 5 15 20");
		System.out.println("eval() =  " + resPre);
		System.out.printf("toString2() =  ");
		testPrefix.toString2();


		System.out.println("\n\nPrefix exp =  + 9 * 2 6");
		System.out.println("eval() =  " + resPre2);
		System.out.printf("toString2() =  ");
		testPrefix2.toString2();

		System.out.printf("\n\n---------------------------------------\n\n");

		System.out.println("\t[POSTFIX]\n");
		System.out.println("Postfix exp =  10 5 15 * + 20 +");
		System.out.println("eval() =  " + resPost);
		System.out.printf("toString2() =  ");
		testPostfix.toString2();

		System.out.println("\n\nPostfix exp =  9 2 6 * +");
		System.out.println("eval() =  " + resPost2);
		System.out.printf("toString2() =  ");
		testPostfix2.toString2();


		System.out.printf("\n---------------------------------------\n");
		System.out.printf("\t\tTEST FINISHED...\n\n\n");
	}

}
