package com.horticola.config.database;

import com.horticola.entity.Vegetal;
import com.horticola.repository.VegetalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
@RequiredArgsConstructor
public class VegetalInitiationDatabase implements CommandLineRunner {

    private final VegetalRepository repository;

    @Override
    public void run(String... args) throws Exception {

        List<Vegetal> vegetals = Arrays.asList(
                new Vegetal("BETERRABA", 85),
                new Vegetal("MILHO VERDE", 110),
                new Vegetal("CENOURA", 90),
                new Vegetal("COUVE-FLOR", 100),
                new Vegetal("FEIJÃO-DE-VAGEM", 120),
                new Vegetal("QUIABO", 180),
                new Vegetal("REPOLHO", 110),
                new Vegetal("ERVILHA", 120),
                new Vegetal("PIMENTÃO", 180),
                new Vegetal("BATATA", 115),
                new Vegetal("TOMATE", 160),
                new Vegetal("ALFACE", 65)
        );

        repository.saveAll(vegetals);

    }
}
