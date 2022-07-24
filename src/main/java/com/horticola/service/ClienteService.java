package com.horticola.service;

import com.horticola.entity.Cliente;
import com.horticola.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository repository;

    public Cliente salvar(Cliente cliente) {
        return repository.save(cliente);
    }

    public Page<Cliente> listar(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Optional<Cliente> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public void remover(Cliente cliente){
        repository.delete(cliente);
    }

}
