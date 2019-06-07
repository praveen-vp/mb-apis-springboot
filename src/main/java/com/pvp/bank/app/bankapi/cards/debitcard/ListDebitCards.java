package com.pvp.bank.app.bankapi.cards.debitcard;

import java.util.HashMap;

public interface ListDebitCards<T> {

    HashMap<String, T> listDebitCards(Long crn);
}
