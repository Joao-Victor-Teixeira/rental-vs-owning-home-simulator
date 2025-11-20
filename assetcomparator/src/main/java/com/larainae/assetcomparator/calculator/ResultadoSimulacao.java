package com.larainae.assetcomparator.calculator;



public class ResultadoSimulacao {
    
    private double totalGastoAluguel;
    private double valorFinalImovel; 
    private String mensagem;

    // Construtor
    public ResultadoSimulacao(double totalGastoAluguel, double valorFinalImovel, String mensagem) {
        this.totalGastoAluguel = totalGastoAluguel;
        this.valorFinalImovel = valorFinalImovel;
        this.mensagem = mensagem;
    }

    public double getTotalGastoAluguel() { return totalGastoAluguel; }
    public double getValorFinalImovel() { return valorFinalImovel; }
    public String getMensagem() { return mensagem; }
}
