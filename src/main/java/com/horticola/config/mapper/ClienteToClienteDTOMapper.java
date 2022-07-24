package com.horticola.config.mapper;

import com.horticola.ClienteDTO;
import com.horticola.entity.Cliente;
import dev.akkinoc.spring.boot.orika.OrikaMapperFactoryConfigurer;
import ma.glasnost.orika.MapperFactory;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

@Component
public class ClienteToClienteDTOMapper implements OrikaMapperFactoryConfigurer {
    @Override
    public void configure(@NotNull MapperFactory orikaMapperFactory) {
        orikaMapperFactory.classMap(Cliente.class, ClienteDTO.class)
                .byDefault()
                .register();
    }
}
