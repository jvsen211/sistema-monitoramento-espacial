package br.com.projetoespacial.modelo;

import java.util.Random;

/*
 * Classe responsável pelo sensor de temperatura.
 *
 * Herda características da classe ComponenteEspacial e implementa a interface Sensor.
 *
 * Conceitos aplicados:
 * Herança, Interface e Polimorfismo
 */
public class SensorDeTemperatura extends ComponenteEspacial implements Sensor {

    // Valor atual lido pelo sensor
    private double valorAtual;

    // Limite de alerta da temperatura
    private double limiteAlerta;

    // Gerador de valores aleatórios
    private Random random;


    public SensorDeTemperatura(String id) {

        // Chama construtor da classe mãe
        super(id, "Sensor de Temperatura");

        // Limite padrão
        this.limiteAlerta = 80.0;

        // Inicializa gerador aleatório
        this.random = new Random();

        // Temperatura inicial
        this.valorAtual = 20.0;
    }

    /*
     * Simula leitura da temperatura
     * usando valores aleatórios
     */
    @Override
    public double lerValor() {
        valorAtual = 15 + (random.nextDouble() * 105);
        return valorAtual;
    }


    // Verifica se o sensor está ligado
    @Override
    public boolean verificarFuncionamento() {
        return isLigado();
    }


    //Define novo limite de alerta
    @Override
    public void setLimiteAlerta(double limite) {
        this.limiteAlerta = limite;
    }

    //Retorna o tipo do sensor
    @Override
    public String getTipo() {
        return "Temperatura";
    }


    //Retorna unidade de medida
    @Override
    public String getUnidade() {
        return "°C";
    }

    //Realiza diagnóstico do sensor e exibe níveis de alerta
    @Override
    public void diagnosticar() {

        System.out.println("Temperatura atual: " + String.format("%.2f", valorAtual) + " °C");

        // Nível de atenção
        if (valorAtual >= 60 && valorAtual < limiteAlerta) {
            System.out.println("[ATENÇÃO] Temperatura próxima ao limite.");
        }

        // Limite atingido
        else if (valorAtual == limiteAlerta) {
            System.out.println("[ALERTA] Limite de temperatura atingido.");
        }

        // Temperatura crítica
        else if (valorAtual > limiteAlerta) {
            System.out.println("[CRÍTICO] Temperatura acima do limite de " + limiteAlerta + " °C");
        }
    }
}

