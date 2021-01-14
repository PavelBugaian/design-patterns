package com.pbugaian.patterns;

import com.pbugaian.entities.AccountEntity;

import java.util.ArrayList;
import java.util.List;

public class AccountsStore {
	private static AccountsStore instance = null;
	private List<AccountEntity> accounts;

	private AccountsStore() {
		accounts = new ArrayList<AccountEntity>();
	}

	public static AccountsStore getInstance() {
		if (instance == null) {
			instance = new AccountsStore();
		}

		return instance;
	}
	
	public AccountsStore add(AccountEntity account) {
		accounts.add(account);
		return this;
	}
	
	public AccountEntity getAccountById(String accountId) {
		for (AccountEntity account : accounts) {
			if (account.getId() == accountId) {
				return account;
			}
		}

		return null;
	}
}
