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
@Table(name = "sys_exercise_type")
public class SysExerciseType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "code")
	private long code;

	@NotNull
	@Column(name = "exercise_type_name")
	private String exerciseTypeName;

	public SysExerciseType() {
	}

	public SysExerciseType(int code, String exerciseTypeName) {
		this.code = code;
		this.exerciseTypeName = exerciseTypeName;
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

	public String getExerciseTypeName() {
		return exerciseTypeName;
	}

	public void setExerciseTypeName(String exerciseTypeName) {
		this.exerciseTypeName = exerciseTypeName;
	}

	@Override
	public String toString() {
		return "SysExerciseType [id=" + id + ", code=" + code + ", exerciseTypeName=" + exerciseTypeName + "]";
	}

}
