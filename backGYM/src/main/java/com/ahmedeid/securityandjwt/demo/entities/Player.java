package com.ahmedeid.securityandjwt.demo.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "players")
public class Player {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "code")
	private long code;

	@NotNull
	@Column(name = "player_name")
	private String playerName;

	@Column(name = "email")
	private String email;

	@NotNull
	@Column(name = "address")
	private String address;

	@Column(name = "passport_number")
	private String passportNumber;

	@Column(name = "card_number")
	private String cardNumber;

	@NotNull
	@Column(name = "phone")
	private String phone;

	@NotNull
	@Column(name = "player_image")
	private String playerImage;

	@Column(name = "player_championships")
	private String playerChampionships;

	@NotNull
	@Column(name = "amount_paid")
	private int amountPaid;

	@NotNull
	@Column(name = "subscription_no")
	private int subscriptionNo;

	@NotNull
	@Column(name = "height")
	private int height;

	@NotNull
	@Column(name = "weight")
	private int weight;

	@NotNull
	@Column(name = "age")
	private int age;
	
	@NotNull
	@Column(name = "amount_rest")
	private int amountRest;
	
	@Column(name = "hulf_month_no")
	private int hulfMonthNo;

	@Column(name = "date_modify")
	private Date dateModify;

	// adding relationship users and usersection
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "subtype_id", referencedColumnName = "id")
	private SysSubtype sysSubtype;

	// adding relationship users and usersection
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "exercise_type_id", referencedColumnName = "id")
	private SysExerciseType sysExerciseType;

	// adding relationship users and usersection
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "gender_id", referencedColumnName = "id")
	private SysGender sysGender;

	// adding relationship users and usersection
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "modified_by_id", referencedColumnName = "id", nullable = false)
	private User user;

	public Player() {
		super();
	}

	public Player(long code, String playerName, String email, String address, String passportNumber, String cardNumber,
			String phone, int modifiedBy, String playerImage, String playerChampionships, int amountPaid,
			Date dateModify) {
		super();
		this.code = code;
		this.playerName = playerName;
		this.email = email;
		this.address = address;
		this.passportNumber = passportNumber;
		this.cardNumber = cardNumber;
		this.phone = phone;
		this.playerImage = playerImage;
		this.playerChampionships = playerChampionships;
		this.amountPaid = amountPaid;
		this.dateModify = dateModify;
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

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPlayerImage() {
		return playerImage;
	}

	public void setPlayerImage(String playerImage) {
		this.playerImage = playerImage;
	}

	public String getPlayerChampionships() {
		return playerChampionships;
	}

	public void setPlayerChampionships(String playerChampionships) {
		this.playerChampionships = playerChampionships;
	}

	public int getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(int amountPaid) {
		this.amountPaid = amountPaid;
	}

	public Date getDateModify() {
		return dateModify;
	}

	public void setDateModify(Date dateModify) {
		this.dateModify = dateModify;
	}

	public SysSubtype getSysSubtype() {
		return sysSubtype;
	}

	public void setSysSubtype(SysSubtype sysSubtype) {
		this.sysSubtype = sysSubtype;
	}

	public SysExerciseType getSysExerciseType() {
		return sysExerciseType;
	}

	public void setSysExerciseType(SysExerciseType sysExerciseType) {
		this.sysExerciseType = sysExerciseType;
	}

	public SysGender getSysGender() {
		return sysGender;
	}

	public void setSysGender(SysGender sysGender) {
		this.sysGender = sysGender;
	}

	public int getSubscriptionNo() {
		return subscriptionNo;
	}

	public void setSubscriptionNo(int subscriptionNo) {
		this.subscriptionNo = subscriptionNo;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getAmountRest() {
		return amountRest;
	}

	public void setAmountRest(int amountRest) {
		this.amountRest = amountRest;
	}

	public int getHulfMonthNo() {
		return hulfMonthNo;
	}

	public void setHulfMonthNo(int hulfMonthNo) {
		this.hulfMonthNo = hulfMonthNo;
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", code=" + code + ", playerName=" + playerName + ", email=" + email + ", address="
				+ address + ", passportNumber=" + passportNumber + ", cardNumber=" + cardNumber + ", phone=" + phone
				+ ", playerImage=" + playerImage + ", playerChampionships=" + playerChampionships + ", amountPaid="
				+ amountPaid + ", subscriptionNo=" + subscriptionNo + ", height=" + height + ", weight=" + weight
				+ ", age=" + age + ", dateModify=" + dateModify + ", sysSubtype=" + sysSubtype + ", sysExerciseType="
				+ sysExerciseType + ", sysGender=" + sysGender + ", user=" + user + "]";
	}

}
