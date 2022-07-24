package com.horticola.config.database;

import com.horticola.entity.Cliente;
import com.horticola.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
@RequiredArgsConstructor
public class ClienteInitiationDatabase implements CommandLineRunner {

    private final ClienteRepository repository;

    @Override
    public void run(String... args) throws Exception {

        List<Cliente> clientes = Arrays.asList(
                new Cliente("KELVIN BISERRA", "Fazenda Azul"),
                new Cliente("PEDRO DA SILVA", "CEF 14"),
                new Cliente("MARINA", "Mercado Palmeiras")
        );

        repository.saveAll(clientes);

    }
}
