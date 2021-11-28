package com.iain.blog.design.iterator;

public class Test {
    public static void main(String[] args) {

        BookShelf bookShelf = new BookShelf();
        Book b1 = new Book();
        b1.setName("a");
        bookShelf.appendBook(b1);
        Book b2 = new Book();
        b2.setName("b");
        bookShelf.appendBook(b1);
        Iterator iterator = bookShelf.iterator();
    }
}
