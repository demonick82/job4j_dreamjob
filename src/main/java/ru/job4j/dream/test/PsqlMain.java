package ru.job4j.dream.test;

import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.model.City;
import ru.job4j.dream.model.Post;
import ru.job4j.dream.model.User;
import ru.job4j.dream.store.PsqlStore;
import ru.job4j.dream.store.Store;


public class PsqlMain {
    public static void main(String[] args) {
        Store store = PsqlStore.instOf();
        City city1 = new City(1, "Санкт-Петербург");
        City city2 = new City(2, "Москва");
        City city3 = new City(3, "Казань");
        City city4 = new City(4, "Нижний Новгород");
        City city5 = new City(5, "Ростов на Дону");

        store.saveCity(city1);
        store.saveCity(city2);
        store.saveCity(city3);
        store.saveCity(city4);
        store.saveCity(city5);

        for (City city : store.findAllCity()) {
            System.out.println(city);
        }
    }
/*        for (Post post : store.findAllPostsToday()
        ) {
            System.out.println(post);
        }*/
}
