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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "sys_subtype")
public class SysSubtype {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "code")
	private long code;

	@NotNull
	@Column(name = "subtype_name")
	private String subtypeName;

	public SysSubtype() {
	}

	public SysSubtype(int code, String subtypeName) {
		this.code = code;
		this.subtypeName = subtypeName;
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

	public String getSubtypeName() {
		return subtypeName;
	}

	public void setSubtypeName(String subtypeName) {
		this.subtypeName = subtypeName;
	}

	@Override
	public String toString() {
		return "SysSubtype [id=" + id + ", code=" + code + ", subtypeName=" + subtypeName + "]";
	}

}
