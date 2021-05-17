package com.tms.hm10.task1;

/**
 * Программа проверяет корректность ввода пароля и логина при регистрации
 */

public class InitilizationOfUser {

    public static void main(String[] args) {

        String login = "monday";
        String password = "a12345";
        String confirmPassword = "a12345";

        try {
            if (isCorrectLoginAndPasword(login, password, confirmPassword)){
                System.out.println("Поздравляем! Регистрация прошла успешно!");}
        } catch (WrongLoginException e1){
            System.out.println(e1);
        }catch (WrongPasswordException e2){
            System.out.println(e2);
        }
    }

    static boolean isCorrectLoginAndPasword (String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException{

        if (login.length() >= 20 || login.matches("(.*)\\s(.*)")){
           throw new WrongLoginException("Проверьте правильность ввода логина! Он должен содержать не более 20 символов без пробелов.");
        } if (password.length() >= 20 || password.matches("(.*)\\s(.*)") || !password.matches("(.*)[0-9](.*)")){
            throw new WrongPasswordException("Проверьте, пожалуйста, правильность пароля! Он должен содержать " +
                    "не более 20 символов без пробелов и хотя бы 1 цифру.");
        } if (!password.equals(confirmPassword)){
            throw new WrongPasswordException("Повторно введенный пароль не совпадает с исходным.");
        } else {
            return true;
        }

    }
}
