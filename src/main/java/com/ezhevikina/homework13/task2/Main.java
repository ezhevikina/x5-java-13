package com.ezhevikina.homework13.task2;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<People> people = new ArrayList<>(Arrays.asList(
                new People("Вася", 16, Sex.MAN),
                new People("Петя", 23, Sex.MAN),
                new People("Елена", 42, Sex.WOMAN),
                new People("Иван Иванович", 69, Sex.MAN)));

        getReservists(people).forEach(System.out::println);
        getAvgManAge(people).ifPresent(System.out::println);
        getPeopleAbleToWork(people).forEach(System.out::println);

    }

    //Выбрать мужчин-военнообязанных (от 18 до 27 лет)
    public static List<People> getReservists(List<People> people) {
        return people.stream()
                .filter(man -> man.getSex() == Sex.MAN)
                .filter(man -> man.getAge() >= 18 && man.getAge() < 27)
                .collect(Collectors.toList());
    }

    //Найти средний возраст среди мужчин
    public static OptionalDouble getAvgManAge(List<People> people) {
        return people.stream()
                .filter(man -> man.getSex() == Sex.MAN)
                .mapToInt(People::getAge)
                .average();
    }

    //Найти кол-во потенциально работоспособных людей в выборке
    //(т.е. от 18 лет и учитывая что женщины выходят в 55 лет, а мужчина в 60)
    public static List<People> getPeopleAbleToWork(List<People> people) {
        return people.stream()
                .filter(man -> man.getAge() >= 18)
                .filter(man -> {
                    if (man.getSex() == Sex.MAN && man.getAge() < 60) {
                        return true;
                    } else {
                        return man.getSex() == Sex.WOMAN && man.getAge() < 55;
                    }
                })
                .collect(Collectors.toList());
    }
}
