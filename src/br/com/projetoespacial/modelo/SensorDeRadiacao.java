package br.com.projetoespacial.modelo;

import java.util.Random;

/*
 * Classe responsável pelo sensor de radiação.
 *
 * Herda características da classe ComponenteEspacial e implementa a interface Sensor.
 *
 * Conceitos aplicados:
 * Herança, Interface e Polimorfismo
 */
public class SensorDeRadiacao extends ComponenteEspacial implements Sensor {

    // Valor atual da radiação
    private double valorAtual;

    // Limite seguro de radiação
    private double limiteAlerta;

    // Gerador de valores aleatórios
    private Random random;


    public SensorDeRadiacao(String id) {

        // Chama construtor da classe mãe
        super(id, "Sensor de Radiação");

        // Limite padrão seguro
        this.limiteAlerta = 1.0;

        // Inicializa gerador aleatório
        this.random = new Random();

        // Valor inicial da radiação
        this.valorAtual = 0.0;
    }


    //Realiza diagnóstico da radiação e exibe níveis de alerta
    @Override
    public void diagnosticar() {

        System.out.println(
                "Radiação atual: " +
                        String.format("%.4f", valorAtual) +
                        " Sv/h"
        );

        // Nível de atenção
        if (valorAtual >= 0.7 &&
                valorAtual < limiteAlerta) {

            System.out.println(
                    "[ATENÇÃO] Radiação próxima ao limite."
            );
        }

        // Limite atingido
        else if (valorAtual == limiteAlerta) {

            System.out.println(
                    "[ALERTA] Níveis de radiação no limite seguro."
            );
        }

        // Radiação crítica
        else if (valorAtual > limiteAlerta) {

            System.out.println(
                    "[CRÍTICO] Radiação acima do limite de "
                            + limiteAlerta + " Sv/h"
            );
        }
    }

    /*
     * Simula leitura da radiaçãousando valores aleatórios
     */
    @Override
    public double lerValor() {
        valorAtual = 0.001 + (random.nextDouble() * 2.499);
        return valorAtual;
    }

    // Verifica se o sensor está ligado
    @Override
    public boolean verificarFuncionamento() {
        return isLigado();
    }

    // Define novo limite de alerta
    @Override
    public void setLimiteAlerta(double limite) {
        this.limiteAlerta = limite;
    }

    // Retorna o tipo do sensor
    @Override
    public String getTipo() {
        return "Radiação";
    }


    // Retorna unidade de medida
    @Override
    public String getUnidade() {
        return "Sv/h";
    }
}

