package com.pvp.bank.app.bankapi.cards.creditcard;

import java.util.HashMap;

public interface ListCreditCards<T> {

    HashMap<String, T> creditCardList(Long crn);

}
