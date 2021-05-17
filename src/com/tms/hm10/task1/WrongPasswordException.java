package com.tms.hm10.task1;

/**
 * исключение на случай неверного ввода пароля
 */

public class WrongPasswordException extends Exception{

    public WrongPasswordException(String message){
        super(message);
    }
}
