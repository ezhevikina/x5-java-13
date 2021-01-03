package com.ezhevikina.homework13;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Task1 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 1, 2, 3, 4, 510, 32, 25, 74);

        System.out.println(howManyOnes(list));

        try {
            System.out.println(get100(list));
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(getTwoElementsStartFromSecond(list));
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(getThirdElement(list));
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }

    // Вернуть количество вхождений цифры 1
    public static long howManyOnes(List<Integer> list) {
        return list.stream().filter(x -> x == 1).count();
    }

    //Найти элемент в коллекции равный 100 или кинуть ошибку
    public static Integer get100(List<Integer> list) throws NoSuchElementException {
        return list.stream().filter(x -> x == 100).findFirst()
                .orElseThrow(() -> new NoSuchElementException("element not found"));
    }

    //Вернуть два элемента начиная со второго
    public static List<Integer> getTwoElementsStartFromSecond(List<Integer> list) throws IndexOutOfBoundsException {
        if (list.size() < 3) {
            throw new IndexOutOfBoundsException("list size is less than 3");
        }
        return list.stream().skip(1).limit(2).collect(Collectors.toList());
    }

    //Вернуть третий элемент коллекции по порядку
    public static Integer getThirdElement(List<Integer> list) throws IndexOutOfBoundsException {
        return list.stream().skip(2).findFirst()
                .orElseThrow(() -> new IndexOutOfBoundsException("list size is less than 3"));
    }
}
