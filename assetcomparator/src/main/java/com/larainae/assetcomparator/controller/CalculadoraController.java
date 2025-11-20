package com.larainae.assetcomparator.controller;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.larainae.assetcomparator.calculator.ResultadoSimulacao;
import com.larainae.assetcomparator.services.CalculadoraService;


@Controller 
public class CalculadoraController {

    private final CalculadoraService service;

    public CalculadoraController(CalculadoraService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String mostrarPagina() {
        return "index"; 
    }

    @PostMapping("/calcular")
    public String calcular(
            @RequestParam("aluguel") double aluguel,
            @RequestParam("parcela") double parcela,
            @RequestParam("anos") int anos,
            Model model 
    ) {
        ResultadoSimulacao resultado = service.calcularCenario(aluguel, parcela, anos);

        model.addAttribute("resultado", resultado);

        return "index"; 
    }
}
