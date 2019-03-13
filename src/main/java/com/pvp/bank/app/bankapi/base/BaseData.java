package com.pvp.bank.app.bankapi.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;
import org.json.JSONObject;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@EqualsAndHashCode(callSuper = false)
@MappedSuperclass
@AllArgsConstructor
@Getter
@Setter
@ToString
public class BaseData extends JSONObject {

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;
    private String userId;

    public BaseData() {
    }

    @Builder(builderMethodName = "BaseDataBuilder")
    public BaseData(String userId) {
        super();
        this.userId = userId;
    }

    public String toJson() {
        try {
            return new ObjectMapper().writeValueAsString(this);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
