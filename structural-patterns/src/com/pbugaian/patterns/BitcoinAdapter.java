package com.pbugaian.patterns;

import com.pbugaian.domain.BitcoinEntity;
import com.pbugaian.domain.MoneyEntity;

public class BitcoinAdapter extends MoneyEntity {
  BitcoinEntity bitcoin;

  public BitcoinAdapter(BitcoinEntity bitcoin) {
    super(bitcoin.calculateHashAmount());
    this.bitcoin = bitcoin;
  }

  @Override
  public double getAmount() {
    return bitcoin.calculateHashAmount();
  }
}
