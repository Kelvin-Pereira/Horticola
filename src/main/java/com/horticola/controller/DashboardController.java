package com.horticola.controller;

import com.horticola.repository.TipoVegetalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dashboard")
@RequiredArgsConstructor
public class DashboardController {

    private final TipoVegetalRepository repository;

    @GetMapping("/teste")
    public String teste(Model model) {
        model.addAttribute("tipos", repository.findAll());
        return "dashboard";
    }

}
