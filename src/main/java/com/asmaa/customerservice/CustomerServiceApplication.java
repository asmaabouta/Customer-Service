package com.asmaa.customerservice;

import com.asmaa.customerservice.dto.CustomerRequestDTO;
import com.asmaa.customerservice.services.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CustomerService customerService){
        return args -> {
           customerService.save(new CustomerRequestDTO("C01", "adria", "adria@adria.com"));
           customerService.save(new CustomerRequestDTO("C02","Asmaa","asmaabouta99@gmail.com"));

           customerService.getAllCustomers()
            .forEach(cust->{
              //  log.info("Customer: {}", cust.getName());
                System.out.println(cust.toString());
           });
        };
    }

}
