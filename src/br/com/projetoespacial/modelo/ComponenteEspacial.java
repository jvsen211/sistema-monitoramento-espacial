package br.com.projetoespacial.modelo;

/*
 * Classe abstrata responsável por representar componentes gerais da estação espacial.
 * Conceitos aplicados:
 * Abstração e Herança
 */
public abstract class ComponenteEspacial {

    // Atributos comuns aos componentes
    private String id;
    private String nome;
    private double temperatura;
    private boolean status;

    /*
     * Construtor principal
     */
    public ComponenteEspacial(String id, String nome) {

        this.id = id;
        this.nome = nome;

        // Componente inicia desligado
        this.status = false;

        // Temperatura padrão
        this.temperatura = 20.0;
    }

    /*
     * Liga o componente
     */
    public void ligar() {

        this.status = true;

        System.out.println(
                "Componente '" + nome +
                        "' (ID: " + id + ") LIGADO."
        );
    }

    /*
     * Desliga o componente
     */
    public void desligar() {

        this.status = false;

        System.out.println(
                "Componente '" + nome +
                        "' (ID: " + id + ") DESLIGADO."
        );
    }

    /*
     * Exibe informações gerais do componente
     */
    public void exibirStatus() {

        System.out.println(
                "----- STATUS DO COMPONENTE -----"
        );

        System.out.println("ID: " + id);

        System.out.println("Nome: " + nome);

        System.out.println(
                "Status: " +
                        (status ? "LIGADO" : "DESLIGADO")
        );

        System.out.println(
                "Temperatura: " +
                        String.format("%.2f", temperatura) +
                        " °C"
        );

        // Chama o método abstrato
        diagnosticar();
    }

    //  GETTERS E SETTERS

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    /*
     * Retorna se o componente está ligado
     */
    public boolean isLigado() {
        return status;
    }

    /*
     * Método abstrato obrigatório
     * para todas as subclasses
     */
    public abstract void diagnosticar();
}

