package org.example.model;

public class Post {
    private static long serialId = 1;
    private long id;
    private String content;

    public Post() {
    }

    public Post(long id, String content) {
        if (id == 0) {
            this.id = serialId++;
        }
        if (id < serialId) {
            this.id = id;
        }
        if (id >= serialId) {
            throw new RuntimeException("Невозможно создать id самостоятельно");
        }
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}