package com.larainae.assetcomparator.services;


import org.springframework.stereotype.Service;

import com.larainae.assetcomparator.calculator.ResultadoSimulacao;

import java.text.NumberFormat;
import java.util.Locale;

@Service 
public class CalculadoraService {

    public ResultadoSimulacao calcularCenario(double aluguelAtual, double parcelaFinanciamento, int anos) {
        
        double totalAluguel = 0;
        double aluguelComInflacao = aluguelAtual;
        double totalFinanciamento = 0;
        int meses = anos * 12;

        double taxaInflacaoAnual = 0.05; 

        for (int i = 1; i <= meses; i++) {
            
            totalAluguel += aluguelComInflacao;
            totalFinanciamento += parcelaFinanciamento;


            if (i % 12 == 0) {
                aluguelComInflacao = aluguelComInflacao + (aluguelComInflacao * taxaInflacaoAnual);
            }
        }

        
        NumberFormat dinheiro = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        String aluguelFormatado = dinheiro.format(totalAluguel);

        
        String mensagem = "Em " + anos + " anos, o senhor terá jogado " + aluguelFormatado + 
                          " no lixo com aluguel. Com o financiamento, esse dinheiro seria patrimônio seu.";

        return new ResultadoSimulacao(totalAluguel, totalFinanciamento, mensagem);
    }
}