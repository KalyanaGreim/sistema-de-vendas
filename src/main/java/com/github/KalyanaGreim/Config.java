package com.github.KalyanaGreim;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@Development
public class Config {

    @Bean
    public CommandLineRunner execute(){
        return args -> {
            System.out.println("RODANDO A CONFIGURAÇÃO DE DESENVOLVIMENTO");

        };
    }

}
