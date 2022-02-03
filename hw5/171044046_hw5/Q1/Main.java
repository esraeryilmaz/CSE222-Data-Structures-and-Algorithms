/**
 * Main class  (Driver file)
 *
 * @author Esra Eryılmaz
 * @since 2020-04-26
 */

public class Main
{
	public static void main(String[] args)
	{
		System.out.printf("\n\t\tTEST STARTING...\n");
		System.out.printf("---------------------------------------------\n");


		//Create a file system with root directory
		FileSystemTree test = new FileSystemTree("root");

		//Add directories and files using paths

		test.addDir("root/first_directory");
		System.out.println("> addDir(\"root/first_directory\")");
		test.printFileSystem();

		test.addDir("root/second_directory");
		System.out.println("> addDir(\"root/second_directory\")");
		test.printFileSystem();

		test.addFile("root/first_directory/new_file.txt");
		System.out.println("> addFile(\"root/first_directory/new_file.txt\")");
		test.printFileSystem();

		test.addDir("root/second_directory/new_directory");
		System.out.println("> addDir(\"root/second_directory/new_directory\")");
		test.printFileSystem();

		test.addFile("root/second_directory/new_directory/new_file.doc");
		System.out.println("> addFile(\"root/second_directory/new_directory/new_file.doc\")");
		test.printFileSystem();

//		test.search("new");

		System.out.println("> remove(\"root/first_directory/new_file.txt\")");
		test.remove("root/first_directory/new_file.txt");
		test.printFileSystem();

		System.out.println("> remove(\"root/second_directory/new_directory\")");
		test.remove("root/second_directory/new_directory");
		test.printFileSystem();

		System.out.printf("---------------------------------------------\n");
		System.out.printf("\t\tTEST FINISHED...\n\n\n");
	}

}
