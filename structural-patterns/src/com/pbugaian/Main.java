package com.pbugaian;

import com.pbugaian.domain.AccountEntity;
import com.pbugaian.domain.ActivityWindowEntity;
import com.pbugaian.domain.BitcoinEntity;
import com.pbugaian.domain.MoneyEntity;
import com.pbugaian.patterns.AccountProxy;
import com.pbugaian.patterns.BitcoinAdapter;
import com.pbugaian.patterns.TransferFacade;

import java.util.ArrayList;

public class Main {

  public static void main(String[] args) {

    AccountEntity alex = new AccountProxy(new AccountEntity("alex", MoneyEntity.of(0), new ActivityWindowEntity(new ArrayList<>())));
    AccountEntity alice = new AccountEntity("alice", new BitcoinAdapter(new BitcoinEntity()), new ActivityWindowEntity(new ArrayList<>()));

    System.out.println("Initial state");
    logAccountState(alex);
    logAccountState(alice);

    TransferFacade.transferMoney(alex, alice, 50d);

    System.out.println();

    System.out.println("'alex' transferred 50 money units to 'alice'");
    logAccountState(alex);
    logAccountState(alice);
  }

  public static void logAccountState(AccountEntity account) {
    System.out.print(account.getId() + ": ");
    System.out.println(account.calculateBalance().getAmount());
  }

}