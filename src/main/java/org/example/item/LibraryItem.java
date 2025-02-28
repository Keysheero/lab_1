package org.example.item;

public abstract class LibraryItem {
    private int id;
    private  String title;
    private String status;

    public LibraryItem(int id, String title, String status) {
        this.id = id;
        this.title = title;
        this.status = status;
    }
}
