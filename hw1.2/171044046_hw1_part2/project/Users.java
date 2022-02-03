/**
 * Abstract class Users
 *
 * @author Esra Eryılmaz
 * @since 2020-03-01
 */

import java.security.InvalidParameterException;

public abstract class Users implements AutomationSystem
{
	//Data fields
	protected Branch branch;
	protected UserType user;
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
	 *Constructor
	 *@param newBranch
	 *@param newUser
	 *@param newUsername
	 *@param newPassword
	 *@throws InvalidParameterException if password has less than 6 characters
	 */
	public Users(Branch newBranch, UserType newUser, String newUsername, String newPassword) throws InvalidParameterException
	{
		this.branch = newBranch;
		this.user = newUser;
		this.username = newUsername;

		if(newPassword.length() < 6)
			throw new InvalidParameterException("Passwords must be at least 6 characters");
		else
			this.password = newPassword;
	}

	/**
	 * prints user information
	 */
	public abstract void printUser();

}
