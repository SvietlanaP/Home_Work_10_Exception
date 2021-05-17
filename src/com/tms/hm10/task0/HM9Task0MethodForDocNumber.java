package com.tms.hm10.task0;

import com.tms.hm10.task0.ExceptionForBeginningOfDoc;
import com.tms.hm10.task0.ExceptionForDocSequence;
import com.tms.hm10.task0.ExceptionForEndOfDoc;

import java.util.Locale;

public class HM9Task0MethodForDocNumber {

    public static void execute() {
        String docNumber = "5654-yRd-5412-ABk-2a2b";

//        blockNumber(docNumber);
//        letterChangingStar(docNumber);
//        letterFormatLower(docNumber);
//        letterFormatUpper(docNumber);
        try{
            sequenceToDocNumber(docNumber);
        } catch (ExceptionForDocSequence e){
            System.out.println(e);
        }
        try {
            docStartingWithNumber(docNumber);
        } catch (ExceptionForBeginningOfDoc e){
            System.out.println(e);
        }
        try{
            docFinishingWithNumber(docNumber);
        }catch (ExceptionForEndOfDoc e){
            System.out.println(e);
        }

    }



    public static void blockNumber(String docNumber){
        // два блока по 4 цифры
        System.out.println("Выводит на экран в одну строку два первых блока по 4 цифры");
        System.out.println(docNumber.substring(0, 4) + " " + docNumber.substring(9, 13));
    }

    public static void letterChangingStar(String docNumber){
        //буквы заменены на *
        System.out.println("Выводит номер документа, где блоки из трех букв заменить на *");
        String docWithoutLetter = docNumber.replaceAll("[a-zA-Z]", "*");
        System.out.println(docWithoutLetter.substring(0, 18) + docNumber.substring(18, 22));
    }

    public static void letterFormatLower(String docNumber){
        //буквы в нижнем регистре в формате yyy/yyy/y/y
        System.out.println("Выводит только буквы в нижнем регистре в формате yyy/yyy/y/y");
        String[] docNumberPart = docNumber.toLowerCase(Locale.ROOT).split("");
        System.out.println(docNumberPart[5] + docNumberPart[6] + docNumberPart[7] + "/"
                + docNumberPart[14] + docNumberPart[15] + docNumberPart[16] + "/"
                + docNumberPart[19] + "/" + docNumberPart[21]);
    }

    public static void letterFormatUpper(String docNumber){
        //буквы из номера документа в формате "Letters:yyy/yyy/y/y" в верхнем регистре
        System.out.println("Выводит только буквы в формате Letters:yyy/yyy/y/y в верхнем регистре");
        StringBuilder strDoc = new StringBuilder(docNumber.toUpperCase(Locale.ROOT));
        StringBuilder str = new StringBuilder();
        str.append(strDoc.substring(5, 8)).append("/").append(strDoc.substring(14, 17))
                .append("/").append(strDoc.substring(19, 20))
                .append("/").append(strDoc.substring(21, 22));
        System.out.println("Letter: " + str);
    }

    public static void sequenceToDocNumber(String docNumber) throws ExceptionForDocSequence{
        //Проверить содержит ли номер документа последовательность abc и вывети сообщение содержит или нет
        System.out.println("Проверяет содержит ли номер документа последовательность abc");
        String isInDoc = "abc";
        if (docNumber.toLowerCase(Locale.ROOT).indexOf(isInDoc.toLowerCase(Locale.ROOT)) == -1){
            throw new ExceptionForDocSequence(isInDoc + " не входит в номер документа " + docNumber);
        } else {
            System.out.println(isInDoc + " входит в номер документа " + docNumber);
        }
    }

    public static void docStartingWithNumber(String docNumber) throws ExceptionForBeginningOfDoc{
        //Проверить начинается ли номер документа с последовательности 555
        System.out.println("Проверяет начинается ли номер документа с последовательности 555");
        String startDoc = "555";
        if (docNumber.substring(0, 3).equalsIgnoreCase(startDoc)){
            System.out.println("Номер документа " + docNumber + " начинается с " + startDoc);
        } else {
            throw new ExceptionForBeginningOfDoc("Номер документа " + docNumber + " не начинается с " + startDoc);
        }
    }

    public static void docFinishingWithNumber(String docNumber) throws ExceptionForEndOfDoc{
        //Проверить заканчивается ли номер документа на последовательность 1a2b.
        System.out.println("Проверяет заканчивается ли номер документа на последовательность 1a2b");
        String finishDoc = "1a2b";
        if (docNumber.substring(18, 22).equalsIgnoreCase(finishDoc)){
            System.out.println("Номер документа " + docNumber + " заканчивается " + finishDoc);
        } else {
            throw new ExceptionForEndOfDoc("Номер документа " + docNumber + "не заканчивается " + finishDoc);
        }
    }

}
