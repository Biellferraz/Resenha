package com.resenha.projetoresenha.listas;

import com.resenha.projetoresenha.dominio.CentroEsportivo;

public interface Iterator {
    boolean hasNext();
    Object next();
//            while (lista.hasNext()) {
//        CentroEsportivo centroEsportivo = (CentroEsportivo) lista.next();
//        if (centroEsportivo.getCidade().equals("São Paulo")) {
//            System.out.println(centroEsportivo);
//        }
//    }
}
