/**
 * TransportationPersonnel class
 *
 * @author Esra Eryılmaz
 * @since 2020-03-01
 */

public class TransportationPersonnel extends Users
{
	/**
	 * @param newBranch
	 * @param newUser
	 * @param newUsername
	 * @param newPassword
	 */
	public TransportationPersonnel(Branch newBranch, UserType newUser, String newUsername, String newPassword)
	{
		super(newBranch, newUser, newUsername, newPassword);
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
	 *removes transportation personnel
	 *@param t
	 */
	public void deletePersonnel(TransportationPersonnel t)
	{
		t.user = null;
		t.branch = null;
		t.username = null;
		t.password = null;
	}

	/**
	 *prints transportation personnel information
	 */
	@Override
	public void printUser()
	{
		if (username == null) {
			System.out.println( "The TransportationPersonnel you tried to print has been removed!!!!");
		}
		else
			System.out.println(this.toString());
	}

	/**
	 * produces transportation personnel information as String
	 *@return String
	 */
	@Override
	public String toString() {
		return "TransportationPersonnel [branch=" + branch.getBranchName() + ", user=" + user + ", username=" + username + ", password=" + password + "]";
	}

}
