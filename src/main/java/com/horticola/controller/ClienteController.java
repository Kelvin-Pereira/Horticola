package com.horticola.controller;

import com.horticola.ClienteDTO;
import com.horticola.entity.Cliente;
import com.horticola.service.ClienteService;
import lombok.RequiredArgsConstructor;
import ma.glasnost.orika.MapperFacade;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cliente")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService service;

    private final MapperFacade mapper;

    // TODO mapper Page<Object> to Page<ObjectDTO>
    @GetMapping
    public String cliente(Model model, @PageableDefault Pageable pageable) {
        model.addAttribute("clientes", service.listar(pageable));
        return "Cliente";
    }

    @PostMapping
    public String salvar(@RequestBody ClienteDTO clienteDTO, Model model) {
        model.addAttribute("cliente", mapper.map(service.salvar(mapper.map(clienteDTO, Cliente.class)), ClienteDTO.class));
        return "Cliente";
    }

    @GetMapping("/{id}")
    public String buscarPorId(@PathVariable("id") Long id, Model model) {
        model.addAttribute("cliente", service.buscarPorId(id).orElseThrow());
        return "Cliente";
    }

    @DeleteMapping("/{id}")
    public String remover(@PathVariable("id") Long id) {
        service.buscarPorId(id).map(cliente -> {
            service.remover(cliente);
            return Void.TYPE;
        }).orElseThrow();
        return "Cliente";
    }

    @PutMapping("/{id}")
    public String atualizar(@PathVariable("id") Long id, @RequestBody ClienteDTO clienteDTO){
        service.buscarPorId(id).map(clienteBase  -> {
            mapper.map(clienteDTO, clienteBase);
            service.salvar(clienteBase);
            return Void.TYPE;
        }).orElseThrow();
        return "Cliente";
    }

}
