package com.project.bank.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_table")
public class UserBean {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	

	
	@Column(name = "login")
	private String login;
	
	@Column(name = "password")
	private String password;
	


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "First_Name")
	private String firstName;
	
	@Override
	public String toString() {
		return "UserBean [id=" + id + ", login=" + login + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", code=" + code + ", userRole=" + userRole + ", contactNumber=" + contactNumber + ", mailID="
				+ mailID + "]";
	}

	@Column(name = "Last_Name")
	private String lastName;
	
	@Column(name = "Code")
	private String code;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getMailID() {
		return mailID;
	}

	public void setMailID(String mailID) {
		this.mailID = mailID;
	}

	@Column(name = "User_Role")
	private String userRole;
	
	@Column(name = "Contact_Number")
	private String contactNumber;
	
	@Column(name = "Mail_ID")
	private String mailID;
	
	@Column(name = "city")
	private String city;
	
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "profile")
	private String profile;



	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}


	
	
	
}
