/**
 * Main class  (Driver file)
 *
 * @author Esra Eryılmaz
 * @since 2020-06-19
 */


public class Main
{

	public static void main(String[] args)
	{
		try
		{
			MazeSolver test = new MazeSolver();
			test.readMaze("input.txt");
		}
		catch(Exception e)
		{
			System.out.println("ERROR");
		}


	}

}
