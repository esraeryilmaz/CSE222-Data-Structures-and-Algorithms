/**
 * Users class
 *
 * @author Esra Eryılmaz
 * @version 1.0
 * @since 2020-02-24
 */

public abstract class Users
{
	protected UserType user;
	protected BranchType branch;
	protected String username;
	protected String password;

	/**
	 * user type enum
	 */
	public enum UserType
	{
		ADMINISTRATOR, BRANCH_EMPLOYEE, TRANSPORTATION_PERSONNEL, CUSTOMER
	}

	/**
	 * branch type enum
	 */
	public enum BranchType
	{
		ISTANBUL, ANKARA, IZMIR, KOCAELI, AMASYA
	}

	/**
	 *Constructor
	 *@param newType
	 *@param newBranch
	 *@param newName
	 *@param newPassword
	 */
	public Users(UserType newType,BranchType newBranch, String newName, String newPassword)
	{
		this.user = newType;
		this.branch = newBranch;
		this.username = newName;
		this.password = newPassword;
	}

	/**
	 * prints user information
	 */
	public abstract void printUser();
}
