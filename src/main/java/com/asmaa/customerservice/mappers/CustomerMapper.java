package com.asmaa.customerservice.mappers;

import com.asmaa.customerservice.dto.CustomerRequestDTO;
import com.asmaa.customerservice.dto.CustomerResponseDTO;
import com.asmaa.customerservice.entities.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
CustomerResponseDTO customerToCustomerDTO(Customer customer);
Customer CustomerDTOToCustomer(CustomerRequestDTO customerRequestDTO);
}
