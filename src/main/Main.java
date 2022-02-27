package main;

import estruturas.Fila;
import estruturas.Lista;
import estruturas.ListaDupla;
import estruturas.Pilha;

public class Main {

    public static void main(String[] args) {

        final String FIRST = "First";
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

        System.out.println("\n-- TESTE LISTA --\n");
        Lista<String> lista = new Lista<>();

        System.out.println(lista.size());
        System.out.println(lista.isEmpty());
        System.out.println(lista);
        lista.add(FIRST, 0);
        System.out.println(lista);
        lista.add(SECOND, 0);
        System.out.println(lista);
        System.out.println(lista.get(0));
        System.out.println(lista.get(1));
        lista.remove(0);
        System.out.println(lista.get(0));

        System.out.println("\n-- TESTE LISTA DUPLA --\n");
        ListaDupla<String> listaDupla = new ListaDupla<>();

        System.out.println(listaDupla.isEmpty());
        System.out.println(listaDupla);
        listaDupla.add(FIRST);
        System.out.println(listaDupla);
        listaDupla.add(SECOND);
        System.out.println(listaDupla);
        listaDupla.add("Third");
        System.out.println(listaDupla);
        listaDupla.add("Fourth", 0);
        System.out.println(listaDupla);
        listaDupla.add("Fifth", 2);
        System.out.println(listaDupla);
        listaDupla.remove(2);
        System.out.println(listaDupla);
        listaDupla.remove(3);
        System.out.println(listaDupla);
        listaDupla.remove(0);
        System.out.println(listaDupla);
        System.out.println(listaDupla.get(1));
        System.out.println(listaDupla.get(0));
    }
}
