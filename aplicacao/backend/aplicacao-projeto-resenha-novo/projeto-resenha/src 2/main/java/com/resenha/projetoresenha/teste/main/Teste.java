package com.resenha.projetoresenha.teste.main;


import com.resenha.projetoresenha.dominio.Agendamento;
import com.resenha.projetoresenha.dominio.CentroEsportivo;
import com.resenha.projetoresenha.dominio.Quadra;
import com.resenha.projetoresenha.repositorio.ListaObj;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class Teste {

    public static void gravaArquivoCsvCentroEsportivo(ListaObj<CentroEsportivo> lista, String nomeArq) {
        FileWriter arq = null;     //Obj q representa o arq a ser gravado
        Formatter saida = null;   //Obj q usaremos para escrever no arq
        Boolean deuRuim = false;

        nomeArq += ".csv";          //Acrescenta a extensão .csv ao nome do arq

        //Bloco try-catch para abrir o arq
        try {
            arq = new FileWriter(nomeArq);    //Abre o arq nomeArq
            saida = new Formatter(arq);       //Associa o obj saida ao arq
        } catch (IOException erro) {
            System.out.println("Erro ao abrir o arquivo");
            System.exit(1);
        }

        //Bloco try-catch para percorrer a lista e gravar no arq
        try {
            for (int i = 0; i < lista.getTamanho(); i++) {
                CentroEsportivo centroE = lista.getElemento(i);
                saida.format("%d;%s;%s;%s;%d;%s;%s;%s;%s\n", centroE.getIdCentroEsportivo(), centroE.getCnpj(),
                        centroE.getCep(), centroE.getCidade(), centroE.getNumero(), centroE.getNome(),
                        centroE.getHoraAbre(), centroE.getHoraFecha(), centroE.getTelefone());
            }
        } catch (FormatterClosedException erro) {
            System.out.println("Erro ao gravar no arquivo");
            deuRuim = true;
        } finally {
            saida.close();
            try {
                arq.close();
            } catch (IOException erro) {
                System.out.println("Erro ao fechar o aquivo");
                deuRuim = true;
            }
            if (deuRuim) {
                System.exit(1);
            }
        }
    }

    public static void leExibeArquivoCsvCentroEsportivo(String nomeArq) {
        FileReader arq = null;          //Obj q represent o arq para leitura
        Scanner entrada = null;         //Obj usado para ler do arq
        Boolean deuRuim = false;

        nomeArq += ".csv";

        //Bloco try-catch para abrir o arq
        try {
            arq = new FileReader(nomeArq);
            /*cria o obj do scanner, informando q o delimitador é o ';' ou o '\n'*/
            entrada = new Scanner(arq).useDelimiter(";|\\n");
        } catch (FileNotFoundException erro) {
            System.out.println("Arquivo não encontrado");
            System.exit(1);
        }

        //Bloco try-catch para ler o arq
        try {
            System.out.printf("%5s %18s %10s %-30s %5s %-30s %20s %20s %19s \n", "ID", "CNPJ", "CEP", "CIDADE", "NUMERO",
                    "NOME", "HORA QUE ABRE", "HORA QUE FECHA", "TELEFONE");
            while (entrada.hasNext()) { // enquanto n for final do arq
                Integer idCentroEsportivo = entrada.nextInt();
                String cnpj = entrada.next();
                String cep = entrada.next();
                String cidade = entrada.next();
                Integer numero = entrada.nextInt();
                String nome = entrada.next();
                String horaAbre = entrada.next();
                String horaFecha = entrada.next();
                String telefone = entrada.next();


                System.out.printf("%05d %18s %10s %-30s %5d %-30s %20s %20s %20s  \n", idCentroEsportivo, cnpj, cep, cidade,
                        numero, nome, horaAbre, horaFecha, telefone);
            }
        } catch (NoSuchElementException erro) {
            System.out.println("Arquivos com problemas");
            deuRuim = true;
        } catch (IllegalStateException erro) {
            System.out.println("Erro na leitura do arquivo");
            deuRuim = true;
        } finally {
            entrada.close();
            try {
                arq.close();
            } catch (IOException erro) {
                System.out.println("Erro ao fechar o arquivo");
                deuRuim = true;
            }
            if (deuRuim) {
                System.exit(1);
            }
        }
    }

    public static void gravaArquivoCsvQuadra(ListaObj<Quadra> lista, String nomeArq){
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
                saida.format("%d;%s;%d;%b\n",quad.getIdQuadra(),quad.getModalidade(),quad.getNumeroQuadra(),quad.getDisponivel());
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

    public static void leExibeArquivoCsvQuadra(String nomeArq){
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

    public static void gravaRegistroQuadra(String registro,String nomeArq){
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

    public static void gravaArquivoTxtQuadra(List<Quadra> lista, String nomeArq){

        //Monta o registro de reader
        String header = "00QUADRA";
        Date dataDeHoje = new Date();
        SimpleDateFormat formataData = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        header += formataData.format(dataDeHoje);
        header += "01";


        //Grava o header
        gravaRegistroQuadra(header, nomeArq);


        Integer contaRegDados = 0;

        //Monta e grava o corpo
        for (Quadra q:lista) {
            String corpo = "02";
            corpo += String.format("%04d",q.getIdQuadra());
            corpo += String.format("%-8.8s",q.getModalidade());
            corpo += String.format("%02d",q.getNumeroQuadra());
            corpo += String.format("%b",q.getDisponivel());

            contaRegDados++;

            gravaRegistroQuadra(corpo, nomeArq);
        }


        //Monta e grava o registro de trailer
        String trailer = "01";
        trailer += String.format("%05d",contaRegDados);

        gravaRegistroQuadra(trailer, nomeArq);
    }

    public static void leArquivoTxtQuadra(String nomeArq){
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

    public static void gravaArquivoCsvAgendamento(ListaObj<Agendamento> lista, String nomeArq){
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

    public static void leExibeArquivoCsvAgendamento(String nomeArq){
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

    public static void gravaRegistroAgendamento(String registro,String nomeArq){
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

    public static void gravaArquivoTxtAgendamento(List<Agendamento> lista, String nomeArq){

        //Monta o registro de reader
        String header = "00AGENDAMENTO";
        Date dataDeHoje = new Date();
        SimpleDateFormat formataData = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        header += formataData.format(dataDeHoje);
        header += "01";


        //Grava o header
        gravaRegistroAgendamento(header, nomeArq);


        Integer contaRegDados = 0;

        //Monta e grava o corpo
        for (Agendamento a:lista) {
            String corpo = "02";
            corpo += String.format("%04d",a.getIdJogador());
            corpo += String.format("%04d",a.getIdQuadra());
            corpo += String.format("%06.2f",a.getPreco());
            corpo += String.format("%19.19s",a.getHoraMarcada());

            contaRegDados++;

            gravaRegistroAgendamento(corpo, nomeArq);
        }


        //Monta e grava o registro de trailer
        String trailer = "01";
        trailer += String.format("%05d",contaRegDados);

        gravaRegistroAgendamento(trailer, nomeArq);
    }

    public static void leArquivoTxtAgendamento(String nomeArq){
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

        ListaObj<CentroEsportivo> lista = new ListaObj<>(7);
//        ArrayList<CentroEsportivo> centroEsportivos = new ArrayList<>();
//
//        centroEsportivos.add(new CentroEsportivo(1,"99.378.761/0001-49","01001-001",
//                2190,"Santo andré","Afonso Quadras","09:00","22:00","(11) 94002-8922"));
//        centroEsportivos.add(new CentroEsportivo(2,"60.210.961/0001-52","09220-440",440,
//                "São Paulo","Web Quadras Poliesportivas","09:00","18:00","(11) 95271-7924"));
//        centroEsportivos.add(new CentroEsportivo(3,"62.587.302/0001-65","09220-140",210,
//                "São Paulo","Quadras Barra Funda","08:00","18:00","(11) 99119-1137"));

//        Iterator<CentroEsportivo> it = centroEsportivos.iterator();
//
//        while (it.hasNext()){
//            CentroEsportivo cidade = it.next();
//            if (cidade.getCidade().equals("São Paulo")) {
//                System.out.println(cidade);
//            }
//        }

//        System.out.println(centroEsportivos);


        lista.adiciona(new CentroEsportivo(1, "99.378.761/0001-49", "01001-001",
                2190, "Santo andré", "Afonso Quadras", "09:00", "22:00", "(11) 94002-8922"));
        lista.adiciona(new CentroEsportivo(2, "60.210.961/0001-52", "09220-440", 440,
                "São Paulo", "Web Quadras Poliesportivas", "09:00", "18:00", "(11) 95271-7924"));
        lista.adiciona(new CentroEsportivo(3, "62.587.302/0001-65", "09220-140", 210,
                "São Paulo", "Quadras Barra Funda", "08:00", "18:00", "(11) 99119-1137"));

        while (lista.hasNext()) {
            CentroEsportivo centroEsportivo = (CentroEsportivo) lista.next();
            if (centroEsportivo.getCidade().equals("São Paulo")){
                System.out.println(centroEsportivo);
            }
        }

//
//        lista.exibe();
//
//        gravaArquivoCsvCentroEsportivo(lista,"centroE");
//
//        leExibeArquivoCsvCentroEsportivo("centroE");


        ListaObj<Quadra> listaQuadraObj = new ListaObj<>(7);
        List<Quadra> listaQuadra = new ArrayList<>();

        listaQuadraObj.adiciona(new Quadra(1,"Futebol",7,true));
        listaQuadraObj.adiciona(new Quadra(2,"Basquete",2,true));
        listaQuadraObj.adiciona(new Quadra(3,"Tenis",3,true));
        listaQuadraObj.adiciona(new Quadra(4,"Volei",5,false));

        listaQuadra.add(new Quadra(1,"Futebol",7,true));
        listaQuadra.add(new Quadra(2,"Basquete",2,true));
        listaQuadra.add(new Quadra(3,"Tenis",3,true));
        listaQuadra.add(new Quadra(4,"Volei",5,false));

//        lista.exibe();
//
        gravaArquivoCsvQuadra(listaQuadraObj,"quad");

        leExibeArquivoCsvQuadra("quad");

        gravaArquivoTxtQuadra(listaQuadra, "quad.txt");

        leArquivoTxtQuadra("quad.txt");


        ListaObj<Agendamento> listaAgendamentoObj = new ListaObj<>(7);
        List<Agendamento> listaAgendamento = new ArrayList<>();

        listaAgendamentoObj.adiciona(new Agendamento(1,1,150.0,"2021-10-13 13:00:00"));
        listaAgendamentoObj.adiciona(new Agendamento(2,2,130.5,"2021-10-13 13:00:00"));
        listaAgendamentoObj.adiciona(new Agendamento(3,3,110.0,"2021-10-13 13:00:00"));
        listaAgendamentoObj.adiciona(new Agendamento(4,1,150.0,"2021-10-13 14:00:00"));
        listaAgendamentoObj.adiciona(new Agendamento(5,2,130.5,"2021-10-13 14:00:00"));
        listaAgendamentoObj.adiciona(new Agendamento(6,1,150.0,"2021-10-13 15:00:00"));

        listaAgendamento.add(new Agendamento(1,1,150.0,"2021-10-13 13:00:00"));
        listaAgendamento.add(new Agendamento(2,2,130.5,"2021-10-13 13:00:00"));
        listaAgendamento.add(new Agendamento(3,3,110.0,"2021-10-13 13:00:00"));
        listaAgendamento.add(new Agendamento(4,1,150.0,"2021-10-13 14:00:00"));
        listaAgendamento.add(new Agendamento(5,2,130.5,"2021-10-13 14:00:00"));
        listaAgendamento.add(new Agendamento(6,1,150.0,"2021-10-13 15:00:00"));

        lista.exibe();

        gravaArquivoCsvAgendamento(listaAgendamentoObj,"agend");

        leExibeArquivoCsvAgendamento("agend");

        gravaArquivoTxtAgendamento(listaAgendamento, "agend");

        leArquivoTxtAgendamento("agend");
    }

}


