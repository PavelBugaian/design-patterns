package com.pbugaian.entities;

public class MoneyEntity {
	private final double amount;

	public MoneyEntity (double amount) {
		this.amount = amount;
	}

	public double getAmount() {
		return amount;
	}

	public MoneyEntity negate() {
		return new MoneyEntity(-getAmount());
	}

	public boolean isPositiveOrZero() {
		return getAmount() >= 0;
	}

	static public MoneyEntity ZERO() {
		return new MoneyEntity(0);
	}

	static public MoneyEntity of(double value) {
		return new MoneyEntity(value);
	}

	static public MoneyEntity add(MoneyEntity a, MoneyEntity b) {
		return new MoneyEntity(a.getAmount() + b.getAmount());
	}
}
