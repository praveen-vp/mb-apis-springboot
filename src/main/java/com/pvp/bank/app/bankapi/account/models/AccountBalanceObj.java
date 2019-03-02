package com.pvp.bank.app.bankapi.account.models;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)
public class AccountBalanceObj extends BaseAcctObj {
    private @NonNull String accountName;
    private @NonNull double effBalance;
    private @NonNull double activeBalance;
}
