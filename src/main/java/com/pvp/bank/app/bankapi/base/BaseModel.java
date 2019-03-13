package com.pvp.bank.app.bankapi.base;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
    private Long reqTime = System.currentTimeMillis();
    private Long respTime;

    public String toJson() {
        try {
            return new ObjectMapper().writeValueAsString(this);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
