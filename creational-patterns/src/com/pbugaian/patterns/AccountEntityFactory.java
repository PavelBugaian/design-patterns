package com.pbugaian.patterns;

import com.pbugaian.entities.AccountEntity;
import com.pbugaian.entities.ActivityEntity;
import com.pbugaian.entities.ActivityWindowEntity;
import com.pbugaian.entities.MoneyEntity;

import java.util.ArrayList;

public class AccountEntityFactory {

	public static AccountEntity makeAccountEntity(String accountId, Double initialBalance) {
		return new AccountEntity(accountId, MoneyEntity.of(initialBalance), new ActivityWindowEntity(new ArrayList<ActivityEntity>()));
	}
}
