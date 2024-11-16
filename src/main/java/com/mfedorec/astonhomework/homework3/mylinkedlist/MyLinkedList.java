package com.mfedorec.astonhomework.homework3.mylinkedlist;
import java.util.Collection;

public class MyLinkedList<T> {

    private Node<T> first; // Первый элемент списка
    private Node<T> last;  // Последний элемент списка
    private int size;

    // Внутренний класс для узла списка
    private static class Node<T> {
        T data;
        Node<T> next;   // Ссылка на следующий узел
        Node<T> prev;   // Ссылка на предыдущий узел

        Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public MyLinkedList() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    public MyLinkedList(Collection<? extends T> collection) {
        addAll(collection);
    }

    // Добавление элемента в конец
    public void add(T element) {
        Node<T> newNode = new Node<>(element);
        if (last == null) { // Если список пуст
            first = newNode;
        } else {
            last.next = newNode;
            newNode.prev = last;
        }
        last = newNode;
        size++;
    }

    // Добавление элемента в начало
    public void addFirst(T element) {
        Node<T> newNode = new Node<>(element);
        if (first == null) { // Если список пуст
            last = newNode;
        } else {
            first.prev = newNode;
            newNode.next = first;
        }
        first = newNode;
        size++;
    }

    // Удаление элемента по индексу
    public T remove(int index) {
        checkIndex(index);
        Node<T> target = getNode(index);

        T removedData = target.data;

        Node<T> prevNode = target.prev;
        Node<T> nextNode = target.next;

        if (prevNode == null) { // Удаляется первый элемент
            first = nextNode;
        } else {
            prevNode.next = nextNode;
        }

        if (nextNode == null) { // Удаляется последний элемент
            last = prevNode;
        } else {
            nextNode.prev = prevNode;
        }

        size--;
        return removedData;
    }

    // Получение элемента по индексу
    public T get(int index) {
        checkIndex(index);
        return getNode(index).data;
    }

    // Получение узла по индексу
    private Node<T> getNode(int index) {
        Node<T> current;
        if (index < size / 2) { // Ближе к first
            current = first;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else { // Ближе к last
            current = last;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }
        return current;
    }
    // Добавление нескольких элементов
    public void addAll(Collection<? extends T> collection) {
        for (T item : collection) {
            add(item);
        }
    }

    // Проверка индекса на корректность
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    // Метод сортировки

    public static <T extends Comparable<? super T>> void sort(MyLinkedList<T> list) {
        if (list.size <= 1) return;
        boolean swapped;
        do {
            swapped = false;
            Node<T> current = list.first;
            while (current != null && current.next != null) {
                if (current.data.compareTo(current.next.data) > 0) {
                    T temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
    }

    // Вывод списка в строку
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<T> current = first;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }

    // Получение текущего размера списка
    public int size() {
        return size;
    }
}
