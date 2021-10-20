package ListaCentroEsportivo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Teste {

    public static void gravaArquivoCsv(ListaCentroEsportivo.ListaObj<CentroEsportivo> lista, String nomeArq) {
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

    public static void leExibeArquivoCsv(String nomeArq) {
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

    public static void main(String[] args) {

        ListaCentroEsportivo.ListaObj<CentroEsportivo> lista = new ListaObj<>(7);
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
//        gravaArquivoCsv(lista,"centroE");
//
//        leExibeArquivoCsv("centroE");
        }
    }

