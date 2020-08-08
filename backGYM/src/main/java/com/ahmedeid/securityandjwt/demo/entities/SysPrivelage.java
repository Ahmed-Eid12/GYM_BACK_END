package com.ahmedeid.securityandjwt.demo.entities;

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
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "sys_privelages")
public class SysPrivelage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "code")
	private long code;

	@NotNull
	@Column(name = "pre_name")
	private String privelageName;

	// adding relationship between tables users and sys_privelages
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_privelage", joinColumns = @JoinColumn(name = "privelage_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
	private List<User> user;

	public SysPrivelage() {
	}

	public SysPrivelage(int code, String privelageName) {
		this.code = code;
		this.privelageName = privelageName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getCode() {
		return code;
	}

	public void setCode(long code) {
		this.code = code;
	}

	public String getPrivelageName() {
		return privelageName;
	}

	public void setPrivelageName(String privelageName) {
		this.privelageName = privelageName;
	}

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "SysPrivelage [id=" + id + ", code=" + code + ", privelageName=" + privelageName + ", user=" + user
				+ "]";
	}

}
