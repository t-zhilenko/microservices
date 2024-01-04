package com.frank.message.dto;

/**
 *
 * @param accountNumber
 * @param name
 * @param email
 * @param mobileNumber
 */
public record AccountsMsgDTO(Long accountNumber, String name,
                             String email, String mobileNumber) {
}
