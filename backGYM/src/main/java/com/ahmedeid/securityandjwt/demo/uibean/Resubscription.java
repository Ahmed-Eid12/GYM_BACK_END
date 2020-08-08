package com.ahmedeid.securityandjwt.demo.uibean;

import java.util.Date;

public class Resubscription {

	private int amountPaid;
	private int amountRest;
	private Date modifiedDate;

	public Resubscription() {
		super();
	}

	public int getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(int amountPaid) {
		this.amountPaid = amountPaid;
	}

	public int getAmountRest() {
		return amountRest;
	}

	public void setAmountRest(int amountRest) {
		this.amountRest = amountRest;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

}
