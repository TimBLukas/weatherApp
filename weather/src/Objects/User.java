package Objects;

public class User {

	private int userID;
	private String userName;
	private String encryptedPW;
	private String referencedTable;
	
	
	public User (int userID, String userName, String encryptedPW) {
		
		this.userID = userID;
		this.userName = userName;
		this.encryptedPW = encryptedPW;
		
	}

	public String toString() {
		
		return userID + ": " + userName;
		
	}

	public int getUserID() {
		return userID;
	}


	public void setUserID(int userID) {
		this.userID = userID;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getEncryptedPW() {
		return encryptedPW;
	}


	public void setEncryptedPW(String encryptedPW) {
		this.encryptedPW = encryptedPW;
	}


	public String getReferencedTable() {
		return referencedTable;
	}


	public void setReferencedTable(String referencedTable) {
		this.referencedTable = referencedTable;
	}
	
	
	
}
