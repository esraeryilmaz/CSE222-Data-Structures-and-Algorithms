/**
 * Administrators class
 *
 * @author Esra Eryılmaz
 * @version 1.0
 * @since 2020-02-24
 */

public class Administrators extends Users
{
	/**
	 *Constructor
	 *@param newType
	 *@param newBranch
	 *@param newName
	 *@param newPassword
	 */
	public Administrators(UserType newType,BranchType newBranch,String newName,String newPassword)
	{
		super(newType,newBranch, newName, newPassword);
	}

	/**
	 *adds branch employee
	 *@param newType
	 *@param newBranch
	 *@param newName
	 *@param newPassword
	 *@return newEmployee
	 */
	public BranchEmployees addBranchEmployee(UserType newType,BranchType newBranch, String newName, String newPassword)
	{
		BranchEmployees newEmployee = new BranchEmployees(newType,newBranch,newName,newPassword);
		return newEmployee;
	}

	/**
	 *removes branch employee
	 *@param employee
	 */
	public void removeBranchEmployee(BranchEmployees employee)
	{
		employee.deleteEmployee(employee);
	}

	/**
	 *adds transportation personnel
	 *@param newType
	 *@param newBranch
	 *@param newName
	 *@param newPassword
	 *@return newPersonnel
	 */
	public TransportationPersonnel addTransportationPersonnel(UserType newType,BranchType newBranch, String newName, String newPassword)
	{
		TransportationPersonnel newPersonnel = new TransportationPersonnel(newType,newBranch,newName,newPassword);
		return newPersonnel;
	}

	/**
	 *removes transportation personnel
	 *@param personnel
	 */
	public void removeTransportationPersonnel(TransportationPersonnel personnel)
	{
		personnel.removePersonnel(personnel);
	}

	/**
	 *adds branch
	 */
	public void addBranch(BranchType b)
	{
		this.branch = b;
	}

	/**
	 *removes branch
	 */
	public void removeBranch()
	{
		this.branch = null;
	}

	/**
	 *prints administrator information
	 */
	@Override
	public void printUser()
	{
		System.out.println(this.toString());	
	}

	/**
	 * produces administrator information as String
	 *@return String
	 */
	@Override
	public String toString() {
		return "Administrator [user=" + user + ", branch=" + branch + ", username=" + username + ", password="
				+ password + "]";
	}

}
