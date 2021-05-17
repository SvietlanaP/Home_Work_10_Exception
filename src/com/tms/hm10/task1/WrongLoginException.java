package com.tms.hm10.task1;

/**
 * Исключение на случай неверного логина
 */

public class WrongLoginException extends Exception{

    public WrongLoginException(String message){
        super(message);
    }
}
