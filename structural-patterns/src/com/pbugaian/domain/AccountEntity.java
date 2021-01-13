package com.pbugaian.domain;

import java.util.ArrayList;
import java.util.Date;

public class AccountEntity {
	private String id;
	private MoneyEntity baseLineBalance;
	private ActivityWindowEntity activityWindow;

	public AccountEntity(String id, MoneyEntity baseLineBalance, ActivityWindowEntity activityWindow) {
		this.id = id;
		this.baseLineBalance = baseLineBalance;
		this.activityWindow = activityWindow;
	}

	public String getId() {
		return id;
	}

	public MoneyEntity getBaseLineBalance() {
		return baseLineBalance;
	}

	public ActivityWindowEntity getActivityWindow() {
		return activityWindow;
	}

	public MoneyEntity calculateBalance() {
		return MoneyEntity.add(
			this.baseLineBalance,
			this.activityWindow.calculateBalance(this.id)
		);
	}

	public boolean withdraw(MoneyEntity money, String targetAccountId) {
		if (!this.mayWithdrawMoney(money)) {
			return false;
		}

		ActivityEntity withdrawal = new ActivityEntity(
			getId(),
			getId(),
			targetAccountId,
			new Date(),
			money
		);

		this.activityWindow.addActivity(withdrawal);
		return true;
	}

	public boolean deposit(MoneyEntity money, String sourceAccountId) {
		ActivityEntity deposit = new ActivityEntity(
			getId(),
			sourceAccountId,
			getId(),
			new Date(),
			money
		);

		this.activityWindow.addActivity(deposit);
		return true;
	}

	private boolean mayWithdrawMoney(MoneyEntity money) {
		return MoneyEntity.add(this.calculateBalance(), money.negate()).isPositiveOrZero();
	}
}
