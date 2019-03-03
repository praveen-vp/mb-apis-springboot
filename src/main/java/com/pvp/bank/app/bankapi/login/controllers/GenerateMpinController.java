package com.pvp.bank.app.bankapi.login.controllers;

import com.pvp.bank.app.bankapi.login.services.imp.GenerateMpinService;
import com.pvp.bank.app.bankapi.models.Customer;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Data
@Controller
public class GenerateMpinController {

    @Autowired
    private final GenerateMpinService generateMpinService;

    @RequestMapping("/GenerateMpin")
    public Boolean generateMpin(Customer customer) {
        return generateMpinService.generateMpin(customer);
    }
}
