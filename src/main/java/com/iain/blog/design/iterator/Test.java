package com.iain.blog.design.iterator;

public class Test {
    public static void main(String[] args) {

        BookShelf bookShelf = new BookShelf(3);
        Book b1 = new Book();
        b1.setName("a");
        bookShelf.appendBook(b1);
        Book b2 = new Book();
        b2.setName("b");
        bookShelf.appendBook(b2);
        Iterator<Book> iterator = bookShelf.iterator();
        while (iterator.hasNext()){
            Book next = iterator.next();
            System.out.println(next.getName());
        }
    }
}
