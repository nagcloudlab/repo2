package com.example;

import com.example.service.TransferService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MyPayServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyPayServiceApplication.class, args);
    }


//    @Bean
//    public CommandLineRunner commandLineRunner(TransferService transferService){
//        return  args->{
//            transferService.transfer(100.00,"1","2");
//        };
//    }

}
