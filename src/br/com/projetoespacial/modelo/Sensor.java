
package br.com.projetoespacial.modelo;

/*
 * Interface responsável por definir o comportamento padrão dos sensores.
 * Conceito aplicado:
 * Interface / Polimorfismo
 */
public interface Sensor {

    // Realiza leitura do sensor
    double lerValor();

    // Verifica se o sensor está funcionando
    boolean verificarFuncionamento();

    // Define limite de alerta
    void setLimiteAlerta(double limite);

    // Retorna o tipo do sensor
    String getTipo();

    // Retorna unidade de medida
    String getUnidade();
}

