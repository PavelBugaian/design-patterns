package com.pbugaian.entities;

import java.util.Date;

public class ActivityEntity {
	private final String ownerAccountId;
	private final String sourceAccountId;
	private final String targetAccountId;
	private final Date timestamp;
	private final MoneyEntity money;

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
