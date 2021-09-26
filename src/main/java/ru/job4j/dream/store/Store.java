package ru.job4j.dream.store;

import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.model.Post;
import ru.job4j.dream.model.User;

import java.util.Collection;

public interface Store {
    Collection<Post> findAllPosts();

    void savePost(Post post);

    Post postFindById(int id);

    void deletePost(int id);

    Collection<Candidate> findAllCandidates();

    void saveCandidate(Candidate candidate);

    Candidate candidateFindById(int id);

    void deleteCandidate(int id);

    void saveUser(User user);

    User findByEmail(String email);

    void deleteUser(int id);

}

