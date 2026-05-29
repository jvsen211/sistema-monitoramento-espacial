package br.com.projetoespacial.modelo;

public class PropulsaoQuimica extends SistemaPropulsao {

    private double consumoCombustivel;

    public PropulsaoQuimica(String nome, double consumoCombustivel) {
        super(nome);
        this.consumoCombustivel = consumoCombustivel;
    }

    @Override
    public double calcularEmpuxo() {
        return potencia * 150;
    }
}