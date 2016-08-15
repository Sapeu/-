package com.example.sapeu.learnrecyclerview;

/**
 * Created by Sapeu on 2016/8/16.
 */
public class CellData {
    private String title;
    private String content;

    public CellData(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
