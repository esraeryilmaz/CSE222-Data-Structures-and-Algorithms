/**
 * BranchEmployee class
 *
 * @author Esra Eryılmaz
 * @since 2020-03-01
 */

import java.util.ArrayList;

public class BranchEmployee extends Users
{
	//Data fields
	private ArrayList<Shipment>shipments;
	private ArrayList<Customer>customers;

	/**
	 * @param newBranch
	 * @param newUser
	 * @param newUsername
	 * @param newPassword
	 * @param shipments
	 */
	public BranchEmployee(Branch newBranch, UserType newUser, String newUsername, String newPassword,
							ArrayList<Shipment> shipments, ArrayList<Customer>customers)
	{
		super(newBranch, newUser, newUsername, newPassword);
		this.shipments = shipments;
		this.customers = customers;
	}

	/**
	 * @param newBranch
	 * @param newUser
	 * @param newUsername
	 * @param newPassword
	 */
	public BranchEmployee(Branch newBranch, UserType newUser, String newUsername, String newPassword)
	{
		super(newBranch, newUser, newUsername, newPassword);
		shipments = new ArrayList<Shipment>();
		customers = new ArrayList<Customer>();
	}

	/**
	 *adds shipment information
	 *@param newCargo
	 *@return newCargo
	 */
	public Shipment addShipment(Shipment newCargo)
	{
		shipments.add(newCargo);
		return newCargo;
	}

	/**
	 *removes shipment information
	 *@param cargo
	 */
	public void removeShipment(Shipment cargo)
	{
		shipments.remove(cargo);
		cargo.deleteShipment();
	}

	/**
	 *updating when package arrives at that branch
	 *@param cargo
	 */
	public void packageArrives(Shipment cargo)
	{
		cargo.setCurrentStatus(this.branch);
	}

	/**
	 *updating when package leaves at that branch
	 *@param cargo
	 *@param where
	 */
	public void packageLeaves(Shipment cargo, Branch where)
	{
		cargo.setCurrentStatus(where);
	}

	/**
	 *adds customer
	 *@param newCustomer
	 *@return newCustomer
	 */
	public Customer addCustomer(Customer newCustomer)
	{
		customers.add(newCustomer);
		return newCustomer;
	}

	/**
	 *removes customer
	 *@param cus
	 */
	public void removeCustomer(Customer cus)
	{
		customers.remove(cus);
		cus.deleteCustomer(cus);
	}

	/**
	 * @return the customers
	 */
	public ArrayList<Customer> getCustomers()
	{
		return customers;
	}

	/**
	 *deletes employee
	 *@param e
	 */
	public void deleteEmployee(BranchEmployee e)
	{
		e.user = null;
		e.branch = null;
		e.username = null;
		e.password = null;
	}

	/**
	 *prints branch employee information
	 */
	@Override
	public void printUser()
	{
		if (username == null) {
			System.out.println( "The BranchEmployee you tried to print has been removed!!!!");
		}
		else
			System.out.println(this.toString());
	}

	/**
	 * produces branch employee information as String
	 *@return String
	 */
	@Override
	public String toString() {
		return "BranchEmployee [branch=" + branch.getBranchName() + ", user=" + user + ", username=" + username + ", password=" + password + "]";
	}

}
