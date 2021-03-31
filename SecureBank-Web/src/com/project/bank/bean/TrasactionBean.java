package com.project.bank.bean;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="transaction")
public class TrasactionBean {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	

	
	@Column(name = "User_Code")
	private String userCode;
	


	@Column(name = "Bank_Name")
	private String bankName;
	


	@Column(name = "Trasaction_Type")
	private String trasactionType;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "State")
	private String state;
	
	@Column(name = "amount")
	private String amount;
	
	@Column(name = "Trasaction_Date")
	private Date trasactionDate;
	
	@Column(name = "user_Account_Number")
	private String userAccountNumber;
	
	@Column(name = "benificiary_Account_Number")
	private String benificiaryAccountNumber;
	
	@Column(name = "Benificiary_IFSC_Code")
	private String benificiaryIFSCCode;

	@Override
	public String toString() {
		return "TrasactionBean [id=" + id + ", userCode=" + userCode + ", bankName=" + bankName + ", trasactionType="
				+ trasactionType + ", city=" + city + ", state=" + state + ", amount=" + amount + ", trasactionDate="
				+ trasactionDate + ", userAccountNumber=" + userAccountNumber + ", benificiaryAccountNumber="
				+ benificiaryAccountNumber + ", benificiaryIFSCCode=" + benificiaryIFSCCode + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getTrasactionType() {
		return trasactionType;
	}

	public void setTrasactionType(String trasactionType) {
		this.trasactionType = trasactionType;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}



	public Date getTrasactionDate() {
		return trasactionDate;
	}

	public void setTrasactionDate(Date trasactionDate) {
		this.trasactionDate = trasactionDate;
	}

	public String getUserAccountNumber() {
		return userAccountNumber;
	}

	public void setUserAccountNumber(String userAccountNumber) {
		this.userAccountNumber = userAccountNumber;
	}

	public String getBenificiaryAccountNumber() {
		return benificiaryAccountNumber;
	}

	public void setBenificiaryAccountNumber(String benificiaryAccountNumber) {
		this.benificiaryAccountNumber = benificiaryAccountNumber;
	}

	public String getBenificiaryIFSCCode() {
		return benificiaryIFSCCode;
	}

	public void setBenificiaryIFSCCode(String benificiaryIFSCCode) {
		this.benificiaryIFSCCode = benificiaryIFSCCode;
	}


	
	
	
}
