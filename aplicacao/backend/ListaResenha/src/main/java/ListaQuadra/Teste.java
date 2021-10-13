package ListaQuadra;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Teste {

    public static void gravaArquivoCsv(ListaQuadra.ListaObj<Quadra> lista, String nomeArq){
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
                Quadra quad = lista.getElemento(i);
                saida.format("%d;%s;%d;%b\n",quad.getId(),quad.getModalidade(),quad.getNumeroQuadra(),quad.getDisponivel());
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
            System.out.printf("%10s %20s %20s %20s \n","ID QUADRA","MODALIDADE","NUMERO DA QUADRA","DISPONÍVEL");
            while (entrada.hasNext()){ // enquanto n for final do arq
                Integer idQuadra = entrada.nextInt();
                String modalidade = entrada.next();
                Integer numeroQuadra = entrada.nextInt();
                String disponivel = entrada.next();


                System.out.printf("%10d %20S %20d %20s \n",idQuadra,modalidade,numeroQuadra,disponivel);
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

        ListaQuadra.ListaObj<Quadra> lista = new ListaObj<>(7);

        lista.adiciona(new Quadra(1,"Futebol",7,true));
        lista.adiciona(new Quadra(2,"Basquete",2,true));
        lista.adiciona(new Quadra(3,"Tenis",3,true));
        lista.adiciona(new Quadra(4,"Volei",5,false));

        lista.exibe();

        gravaArquivoCsv(lista,"quad");

        leExibeArquivoCsv("quad");
    }
}

