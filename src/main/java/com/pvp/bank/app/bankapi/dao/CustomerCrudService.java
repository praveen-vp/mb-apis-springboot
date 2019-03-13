package com.pvp.bank.app.bankapi.dao;

import com.pvp.bank.app.bankapi.models.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerCrudService extends CrudRepository<Customer, Long> {

    Integer getMobileByUserId(String userId);

}
