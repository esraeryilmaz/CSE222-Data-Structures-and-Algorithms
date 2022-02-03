/**
 * Customer class
 *
 * @author Esra Eryılmaz
 * @since 2020-03-01
 */

public class Customer extends Users
{
	/**
	 * @param newBranch
	 * @param newUser
	 * @param newUsername
	 * @param newPassword
	 */
	public Customer(Branch newBranch, UserType newUser, String newUsername, String newPassword)
	{
		super(newBranch, newUser, newUsername, newPassword);
	}

	/**
	 *prints cargo information
	 *@param trackingNumber
	 *@param cargo
	 */
	public void cargoInformation(String trackingNumber,Shipment cargo)
	{
		cargo.printInformation(trackingNumber);
	}

	/**
	 *deletes customer
	 *@param c
	 */
	public void deleteCustomer(Customer c)
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
		if (username == null) {
			System.out.println( "The Customer you tried to print has been removed!!!!");
		}
		else
			System.out.println(this.toString());
	}

	/**
	 * produces customer information as String
	 *@return String
	 */
	@Override
	public String toString(){
		return "Customer [branch=" + branch.getBranchName() + ", user=" + user + ", username=" + username + ", password=" + password + "]";
	}
}
