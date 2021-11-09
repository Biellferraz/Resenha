package ListaAgendamento;

import ListaQuadra.Quadra;

import java.io.*;
import java.text.SimpleDateFormat;
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

    public static void gravaArquivoTxt(List<Agendamento> lista, String nomeArq){

        //Monta o registro de reader
        String header = "00AGENDAMENTO";
        Date dataDeHoje = new Date();
        SimpleDateFormat formataData = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        header += formataData.format(dataDeHoje);
        header += "01";


        //Grava o header
        gravaRegistro(header, nomeArq);


        Integer contaRegDados = 0;

        //Monta e grava o corpo
        for (Agendamento a:lista) {
            String corpo = "02";
            corpo += String.format("%04d",a.getIdJogador());
            corpo += String.format("%04d",a.getIdQuadra());
            corpo += String.format("%06.2f",a.getPreco());
            corpo += String.format("%19.19s",a.getHoraMarcada());

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
        String horaMarcada;
        Integer idJogador,idQuadra;
        Double preco;
        Integer qtdResgistrosGravados;

        List<Agendamento> listaLida = new ArrayList<>();

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
                    System.out.println("\nÉ um registro de header");
                    System.out.println("Tipo de arquivo: " + registro.substring(2,13));
                    System.out.println("Data/hora de gravação: " + registro.substring(13,32));
                    System.out.println("Versão do documento: " + registro.substring(32,34));
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
                    idJogador = Integer.valueOf(registro.substring(2,6));
                    idQuadra = Integer.valueOf(registro.substring(6,10));
                    preco = Double.valueOf(registro.substring(10,16).replace(',','.'));
                    horaMarcada = registro.substring(16,35);



                    listaLida.add(new Agendamento(idJogador,idQuadra,preco,horaMarcada));
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
        for (Agendamento a:listaLida) {
            System.out.println(a);
        }
    }

    public static void main(String[] args) {

        ListaObj<Agendamento> lista = new ListaObj<>(7);
        List<Agendamento> listaAgendamento = new ArrayList<>();

        lista.adiciona(new Agendamento(1,1,150.0,"2021-10-13 13:00:00"));
        lista.adiciona(new Agendamento(2,2,130.5,"2021-10-13 13:00:00"));
        lista.adiciona(new Agendamento(3,3,110.0,"2021-10-13 13:00:00"));
        lista.adiciona(new Agendamento(4,1,150.0,"2021-10-13 14:00:00"));
        lista.adiciona(new Agendamento(5,2,130.5,"2021-10-13 14:00:00"));
        lista.adiciona(new Agendamento(6,1,150.0,"2021-10-13 15:00:00"));

        listaAgendamento.add(new Agendamento(1,1,150.0,"2021-10-13 13:00:00"));
        listaAgendamento.add(new Agendamento(2,2,130.5,"2021-10-13 13:00:00"));
        listaAgendamento.add(new Agendamento(3,3,110.0,"2021-10-13 13:00:00"));
        listaAgendamento.add(new Agendamento(4,1,150.0,"2021-10-13 14:00:00"));
        listaAgendamento.add(new Agendamento(5,2,130.5,"2021-10-13 14:00:00"));
        listaAgendamento.add(new Agendamento(6,1,150.0,"2021-10-13 15:00:00"));

        lista.exibe();

        gravaArquivoCsv(lista,"agend");

        leExibeArquivoCsv("agend");

        gravaArquivoTxt(listaAgendamento, "agend");

        leArquivoTxt("agend");
    }
}
