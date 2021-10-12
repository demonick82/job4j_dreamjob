package ru.job4j.dream.store;

import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.model.City;
import ru.job4j.dream.model.Post;
import ru.job4j.dream.model.User;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class MemStore implements Store {
    private static final MemStore INST = new MemStore();
    private final Map<Integer, Post> posts = new ConcurrentHashMap<>();
    private final Map<Integer, Candidate> candidates = new ConcurrentHashMap<>();
    private static AtomicInteger POST_ID = new AtomicInteger(4);
    private static AtomicInteger CANDIDATE_ID = new AtomicInteger(4);


    private MemStore() {
/*        posts.put(1, new Post(1, "Junior Java Job", "Work in Sber",
                LocalDate.of(2021, 8, 12)));
        posts.put(2, new Post(2, "Middle Java Job", "Work in Luxoft",
                LocalDate.of(2021, 9, 10)));
        posts.put(3, new Post(3, "Senior Java Job", "Work in Yandex",
                LocalDate.of(2021, 9, 11)));
        candidates.put(1, new Candidate(1, "Junior Java"));
        candidates.put(2, new Candidate(2, "Middle Java"));
        candidates.put(3, new Candidate(3, "Senior Java"));*/
    }

    public static MemStore instOf() {
        return INST;
    }

    public void savePost(Post post) {
        if (post.getId() == 0) {
            post.setId(POST_ID.incrementAndGet());
        }
        posts.put(post.getId(), post);
    }

    public void saveCandidate(Candidate candidate) {
        if (candidate.getId() == 0) {
            candidate.setId(CANDIDATE_ID.incrementAndGet());
        }
        candidates.put(candidate.getId(), candidate);
    }

    public Post postFindById(int id) {
        return posts.get(id);
    }

    public Candidate candidateFindById(int id) {
        return candidates.get(id);
    }


    public Collection<Post> findAllPosts() {
        return posts.values();
    }

    @Override
    public Collection<Post> findAllPostsToday() {
        return null;
    }

    public Collection<Candidate> findAllCandidates() {
        return candidates.values();
    }

    @Override
    public Collection<Candidate> findAllCandidatesToday() {
        return null;
    }

    public void deleteCandidate(int id) {
        candidates.remove(id);
    }

 /*   @Override
    public Collection<User> findAllUsers() {
        return null;
    }
*/
    @Override
    public void saveUser(User user) {

    }

    @Override
    public User findByEmail(String email) {
        return null;
    }

    @Override
    public void deleteUser(int id) {

    }

    @Override
    public Collection<City> findAllCity() {
        return null;
    }

    @Override
    public void saveCity(City city) {

    }

    @Override
    public void deleteCity(City city) {

    }

    @Override
    public City cityFindById(int id) {
        return null;
    }

    @Override
    public void deletePost(int id) {
        posts.remove(id);
    }
}
