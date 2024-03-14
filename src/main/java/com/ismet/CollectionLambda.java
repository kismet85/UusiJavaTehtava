package com.ismet;

import java.util.ArrayList;

public class CollectionLambda {



    public static void main(String[] args) {
        ArrayList<Integer>numeroLista = new ArrayList<>();

        numeroLista.add(10);
        numeroLista.add(5);
        numeroLista.add(8);
        numeroLista.add(20);
        numeroLista.add(15);
        numeroLista.add(3);
        numeroLista.add(12);

        // Printtaa luvut aluksi sellaisenaan
        numeroLista.forEach(System.out::print);

        // poista jos luku on jaollinen kahdella
        numeroLista.removeIf(numero -> numero % 2 == 0);

        // tuplaa kaikki luvut
        numeroLista.replaceAll(numero -> numero*2);
        System.out.println();

        // Printtaa kaikki luvut
        numeroLista.forEach(System.out::print);
        System.out.println();
        
        // Summa luvut yhteen
        int sum = numeroLista.stream().mapToInt(Integer::intValue).sum();

        // Printtaa summa
        System.out.println("Lukujen summa on: " + sum);
    }

}
