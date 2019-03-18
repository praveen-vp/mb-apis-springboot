package com.pvp.bank.app.bankapi.login.services.imp;

import com.pvp.bank.app.bankapi.appconstants.APIConstants;
import com.pvp.bank.app.bankapi.appconstants.Appconstants;
import com.pvp.bank.app.bankapi.exceptions.BankException;
import com.pvp.bank.app.bankapi.login.httpapi.NBPasswordAPIService;
import com.pvp.bank.app.bankapi.login.services.VerifyNBDetails;
import com.pvp.bank.app.bankapi.models.HttpReqModel;
import com.pvp.bank.app.bankapi.models.HttpRespModel;
import org.springframework.stereotype.Service;

@Service
public class VerifyNBPasswordService implements VerifyNBDetails {

    private final NBPasswordAPIService nbPasswordAPIService;

    public VerifyNBPasswordService() {
        this.nbPasswordAPIService = new NBPasswordAPIService(new HttpReqModel(APIConstants.NB_PASSWORD_API_URL));
    }

    @Override
    public Boolean verifyNBPassword(String nbUserId, String nbPassword) throws BankException {
        try {
            // API Call for the nb password
            HttpRespModel response = nbPasswordAPIService.getResponseFromAPI();
            // validate thew response and return true or false;
            return response.getApiRespCode().equalsIgnoreCase(Appconstants.SUCCESS);
        } catch (Exception e) {
            throw new BankException(e.getLocalizedMessage());
        }
    }
}
