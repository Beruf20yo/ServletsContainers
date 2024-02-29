package org.example.model;

public class Post {
    private static long serialId = 1;
    private long id;
    private String content;

    public Post() {
        this.id = serialId++;
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

    public static long getSerialId() {
        return serialId;
    }

    public long getId() {
        return id;
    }

    public static void minusSerialId() {
        Post.serialId--;
    }

    public void setId() {
        this.id = serialId++;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}