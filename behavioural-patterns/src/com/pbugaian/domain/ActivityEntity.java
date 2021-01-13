package com.pbugaian.domain;

import java.util.Date;

public class ActivityEntity {
	private String ownerAccountId;
	private String sourceAccountId;
	private String targetAccountId;
	private Date timestamp;
	private MoneyEntity money;

	public ActivityEntity(
		String ownerAccountId,
		String sourceAccountId,
		String targetAccountId,
		Date timestamp,
		MoneyEntity money
	) {
		this.ownerAccountId = ownerAccountId;
		this.sourceAccountId = sourceAccountId;
		this.targetAccountId = targetAccountId;
		this.timestamp = timestamp;
		this.money = money;
	}

	public String getOwnerAccountId() {
		return ownerAccountId;
	}

	public String getSourceAccountId() {
		return sourceAccountId;
	}

	public String getTargetAccountId() {
		return targetAccountId;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public MoneyEntity getMoney() {
		return money;
	}
}
