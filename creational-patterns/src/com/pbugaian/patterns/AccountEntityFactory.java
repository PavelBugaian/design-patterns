package com.pbugaian.patterns;

import com.afishr.entities.AccountEntity;
import com.afishr.entities.ActivityEntity;
import com.afishr.entities.ActivityWindowEntity;
import com.afishr.entities.MoneyEntity;

import java.util.ArrayList;


public class AccountEntityFactory {

	public static AccountEntity makeAccountEntity(String accountId, Double initialBalance) {
		return new AccountEntity(accountId, MoneyEntity.of(initialBalance), new ActivityWindowEntity(new ArrayList<ActivityEntity>()));
	}
}
