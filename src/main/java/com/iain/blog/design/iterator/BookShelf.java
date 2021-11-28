package com.iain.blog.design.iterator;

public class BookShelf implements Aggregate{
    Book[] books ;
    int last = 0;
    public BookShelf(int maxSize){
        books = new Book[maxSize];
    }
    public Book getBookAt(int i){
        return books[i];
    }

    public void appendBook(Book book){
        books[last++] = book;
    }

    public int getLength(){
        return last;
    }
    @Override
    public Iterator iterator() {
        return new BookShelfIterator(this);
    }
}
