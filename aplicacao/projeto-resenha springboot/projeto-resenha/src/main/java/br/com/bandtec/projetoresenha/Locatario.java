package br.com.bandtec.projetoresenha;
import java.util.Scanner;

public class Locatario extends Usuario {

    Scanner leitor = new Scanner(System.in);

    private Double aluguelQuadra;
    private Boolean horarioAprovado;

    public Locatario(String nome, String login, String senha, Double aluguelQuadra) {
        super(nome, login, senha);
        this.aluguelQuadra = aluguelQuadra;
        this.horarioAprovado = false;
    }

    public boolean aprovarHorario() {

        System.out.println(agendarHorario());
        System.out.println("Você aprova o horário acima ?(S/N)");
        String resposta = leitor.nextLine();

        if (resposta == "S") {

            return horarioAprovado = true;
        }

        else {

            return horarioAprovado = false;
        }
    }

    @Override
    public Double calculaTributo() {

        return calculaTributo() - aluguelQuadra;
    }

    public String exibeSalario() {

        return "Salário no fim do mês: " + calculaTributo();
    }

    @Override
    public String agendarHorario() {

        if (horarioAprovado) {

            return agendarHorario();
        }

        else {

            return "horário não aprovado";
        }
    }

    @Override
    public String toString() {
        return "Locatario{" +
                super.toString() +
                ", aluguelQuadra:" + "R$"+ aluguelQuadra +
                ", horarioAprovado:" + horarioAprovado +
                exibeSalario() +
                ", horário registrado: " + agendarHorario() +
                '}';
    }
}