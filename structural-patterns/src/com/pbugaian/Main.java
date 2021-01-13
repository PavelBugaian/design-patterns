package com.pbugaian;

import com.afishr.domain.AccountEntity;
import com.afishr.domain.ActivityWindowEntity;
import com.afishr.domain.BitcoinEntity;
import com.afishr.domain.MoneyEntity;
import com.afishr.patterns.AccountProxy;
import com.afishr.patterns.BitcoinAdapter;
import com.afishr.patterns.TransferFacade;

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