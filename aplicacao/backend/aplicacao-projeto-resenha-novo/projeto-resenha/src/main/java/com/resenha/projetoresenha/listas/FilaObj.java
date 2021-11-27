package com.resenha.projetoresenha.listas;

import java.util.ArrayList;
import java.util.List;

public class FilaObj<T> {



    // Atributos
    private T[] fila;
    private int tamanho;

    // Construtor
    public FilaObj(int capacidade) {
        fila = (T[]) new Object[capacidade];
        tamanho = 0;
    }

    // Métodos

    public Boolean isEmpty() {
        return tamanho == 0;
    }

    public Boolean isFull() {
        return tamanho == fila.length;
    }

    public void insert(T info) {
        if (isFull()) {
            System.out.println("Fila cheia!");
        }
        else {
            fila[tamanho++] = info;
        }
    }

    public T peek() {
        if (isEmpty()) {
            return null;
        }
//        int retorno = pilha[topo];
//        topo--;
//        return retorno;

        return fila[0];
    }

    public T poll() {
        T primeiro = peek();
        if (!isEmpty()) {
            for (int i = 0; i < tamanho - 1; i++) {
                fila[i] = fila[i + 1];
            }
            fila[tamanho - 1] = null;
            tamanho--;
        }
        return primeiro;
    }
    public void exibe() {
        if (isEmpty()) {
            System.out.println("Pilha vazia");
        }
        else {
            for (int i = 0; i < tamanho; i++) {
                System.out.print(fila[i]);
            }
        }
    }

    public int getTamanho(){
        return tamanho;
    }

    public List<T> toList() {
        List<T> lista = new ArrayList<>();
        for (int i = 0; i < tamanho; i++) {
            lista.add(fila[i]);
        }
        return lista;
    }
}
