/**
 * BranchEmployees class
 *
 * @author Esra Eryılmaz
 * @version 1.0
 * @since 2020-02-24
 */

public class BranchEmployees extends Users
{
	/**
	 *Constructor
	 *@param newType
	 *@param newBranch
	 *@param newName
	 *@param newPassword
	 */
	public BranchEmployees(UserType newType,BranchType newBranch, String newName, String newPassword)
	{
		super(newType,newBranch, newName, newPassword);
	}

	/**
	 *sets shipment information
	 *@param trackingNumber
	 *@param senderName
	 *@param receiverName
	 *@param deliveredBranch
	 *@return newShipment
	 */
	public Shipment setShipmentInformation(String trackingNumber,String senderName,String receiverName,BranchType deliveredBranch)
	{
		Shipment newShipment = new Shipment(trackingNumber, senderName, receiverName, deliveredBranch,this.branch);
		return newShipment;
	}

	/**
	 *removes shipment information
	 *@param cargo
	 */
	public void removeShipmentInformation(Shipment cargo)
	{
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
	public void packageLeaves(Shipment cargo,BranchType where)
	{
		cargo.setCurrentStatus(where);
	}

	/**
	 *deletes employee
	 *@param e
	 */
	public void deleteEmployee(BranchEmployees e)
	{
		e.user = null;
		e.branch = null;
		e.username = null;
		e.password = null;
	}

	/**
	 *adds customer
	 *@param newType
	 *@param newBranch
	 *@param newName
	 *@param newPassword
	 *@return newCustomer
	 */
	public Customers addCustomer(UserType newType,BranchType newBranch, String newName, String newPassword)
	{
		Customers newCustomer = new Customers(newType,newBranch,newName,newPassword);
		return newCustomer;
	}

	/**
	 *removes customer
	 *@param customer
	 */
	public void removeCustomer(Customers customer)
	{
		customer.deleteCustomer(customer);
	}

	/**
	 *prints branch employee information
	 */
	@Override
	public void printUser()
	{
		System.out.println(this.toString());
	}

	/**
	 * produces branch employee information as String
	 *@return String
	 */
	@Override
	public String toString() {
		return "BranchEmployee [user=" + user + ", branch=" + branch + ", username=" + username + ", password="
				+ password + "]";
	}
	
}
