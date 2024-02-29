package org.example.model;

import java.util.concurrent.atomic.AtomicLong;

public class Post {
    private static AtomicLong serialId = new AtomicLong(0);
    private long id;
    private String content;

    public Post() {
        this.id = serialId.incrementAndGet();
    }

    public Post(long id, String content) {
        if (id == 0) {
            this.id = serialId.incrementAndGet();
        }
        if (id < serialId.get()) {
            this.id = id;
        }
        if (id >= serialId.get()) {
            throw new RuntimeException("Невозможно создать id самостоятельно");
        }
        this.content = content;
    }

    public static long getSerialId() {
        return serialId.get();
    }

    public long getId() {
        return id;
    }

    public static void minusSerialId() {
        Post.serialId.decrementAndGet();
    }

    public void setId() {
        this.id = serialId.incrementAndGet();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}