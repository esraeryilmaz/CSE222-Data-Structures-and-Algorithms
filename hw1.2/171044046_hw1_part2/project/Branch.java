/**
 * Branch class
 *
 * @author Esra Eryılmaz
 * @since 2020-03-01
 */

public class Branch
{
	//Data field
	private String branchName;


	/**
	 * @param newBranchName
	 */
	public Branch(String newBranchName)
	{
		this.branchName = newBranchName;
	}

	/**
	 * @return the branchName
	 */
	public String getBranchName()
	{
		return branchName;
	}

	/**
	 * @param newBranchName the branchName to set
	 */
	public void setBranchName(String newBranchName)
	{
		this.branchName = newBranchName;
	}

}
