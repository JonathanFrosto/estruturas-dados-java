package main;

import estruturas.*;

public class Main {

    public static void main(String[] args) {

        final String FIRST = "First";
        final String SECOND = "Second";
        final String THIRD = "Third";
        final String fourth = "Fourth";
        final String fifth = "Fifth";

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
        listaDupla.add(THIRD);
        System.out.println(listaDupla);

        listaDupla.add(fourth, 0);
        System.out.println(listaDupla);
        listaDupla.add(fifth, 2);
        System.out.println(listaDupla);
        listaDupla.remove(2);
        System.out.println(listaDupla);
        listaDupla.remove(3);
        System.out.println(listaDupla);
        listaDupla.remove(0);
        System.out.println(listaDupla);
        System.out.println(listaDupla.get(1));
        System.out.println(listaDupla.get(0));

        System.out.println("\n-- TESTE LISTA CIRCULAR --\n");
        ListaCircular<String> listaCircular = new ListaCircular<>();

        System.out.println(listaCircular.isEmpty());
        System.out.println(listaCircular);
        System.out.println(listaCircular.size());
        listaCircular.add(FIRST);
        System.out.println(listaCircular);
        listaCircular.add(SECOND);
        System.out.println(listaCircular);
        listaCircular.add(THIRD);
        System.out.println(listaCircular);
        listaCircular.add(fourth, 1);
        System.out.println(listaCircular);
        listaCircular.add(fifth, 0);
        System.out.println(listaCircular);
        listaCircular.remove(4);
        System.out.println(listaCircular);
        System.out.println(listaCircular.get(1));

        System.out.println("\n-- TESTE LISTA CIRCULAR --\n");
        ArvoreBinaria<Integer> arvoreBinaria = new ArvoreBinaria<>();

        arvoreBinaria.add(5);
        arvoreBinaria.add(6);
        arvoreBinaria.add(2);
        arvoreBinaria.add(1);
        arvoreBinaria.add(3);
        arvoreBinaria.add(4);
        System.out.println(arvoreBinaria.inOrder());
        arvoreBinaria.remove(5);
        System.out.println(arvoreBinaria.inOrder());
        System.out.println(arvoreBinaria.contains(5));
        System.out.println(arvoreBinaria.contains(2));
    }
}
