package br.com.bandtec.projetoresenha;
import java.util.Scanner;

public class Jogador extends Usuario {

    Scanner leitor = new Scanner(System.in);

    private Double qtdHora;
    private Double valorHora;
    private String horarioLocacao;

    public Jogador(String nome, String login, String senha, Double qtdHora, Double valorHora,
                   String horarioLocacao) {
        super(nome, login, senha);
        this.qtdHora = qtdHora;
        this.valorHora = valorHora;
        this.horarioLocacao = horarioLocacao;
    }

    @Override
    public Double calculaTributo() {
        return qtdHora * valorHora;
    }

    @Override
    public String agendarHorario() {
        return horarioLocacao;
    }

    @Override
    public String toString() {
        return "Jogador{" +
                super.toString() +
                "qtdHora=" + qtdHora +
                ", valorHora=" + "R$"+ valorHora +
                ", horarioLocacao=" + horarioLocacao +
                ", valor à pagar="  + "R$"+ horarioLocacao +
                '}';
    }
}
