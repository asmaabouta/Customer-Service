package com.asmaa.customerservice.mappers;

import com.asmaa.customerservice.dto.CustomerRequestDTO;
import com.asmaa.customerservice.dto.CustomerResponseDTO;
import com.asmaa.customerservice.entities.Customer;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-11-13T18:01:13+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_301 (Oracle Corporation)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public CustomerResponseDTO customerToCustomerDTO(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerResponseDTO customerResponseDTO = new CustomerResponseDTO();

        customerResponseDTO.setId( customer.getId() );
        customerResponseDTO.setName( customer.getName() );
        customerResponseDTO.setEmail( customer.getEmail() );

        return customerResponseDTO;
    }

    @Override
    public Customer CustomerDTOToCustomer(CustomerRequestDTO customerRequestDTO) {
        if ( customerRequestDTO == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setId( customerRequestDTO.getId() );
        customer.setName( customerRequestDTO.getName() );
        customer.setEmail( customerRequestDTO.getEmail() );

        return customer;
    }
}
