package net.codejava.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name = "user")

public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)    
	private Long id;
	
	@Column(name = "name" ,nullable = false, unique = true, length = 45)
	private String name;
	

	
	@Column(name = "email", nullable = false, length = 20)
	private String email;
	
	@Column(name = "mobile", nullable = false, length = 20)
	private String mobile;
	
	private boolean sendViaEmail ;
	
	public boolean isSendViaEmail() {
		return sendViaEmail;
	}

	public void setSendViaEmail(boolean sendViaEmail) {
		this.sendViaEmail = sendViaEmail;
	}

	public boolean isSendViaMessage() {
		return sendViaMessage;
	}

	public void setSendViaMessage(boolean sendViaMessage) {
		this.sendViaMessage = sendViaMessage;
	}

	private  boolean sendViaMessage ;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Users(Long id, String name, String email, String mobile) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
	}

	public Users() {
		super();
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", mobile=" + mobile + "]";
	}


	

	

}
