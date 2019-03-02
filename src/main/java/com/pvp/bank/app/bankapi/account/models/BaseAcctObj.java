package com.pvp.bank.app.bankapi.account.models;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class BaseAcctObj {
    private @NonNull String acctNumber;
}
