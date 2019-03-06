package com.pvp.bank.app.bankapi.base;

import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode
@NoArgsConstructor
@Getter
@Setter
@ToString
@SuperBuilder
public class BaseModel {
    private String msgId;
}
