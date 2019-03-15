package com.pvp.bank.app.bankapi.login.services.imp;

import com.pvp.bank.app.bankapi.login.services.VerifyNBDetails;
import org.springframework.stereotype.Service;

@Service
public class VerifyNBPasswordService implements VerifyNBDetails {

    @Override
    public Boolean verifyNBPassword(String nbUserId, String nbPassword) {

        // API Call for the nb password

        return true;
    }
}
