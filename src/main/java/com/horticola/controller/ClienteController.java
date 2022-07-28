package com.horticola.controller;

import com.horticola.ClienteDTO;
import com.horticola.entity.Cliente;
import com.horticola.service.ClienteService;
import lombok.RequiredArgsConstructor;
import ma.glasnost.orika.MapperFacade;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cliente")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService service;

    private final MapperFacade mapper;

    @GetMapping("/listar")
    public String listar() {
        return "listar";
    }

    @GetMapping("/cadastrar")
    public String cadastro() {
        return "/cliente/cadastro";
    }

    @PostMapping
    public String salvar(@ModelAttribute ClienteDTO clienteDTO, Model model) {
        service.salvar(mapper.map(clienteDTO, Cliente.class));
        model.addAttribute("clientes", mapper.mapAsList(service.listar(), ClienteDTO.class));
        return "listar";
    }

    @GetMapping("/{id}")
    public String buscarPorId(@PathVariable("id") Long id, Model model) {
        model.addAttribute("cliente", service.buscarPorId(id).orElseThrow());
        return "/cliente";
    }

    @DeleteMapping("/{id}")
    public String remover(@PathVariable("id") Long id) {
        service.buscarPorId(id).map(cliente -> {
            service.remover(cliente);
            return Void.TYPE;
        }).orElseThrow();
        return "/cliente";
    }

    @PutMapping("/{id}")
    public String atualizar(@PathVariable("id") Long id, @RequestBody ClienteDTO clienteDTO) {
        service.buscarPorId(id).map(clienteBase -> {
            mapper.map(clienteDTO, clienteBase);
            service.salvar(clienteBase);
            return Void.TYPE;
        }).orElseThrow();
        return "/cliente";
    }

}
