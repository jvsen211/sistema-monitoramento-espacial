package br.com.projetoespacial.modelo;

public class DadosMissao {

    private String nomeMissao;
    private int numeroDeTripulantes;
    private double nivelCombustivel;
    private String trajetoria;
    private String codigoAcesso;
    private double coordenadaX;
    private double coordenadaY;
    private double coordenadaZ;

    public DadosMissao(String nomeMissao, int numeroDeTripulantes, String codigoAcesso) {
        this.nomeMissao = nomeMissao;
        this.numeroDeTripulantes = numeroDeTripulantes;
        this.nivelCombustivel = 100.0;
        this.trajetoria = "Órbita Terrestre Baixa";
        this.codigoAcesso = codigoAcesso;
        this.coordenadaX = 0.0;
        this.coordenadaY = 0.0;
        this.coordenadaZ = 0.0;
    }

    // getters públicos
    public String getNomeMissao() { return nomeMissao; }
    public int getNumeroDeTripulantes() { return numeroDeTripulantes; }
    public double getNivelCombustivel() { return nivelCombustivel; }
    public String getTrajetoria() { return trajetoria; }

    // getter restrito por senha
    public String getCoordenadas(String senhaInformada) {
        if (codigoAcesso.equals(senhaInformada)) {
            return "X: " + coordenadaX + " | Y: " + coordenadaY + " | Z: " + coordenadaZ;
        } else {
            return "ACESSO NEGADO! Código incorreto.";
        }
    }

    // setters com validação
    public void setNumeroDeTripulantes(int numero) {
        if (numero < 0) {
            System.out.println("ERRO! Número de tripulantes não pode ser negativo.");
        } else {
            this.numeroDeTripulantes = numero;
        }
    }

    public void setNivelCombustivel(double nivel) {
        if (nivel < 0 || nivel > 100) {
            System.out.println("ERRO! Nível deve ser entre 0 e 100.");
        } else {
            this.nivelCombustivel = nivel;
            if (nivel < 20) {
                System.out.println("ALERTA! Combustível crítico: " + nivel + "%");
            }
        }
    }

    public void setTrajetoria(String trajetoria) {
        if (trajetoria == null || trajetoria.isEmpty()) {
            System.out.println("ERRO! Trajetória não pode ser vazia.");
        } else {
            this.trajetoria = trajetoria;
        }
    }

    public void setCoordenadas(double x, double y, double z, String senhaInformada) {
        if (codigoAcesso.equals(senhaInformada)) {
            this.coordenadaX = x;
            this.coordenadaY = y;
            this.coordenadaZ = z;
            System.out.println("Coordenadas atualizadas!");
        } else {
            System.out.println("ACESSO NEGADO! Coordenadas não alteradas.");
        }
    }

    public void ResumoDaMissao() {
        System.out.println("----- DADOS DA MISSÃO -----");
        System.out.println("Missão: " + nomeMissao);
        System.out.println("Tripulantes: " + numeroDeTripulantes);
        System.out.println("Combustível: " + nivelCombustivel + "%");
        System.out.println("Trajetória: " + trajetoria);
        System.out.println("Coordenadas: Acesso restrito");
    }
}