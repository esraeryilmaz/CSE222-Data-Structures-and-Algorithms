/**
 * Main	(Driver File)
 *
 * @author Esra Eryılmaz
 * @since 2020-03-01
 */

import java.util.ArrayList;
import java.security.InvalidParameterException;

public class Driver
{
	/**
	 * Prints the users with their informations
	 * @param user
	 */
	public static void print(ArrayList<Users>user)
	{
		for (Users u : user)
			u.printUser();	//polymorphic call
	}


	public static void main(String[] args)
	{
		ArrayList<Users> usersTest = new ArrayList<Users>();

		System.out.printf("\t\tTEST STARTING...\n\n");
		System.out.printf("---------------------------------------------------------------------------------------------------------\n");
		System.out.printf("\tADMINISTRATOR CLASS TEST STARTING...\n\n");

		try
		{
			System.out.println("****Created administrator & administrator adds five branchs ,three employees and two personnel****\n");
			Branch firstBranch = new Branch("ANKARA");

			//creating administrator object
			Administrator adminTest = new Administrator(firstBranch,Users.UserType.ADMINISTRATOR,"Esra Eryilmaz","123456");

			//administrator adds branchs at the end of the ArrayList
			adminTest.addBranch(firstBranch);
			adminTest.addBranch(new Branch("ISTANBUL"));
			adminTest.addBranch(new Branch("KOCAELI"));
			adminTest.addBranch(new Branch("IZMIR"));
			adminTest.addBranch(new Branch("AMASYA"));

			//administrator adds three new branch employees
			BranchEmployee emp1 = adminTest.addEmployee(new BranchEmployee(adminTest.getBranchs().get(1),Users.UserType.BRANCH_EMPLOYEE,"Ahmet Demir","111111"));
			BranchEmployee emp2 = adminTest.addEmployee(new BranchEmployee(adminTest.getBranchs().get(2),Users.UserType.BRANCH_EMPLOYEE,"Mehmet Sahin","000000"));
			BranchEmployee emp3 = adminTest.addEmployee(new BranchEmployee(adminTest.getBranchs().get(4),Users.UserType.BRANCH_EMPLOYEE,"Fatma Kaya","abc123"));

			//administrator adds two new transportation personnel
			TransportationPersonnel per1 = adminTest.addPersonnel(new TransportationPersonnel(adminTest.getBranchs().get(3),Users.UserType.TRANSPORTATION_PERSONNEL,"Ayse Yildirim","135790"));
			TransportationPersonnel per2 = adminTest.addPersonnel(new TransportationPersonnel(adminTest.getBranchs().get(4),Users.UserType.TRANSPORTATION_PERSONNEL,"Mustafa Kara","010101"));

			//adding objects to the usersTest ,for testing polymorphic call
			usersTest.add(adminTest);
			usersTest.add(emp1);
			usersTest.add(emp2);
			usersTest.add(emp3);
			usersTest.add(per1);
			usersTest.add(per2);

			print(usersTest);		//calling static function

			System.out.println("\n\n****Administrator removes fifth branch ,second employee and second personnel****\n");

			//removing branch
			adminTest.removeBranch(adminTest.getBranchs().get(4));

			//administrator removes one of the branch employee
			adminTest.removeEmployee(emp2);

			//administrator removes one of the transportation personnel
			adminTest.removePersonnel(per2);

			print(usersTest);

			System.out.printf("\n\n---------------------------------------------------------------------------------------------------------\n");
			System.out.printf("\tBRANCHEMPLOYEE CLASS TEST STARTING...\n\n");

			System.out.println("****First branch employee adds two customers and two shipments****\n");
			//Branch Employee adds two new customers in his branch
			Customer cus1 = emp1.addCustomer(new Customer(emp1.branch,Users.UserType.CUSTOMER,"Ali Yilmaz","000111"));
			cus1.printUser();
			Customer cus2 = emp1.addCustomer(new Customer(emp1.branch,Users.UserType.CUSTOMER,"Emine Aslan","abcdef"));
			cus2.printUser();

			//Branch Employee adds two new cargo sent from his branch
			Shipment cargo1 = emp1.addShipment(new Shipment("45322567","Ali Yilmaz","Meryem Yildiz",firstBranch,emp1.branch));
			cargo1.printInformation(cargo1.getTrackingNumber());
			Shipment cargo2 = emp1.addShipment(new Shipment("54327924","Emine Aslan", "Ismail Kilic",firstBranch,emp1.branch));
			cargo2.printInformation(cargo2.getTrackingNumber());

			System.out.println("\n\n****First branch employee removes second customer and second cargo****\n");
			//branch employee removes one of the customer
			emp1.removeCustomer(cus2);
			cus1.printUser();
			cus2.printUser();

			//branch employee removes one of the cargo
			emp1.removeShipment(cargo2);
			cargo1.printInformation(cargo1.getTrackingNumber());
			cargo2.printInformation(cargo2.getTrackingNumber());

			System.out.println("\n\n****First branch employee updates first cargo's current status****\n");

			//branch employee updates when package arrives at that branch
			emp1.packageArrives(cargo1);
			cargo1.printInformation(cargo1.getTrackingNumber());

			//branch employee updates when package leaves at that branch
			emp1.packageLeaves(cargo1,firstBranch);
			cargo1.printInformation(cargo1.getTrackingNumber());

			System.out.printf("\n\n---------------------------------------------------------------------------------------------------------\n");
			System.out.printf("\tTRANSPORTATIONPERSONNEL CLASS TEST STARTING...\n\n");

			System.out.println("****First transportation personnel delivered first cargo****\n");

			//transportation personnel makes the update when cargo is delivered
			per1.updateDeliveredCargo(cargo1);
			cargo1.printInformation(cargo1.getTrackingNumber());

			System.out.printf("\n\n---------------------------------------------------------------------------------------------------------\n");
			System.out.printf("\tCUSTOMER CLASS TEST STARTING...\n\n");

			System.out.println("****First customer entered TrackingNumber and see the first cargo information****\n");

			//customers can see the cargo information if they enter the tracking number
			cus1.cargoInformation(cargo1.getTrackingNumber(),cargo1);

			System.out.printf("\n---------------------------------------------------------------------------------------------------------\n");
		}

		catch(NullPointerException e)
		{
			System.out.println("NullPointerException Caught");
		}
		catch(InvalidParameterException e)
		{
			System.out.println(e.getMessage());
		}

	}

}
