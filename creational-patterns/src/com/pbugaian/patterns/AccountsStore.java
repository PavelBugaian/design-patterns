package com.pbugaian.patterns;

import com.pbugaian.entities.AccountEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AccountsStore {
	private static AccountsStore instance = null;
	private final List<AccountEntity> accounts;

	private AccountsStore() {
		accounts = new ArrayList<AccountEntity>();
	}

	public static AccountsStore getInstance() {
		if (instance == null) {
			instance = new AccountsStore();
		}

		return instance;
	}
	
	public void add(AccountEntity account) {
		accounts.add(account);
	}
	
	public AccountEntity getAccountById(String accountId) {
		for (AccountEntity account : accounts) {
			if (Objects.equals(account.getId(), accountId)) {
				return account;
			}
		}

		return null;
	}
}
