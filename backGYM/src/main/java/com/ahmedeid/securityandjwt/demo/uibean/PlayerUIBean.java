package com.ahmedeid.securityandjwt.demo.uibean;

import java.util.Date;

public class PlayerUIBean {

	private String id;
	private long code;
	private String playerName;
	private String email;
	private String address;
	private String passportNumber;
	private String cardNumber;
	private String phone;
	private int modifiedBy;
	private String playerImage;
	private String playerChampionships;
	private int amountPaid;
	private int subscriptionNo;
	private Date dateModify;
	private int sysSubtype;
	private int sysExerciseType;
	private int sysGender;
	private int height;
	private int weight;
	private int age;
	private int amountRest;
	private int hulfMonthNo;

	public PlayerUIBean() {
		super();
	}

	public PlayerUIBean(long code, String playerName, String email, String address, String passportNumber,
			String cardNumber, String phone, int modifiedBy, String playerImage, String playerChampionships,
			int amountPaid, int subscriptionNo, Date dateModify, int sysSubtypeId, int sysExerciseTypeId,
			int sysGenderId) {
		super();
		this.code = code;
		this.playerName = playerName;
		this.email = email;
		this.address = address;
		this.passportNumber = passportNumber;
		this.cardNumber = cardNumber;
		this.phone = phone;
		this.modifiedBy = modifiedBy;
		this.playerImage = playerImage;
		this.playerChampionships = playerChampionships;
		this.amountPaid = amountPaid;
		this.subscriptionNo = subscriptionNo;
		this.dateModify = dateModify;

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public int getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(int modifiedBy) {
		this.modifiedBy = modifiedBy;
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

	public int getSubscriptionNo() {
		return subscriptionNo;
	}

	public void setSubscriptionNo(int subscriptionNo) {
		this.subscriptionNo = subscriptionNo;
	}

	public Date getDateModify() {
		return dateModify;
	}

	public void setDateModify(Date dateModify) {
		this.dateModify = dateModify;
	}

	public int getSysSubtype() {
		return sysSubtype;
	}

	public void setSysSubtype(int sysSubtype) {
		this.sysSubtype = sysSubtype;
	}

	public int getSysExerciseType() {
		return sysExerciseType;
	}

	public void setSysExerciseType(int sysExerciseType) {
		this.sysExerciseType = sysExerciseType;
	}

	public int getSysGender() {
		return sysGender;
	}

	public void setSysGender(int sysGender) {
		this.sysGender = sysGender;
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

}
