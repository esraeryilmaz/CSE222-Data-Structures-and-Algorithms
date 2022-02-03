/**
 * TransportationPersonnel class
 *
 * @author Esra Eryılmaz
 * @version 1.0
 * @since 2020-02-24
 */

public class TransportationPersonnel extends Users
{
	/**
	 *Constructor
	 *@param newType
	 *@param newBranch
	 *@param newName
	 *@param newPassword
	 */
	public TransportationPersonnel(UserType newType, BranchType newBranch, String newName, String newPassword)
	{
		super(newType, newBranch, newName, newPassword);
	}

	/**
	 *removes transportation personnel
	 *@param t
	 */
	public void removePersonnel(TransportationPersonnel t)
	{
		t.user = null;
		t.branch = null;
		t.username = null;
		t.password = null;
	}

	/**
	 *makes the update when cargo is delivered
	 *@param cargo
	 */
	public void updateDeliveredCargo(Shipment cargo)
	{
		cargo.setCurrentStatus(cargo.getDeliveredBranch());
	}

	/**
	 *prints transportation personnel information
	 */
	@Override
	public void printUser()
	{
		System.out.println(this.toString());
	}

	/**
	 * produces transportation personnel information as String
	 *@return String
	 */
	@Override
	public String toString() {
		return "TransportationPersonnel [user=" + user + ", branch=" + branch + ", username=" + username + ", password="
				+ password + "]";
	}
}
