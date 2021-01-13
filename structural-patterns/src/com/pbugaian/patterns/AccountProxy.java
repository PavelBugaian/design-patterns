package com.pbugaian.patterns;

import com.afishr.domain.AccountEntity;
import com.afishr.domain.ActivityWindowEntity;
import com.afishr.domain.MoneyEntity;

public class AccountProxy extends AccountEntity {
  AccountEntity account;

  public AccountProxy(AccountEntity account) {
    super(account.getId(), account.getBaseLineBalance(), account.getActivityWindow());
    this.account = account;
  }

  @Override
  public boolean withdraw(MoneyEntity money, String targetAccountId) {
    System.out.println("Making secret security checks here...");
    return account.withdraw(money, targetAccountId);
  }
}
