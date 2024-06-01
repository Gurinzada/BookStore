package com.emakersBookstore.BookStore.exception;

public class NotFindError extends RuntimeException {
    public NotFindError(Integer number){
        super("Id not found: "+ number );
    }
}
