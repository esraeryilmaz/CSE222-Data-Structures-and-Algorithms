/**
 * Shipment class
 *
 * @author Esra Eryılmaz
 * @since 2020-03-01
 */

public class Shipment
{
	//Data fields
	private String trackingNumber;
	private String senderName;
	private String receiverName;
	private Branch deliveredBranch;
	private Branch currentStatus;

	/**
	 * @param newTrackingNumber
	 * @param newSenderName
	 * @param newReceiverName
	 * @param newDeliveredBranch
	 * @param newCurrentStatus
	 */
	public Shipment(String newTrackingNumber, String newSenderName, String newReceiverName, Branch newDeliveredBranch, Branch newCurrentStatus)
	{
		this.trackingNumber = newTrackingNumber;
		this.senderName = newSenderName;
		this.receiverName = newReceiverName;
		this.deliveredBranch = newDeliveredBranch;
		this.currentStatus = newCurrentStatus;
	}

	/**
	 *deletes shipment
	 */
	public void deleteShipment()
	{
		this.trackingNumber = null;
		this.senderName = null;
		this.receiverName = null;
		this.deliveredBranch = null;
		this.currentStatus = null;
	}

	/**
	 *prints shipment information
	 *@param trackingNumber
	 */
	public void printInformation(String trackingNumber)
	{
		if (trackingNumber == null)
			System.out.println( "The Shipment you tried to print has been removed!!!!");
		else if(this.trackingNumber == trackingNumber)
			System.out.println(this.toString());
		else
			System.out.printf("trackingNumber is wrong");
	}

	/**
	 *gets the cargo tracking number
	 * @return the trackingNumber
	 */
	public String getTrackingNumber()
	{
		return trackingNumber;
	}

	/**
	 *sets the cargo tracking number
	 * @param trackingNumber the trackingNumber to set
	 */
	public void setTrackingNumber(String trackingNumber)
	{
		this.trackingNumber = trackingNumber;
	}

	/**
	 * @return the senderName
	 */
	public String getSenderName()
	{
		return senderName;
	}

	/**
	 * @param senderName the senderName to set
	 */
	public void setSenderName(String senderName)
	{
		this.senderName = senderName;
	}

	/**
	 * @return the receiverName
	 */
	public String getReceiverName()
	{
		return receiverName;
	}

	/**
	 * @param receiverName the receiverName to set
	 */
	public void setReceiverName(String receiverName)
	{
		this.receiverName = receiverName;
	}

	/**
	 * @return the deliveredBranch
	 */
	public Branch getDeliveredBranch()
	{
		return deliveredBranch;
	}

	/**
	 * @param deliveredBranch the deliveredBranch to set
	 */
	public void setDeliveredBranch(Branch deliveredBranch)
	{
		this.deliveredBranch = deliveredBranch;
	}

	/**
	 * @return the currentStatus
	 */
	public Branch getCurrentStatus()
	{
		return currentStatus;
	}

	/**
	 * @param currentStatus the currentStatus to set
	 */
	public void setCurrentStatus(Branch currentStatus)
	{
		this.currentStatus = currentStatus;
	}

	/**
	 * produces shipment information as String
	 *@return String
	 */
	@Override
	public String toString() {
		return "Shipment [trackingNumber=" + trackingNumber + ", senderName=" + senderName + ", receiverName="
				+ receiverName + ", deliveredBranch=" + deliveredBranch.getBranchName() + ", currentStatus=" + currentStatus.getBranchName() + "]";
	}

}
