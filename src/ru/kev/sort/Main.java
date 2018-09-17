package ru.kev.sort;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


/**
 * Класс для сортировки массива по количеству повторений числа в массиве
 *
 * @author Kotelnikova E. group 15it18
 */
public class Main {

    public static void main(String[] args) {

        ArrayList<Integer> numbers = input();

        Map<Integer, Integer> hashMap = freq(numbers);

    }

    /**
     * Метод подсчитывает количество повторений числа в списке и
     * сохраняет в hashMap в виде: ключ(число) - значение(кол-во повторений)
     * @param numbers список чисел
     * @return hashMap
     */
    private static Map<Integer, Integer> freq(ArrayList<Integer> numbers) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (Integer key : numbers) {
            if (hashMap.keySet().contains(key)) {
                hashMap.put(key, hashMap.get(key) + 1);
            } else {
                hashMap.put(key, 1);
            }
        }
        System.out.println(hashMap);
        return hashMap;
    }

    /**
     * Метод для считывания данных из файла в Array List.
     * @return Array List, содержащий числа из файла
     */
    private static ArrayList<Integer> input() {
        ArrayList<Integer> numbers = new ArrayList<>();
        String s;
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            s = reader.readLine();
            for (String num : s.split(" ")) {
                numbers.add(Integer.parseInt(num));
            }

        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return numbers;
    }
}
