package com.example.zqamar.zainapplication;

import java.io.Serializable;

/**
 * Created by zqamar on 2/23/17.
 */

public class Book implements Serializable {

    private String name;
    private String author;

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

}
