package com.crud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;



@Entity
@Table(name = "user")
public class User {

	@Id
	@Column(name = "u_iduser")
	private Long idUser;

	@NotBlank
	@Column(name = "u_name")
	private String nameUser;

	@NotBlank
	@Column(name = "u_lastname")
	private String lastnameUser;

	@NotBlank
	@Column(name = "u_username")
	private String usernameUser;

	@NotBlank
	@Column(name = "u_email")
	private String emailUser;

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public String getNameUser() {
		return nameUser;
	}

	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}

	public String getLastnameUser() {
		return lastnameUser;
	}

	public void setLastnameUser(String lastnameUser) {
		this.lastnameUser = lastnameUser;
	}

	public String getUsernameUser() {
		return usernameUser;
	}

	public void setUsernameUser(String usernameUser) {
		this.usernameUser = usernameUser;
	}

	public String getEmailUser() {
		return emailUser;
	}

	public void setEmailUser(String emailUser) {
		this.emailUser = emailUser;
	}

	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", nameUser=" + nameUser + ", lastnameUser=" + lastnameUser
				+ ", usernameUser=" + usernameUser + ", emailUser=" + emailUser + "]";
	}

}
