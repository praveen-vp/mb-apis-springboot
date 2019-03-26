package com.pvp.bank.app.bankapi.baseservice;

import com.pvp.bank.app.bankapi.models.BaseEntity;

public interface BaseService {

    Boolean verifyDetails();


    BaseEntity processDetails();
}
