package ru.job4j.dream.test;

import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.model.Post;
import ru.job4j.dream.model.User;
import ru.job4j.dream.store.PsqlStore;
import ru.job4j.dream.store.Store;

import java.time.LocalDate;

public class PsqlMain {
    public static void main(String[] args) {
        Store store = PsqlStore.instOf();
        User user1 = new User("vasia", "vasia@mail.ru", "111");
        User user2 = new User( "petia", "petia@mail.ru", "222");
        store.saveUser(user1);
        store.saveUser(user2);

        System.out.println(store.findByEmail("vasia@mail.ru"));

/*       store.savePost(new Post(0, "Java Job", "work", LocalDate.now()));
        store.savePost(new Post(0, "Java Job", "work1", LocalDate.now()));
        store.savePost(new Post(1, "Java Job", "work10", LocalDate.now()));

        for (Post post : store.findAllPosts()) {
            System.out.println(post);
        }
        store.saveCandidate(new Candidate(0, "name"));
        store.saveCandidate(new Candidate(0, "name1"));
        store.saveCandidate(new Candidate(2, "name3"));

        for (Candidate candidate : store.findAllCandidates()) {
            System.out.println(candidate);
        }

        System.out.println("post findById" + store.postFindById(2));
        System.out.println("candidate findbyId" + store.candidateFindById(2));
        store.deleteCandidate(14);
        for (Candidate candidate : store.findAllCandidates()) {
            System.out.println(candidate);
        }
        store.deletePost(18);
        for (Post post : store.findAllPosts()) {
            System.out.println(post);
        }*/

    }
}
