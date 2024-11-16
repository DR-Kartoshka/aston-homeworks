package com.mfedorec.astonhomework.homework3.myarraylist;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class MyArrayList<T extends Comparable<T>> {

    private T[] array; //массив для хранения элементов
    private final int INIT_SIZE = 10; //размер по умолчанию
    private int size; //текущий размер списка
    private boolean isSorted = false;

    //Конструктор по умолчанию
    public MyArrayList() {
        array = (T[]) new Comparable[INIT_SIZE];
        size = 0;
    }

    // Переопределяем toString для удобного вывода
    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(array, size));
    }

    // Конструктор, принимающий другую коллекцию
    public MyArrayList(Collection<? extends T> collection) {
        this(); // Вызываем основной конструктор для инициализации массива
        for (T element : collection) { // Итерируемся по коллекции
            add(element); // Добавляем каждый элемент
        }
    }

    // Проверка индекса
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекса не сущетсвует" + "\n Индекс: " + index + ", Размер: " + size);
        }
    }

    //Проверка на необходимость увеличение размера массива + увеличение

    private void ensureCapacity(int additionalCapacity) {
        if (size + additionalCapacity > array.length) {
            int newCapacity = Math.max(array.length + (array.length / 2) + 1, size + additionalCapacity);
            array = Arrays.copyOf(array, newCapacity);
        }
    }
    private void ensureCapacity() {
        ensureCapacity(1);
    }

    //Метод add (добавляет в конец массива)

    public void add(T value) {
        ensureCapacity(); // Проверяем, достаточно ли места
        array[size] = value; //Добавляем элемент
        size++;
        isSorted = false;
    }

    //Метод addAll - метод добавления нескольких элементов

    public void addAll(T[] newElements) {
        if (newElements == null || newElements.length == 0) {
            return; // Если массив пустой или null, ничего не делаем
        }
        ensureCapacity(newElements.length); // Увеличиваем массив, если нужно
        for (int i = 0; i < newElements.length; i++) { // Проходим по массиву
            array[size] = newElements[i]; // Добавляем каждый элемент
            size++; // Увеличиваем размер
        }
    }


    //Метод get - получение элемента по индексу

    public T get(int index) {
        //проверка на наличие такого индекса
            checkIndex(index);
            return array[index];
        }


    //Метод remove - удаление элемента по индексу

    public T remove(int index) {
        checkIndex(index);
        T removedElement = array[index]; // Сохраняем удаляемый элемент

        // Сдвигаем элементы влево
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }

        array[size - 1] = null; // Убираем ссылку на последний элемент
        size--; // Уменьшаем размер списка

        return removedElement; // Возвращаем удалённый элемент
    }


    //Метод сортировки пузырьком (с флагом оптимизации isSorted,
    //если отсортировали - true, если добавили add - не отсортированно)

    public void bubbleSort() {
        if (isSorted == false) {
            for (int i = 0; i < size - 1; i++) { // Внешний цикл: проход по всем элементам, кроме последнего
                for (int j = 0; j < size - 1 - i; j++) { // Внутренний цикл: сравнение соседних элементов
                    if (array[j].compareTo(array[j + 1]) > 0) { // Если текущий больше следующего
                        // Меняем местами элементы
                        T temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                    }
                }
            }
            System.out.println("Список отсортирован");
            isSorted = true;
        }
        else{
            System.out.println("Список уже отсортирован");
        }
    }

    //Статический метод сордировки
    public static <T extends Comparable<? super T>> void sort(List<T> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - 1 - i; j++) {
                if (list.get(j).compareTo(list.get(j + 1)) > 0) {
                    T temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
    }

}
