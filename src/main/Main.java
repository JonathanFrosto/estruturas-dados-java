package main;

import estruturas.Fila;
import estruturas.Pilha;

public class Main {

    public static void main(String[] args) {

        final String FIRST = "Fist";
        final String SECOND = "Second";

        System.out.println("\n-- TESTE PILHA --\n");
        Pilha<String> pilha = new Pilha<>();

        System.out.println(pilha.top());
        System.out.println(pilha.isEmpty());
        pilha.push(FIRST);
        System.out.println(pilha.top());
        pilha.push(SECOND);
        System.out.println(pilha.top());
        System.out.println(pilha.pop());
        System.out.println(pilha.pop());

        System.out.println("\n-- TESTE FILA --\n");
        Fila<String> fila = new Fila<>();

        System.out.println(fila.dequeue());
        System.out.println(fila.isEmpty());
        fila.enqueue(FIRST);
        System.out.println(fila.dequeue());
        System.out.println(fila.isEmpty());
        fila.enqueue(FIRST);
        fila.enqueue(SECOND);
        System.out.println(fila.first());
        System.out.println(fila.dequeue());
        System.out.println(fila.dequeue());
        System.out.println(fila.isEmpty());
    }
}
