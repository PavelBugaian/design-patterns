package com.pbugaian.entities;

import com.pbugaian.patterns.AccountEntityFactory;

import java.util.ArrayList;
import java.util.Date;

public class AccountEntity {
	private final String id;
	private final MoneyEntity baseLineBalance;
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

	public void withdraw(MoneyEntity money, String targetAccountId) {
		if (!this.mayWithdrawMoney(money)) {
			return;
		}

		ActivityEntity withdrawal = new ActivityEntity(
			getId(),
			getId(),
			targetAccountId,
			new Date(),
			money
		);

		this.activityWindow.addActivity(withdrawal);
	}

	public void deposit(MoneyEntity money, String sourceAccountId) {
		ActivityEntity deposit = new ActivityEntity(
			getId(),
			sourceAccountId,
			getId(),
			new Date(),
			money
		);

		this.activityWindow.addActivity(deposit);
	}

	public AccountEntity copy(String newAccountId) {
		AccountEntity newAccount = AccountEntityFactory.makeAccountEntity(newAccountId, this.baseLineBalance.getAmount());
		newAccount.activityWindow = new ActivityWindowEntity(new ArrayList<ActivityEntity>(this.activityWindow.getActivities()));

		return newAccount;
	}

	private boolean mayWithdrawMoney(MoneyEntity money) {
		return MoneyEntity.add(this.calculateBalance(), money.negate()).isPositiveOrZero();
	}
}
