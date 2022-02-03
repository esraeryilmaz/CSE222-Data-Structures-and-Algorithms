import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * MazeSolver class
 *
 * @author Esra Eryılmaz
 * @since 2020-06-19
 */


public class MazeSolver
{
	private LinkedList<Edge>[] adj;
	private int[][] maze;
	private int row=0;		//total row
	private int column=0;	//total column
	private int vertex=0;	//total vertex number
	private VertexPoints[] v;


	public static class VertexPoints
	{
		private int vertNumb=0;
		private int x=0;
		private int y=0;

		/**
		 * @param vertex
		 * @param x
		 * @param y
		 */
		public VertexPoints(int vertex, int x, int y) {
			this.vertNumb = vertex;
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "VertexPoints [vertNumb=" + vertNumb + ", x=" + x + ", y=" + y + "]";
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			VertexPoints other = (VertexPoints) obj;
			if (vertNumb != other.vertNumb)
				return false;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}

	}


	/**
	 * It creates 2D maze array.
	 * @param filename
	 * @throws IOException
	 */
	public void readMaze(String filename) throws IOException
	{
		File file = new File(filename);
		Scanner scanner = new Scanner(file);
		String arr = new String();

		while (scanner.hasNextLine()) {
			row++;
			column = scanner.nextLine().length();
		}
		scanner.close();

		maze = new int[row][column];
		System.out.println("Row : " + row + "\nColumn : " + column);

		scanner = new Scanner(file);
		for(int i=0 ; i<row ; ++i)
		{
			arr = scanner.nextLine();
			for(int j=0 ; j<column ; ++j)
			{
				char ch = arr.charAt(j);
				maze[i][j] = Character.getNumericValue(ch);
			}
		}
		scanner.close();

		createAdj();
	}

	/**
	 * It finds vertex points.
	 */
	public void createAdj()
	{
		//FIND HOW MANY VERTEX
		for(int i=0 ; i<row ; ++i)
		{
			for(int j=0 ; j<column ;++j)
			{
				if(maze[i][j] == 0)
				{
					if(i==0 && j==0)
						++vertex;
					else if(i==row-1 && j== column-1)
						++vertex;
					else if(isVertex(i,j))
						++vertex;
				}
			}
		}

		v = new VertexPoints[vertex];

		int temp=0;
		for(int i=0 ; i<row ; ++i)
		{
			for(int j=0 ; j<column ;++j)
			{
				if(maze[i][j] == 0)
				{
					if(i==0 && j==0)
					{
						v[temp] = new VertexPoints(temp, i, j);
						++temp;
					}

					else if(i==row-1 && j== column-1)
					{
						v[temp] = new VertexPoints(temp, i, j);
						++temp;
					}

					else if(isVertex(i,j))
					{
						v[temp] = new VertexPoints(temp, i, j);
						++temp;
					}
				}
			}
		}

		adj = new LinkedList[vertex];
		System.out.println("How many vertices does it have? : " + vertex);

	}

	public VertexPoints findVertex(int x , int y)
	{
		for(int i=0 ; i<v.length ; ++i)
		{
			if(v[i].x == x && v[i].y == y)
				return v[i];
		}
		return null;
	}

	public boolean isVertex(int i, int j)
	{
		if(haveUp(i, j) && haveDown(i, j) && haveLeft(i, j) && haveRight(i, j))
			return true;
		else if(haveLeft(i, j) && haveDown(i, j) && haveRight(i, j))
			return true;
		else if(haveUp(i, j) && haveRight(i, j) && haveDown(i, j))
			return true;
		else if(haveLeft(i, j) && haveUp(i, j) && haveRight(i, j))
			return true;
		else if(haveUp(i, j) && haveLeft(i, j) && haveDown(i, j))
			return true;
		else if(deadEnd(i,j))
			return true;

		return false;
	}

	public boolean deadEnd(int i, int j)
	{
		if(!haveLeft(i, j) && !haveDown(i, j) && !haveRight(i, j))
			return true;
		else if(!haveUp(i, j) && !haveRight(i, j) && !haveDown(i, j))
			return true;
		else if(!haveLeft(i, j) && !haveUp(i, j) && !haveRight(i, j))
			return true;
		else if(!haveUp(i, j) && !haveLeft(i, j) && !haveDown(i, j))
			return true;

		return false;
	}
	
	public boolean haveUp(int i, int j)
	{
		if(i != 0)
		{
			if(maze[i][j] == maze[i-1][j])
				return true;
		}
		return false;		
	}

	public boolean haveDown(int i, int j)
	{
		if(i != row-1)
		{
			if(maze[i][j] == maze[i+1][j])
				return true;
		}
		return false;		
	}

	public boolean haveLeft(int i, int j)
	{
		if(j != 0)
		{
			if(maze[i][j] == maze[i][j-1])
				return true;
		}
		return false;
	}

	public boolean haveRight(int i, int j)
	{
		if(j != column-1)
		{
			if(maze[i][j] == maze[i][j+1])
				return true;
		}
		return false;
	}

}
