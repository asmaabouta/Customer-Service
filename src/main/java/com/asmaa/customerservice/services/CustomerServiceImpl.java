package com.asmaa.customerservice.services;

import com.asmaa.customerservice.dto.CustomerRequestDTO;
import com.asmaa.customerservice.dto.CustomerResponseDTO;
import com.asmaa.customerservice.entities.Customer;
import com.asmaa.customerservice.mappers.CustomerMapper;
import com.asmaa.customerservice.repositories.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
   //au lieu d'injecter les dependances avec @Autowired on la fait de cette maniere (constructeur)
    private CustomerRepository customerRepository;
    private CustomerMapper customerMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper){
        this.customerRepository=customerRepository;
        this.customerMapper = customerMapper;
    }
    @Override
    public CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO) {

        Customer customer=customerMapper.CustomerDTOToCustomer(customerRequestDTO);

        Customer saveCustomer=customerRepository.save(customer);

        CustomerResponseDTO customerResponseDTO=customerMapper.customerToCustomerDTO(saveCustomer);
        return customerResponseDTO;

    }

    @Override
    public CustomerResponseDTO getCustomer(String id) {
        Customer customer=customerRepository.findById(id).get();
        CustomerResponseDTO customerResponseDTO=customerMapper.customerToCustomerDTO(customer);
        return customerResponseDTO;
    }

    @Override
    public CustomerResponseDTO update(CustomerRequestDTO customerRequestDTO) {
     Customer customer=customerMapper.CustomerDTOToCustomer(customerRequestDTO);
     Customer updatedCustomer= customerRepository.save(customer);
     //Customer updatedCustomer= customerRepository.save(customer);
     return customerMapper.customerToCustomerDTO(updatedCustomer);
    }

    @Override
    public List<CustomerResponseDTO> getAllCustomers() {
        List<Customer> customerList=customerRepository.findAll();
        List<CustomerResponseDTO> customerResponseDTOList=customerList.stream()
                .map(cust -> customerMapper.customerToCustomerDTO(cust))
                .collect(Collectors.toList());
        return customerResponseDTOList;
    }
}
