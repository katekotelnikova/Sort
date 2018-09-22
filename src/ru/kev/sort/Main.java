package ru.kev.sort;


import java.io.*;
import java.util.*;

/**
 * Класс для сортировки массива по количеству повторений числа в массиве
 *
 * @author Kotelnikova E. group 15it18
 */

public class Main {

    public static void main(String[] args) {

        ArrayList<Integer> numbers = readFile();

        Map<Integer, Integer> hashMap = freq(numbers);

        System.out.println("Сортируем числа...");
        SortedSet<Map.Entry<Integer, Integer>> set = sortedNumbers(hashMap);

        writeInFile(set);
    }

    /**
     * Метод для записи отсортированных чисел в файл.
     * @param set множество чисел
     */
    private static void writeInFile(SortedSet<Map.Entry<Integer, Integer>> set) {
        try (FileWriter writer = new FileWriter("output.txt")) {
            for (Map.Entry<Integer, Integer> val : set) {
                for (int i = 0; i < val.getValue(); i++) {
                    writer.write(val.getKey() + " ");
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Метод возвращает набор чисел, отсортированных по количеству повторений
     *
     * @param hashMap набор данных в виде: число-количество повторений
     * @return набор чисел
     */
    private static SortedSet<Map.Entry<Integer, Integer>> sortedNumbers(Map<Integer, Integer> hashMap) {
        SortedSet<Map.Entry<Integer, Integer>> set = new TreeSet<>(Map.Entry.<Integer, Integer>comparingByValue().reversed());
        set.addAll(hashMap.entrySet());

        System.out.println(set);
        return set;
    }


    /**
     * Метод подсчитывает количество повторений числа в списке и
     * сохраняет в hashMap в виде: ключ(число) - значение(кол-во повторений)
     *
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
     *
     * @return Array List, содержащий числа из файла
     */
    private static ArrayList<Integer> readFile() {
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
