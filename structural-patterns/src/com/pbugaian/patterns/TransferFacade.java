package com.pbugaian.patterns;

import com.pbugaian.domain.AccountEntity;
import com.pbugaian.domain.MoneyEntity;

public class TransferFacade {

  public static void transferMoney(AccountEntity sourceAccount, AccountEntity targetAccount, Double amount) {
    sourceAccount.withdraw(MoneyEntity.of(amount), targetAccount.getId());
    targetAccount.deposit(MoneyEntity.of(amount), sourceAccount.getId());
  }

}
