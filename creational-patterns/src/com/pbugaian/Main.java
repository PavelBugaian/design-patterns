package com.pbugaian;

import com.pbugaian.entities.AccountEntity;
import com.pbugaian.entities.MoneyEntity;
import com.pbugaian.patterns.AccountEntityFactory;
import com.pbugaian.patterns.AccountsStore;

public class Main {

	public static void main(String[] args) {
		/* Simple Factory design pattern */
		AccountEntity a = AccountEntityFactory.makeAccountEntity("alex", 100d);

		/* Singleton design pattern */
		AccountsStore store = AccountsStore.getInstance();
		store.add(a);

		/* Prototype design pattern */
		store.add(a.copy("alice"));

		/* ... */

		AccountsStore another_store = AccountsStore.getInstance();

		AccountEntity alex = another_store.getAccountById("alex");
		AccountEntity alice = another_store.getAccountById("alice");

		System.out.println("Initial state");
		logAccountState(alex);
		logAccountState(alice);

		transferMoney(alex, alice, 50d);

		System.out.println();

		System.out.println("'alex' transferred 50 money units to 'alice'");
		logAccountState(alex);
		logAccountState(alice);
	}

	public static void logAccountState(AccountEntity account) {
		System.out.print(account.getId() + ": ");
		System.out.println(account.calculateBalance().getAmount());
	}

	public static void transferMoney(AccountEntity sourceAccount, AccountEntity targetAccoutn, Double amount) {
		sourceAccount.withdraw(MoneyEntity.of(amount), targetAccoutn.getId());
		targetAccoutn.deposit(MoneyEntity.of(amount), sourceAccount.getId());
	}
}