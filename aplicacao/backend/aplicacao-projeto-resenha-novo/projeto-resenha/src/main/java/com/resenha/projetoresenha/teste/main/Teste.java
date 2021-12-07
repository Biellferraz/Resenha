package com.resenha.projetoresenha.teste.main;


import com.resenha.projetoresenha.dominio.Agendamento;
import com.resenha.projetoresenha.dominio.CentroEsportivo;
import com.resenha.projetoresenha.dominio.Quadra;
import com.resenha.projetoresenha.listas.ListaObj;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
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
                saida.format("%d;%s;%s;%s;%d;%s;%s;%s;%s\n", centroE.getId(), centroE.getCnpj(),
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

    public static void gravaArquivoCsvQuadra(ListaObj<Quadra> lista, String nomeArq) {
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
                Quadra quad = lista.getElemento(i);
                saida.format("%d;%s;%d;%b\n", quad.getId(), quad.getModalidade(), quad.getNumero_quadra(), quad.getDisponivel());
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

    public static void leExibeArquivoCsvQuadra(String nomeArq) {
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
            System.out.printf("%10s %20s %20s %20s \n", "ID QUADRA", "MODALIDADE", "NUMERO DA QUADRA", "DISPONÍVEL");
            while (entrada.hasNext()) { // enquanto n for final do arq
                Integer idQuadra = entrada.nextInt();
                String modalidade = entrada.next();
                Integer numeroQuadra = entrada.nextInt();
                String disponivel = entrada.next();


                System.out.printf("%10d %20S %20d %20s \n", idQuadra, modalidade, numeroQuadra, disponivel);
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

    public static void gravaRegistroQuadra(String registro, String nomeArq) {
        BufferedWriter saida = null;

        //Abre o arquivo
        try {
            saida = new BufferedWriter(new FileWriter(nomeArq, true));
        } catch (IOException erro) {
            System.out.println("Erro ao abrir o arquivo: " + erro.getMessage());
        }

        //Grava o registro e fecha o arquivo
        try {
            saida.append(registro + "\n");
            saida.close();
        } catch (IOException erro) {
            System.out.println("Erro ao gravar o arquivo: " + erro.getMessage());
        }

    }

    public static void gravaArquivoTxtQuadra(List<Quadra> lista, String nomeArq) {

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
        for (Quadra q : lista) {
            String corpo = "02";
            corpo += String.format("%04d", q.getId());
            corpo += String.format("%-8.8s", q.getModalidade());
            corpo += String.format("%02d", q.getNumero_quadra());
            corpo += String.format("%d", q.getDisponivel());
            corpo += String.format("%04d", q.getFkCentroEsportivo());

            contaRegDados++;

            gravaRegistroQuadra(corpo, nomeArq);
        }


        //Monta e grava o registro de trailer
        String trailer = "01";
        trailer += String.format("%05d", contaRegDados);

        gravaRegistroQuadra(trailer, nomeArq);
    }

    public static void leArquivoTxtQuadra(String nomeArq) {
        BufferedReader entrada = null;
        String registro, tipoRegistro;
        String modalidade;
        Integer id, numeroQuadra, fk_centro_esportivo, disponivel;
        Integer qtdResgistrosGravados;

        List<Quadra> listaLida = new ArrayList<>();

        //Abre o arquivo
        try {
            entrada = new BufferedReader(new FileReader(nomeArq));
        } catch (IOException erro) {
            System.out.println("Erro ao abrir o arquivo: " + erro.getMessage());
        }


        //Lê o arquivo
        try {
            //Lê o primeiro registro do arquivo
            registro = entrada.readLine();
            while (registro != null) {
                //Enquanto não chegou ao final do arquivo
                tipoRegistro = registro.substring(0, 2);

                if (tipoRegistro.equals("00")) {
                    System.out.println("\n" +
                            "É um registro de header");
                    System.out.println("Tipo de arquivo: " + registro.substring(2, 8));
                    System.out.println("Data/hora de gravação: " + registro.substring(8, 27));
                    System.out.println("Versão do documento: " + registro.substring(27, 29));
                } else if (tipoRegistro.equals("01")) {
                    System.out.println("É um registro de trailer");
                    qtdResgistrosGravados = Integer.valueOf(registro.substring(2, 7));
                    if (qtdResgistrosGravados == listaLida.size()) {
                        System.out.println("Quantidade de registros gravados compatível com quantidade lida");
                    } else {
                        System.out.println("Quantidade de registro gravados imcompatível com quantidade lida");
                    }

                } else if (tipoRegistro.equals("02")) {
                    System.out.println("É um registro de corpo");
                    id = Integer.valueOf(registro.substring(2, 6));
                    modalidade = registro.substring(6, 14).trim();
                    numeroQuadra = Integer.valueOf(registro.substring(14, 16));
                    disponivel = Integer.valueOf(registro.substring(16, 17));
                    fk_centro_esportivo = Integer.valueOf(registro.substring(17, 21));

                    listaLida.add(new Quadra(id, modalidade, numeroQuadra, disponivel, fk_centro_esportivo));
                } else {
                    System.out.println("Tipo de registro inválido");
                }
                //Le o proximo registro
                registro = entrada.readLine();
            }
            entrada.close();
        } catch (IOException erro) {
            System.out.println("Erro ao ler o arquivo: " + erro.getMessage());
        }

        System.out.println("\nConteúdo lido do arquivo");
        for (Quadra q : listaLida) {
            System.out.println(q);
        }
    }

    public static void gravaArquivoCsvAgendamento(ListaObj<Agendamento> lista, String nomeArq) {
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
                Agendamento agend = lista.getElemento(i);
                saida.format("%d;%d;%.2f;%s\n", agend.getFk_Jogador(), agend.getFkQuadra(), agend.getPreco(), agend.getHora_Marcada());
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

    public static void leExibeArquivoCsvAgendamento(String nomeArq) {
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
            System.out.printf("%10s %10s %10s %20s \n", "ID JOGADOR", "ID QUADRA", "PREÇO", "HORA MARCADA");
            while (entrada.hasNext()) { // enquanto n for final do arq
                Integer idJogador = entrada.nextInt();
                Integer idQuadra = entrada.nextInt();
                Double preco = entrada.nextDouble();
                String horaDisponivel = entrada.next();


                System.out.printf("%10d %10d %10.2f %20s \n", idJogador, idQuadra, preco, horaDisponivel);
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

    public static void gravaRegistroCentroEsportivo(String registro, String nomeArq) {
        BufferedWriter saida = null;

        //Abre o arquivo
        try {
            saida = new BufferedWriter(new FileWriter(nomeArq, true));
        } catch (IOException erro) {
            System.out.println("Erro ao abrir o arquivo: " + erro.getMessage());
        }

        //Grava o registro e fecha o arquivo
        try {
            saida.append(registro + "\n");
            saida.close();
        } catch (IOException erro) {
            System.out.println("Erro ao gravar o arquivo: " + erro.getMessage());
        }

    }

    public static void gravaArquivoTxtCentroEsportivo(List<CentroEsportivo> lista, String nomeArq) {

        //Monta o registro de reader
        String header = "00CENTROESPORTIVO";
        Date dataDeHoje = new Date();
        SimpleDateFormat formataData = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        header += formataData.format(dataDeHoje);
        header += "01";


        //Grava o header
        gravaRegistroCentroEsportivo(header, nomeArq);


        Integer contaRegDados = 0;

        //Monta e grava o corpo
        for (CentroEsportivo c : lista) {
            String corpo = "02";
            corpo += String.format("%04d", c.getId());
            corpo += String.format("%18.18s", c.getCnpj());
            corpo += String.format("%9.9s", c.getCep());
            corpo += String.format("%04d", c.getNumero());
            corpo += String.format("%25.25s", c.getCidade());
            corpo += String.format("%30.30s", c.getNome());
            corpo += String.format("%5.5s", c.getHoraAbre());
            corpo += String.format("%5.5s", c.getHoraFecha());
            corpo += String.format("%14.14s", c.getTelefone());

            contaRegDados++;

            gravaRegistroCentroEsportivo(corpo, nomeArq);
        }


        //Monta e grava o registro de trailer
        String trailer = "01";
        trailer += String.format("%05d", contaRegDados);

        gravaRegistroCentroEsportivo(trailer, nomeArq);
    }

//    public static void leArquivoTxtCentroEsportivo(String nomeArq) {
//        BufferedReader entrada = null;
//        String registro, tipoRegistro;
//        String cnpj, cep, cidade, nome, horaAbre, horaFecha, telefone;
//        Integer id, numero;
//        Integer qtdResgistrosGravados;
//
//        List<CentroEsportivo> listaLida = new ArrayList<>();
//
//        //Abre o arquivo
//        try {
//            entrada = new BufferedReader(new FileReader(nomeArq));
//        } catch (IOException erro) {
//            System.out.println("Erro ao abrir o arquivo: " + erro.getMessage());
//        }
//
//
//        //Lê o arquivo
//        try {
//            //Lê o primeiro registro do arquivo
//            registro = entrada.readLine();
//            while (registro != null) {
//                //Enquanto não chegou ao final do arquivo
//                tipoRegistro = registro.substring(0, 2);
//
//                if (tipoRegistro.equals("00")) {
//                    System.out.println("\nÉ um registro de header");
//                    System.out.println("Tipo de arquivo: " + registro.substring(2, 17));
//                    System.out.println("Data/hora de gravação: " + registro.substring(13, 32));
//                    System.out.println("Versão do documento: " + registro.substring(32, 34));
//                } else if (tipoRegistro.equals("01")) {
//                    System.out.println("É um registro de trailer");
//                    qtdResgistrosGravados = Integer.valueOf(registro.substring(2, 7));
//                    if (qtdResgistrosGravados == listaLida.size()) {
//                        System.out.println("Quantidade de registros gravados compatível com quantidade lida");
//                    } else {
//                        System.out.println("Quantidade de registro gravados imcompatível com quantidade lida");
//                    }
//
//                } else if (tipoRegistro.equals("02")) {
//                    System.out.println("É um registro de corpo");
//                    id = Integer.valueOf(registro.substring(2, 5));
//                    cnpj = registro.substring(5, 23);
//                    cep = registro.substring(23, 32);
//                    numero = Integer.valueOf(registro.substring(32, 36));
//                    cidade = registro.substring(36, 61).trim();
//                    nome = registro.substring(61, 91).trim();
//                    horaAbre = registro.substring(91, 96);
//                    horaFecha = registro.substring(96, 101);
//                    telefone = registro.substring(101, 115);
//
//
//                    listaLida.add(new CentroEsportivo(id, cnpj, cep, numero, cidade, nome, horaAbre, horaFecha, telefone));
//                } else {
//                    System.out.println("Tipo de registro inválido");
//                }
//                //Le o proximo registro
//                registro = entrada.readLine();
//            }
//            entrada.close();
//        } catch (IOException erro) {
//            System.out.println("Erro ao ler o arquivo: " + erro.getMessage());
//        }
//
//        System.out.println("\nConteúdo lido do arquivo");
//        for (CentroEsportivo c : listaLida) {
//            System.out.println(c);
//        }
//    }

    public static String gravaArquivoTxtAgendamento(List<Agendamento> lista, String nomeArq) {
        Integer contaRegDados = 0;
        String relatorio = "";
        String header = "00AGENDAMENTO";
        Date dataDeHoje = new Date();

        LocalDateTime localDateTime = LocalDateTime.ofInstant(dataDeHoje.toInstant(), ZoneId.of("America/Sao_Paulo"));
        dataDeHoje = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());

        DateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss", Locale.GERMANY);
        String horaAtual = df.format(dataDeHoje);

        SimpleDateFormat formataData = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        header += dataDeHoje;
        header += "01";
        relatorio += header + "\n";

        for (Agendamento a : lista) {
            String corpo = "02";
            corpo += String.format("%5d", a.getId());
            corpo += String.format("%3d", a.getFk_Jogador());
            corpo += String.format("%4d", a.getFkQuadra());
            corpo += String.format("%06.2f", a.getPreco());
            corpo += String.format("%16.16s", a.getHora_Marcada());
            relatorio += corpo + "\n";
            contaRegDados++;
        }

        String trailer = "01";
        trailer += String.format("%05d", contaRegDados);
        relatorio += trailer;

        return relatorio;
    }

    public static List<Agendamento> leArquivoTxtAgendamento(String conteudo) throws ParseException {
        LocalDateTime horaMarcada;
        Integer id, idJogador, idQuadra;
        Double preco;

        List<Agendamento> agendamentos = new ArrayList<>();

        Scanner scanner = new Scanner(conteudo);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Agendamento agendamento = new Agendamento();
            Integer contador = 0;
            if(line.substring(0, 2).equals("00")) {
                System.out.println("\nsou um header");
            } else if (line.substring(0, 2).equals("02")) {
                contador = 1;
                agendamento = new Agendamento();
                id = Integer.valueOf(line.substring(2, 7));
                idJogador = Integer.valueOf(line.substring(7, 10));
                idQuadra = Integer.valueOf(line.substring(10, 14));
                preco = Double.valueOf(line.substring(14, 20).replace(',', '.'));
                horaMarcada = LocalDateTime.parse(line.substring(20, 36));

                line = scanner.nextLine();

                agendamento.setId(id);
                agendamento.setFk_Jogador(idJogador);
                agendamento.setFkQuadra(idQuadra);
                agendamento.setPreco(preco);
                agendamento.setHora_Marcada(horaMarcada);

            } else if (line.substring(0, 2).equals("01")) {
                System.out.println("\nsou trailer");
            } else {
                System.out.println("\ntipo de registro inválido");
            }

            if(contador > 0) {
                agendamentos.add(agendamento);
            }

        }
        scanner.close();

        return agendamentos;
    }

    public static List<CentroEsportivo> leArquivoTxtCentroEsportivo(String conteudo){
        String cnpj, cep, cidade, nome, horaAbre, horaFecha, telefone;
        Integer id, numero,fkLocatario;


        List<CentroEsportivo> centroEsportivos = new ArrayList<>();


        Scanner scanner = new Scanner(conteudo);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            CentroEsportivo centroEsportivo = new CentroEsportivo();
            Integer contador = 0;
            if(line.substring(0, 2).equals("00")) {
                System.out.println("\nsou um header");
            } else if (line.substring(0, 2).equals("02")) {
                contador = 1;
                centroEsportivo = new CentroEsportivo();
                id = Integer.valueOf(line.substring(2, 6));
                cnpj = line.substring(6, 24).trim();
                cep = line.substring(24, 33).trim();
                numero = Integer.valueOf(line.substring(33, 37));
                cidade = line.substring(37, 62).trim();
                nome = line.substring(62, 92).trim();
                horaAbre = line.substring(92, 97);
                horaFecha = line.substring(97, 102);
                telefone = line.substring(102, 106).trim();
                fkLocatario = Integer.valueOf(line.substring(106,108));

                line = scanner.nextLine();

                centroEsportivo.setId(id);
                centroEsportivo.setCnpj(cnpj);
                centroEsportivo.setCep(cep);
                centroEsportivo.setNumero(numero);
                centroEsportivo.setCidade(cidade);
                centroEsportivo.setNome(nome);
                centroEsportivo.setHoraAbre(horaAbre);
                centroEsportivo.setHoraFecha(horaFecha);
                centroEsportivo.setTelefone(telefone);
                centroEsportivo.setFkLocatario(fkLocatario);


            } else if (line.substring(0, 2).equals("01")) {
                System.out.println("\nsou trailer");
            } else {
                System.out.println("\ntipo de registro inválido");
            }

            if(contador > 0) {
                centroEsportivos.add(centroEsportivo);
            }

        }
        scanner.close();

        return centroEsportivos;
    }

    public static void main(String[] args) {

        ListaObj<CentroEsportivo> lista = new ListaObj<>(7);
        List<CentroEsportivo> listaCentroEsportivo = new ArrayList<>();
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
                2190, "Santo andré", "Afonso Quadras", "09:00", "22:00", "(11) 94002-8922",84));
        lista.adiciona(new CentroEsportivo(2, "60.210.961/0001-52", "09220-440", 440,
                "São Paulo", "Web Quadras Poliesportivas", "09:00", "18:00", "(11) 95271-7924",84));
        lista.adiciona(new CentroEsportivo(3, "62.587.302/0001-65", "09220-140", 210,
                "São Paulo", "Quadras Barra Funda", "08:00", "18:00", "(11) 99119-1137",84));

        listaCentroEsportivo.add(new CentroEsportivo(1, "99.378.761/0001-49", "01001-001",
                2190, "Santo andré", "Afonso Quadras", "09:00", "22:00", "(11) 94002-8922",84));
        listaCentroEsportivo.add(new CentroEsportivo(2, "60.210.961/0001-52", "09220-440", 440,
                "São Paulo", "Web Quadras Poliesportivas", "09:00", "18:00", "(11) 95271-7924",84));
        listaCentroEsportivo.add(new CentroEsportivo(3, "62.587.302/0001-65", "09220-140", 210,
                "São Paulo", "Quadras Barra Funda", "08:00", "18:00", "(11) 99119-1137",84));

//        while (lista.hasNext()) {
//            CentroEsportivo centroEsportivo = (CentroEsportivo) lista.next();
//            if (centroEsportivo.getCidade().equals("São Paulo")) {
//                System.out.println(centroEsportivo);
//            }
//        }
//
//
//        lista.exibe();

        gravaArquivoTxtCentroEsportivo(listaCentroEsportivo, "CentroE.txt");
    }

}