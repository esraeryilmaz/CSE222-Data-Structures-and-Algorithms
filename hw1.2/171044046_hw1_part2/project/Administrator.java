/**
 * Administrator class
 *
 * @author Esra Eryılmaz
 * @since 2020-03-01
 */

import java.util.ArrayList;

public class Administrator extends Users
{
	//Data fields
	private ArrayList<Branch>branchs;
	private ArrayList<BranchEmployee>employees;
	private ArrayList<TransportationPersonnel>personnel;

	/**
	 * @param newBranch
	 * @param newUser
	 * @param newUsername
	 * @param newPassword
	 * @param branchs
	 * @param employees
	 * @param personnel
	 */
	public Administrator(Branch newBranch, UserType newUser, String newUsername, String newPassword,ArrayList<Branch> branchs,
							ArrayList<BranchEmployee> employees,ArrayList<TransportationPersonnel> personnel)
	{
		super(newBranch, newUser, newUsername, newPassword);
		this.branchs = branchs;
		this.employees = employees;
		this.personnel = personnel;
	}

	/**
	 * @param newBranch
	 * @param newUser
	 * @param newUsername
	 * @param newPassword
	 */
	public Administrator(Branch newBranch, UserType newUser, String newUsername, String newPassword)
	{
		super(newBranch, newUser, newUsername, newPassword);
		branchs = new ArrayList<Branch>();
		employees = new ArrayList<BranchEmployee>();
		personnel = new ArrayList<TransportationPersonnel>();
	}

	/**
	 * Gets the branchs list
	 * @return the branchs
	 */
	public ArrayList<Branch> getBranchs()
	{
		return branchs;
	}

	/**
	 * Gets the employees list
	 * @return the employees
	 */
	public ArrayList<BranchEmployee> getEmployees()
	{
		return employees;
	}

	/**
	 * Gets the personnel list
	 * @return the personnel
	 */
	public ArrayList<TransportationPersonnel> getPersonnel()
	{
		return personnel;
	}

	/**
	 * Adds branch
	 */
	public void addBranch(Branch newBranch)
	{
		branchs.add(newBranch);
	}

	/**
	 * Removes branch
	 */
	public void removeBranch(Branch branch)
	{
		branchs.remove(branch);
		searchAndRemove(branch);
	}

	/**
	 * Adds branch employee
	 *@param newEmployee
	 *@return newEmployee
	 */
	public BranchEmployee addEmployee(BranchEmployee newEmployee)
	{
		employees.add(newEmployee);
		return newEmployee;
	}

	/**
	 * Removes branch employee
	 *@param emp
	 */
	public void removeEmployee(BranchEmployee emp)
	{
		//delete employee in the ArrayList and delete created object
		employees.remove(emp);
		emp.deleteEmployee(emp);
	}

	/**
	 * Adds transportation personnel
	 *@param newPersonnel
	 *@return newPersonnel
	 */
	public TransportationPersonnel addPersonnel(TransportationPersonnel newPersonnel)
	{
		personnel.add(newPersonnel);
		return newPersonnel;
	}

	/**
	 * Removes transportation personnel
	 *@param per
	 */
	public void removePersonnel(TransportationPersonnel per)
	{
		personnel.remove(per);
		per.deletePersonnel(per);
	}

	/**
	 * If there are employees or personnel in the deleted branch, it will delete them.
	 *@param removedBranch
	 */
	public void searchAndRemove(Branch removedBranch)
	{
		BranchEmployee temp;
		for(int i = 0; i < employees.size() ; i++)
		{
			temp = employees.get(i);
			if(temp.branch == removedBranch)
				removeEmployee(temp);
		}

		TransportationPersonnel tmp;
		for(int i = 0; i<personnel.size() ; i++)
		{
			tmp = personnel.get(i);
			if(tmp.branch == removedBranch)
				removePersonnel(tmp);
		}
	}

	/**
	 *prints administrator information
	 */
	@Override
	public void printUser()
	{
		if (username == null) {
			System.out.println( "The Administrator you tried to print has been removed!!!!");
		}
		else
			System.out.println(this.toString());
	}

	/**
	 * produces administrator information as String
	 *@return String
	 */
	@Override
	public String toString() {
		return "Administrator [branch=" + branch.getBranchName() + ", user=" + user + ", username=" + username + ", password=" + password + "]";
	}

}
