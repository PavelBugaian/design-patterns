package com.pbugaian.domain;

import java.util.List;

public class ActivityWindowEntity {
	private List<ActivityEntity> activities;

	public List<ActivityEntity> getActivities() {
		return activities;
	}

	public ActivityWindowEntity(List<ActivityEntity> activities) {
		this.activities = activities;
	}

	public ActivityWindowEntity addActivity(ActivityEntity activity) {
		this.activities.add(activity);
		return this;
	}

	public MoneyEntity calculateBalance(String accountId) {
		MoneyEntity depositBalance = this.activities.stream()
			.filter(activity -> activity.getTargetAccountId().equals(accountId))
			.map(ActivityEntity::getMoney)
			.reduce(MoneyEntity.ZERO(), MoneyEntity::add);

		MoneyEntity withdrawalBalance = this.activities.stream()
			.filter(activity -> activity.getSourceAccountId().equals(accountId))
			.map(ActivityEntity::getMoney)
			.reduce(MoneyEntity.ZERO(), MoneyEntity::add);

		return MoneyEntity.add(depositBalance, withdrawalBalance.negate());
	}
}
