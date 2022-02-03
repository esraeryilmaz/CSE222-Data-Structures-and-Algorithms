/**
 * Main class	(Driver File)
 *
 * @author Esra Eryılmaz
 * @version 1.0
 * @since 2020-02-24
 */

public class Driver
{
	public static void main(String[] args)
	{
		Administrators[] adminTest = new Administrators[2];
		BranchEmployees[] empTest = new BranchEmployees[2];
		TransportationPersonnel[] perTest = new TransportationPersonnel[2];
		Customers[] custTest = new Customers[2];
		Shipment[] cargo = new Shipment[2];

		System.out.printf("\t\tTEST STARTING...\n\n");
		System.out.printf("---------------------------------------------------------------------------------------------------------\n");

		System.out.printf("\tADMINISTRATORS CLASS TEST STARTING...\n\n");

		//creating two new administrators
		System.out.printf("1.->");
		adminTest[0] = new Administrators(Users.UserType.ADMINISTRATOR,Users.BranchType.ANKARA,"Esra Eryilmaz","123456");
		adminTest[0].printUser();
		System.out.printf("2.->");
		adminTest[1] = new Administrators(Users.UserType.ADMINISTRATOR,Users.BranchType.IZMIR,"Fatma Kaya","abc123");
		adminTest[1].printUser();
		System.out.printf("\n");

		//administrators add two new branch employees
		System.out.printf("1.->");
		empTest[0] = adminTest[0].addBranchEmployee(Users.UserType.BRANCH_EMPLOYEE,Users.BranchType.KOCAELI,"Ahmet Demir","111111");
		empTest[0].printUser();
		System.out.printf("2.->");
		empTest[1] = adminTest[1].addBranchEmployee(Users.UserType.BRANCH_EMPLOYEE,Users.BranchType.ISTANBUL,"Mehmet Sahin","000000");
		empTest[1].printUser();
		System.out.printf("\n");

		//administrator removes one of the branch employee
		adminTest[1].removeBranchEmployee(empTest[1]);
		empTest[1].printUser();
		System.out.printf("\n");

		//administrators add two new transportation personnel
		System.out.printf("1.->");
		perTest[0] = adminTest[0].addTransportationPersonnel(Users.UserType.TRANSPORTATION_PERSONNEL,Users.BranchType.AMASYA,"Ayse Yildirim","135790");
		perTest[0].printUser();
		System.out.printf("2.->");
		perTest[1] = adminTest[1].addTransportationPersonnel(Users.UserType.TRANSPORTATION_PERSONNEL,Users.BranchType.ISTANBUL,"Mustafa Kara","010101");
		perTest[0].printUser();
		System.out.printf("\n");

		//administrator removes one of the transportation personnel
		adminTest[1].removeTransportationPersonnel(perTest[1]);
		perTest[1].printUser();

		System.out.printf("\n\n---------------------------------------------------------------------------------------------------------\n");
		System.out.printf("\tBRANCHEMPLOYEES CLASS TEST STARTING...\n\n");

		//creating two new customer
		System.out.printf("1.->");
		custTest[0] = empTest[0].addCustomer(Users.UserType.CUSTOMER, Users.BranchType.ANKARA,"Ali Yilmaz","000111");
		custTest[0].printUser();
		System.out.printf("2.->");
		custTest[1] = empTest[1].addCustomer(Users.UserType.CUSTOMER, Users.BranchType.KOCAELI,"Emine Aslan","abcdef");
		custTest[1].printUser();
		System.out.printf("\n");

		//branch employees add two new cargo with their informations
		System.out.printf("1.->");
		cargo[0] = empTest[1].setShipmentInformation("45322567","Ali Yilmaz","Meryem Yildiz", Users.BranchType.ANKARA);
		cargo[0].printInformation(cargo[0].getTrackingNumber());
		System.out.printf("2.->");
		cargo[1] = empTest[0].setShipmentInformation("54327924","Emine Aslan", "Ismail Kilic", Users.BranchType.KOCAELI);
		cargo[1].printInformation(cargo[1].getTrackingNumber());
		System.out.printf("\n");

		//branch employee removes one of the cargo
		empTest[0].removeShipmentInformation(cargo[1]);
		cargo[1].printInformation(cargo[1].getTrackingNumber());

		//branch employee updates when package arrives at that branch
		empTest[0].packageArrives(cargo[1]);

		//branch employee updates when package leaves at that branch
		empTest[0].packageLeaves(cargo[1],Users.BranchType.AMASYA);

		System.out.printf("\n\n---------------------------------------------------------------------------------------------------------\n");
		System.out.printf("\tTRANSPORTATIONPERSONNEL CLASS TEST STARTING...\n\n");

		//transportation personnel makes the update when cargo is delivered
		perTest[0].updateDeliveredCargo(cargo[0]);
		cargo[0].printInformation(cargo[0].getTrackingNumber());

		System.out.printf("\n\n---------------------------------------------------------------------------------------------------------\n");
		System.out.printf("\tCUSTOMERS CLASS TEST STARTING...\n\n");

		//customers can see the cargo information if they enter the tracking number
		custTest[0].cargoInformation(cargo[0].getTrackingNumber(),cargo[0]);

		System.out.printf("\n---------------------------------------------------------------------------------------------------------\n");
	}

}
