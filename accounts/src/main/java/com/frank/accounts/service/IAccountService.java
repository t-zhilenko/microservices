package com.frank.accounts.service;

import com.frank.accounts.dto.CustomerDTO;

public interface IAccountService {

    /**
     * @param customerDTO - CustomerDTO Object
     */
    void createAccount(CustomerDTO customerDTO);

    /**
     * @param mobileNumber - Input Mobile Number
     * @return Accounts details based on a given mobileNumber
     */
    CustomerDTO fetchAccount(String mobileNumber);

    /**
     * @param customerDTO - CustomerDTO Object
     * @return boolean indicating if the update of Account details is successful or not
     */
    boolean updateAccount(CustomerDTO customerDTO);

    /**
     * @param mobileNumber - Input mobile number
     * @return boolean indicating if the delete of Account details is successful or not
     */
    boolean deleteAccount(String mobileNumber);

    /**
     *
     * @param accountNumber Long
     * @return boolean indicating if the update of the communication status is successful or not
     */
    boolean updateCommunicationStatus(Long accountNumber);

}

