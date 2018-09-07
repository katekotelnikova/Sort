package ru.kev.sort;

import java.util.HashMap;

/**
 * Класс для сортировки массива по количеству повторений числа в массиве
 *
 * @author Kotelnikova E. group 15it18
 */
public class Main {

    public static void main(String[] args) {
        int mas[] = {10, 12, 12, 2, 3, 3};

        HashMap<Integer, Integer> uniqueValues = new HashMap<>();

        for (int i = 0; i < mas.length; i++) {
            int count = 0;
            for (int j = 0; j < mas.length; j++) {
                if (mas[i] == mas[j]) {
                    count++;
                }
            }
            uniqueValues.put(mas[i], count);
        }
        System.out.println(uniqueValues);
    }
}

