package com.frank.accounts.service;

import com.frank.accounts.dto.CustomerDetailsDTO;

public interface ICustomerService {

    /**
     *
     * @param mobileNumber Input mobile number
     * @return Customer Details on a given mobile number
     */
    CustomerDetailsDTO fetchCustomerDetails(String mobileNumber, String correlationId);
}
