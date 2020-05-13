package auth.dto;

import java.io.Serializable;

public class Member implements Serializable {
	private String username;
	private String userAge;
	private String userAddress;
	private String useremail;

	@Override
	public String toString() {
		return "Member [username=" + username + ", userAge=" + userAge + ", userAddress=" + userAddress + ", useremail="
				+ useremail + "]";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserAge() {
		return userAge;
	}

	public void setUserAge(String userAge) {
		this.userAge = userAge;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUseremail() {
		return useremail;
	}

	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

}
