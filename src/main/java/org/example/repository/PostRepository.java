package org.example.repository;

import org.example.model.Post;


import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

public class PostRepository {
    CopyOnWriteArrayList<Post> posts = new CopyOnWriteArrayList<>();
    public List<Post> all() {
        return posts;
    }

    public Optional<Post> getById(long id) {
        return posts.stream().filter(x->x.getId()==id).findAny();
    }

    public Post save(Post post) {
        posts.add(post);
        return post;
    }

    public void removeById(long id) {
        Iterator<Post> iterator = posts.iterator();
        while (iterator.hasNext()){
            Post elem = iterator.next();
            if(elem.getId()==id){
                posts.remove(elem);
            }
        }
    }
}
