package com.pvp.bank.app.bankapi.login.services.imp;

import com.pvp.bank.app.bankapi.appconstants.Appconstants;
import com.pvp.bank.app.bankapi.exceptions.BankException;
import com.pvp.bank.app.bankapi.login.services.VerifyDCDetails;
import com.pvp.bank.app.bankapi.models.DCDetails;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class VerifyDCDetailService implements VerifyDCDetails {

    private final Date today = new Date();

    @Override
    public Boolean verifyDCPin(DCDetails details) throws BankException {

        if (validateDcDetails(details)) {
            // proceed to verify the dcPin details.
            // api call

            return true;

        } else {
            throw new BankException(Appconstants.INVALID_REQUEST);
        }
    }

    @Override
    public Boolean validateDcDetails(DCDetails dcDetails) throws BankException {
        // validateDcDetails the pattern of the dcNumber, cvv, expiry and pin.
        String dcNumString = String.valueOf(dcDetails.getDcNumber());

        Boolean status = (dcNumString != null && dcNumString.length() < 20)
                && ((dcDetails.getCvv() != null && dcDetails.getCvv() <= 999)
                && (dcDetails.getDcPin() != null && dcDetails.getDcPin() <= 999999));

        if (!status)
            throw new BankException(Appconstants.INVALID_REQUEST);

        // expiry date is valid or not
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date expiryDate = sdf.parse(dcDetails.getExpYear() + "-" + dcDetails.getExpMonth() + "-01");
            status = expiryDate.after(today);
        } catch (ParseException e) {
            throw new BankException(e.getLocalizedMessage());
        }

        if (!status)
            throw new BankException(Appconstants.INVALID_EXP_DATE);

        // validateDcDetails, provided dcNumber is valid for the userId.
        // API Call TODO
        return true;
    }

    @Override
    public void insertVerificationData(String userId, String appId) throws BankException {
        // insert verification data to the mpin gen validation table
    }
}
