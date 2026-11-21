package ru.urfu.student.autopark.exception;

public class UnderageOwnerException extends RuntimeException{
    public UnderageOwnerException(String message){
        super(message);
    }
}
