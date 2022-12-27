package Model;

public class Contact {
private int contactID;
private String userID;
private String contactName;
private String contactEmail;
private String contactAddress;
private String contactPhone;

public String getUserID() {
	return userID;
}
public void setUserID(String userID) {
	this.userID = userID;
}
public Contact() {
	super();
}
public Contact(int contactID, String contactName, String contactEmail, String contactAddress, String contactPhone) {
	super();
	this.contactID = contactID;
	this.contactName = contactName;
	this.contactEmail = contactEmail;
	this.contactAddress = contactAddress;
	this.contactPhone = contactPhone;
}
public Contact(String userID, String contactName, String contactEmail, String contactAddress, String contactPhone) {
	super();
	this.userID = userID;
	this.contactName = contactName;
	this.contactEmail = contactEmail;
	this.contactAddress = contactAddress;
	this.contactPhone = contactPhone;
}
public Contact(int contactID, String userID, String contactName, String contactEmail, String contactAddress,
		String contactPhone) {
	super();
	this.contactID = contactID;
	this.userID = userID;
	this.contactName = contactName;
	this.contactEmail = contactEmail;
	this.contactAddress = contactAddress;
	this.contactPhone = contactPhone;
}
public int getContactID() {
	return contactID;
}
public void setContactID(int contactID) {
	this.contactID = contactID;
}
public String getContactName() {
	return contactName;
}
public void setContactName(String contactName) {
	this.contactName = contactName;
}
public String getContactEmail() {
	return contactEmail;
}
public void setContactEmail(String contactEmail) {
	this.contactEmail = contactEmail;
}
public String getContactAddress() {
	return contactAddress;
}
public void setContactAddress(String contactAddress) {
	this.contactAddress = contactAddress;
}
public String getContactPhone() {
	return contactPhone;
}
public void setContactPhone(String contactPhone) {
	this.contactPhone = contactPhone;
}
@Override
public String toString() {
	return "Contact [contactID=" + contactID + ", userID=" + userID + ", contactName=" + contactName + ", contactEmail="
			+ contactEmail + ", contactAddress=" + contactAddress + ", contactPhone=" + contactPhone + "]";
}



}
