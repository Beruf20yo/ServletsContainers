package org.example.repository;

import org.example.model.Post;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class PostRepository {
    ConcurrentHashMap<Long, Post> postMap = new ConcurrentHashMap<>();


    public List<Post> all() {
        return new ArrayList<>(postMap.values());
    }

    public Optional<Post> getById(long id) {
        return postMap.values().stream().filter(x -> x.getId() == id).findAny();
    }

    public Post save(Post post) {
        if(post.getId() == 0) {
            post.setId();
        }
        if(post.getId() > Post.getSerialId()){
            Post.minusSerialId();
            throw new RuntimeException("Невозможно создать id самостоятельно");
        }
        postMap.put(post.getId(), post);
        return post;
    }

    public void removeById(long id) {
        postMap.remove(id);
    }
}
