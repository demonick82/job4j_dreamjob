package ru.job4j.dream.store;

import ru.job4j.dream.model.Post;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Store {
    private static final Store INST = new Store();

    private final Map<Integer, Post> posts = new ConcurrentHashMap<>();

    private Store() {
        posts.put(1, new Post(1, "Junior Java Job", "Work in Sber",
                LocalDate.of(2021, 8, 12)));
        posts.put(2, new Post(2, "Middle Java Job", "Work in Luxoft",
                LocalDate.of(2021, 9, 10)));
        posts.put(3, new Post(3, "Senior Java Job", "Work in Yandex",
                LocalDate.of(2021, 9, 11)));
    }

    public static Store instOf() {
        return INST;
    }

    public Collection<Post> findAll() {
        return posts.values();
    }
}
