package com.ahmedeid.securityandjwt.demo.entities;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

@Entity
@Table(name = "users")
public class User implements UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "code")
	private long code;

	@NotNull
	@Column(name = "user_name")
	private String userName;

	@NotNull
	@Column(name = "email")
	private String email;

	@NotNull
	@JsonIgnore
	@Column(name = "password")
	private String password;

	@NotNull
	@Column(name = "is_admin")
	private int isAdmin;

	@Column(name = "modified_by")
	private int modifiedBy;

	@Column(name = "date_modify")
	private Date dateModify;

	// adding relationship between tables users and sys_privelages
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_privelage", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "privelage_id"))
	private List<SysPrivelage> sysPrivelage;

	public User() {
		super();
	}

	public User(String userName, String email, String password) {
		super();
		this.userName = userName;
		this.email = email;
		this.password = password;
//		this.timeCreated = new Date();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// methods implements of UserDetails
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public int getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}

	public long getCode() {
		return code;
	}

	public void setCode(long code) {
		this.code = code;
	}

	public int getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(int modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getDateModify() {
		return dateModify;
	}

	public void setDateModify(Date dateModify) {
		this.dateModify = dateModify;
	}

	public List<SysPrivelage> getSysPrivelage() {
		return sysPrivelage;
	}

	public void setSysPrivelage(List<SysPrivelage> sysPrivelage) {
		this.sysPrivelage = sysPrivelage;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", code=" + code + ", userName=" + userName + ", email=" + email + ", password="
				+ password + ", isAdmin=" + isAdmin + ", modifiedBy=" + modifiedBy + ", dateModify=" + dateModify
				+ ", sysPrivelage=" + sysPrivelage + "]";
	}

}
