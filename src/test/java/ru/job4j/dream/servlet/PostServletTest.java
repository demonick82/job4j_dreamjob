package ru.job4j.dream.servlet;

import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import ru.job4j.dream.model.Post;
import ru.job4j.dream.store.MemStore;
import ru.job4j.dream.store.PsqlStore;
import ru.job4j.dream.store.Store;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.*;


@RunWith(PowerMockRunner.class)
@PrepareForTest(PsqlStore.class)
public class PostServletTest {

    @Test
    public void whenDoPostAddNewPost() throws ServletException, IOException {
        Store store = MemStore.instOf();

        PowerMockito.mockStatic(PsqlStore.class);
        PowerMockito.when(PsqlStore.instOf()).thenReturn(store);

        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        PowerMockito.when(req.getParameter("id")).thenReturn(String.valueOf(0));
        PowerMockito.when(req.getParameter("name")).thenReturn("Name");
        PowerMockito.when(req.getParameter("description")).thenReturn("new post");
        new PostServlet().doPost(req, resp);

        Post result = store.findAllPosts().iterator().next();
        assertThat(result.getName(), is("Name"));
        assertThat(result.getDescription(), is("new post"));
    }

    @Test
    public void whenDoPostUpdatePost() throws ServletException, IOException {
        Store store = MemStore.instOf();
        Post post = new Post(1, "name", "post", LocalDate.now());
        store.savePost(post);
        PowerMockito.mockStatic(PsqlStore.class);
        when(PsqlStore.instOf()).thenReturn(store);
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        PowerMockito.when(req.getParameter("id")).thenReturn(String.valueOf(post.getId()));
        PowerMockito.when(req.getParameter("name")).thenReturn("update name");
        PowerMockito.when(req.getParameter("description")).thenReturn("update post");
        new PostServlet().doPost(req, resp);

        Post result = store.findAllPosts().iterator().next();
        assertThat(result.getName(), is("update name"));
        assertThat(result.getDescription(), is("update post"));
    }
}