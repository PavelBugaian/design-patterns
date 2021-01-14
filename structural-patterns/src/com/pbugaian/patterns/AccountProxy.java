package com.pbugaian.patterns;

import com.pbugaian.domain.AccountEntity;
import com.pbugaian.domain.ActivityWindowEntity;
import com.pbugaian.domain.MoneyEntity;

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
