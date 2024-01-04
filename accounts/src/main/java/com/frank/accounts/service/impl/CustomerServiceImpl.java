package com.frank.accounts.service.impl;

import com.frank.accounts.dto.*;
import com.frank.accounts.entity.Accounts;
import com.frank.accounts.entity.Customer;
import com.frank.accounts.exception.ResourceNotFoundException;
import com.frank.accounts.mapper.AccountMapper;
import com.frank.accounts.mapper.CustomerMapper;
import com.frank.accounts.repository.AccountRepository;
import com.frank.accounts.repository.CustomerRepository;
import com.frank.accounts.service.ICustomerService;
import com.frank.accounts.service.client.CardsFeignClient;
import com.frank.accounts.service.client.LoansFeignClient;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements ICustomerService {

    private AccountRepository accountRepository;
    private CustomerRepository customerRepository;
    private CardsFeignClient cardsFeignClient;
    private LoansFeignClient loansFeignClient;

    /**
     *
     * @param mobileNumber Input mobile number
     * @return Customer Details on a given mobile number
     */
    @Override
    public CustomerDetailsDTO fetchCustomerDetails(String mobileNumber, String correlationId) {

        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber)
        );

        Accounts accounts = accountRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
                () -> new ResourceNotFoundException("Account", "customerId", customer.getCustomerId().toString())
        );

        CustomerDetailsDTO customerDetailsDTO = CustomerMapper.mapToCustomerDetailsDTO(customer, new CustomerDetailsDTO());
        customerDetailsDTO.setAccountDTO(AccountMapper.mapToAccountsDto(accounts, new AccountDTO()));

        ResponseEntity<LoansDTO> loansDTOResponseEntity = loansFeignClient.fetchLoanDetails(correlationId, mobileNumber);
        if (loansDTOResponseEntity != null) {
            customerDetailsDTO.setLoansDTO(loansDTOResponseEntity.getBody());
        }

        ResponseEntity<CardsDTO> cardsDTOResponseEntity = cardsFeignClient.fetchCardDetails(correlationId, mobileNumber);
        if (cardsDTOResponseEntity != null) {
            customerDetailsDTO.setCardsDTO(cardsDTOResponseEntity.getBody());
        }

        return customerDetailsDTO;
    }
}
