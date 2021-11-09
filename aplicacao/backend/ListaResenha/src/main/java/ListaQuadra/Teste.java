package ListaQuadra;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

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

    public static void gravaRegistro(String registro,String nomeArq){
        BufferedWriter saida = null;

        //Abre o arquivo
        try {
            saida = new BufferedWriter(new FileWriter(nomeArq, true));
        }
        catch (IOException erro){
            System.out.println("Erro ao abrir o arquivo: " + erro.getMessage());
        }

        //Grava o registro e fecha o arquivo
        try {
            saida.append(registro + "\n");
            saida.close();
        }
        catch (IOException erro){
            System.out.println("Erro ao gravar o arquivo: " + erro.getMessage());
        }

    }

    public static void gravaArquivoTxt(List<Quadra> lista, String nomeArq){

        //Monta o registro de reader
        String header = "00QUADRA";
        Date dataDeHoje = new Date();
        SimpleDateFormat formataData = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        header += formataData.format(dataDeHoje);
        header += "01";


        //Grava o header
        gravaRegistro(header, nomeArq);


        Integer contaRegDados = 0;

        //Monta e grava o corpo
        for (Quadra q:lista) {
            String corpo = "02";
            corpo += String.format("%04d",q.getId());
            corpo += String.format("%-8.8s",q.getModalidade());
            corpo += String.format("%02d",q.getNumeroQuadra());
            corpo += String.format("%b",q.getDisponivel());

            contaRegDados++;

            gravaRegistro(corpo, nomeArq);
        }


        //Monta e grava o registro de trailer
        String trailer = "01";
        trailer += String.format("%05d",contaRegDados);

        gravaRegistro(trailer, nomeArq);
    }

    public static void leArquivoTxt(String nomeArq){
        BufferedReader entrada = null;
        String registro,tipoRegistro;
        String modalidade;
        Integer id,numeroQuadra;
        Boolean disponivel;
        Integer qtdResgistrosGravados;

        List<Quadra> listaLida = new ArrayList<>();

        //Abre o arquivo
        try {
            entrada = new BufferedReader(new FileReader(nomeArq));
        }
        catch (IOException erro){
            System.out.println("Erro ao abrir o arquivo: " + erro.getMessage());
        }


        //Lê o arquivo
        try {
            //Lê o primeiro registro do arquivo
            registro = entrada.readLine();
            while (registro != null){
                //Enquanto não chegou ao final do arquivo
                tipoRegistro = registro.substring(0,2);

                if (tipoRegistro.equals("00")){
                    System.out.println("\n" +
                            "É um registro de header");
                    System.out.println("Tipo de arquivo: " + registro.substring(2,8));
                    System.out.println("Data/hora de gravação: " + registro.substring(8,27));
                    System.out.println("Versão do documento: " + registro.substring(27,29));
                }
                else if(tipoRegistro.equals("01")){
                    System.out.println("É um registro de trailer");
                    qtdResgistrosGravados = Integer.valueOf(registro.substring(2,7));
                    if (qtdResgistrosGravados == listaLida.size()){
                        System.out.println("Quantidade de registros gravados compatível com quantidade lida");
                    }
                    else{
                        System.out.println("Quantidade de registro gravados imcompatível com quantidade lida");
                    }

                }
                else if(tipoRegistro.equals("02")){
                    System.out.println("É um registro de corpo");
                    id = Integer.valueOf(registro.substring(2,6));
                    modalidade = registro.substring(6,14).trim();
                    numeroQuadra = Integer.valueOf(registro.substring(14,16));
                    disponivel = Boolean.valueOf(registro.substring(16,18));



                    listaLida.add(new Quadra(id,modalidade,numeroQuadra,disponivel));
                }
                else{
                    System.out.println("Tipo de registro inválido");
                }
                //Le o proximo registro
                registro = entrada.readLine();
            }
            entrada.close();
        }
        catch (IOException erro){
            System.out.println("Erro ao ler o arquivo: " + erro.getMessage());
        }

        System.out.println("\nConteúdo lido do arquivo");
        for (Quadra q:listaLida) {
            System.out.println(q);
        }
    }

    public static void main(String[] args) {

        ListaQuadra.ListaObj<Quadra> lista = new ListaObj<>(7);
        List<Quadra> listaQuadra = new ArrayList<>();

        lista.adiciona(new Quadra(1,"Futebol",7,true));
        lista.adiciona(new Quadra(2,"Basquete",2,true));
        lista.adiciona(new Quadra(3,"Tenis",3,true));
        lista.adiciona(new Quadra(4,"Volei",5,false));

        listaQuadra.add(new Quadra(1,"Futebol",7,true));
        listaQuadra.add(new Quadra(2,"Basquete",2,true));
        listaQuadra.add(new Quadra(3,"Tenis",3,true));
        listaQuadra.add(new Quadra(4,"Volei",5,false));

//        lista.exibe();
//
        gravaArquivoCsv(lista,"quad");

        leExibeArquivoCsv("quad");

        gravaArquivoTxt(listaQuadra, "quad.txt");

        leArquivoTxt("quad.txt");
    }
}

