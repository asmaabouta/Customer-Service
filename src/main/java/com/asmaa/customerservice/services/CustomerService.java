package com.asmaa.customerservice.services;

import com.asmaa.customerservice.dto.CustomerRequestDTO;
import com.asmaa.customerservice.dto.CustomerResponseDTO;
import com.asmaa.customerservice.entities.Customer;

import java.util.List;

public interface CustomerService {
    CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO);
    CustomerResponseDTO getCustomer(String id);
    CustomerResponseDTO update(CustomerRequestDTO customerRequestDTO);
    List<CustomerResponseDTO> getAllCustomers();
}
