/**
 * Customers class
 *
 * @author Esra Eryılmaz
 * @version 1.0
 * @since 2020-02-24
 */

public class Customers extends Users
{
	/**
	 *Constructor
	 *@param newType
	 *@param newBranch
	 *@param newName
	 *@param newPassword
	 */
	public Customers(UserType newType, BranchType newBranch, String newName, String newPassword)
	{
		super(newType, newBranch, newName, newPassword);
	}

	/**
	 *prints cargo information
	 *@param trackingNumber
	 *@param shipmentObj
	 */
	public void cargoInformation(String trackingNumber,Shipment shipmentObj)
	{
		shipmentObj.printInformation(trackingNumber);
	}

	/**
	 *deletes customer
	 *@param c
	 */
	public void deleteCustomer(Customers c)
	{
		c.user = null;
		c.branch = null;
		c.username = null;
		c.password = null;
	}

	/**
	 *prints customer information
	 */
	@Override
	public void printUser()
	{
		System.out.println(this.toString());
	}

	/**
	 * produces customer information as String
	 *@return String
	 */
	@Override
	public String toString() {
		return "Customer [user=" + user + ", branch=" + branch + ", username=" + username + ", password="
				+ password + "]";
	}

}
