package br.com.projetoespacial.modelo;

/*
 * Classe abstrata responsável por representar os sistemas de propulsão da nave espacial.
 * Conceitos aplicados:
 * Abstração e Herança
 */
public abstract class SistemaPropulsao {

    // Nome do sistema de propulsão
    protected String nome;

    // Indica se o sistema está ligado
    protected boolean ligado;

    // Potência atual do motor
    protected double potencia;

    /*
     * Construtor principal da propulsão
     */
    public SistemaPropulsao(String nome) {

        this.nome = nome;

        // Sistema inicia desligado
        this.ligado = false;

        // Potência inicial
        this.potencia = 0;
    }

    //Liga o sistema de propulsão

    public void ligar() {

        ligado = true;

        System.out.println(
                nome + " ligado."
        );
    }

    /*
     * Desliga o sistema de propulsão
     */
    public void desligar() {

        ligado = false;

        // Zera a potência ao desligar
        potencia = 0;

        System.out.println(
                nome + " desligado."
        );
    }

    /*
     * Controla a aceleração do motor
     *
     * Validação:
     * potência deve estar entre 0 e 100
     */
    public void acelerar(double potencia) {

        if (potencia < 0 || potencia > 100) {

            System.out.println(
                    "Potência inválida!"
            );

            return;
        }

        // Atualiza potência atual
        this.potencia = potencia;

        System.out.println(
                nome + " acelerando em "
                        + potencia + "%"
        );
    }

    /*
     * Método abstrato responsável pelo cálculo do empuxo.
     * Cada tipo de propulsão terá seu próprio cálculo.
     */
    public abstract double calcularEmpuxo();
}

