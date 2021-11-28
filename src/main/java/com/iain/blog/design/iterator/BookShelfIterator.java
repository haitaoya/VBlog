package com.iain.blog.design.iterator;

public class BookShelfIterator implements Iterator<Book> {
    private BookShelf bookShelf;
    int index = 0;
    public BookShelfIterator(BookShelf bookShelf){
        this.bookShelf = bookShelf;
    }
    @Override
    public boolean hasNext() {
        return bookShelf.getLength() > index;
    }

    @Override
    public Book next() {
        return bookShelf.getBookAt(index++);
    }
}
