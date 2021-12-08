package com.resenha.projetoresenha.listas;

public class ListaObj<T> implements Iterator {

    // Atributos
    private T[] vetor;
    private int nroElem;
    private int posicao;


    // Construtor
    public ListaObj(int tamanho) {
        vetor = (T[]) new Object[tamanho];
        nroElem = 0;
        posicao = 0;
    }

    public ListaObj(T[] vetor) {
        this.vetor = vetor;
    }

    // Métodos

    public boolean adiciona(T elemento) {
        if (nroElem >= vetor.length) {
            System.out.println("Lista está cheia");
            return false;
        }
        vetor[nroElem++] = elemento;
        return true;
    }

    public void exibe() {
        if (nroElem == 0) {
            System.out.println("\nA lista está vazia.");
        } else {
            System.out.println("\nElementos da lista:");
            for (int i = 0; i < nroElem; i++) {
                System.out.print(vetor[i]);
            }
            System.out.println();
        }
    }

    public Object next() {
        T var = vetor[posicao];
        posicao++;
        return var;
    }

    public boolean hasNext() {
        if (nroElem >= vetor.length || vetor[posicao] == null) {
            return false;
        }
        return true;
    }

    public int busca(T elementoBuscado) {
        for (int i = 0; i < nroElem; i++) {
            if (vetor[i].equals(elementoBuscado)) {
                return i;
            }
        }
        return -1;
    }

    public boolean removePeloIndice(int indice) {
        if (indice < 0 || indice >= nroElem) {
            System.out.println("\nÍndice inválido!");
            return false;
        }
        // Loop para "deslocar para a esquerda" os elementos do vetor
        // sobrescrevendo o elemento removido
        for (int i = indice; i < nroElem - 1; i++) {
            vetor[i] = vetor[i + 1];
        }
        nroElem--;
        return true;
    }

    public boolean removeElemento(T elementoARemover) {
        return removePeloIndice(busca(elementoARemover));
    }

    public int getTamanho() {
        return nroElem;
    }

    public T getElemento(int indice) {
        if (indice < 0 || indice >= nroElem) {
            return null;
        }
        return vetor[indice];
    }

    public void limpa() {
        nroElem = 0;
    }

}

