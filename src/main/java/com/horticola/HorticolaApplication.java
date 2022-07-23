package com.horticola;

import com.horticola.entity.TipoVegetal;
import com.horticola.repository.TipoVegetalRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class HorticolaApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                SpringApplication.run(HorticolaApplication.class, args);
        TipoVegetalRepository repository =
                context.getBean(TipoVegetalRepository.class);
        TipoVegetal tipoVegetal = new TipoVegetal("Folhagem");

        repository.save(tipoVegetal);
    }

}
