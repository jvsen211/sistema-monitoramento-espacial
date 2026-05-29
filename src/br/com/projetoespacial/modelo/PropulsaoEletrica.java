package br.com.projetoespacial.modelo;

public class PropulsaoEletrica extends SistemaPropulsao {

    private double eficienciaEnergetica;

    public PropulsaoEletrica(String nome, double eficienciaEnergetica) {
        super(nome);
        this.eficienciaEnergetica = eficienciaEnergetica;
    }

    @Override
    public double calcularEmpuxo() {
        return potencia * 80 * eficienciaEnergetica;
    }
}