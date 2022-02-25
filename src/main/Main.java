package main;

import estruturas.Fila;
import estruturas.No;
import estruturas.Pilha;

public class Main {

    public static void main(String[] args) {
        No<String> firstNo = new No<>("First");
        No<String> secondNo = new No<>("Second");

        firstNo.setNextNo(secondNo);

        System.out.println(firstNo);
        System.out.println(firstNo.getNextNo());

        System.out.println("\n-- TESTE PILHA --\n");
        Pilha<String> pilha = new Pilha<>();

        System.out.println(pilha.top());
        System.out.println(pilha.isEmpty());
        pilha.push(firstNo);
        System.out.println(pilha.top());
        pilha.push(secondNo);
        System.out.println(pilha.top());
        System.out.println(pilha.pop());
        System.out.println(pilha.pop());

        System.out.println("\n-- TESTE FILA --\n");
        Fila<String> fila = new Fila<>();

        System.out.println(fila.dequeue());
        System.out.println(fila.isEmpty());
        fila.enqueue(firstNo);
        System.out.println(fila.dequeue());
        System.out.println(fila.isEmpty());
        fila.enqueue(firstNo);
        fila.enqueue(secondNo);
        System.out.println(fila.first());
        System.out.println(fila.dequeue());
        System.out.println(fila.dequeue());
        System.out.println(fila.isEmpty());
    }
}
