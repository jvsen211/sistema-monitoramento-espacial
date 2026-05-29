
        package br.com.projetoespacial.modelo;

import java.util.Random;

/*
 * Classe responsável pelo sensor de pressão.
 *
 * Herda características da classe ComponenteEspacial e implementa a interface Sensor.
 *
 * Conceitos aplicados:
 * Herança, Interface e Polimorfismo
 */
public class SensorDePressao extends ComponenteEspacial implements Sensor {

    // Valor atual da pressão
    private double valorAtual;

    // Limite máximo seguro
    private double limiteAlerta;

    // Gerador de valores aleatórios
    private Random random;


    public SensorDePressao(String id) {

        // Chama construtor da classe mãe
        super(id, "Sensor de Pressão");

        // Inicializa gerador aleatório
        this.random = new Random();

        // Pressão atmosférica inicial
        this.valorAtual = 101325.0;

        // Limite padrão de alerta
        this.limiteAlerta = 120000.0;
    }

    /*
     * Realiza diagnóstico da pressão
     * e exibe níveis de alerta
     */
    @Override
    public void diagnosticar() {

        System.out.println("Pressão atual: " + String.format("%.2f", valorAtual) + " Pa");
        // Nível de atenção
        if (valorAtual >= 100000 && valorAtual < limiteAlerta) {
            System.out.println("[ATENÇÃO] Pressão próxima ao limite.");
        }

        // Limite atingido
        else if (valorAtual == limiteAlerta) {

            System.out.println("[ALERTA] Limite de pressão atingido.");
        }

        // Pressão crítica
        else if (valorAtual > limiteAlerta) {

            System.out.println("[CRÍTICO] Pressão acima do limite de "+ limiteAlerta + " Pa"
            );
        }
    }

    /*
     * Simula leitura da pressão
     * usando valores aleatórios
     */
    @Override
    public double lerValor() {
        valorAtual = 80000 + (random.nextDouble() * 70000);
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
        return "Pressão";
    }


     // Retorna unidade de medida
    @Override
    public String getUnidade() {
        return "Pa";
    }
}

