package com.koderunner.vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "SDUser_details", schema = "marrygold")
public class SDUserVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 private Integer SNo;
	 private String loginId;
     private String firstName;
     private String lastName;
     private String password;
     private String gender;
     private String emailId;
     private String userName;
     private String oauthProvider;
     private String oauthUId;
     
     public SDUserVO() { }
     
     public SDUserVO(Integer sNo, String loginId, String firstName,
			String lastName, String password, String gender, String emailId,
			String userName, String oauthProvider, String oauthUId) {
		SNo = sNo;
		this.loginId = loginId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.gender = gender;
		this.emailId = emailId;
		this.userName = userName;
		this.oauthProvider = oauthProvider;
		this.oauthUId = oauthUId;
	}
	public SDUserVO(String loginId, String firstName, String lastName, String password, String emailId,String userName) {
 		this.loginId = loginId;
 		this.firstName = firstName;
 		this.lastName = lastName;
 		this.password = password;
 		this.emailId = emailId;
 		this.userName = userName;
 	}
     @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
     
    @Column(name="S_NO", unique=true, nullable=false)
    public Integer getSNo() {
		return SNo;
	}

	public void setSNo(Integer sNo) {
		SNo = sNo;
	}

    @Column(name="LOGIN_ID", length=100) 
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
    @Column(name="FIRST_NAME", length=100)
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	@Column(name="LAST_NAME", length=100)
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@Column(name="PASSWORD", length=100)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Column(name="GENDER", length=100)
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Column(name="EMAIL_ID", length=100)
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	@Column(name="USER_NAME", length=100)
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Column(name="OAUTH_PROVIDER", length=100)
	public String getOauthProvider() {
		return oauthProvider;
	}
	public void setOauthProvider(String oauthProvider) {
		this.oauthProvider = oauthProvider;
	}
	@Column(name="OAUTH_ID", length=100)
	public String getOauthUId() {
		return oauthUId;
	}
	public void setOauthUId(String oauthUId) {
		this.oauthUId = oauthUId;
	}
    
    
     
    

}
