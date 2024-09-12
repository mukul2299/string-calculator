package com.incubyte.kata.exceptions;

public class InvalidCharacterException extends RuntimeException{
    public InvalidCharacterException(){
        super("Contain(s) Invalid Character(s)");
    }

    public InvalidCharacterException(String msg){
        super(msg);
    }
}
