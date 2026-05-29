package br.com.projetoespacial.main;

import java.util.Scanner;
import br.com.projetoespacial.modelo.*;

public class SistemaMonitoramento {

    public static void main(String[] args) {

        // Scanner para entrada do usuário
        Scanner sc = new Scanner(System.in);

        // Instanciando sensores
        SensorDeTemperatura temp = new SensorDeTemperatura("TEMP-01");
        SensorDePressao pressao = new SensorDePressao("PRESS-01");
        SensorDeRadiacao radiacao = new SensorDeRadiacao("RAD-01");

        PropulsaoQuimica quimica =
                new PropulsaoQuimica("Motor Químico", 50);

        DadosMissao missao =
                new DadosMissao("Apollo Java", 5, "1234");

        int opcao;

        // Loop principal do sistema
        do {

            // Menu principal
            System.out.println("\n===== SISTEMA ESPACIAL =====");
            System.out.println("1 - Verificar sensores");
            System.out.println("2 - Controlar propulsão");
            System.out.println("3 - Ver dados da missão");
            System.out.println("0 - Sair");

            opcao = sc.nextInt();

            // Controle das opções escolhidas
            switch (opcao) {

                case 1:

                    temp.ligar();
                    temp.lerValor();
                    temp.diagnosticar();

                    pressao.ligar();
                    pressao.lerValor();
                    pressao.diagnosticar();

                    radiacao.ligar();
                    radiacao.lerValor();
                    radiacao.diagnosticar();

                    break;

                case 2:

                    quimica.ligar();
                    quimica.acelerar(70);

                    System.out.println(
                            "Empuxo: " +
                                    quimica.calcularEmpuxo()
                    );

                    break;

                case 3:

                    missao.ResumoDaMissao();

                    break;

                case 0:

                    System.out.println("Encerrando sistema...");
                    break;

                default:

                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        sc.close();
    }
}