import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * FileSystemTree class
 *
 * @author Esra Eryılmaz
 * @since 2020-04-26
 */

public class FileSystemTree
{
	/**
	 * The root of the file system tree
	 */
	private FileNode root;


	/**
	 * No parameter constructor
	 */
	public FileSystemTree()
	{
		this.root = new FileNode("root");
		this.root.type = FileNode.nodeType.DIRECTORY;
	}

	/**
	 * Constructor
	 * @param name
	 */
	public FileSystemTree(String name)
	{
		this.root = new FileNode(name);
		this.root.type = FileNode.nodeType.DIRECTORY;
	}

	/**
	 * To add directory to the file system.The path of the new directory will be given as a parameter.
	 * (Using Level Order Traversal)
	 * @param newDir
	 */
	public void addDir(String newDir)
	{
		String[] path = newDir.split("/");	//Split path into the string array
		int pathSize = path.length-2;
		int k=0;
		FileNode p = root;

		Queue<FileNode> q = new LinkedList<>(); // Create a queue
		q.add(root);

		while (!q.isEmpty())
		{
			int n = q.size();
			
			// If this node has children
			while (n > 0)
			{
				p = q.peek();

				if(k==pathSize && p.type==FileNode.nodeType.DIRECTORY)	//It adds if it is in the right node.
				{
					if(p.data.equals(path[k]))
					{
						p.addChildDir(path[pathSize+1]);
						break;
					}
				}
				q.remove();

				for (int i=0 ; i<p.children.size() ; ++i) 
					q.add(p.children.get(i));

				n--;
			}
			k++;
		}
	}


	/**
	 * To add file to the file system.The path of the new file will be given as a parameter.
	 * (Using Level Order Traversal)
	 * @param newFile
	 */
	public void addFile(String newFile)
	{
		String[] path = newFile.split("/");	//Split path into the string array
		int pathSize = path.length-2;
		int k=0;
		FileNode p = root;

		Queue<FileNode> q = new LinkedList<>(); // Create a queue
		q.add(root);

		while (!q.isEmpty())
		{
			int n = q.size();

			// If this node has children
			while (n > 0)
			{
				p = q.peek();

				if(pathSize==k && p.type==FileNode.nodeType.DIRECTORY)	//It adds if it is in the right node.
				{
					if(p.data.equals(path[k]))
					{
						p.addChildFile(path[pathSize+1]);
						break;
					}
				}
				q.remove();

				for (int i=0 ; i<p.children.size() ; ++i)
					q.add(p.children.get(i));

				n--;
			}
			k++;
		}
	}

	/**
	 * To remove a directory or a file from the file system. The path of the directory or the file will be given as a parameter.
	 * (Using Level Order Traversal)
	 * @param delPath
	 */
	public void remove(String delPath)
	{
		String[] path = delPath.split("/");	//Split path into the string array
		int pathSize = path.length-2;
		int temp=-1;
		int k=0;

		FileNode p = root;

		Queue<FileNode> q = new LinkedList<>(); // Create a queue
		q.add(root);

		while (!q.isEmpty())
		{
			int n = q.size();

			// If this node has children
			while (n > 0)
			{
				p = q.peek();

				if(pathSize==k && p.type==FileNode.nodeType.DIRECTORY)	//It removes if it is in the right node.
				{
					if(p.data.equals(path[k]))
					{
						for(int i=0 ; i<p.children.size() ; ++i)
						{
							if(p.children.get(i).data.equals(path[k+1]))
							{
								temp = 1;
								if(p.children.get(i).children.size() != 0)
								{
									System.out.println("Directory has child. Do you want to delete it?\n YES>1\n NO>0");
									Scanner sc = new Scanner(System.in); // object for scanner
									int res = sc.nextInt();

									if(res == 1) {
										p.removeChild(i);
										break;
									}
									else
										break;
								}
								else
									p.removeChild(i);
								break;
							}
						}
					}
				}
				q.remove();

				for (int i=0 ; i<p.children.size() ; ++i)
					q.add(p.children.get(i));

				n--;
			}
			k++;
		}
		if(temp != 1)		//If it did not remove
			System.out.println("PATH CANNOT BE FOUND!!");
	}

	/**
	 * 
	 * @param chars
	 */
	public void search(String chars)
	{

	}



	/**
	 * Prints the general tree (Level Order Traversal)
	 */
	public void printFileSystem()
	{
		System.out.println("[PRINT]");
		if(root == null)
			return;

		// Standard level order traversal code
		Queue<FileNode> q = new LinkedList<>(); // Create a queue
		q.add(root); // Enqueue root
		while (!q.isEmpty())
		{
			int n = q.size();

			// If this node has children
			while (n > 0)
			{
				// Dequeue an item from queue and print it.
				FileNode p = q.peek();
				q.remove();
				System.out.print(p.data + " ");

				// Enqueue all children of the dequeued item
				for (int i = 0; i < p.children.size(); i++)
					q.add(p.children.get(i));
				n--;
			}
			System.out.println();
		}
		System.out.println();
	}



	/**
	 * File Node Class to encapsulate a tree node.
	 *
	 */
	protected static class FileNode
	{
		/**
		 * The data value.
		 */
		private String data = null;

		/**
		 * The arraylist that holds the children of the node.
		 */
		private ArrayList<FileNode> children = new ArrayList<FileNode>();

		/**
		 * Instance that holds whether the node is a file or a directory.
		 */
		private nodeType type;


		/**
		 * Enum node type
		 */
		public enum nodeType{
			FILE,
			DIRECTORY
		}


		/**
		 * Constructor
		 * @param newData
		 */
		public FileNode(String newData)
		{
			this.data = newData;
		}

		/**
		 * Adds directory children to the directory node.
		 * @param newData
		 */
		public void addChildDir(String newData)
		{
			FileNode newChild = new FileNode(newData);
			newChild.type = nodeType.DIRECTORY;
			this.children.add(newChild);
		}

		/**
		 * Adds file children to the directory node.
		 * @param newData
		 */
		public void addChildFile(String newData)
		{
			FileNode newChild = new FileNode(newData);
			newChild.type = nodeType.FILE;
			this.children.add(newChild);
		}

		/**
		 * Removes child from arraylist
		 * @param delSize
		 */
		public void removeChild(int delSize)
		{
			this.children.remove(delSize);
		}

		/**
		 * It returns true if node's left and right child is null.
		 * @return
		 */
		public boolean isLeaf()
		{
			return this.children.size() == 0;
		}

	}

}
