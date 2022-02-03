/**
 * Shipment class
 *
 * @author Esra Eryılmaz
 * @version 1.0
 * @since 2020-02-24
 */

public class Shipment
{
	private String trackingNumber;
	private String senderName;
	private String receiverName;
	private Users.BranchType deliveredBranch;
	private Users.BranchType currentStatus;

	/**
	 *prints shipment information
	 *@param trackingNumber
	 */
	public void printInformation(String trackingNumber)
	{
		if(this.trackingNumber == trackingNumber)
			System.out.println(this.toString());
		else
			System.out.printf("trackingNumber is wrong");
	}

	/**
	 *Constructor
	 *@param newTrackingNumber
	 *@param newSenderName
	 *@param newReceiverName
	 *@param newDeliveredBranch
	 *@param newCurrentStatus
	 */
	public Shipment(String newTrackingNumber, String newSenderName, String newReceiverName, Users.BranchType newDeliveredBranch, Users.BranchType newCurrentStatus)
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
	 *gets the cargo tracking number
	 *@return trackingNumber
	 */
	public String getTrackingNumber() {
		return trackingNumber;
	}

	/**
	 *sets the cargo tracking number
	 *@param trackingNumber
	 */
	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}

	/**
	 *gets the sender name
	 *@return senderName
	 */
	public String getSenderName() {
		return senderName;
	}

	/**
	 *sets the sender name
	 *@param senderName
	 */
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	/**
	 *gets the receiver name
	 *@return receiverName
	 */
	public String getReceiverName() {
		return receiverName;
	}

	/**
	 *sets the receiver name
	 *@param receiverName
	 */
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	/**
	 *gets the current status of cargo
	 *@return currentStatus
	 */
	public Users.BranchType getCurrentStatus() {
		return currentStatus;
	}

	/**
	 *sets the current status of cargo
	 *@param currentStatus
	 */
	public void setCurrentStatus(Users.BranchType currentStatus) {
		this.currentStatus = currentStatus;
	}

	/**
	 *gets the delivering branch
	 *@return deliveredBranch
	 */
	public Users.BranchType getDeliveredBranch() {
		return deliveredBranch;
	}

	/**
	 *sets the delivering branch
	 *@param deliveredBranch
	 */
	public void setDeliveredBranch(Users.BranchType deliveredBranch) {
		this.deliveredBranch = deliveredBranch;
	}

	/**
	 * produces shipment information as String
	 *@return String
	 */
	@Override
	public String toString() {
		return "Shipment [trackingNumber=" + trackingNumber + ", senderName=" + senderName + ", receiverName=" + receiverName 
				+ ", deliveredBranch=" + deliveredBranch + "currentStatus" + currentStatus + "]";
	}

}
