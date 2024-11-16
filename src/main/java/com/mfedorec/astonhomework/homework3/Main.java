package com.mfedorec.astonhomework.homework3;
import com.mfedorec.astonhomework.homework3.myarraylist.MyArrayList;
import com.mfedorec.astonhomework.homework3.mylinkedlist.MyLinkedList;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //MyArrayList
        System.out.println("MyArrayList"+ "\n___________________________");

        MyArrayList<Integer> myList = new MyArrayList<>();
        // Добавляем элементы по одному
        myList.add(1);
        myList.add(2);
        myList.add(3);
        System.out.println("До добавления массива: " + myList);

        // Добавляем массив элементов
        Integer[] additionalElements = {4, 5, 6, 7, 8};
        myList.addAll(additionalElements);
        System.out.println("После добавления массива: " + myList);

        // Часть 2: Конструктор
        List<Integer> initialList = Arrays.asList(5, 3, 8, 1);
        MyArrayList<Integer> myList2 = new MyArrayList<>(initialList);
        System.out.println("После инициализации: " + myList2);

        // Часть 2: Статический метод сортировки
        MyArrayList.sort(initialList);
        System.out.println("После сортировки: " + initialList);


        //MyLinkedList
        System.out.println("\nMyLinkedList" + "\n___________________________");

        MyLinkedList<Integer> linkList = new MyLinkedList<>();
        linkList.add(1);
        linkList.add(2);
        linkList.add(3);
        linkList.addFirst(0);
        System.out.println("Список: " + linkList); // [0, 1, 2, 3]
        linkList.remove(2); // Удаляем элемент с индексом 2
        System.out.println("После удаления: " + linkList); // [0, 1, 3]
        System.out.println("Элемент по индексу 1: " + linkList.get(1)); // 1
        System.out.println("Размер списка: " + linkList.size()); // 3

    }
}

