package ListaAgendamento;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Teste {

    public static void gravaArquivoCsv(ListaObj<Agendamento> lista, String nomeArq){
        FileWriter arq = null;     //Obj q representa o arq a ser gravado
        Formatter saida =  null;   //Obj q usaremos para escrever no arq
        Boolean deuRuim = false;

        nomeArq+= ".csv";          //Acrescenta a extensão .csv ao nome do arq

        //Bloco try-catch para abrir o arq
        try{
            arq = new FileWriter(nomeArq);    //Abre o arq nomeArq
            saida = new Formatter(arq);       //Associa o obj saida ao arq
        }
        catch (IOException erro){
            System.out.println("Erro ao abrir o arquivo");
            System.exit(1);
        }

        //Bloco try-catch para percorrer a lista e gravar no arq
        try {
            for (int i = 0; i < lista.getTamanho(); i++) {
                Agendamento agend = lista.getElemento(i);
                saida.format("%d;%d;%.2f;%s\n",agend.getIdJogador(),agend.getIdQuadra(),agend.getPreco(),agend.getHoraMarcada());
            }
        }
        catch (FormatterClosedException erro){
            System.out.println("Erro ao gravar no arquivo");
            deuRuim = true;
        }
        finally {
            saida.close();
            try {
                arq.close();
            }
            catch (IOException erro){
                System.out.println("Erro ao fechar o aquivo");
                deuRuim = true;
            }
            if (deuRuim){
                System.exit(1);
            }
        }
    }

    public static void leExibeArquivoCsv(String nomeArq){
        FileReader arq = null;          //Obj q represent o arq para leitura
        Scanner entrada = null;         //Obj usado para ler do arq
        Boolean deuRuim = false;

        nomeArq+= ".csv";

        //Bloco try-catch para abrir o arq
        try {
            arq = new FileReader(nomeArq);
            /*cria o obj do scanner, informando q o delimitador é o ';' ou o '\n'*/
            entrada = new Scanner(arq).useDelimiter(";|\\n");
        }
        catch (FileNotFoundException erro){
            System.out.println("Arquivo não encontrado");
            System.exit(1);
        }

        //Bloco try-catch para ler o arq
        try {
            System.out.printf("%10s %10s %10s %20s \n","ID JOGADOR","ID QUADRA","PREÇO","HORA MARCADA");
            while (entrada.hasNext()){ // enquanto n for final do arq
                Integer idJogador = entrada.nextInt();
                Integer idQuadra = entrada.nextInt();
                Double preco = entrada.nextDouble();
                String horaDisponivel = entrada.next();


                System.out.printf("%10d %10d %10.2f %20s \n",idJogador,idQuadra,preco,horaDisponivel);
            }
        }

        catch (NoSuchElementException erro){
            System.out.println("Arquivos com problemas");
            deuRuim = true;
        }

        catch (IllegalStateException erro){
            System.out.println("Erro na leitura do arquivo");
            deuRuim = true;
        }

        finally {
            entrada.close();
            try {
                arq.close();
            }
            catch (IOException erro){
                System.out.println("Erro ao fechar o arquivo");
                deuRuim = true;
            }
            if(deuRuim){
                System.exit(1);
            }
        }
    }

    public static void main(String[] args) {

        ListaObj<Agendamento> lista = new ListaObj<>(7);

        lista.adiciona(new Agendamento(1,1,150.0,"2021-10-13 13:00:00"));
        lista.adiciona(new Agendamento(2,2,130.5,"2021-10-13 13:00:00"));
        lista.adiciona(new Agendamento(3,3,110.0,"2021-10-13 13:00:00"));
        lista.adiciona(new Agendamento(4,1,150.0,"2021-10-13 14:00:00"));
        lista.adiciona(new Agendamento(5,2,130.5,"2021-10-13 14:00:00"));
        lista.adiciona(new Agendamento(6,1,150.0,"2021-10-13 15:00:00"));

        lista.exibe();

        gravaArquivoCsv(lista,"agend");

        leExibeArquivoCsv("agend");
    }
}
