package ru.kev.sort;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;


/**
 * Класс для сортировки массива по количеству повторений числа в массиве
 *
 * @author Kotelnikova E. group 15it18
 */
public class Main {

    public static void main(String[] args) {

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


        Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();

        for (Integer key : numbers) {
            if (hashMap.keySet().contains(key)) {
                hashMap.put(key, hashMap.get(key) + 1);
            } else {
                hashMap.put(key, 1);
            }
        }
        System.out.println(hashMap);
















// Set<Map.Entry<Integer, Integer>> set = hashMap.entrySet();
//
//
//        int sortMas[] = new int[mas.length];
//            //for (int j = 0; j < sortMas.length; j++) {
//        for (Map.Entry<Integer, Integer> val : set) {
//                for (int i = 0; i < val.getValue(); i++) {
//                    //sortMas[j] = val.getKey();
//                    System.out.print(val.getKey() + " ");
//
//                }
//            }

    }
}

