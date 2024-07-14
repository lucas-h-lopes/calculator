package model.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FormatDate {
    private static final DateTimeFormatter localDateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final DateTimeFormatter localDateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm:ss");

    public static DateTimeFormatter getLocalDateFormatter() {
        return localDateFormatter;
    }

    public static DateTimeFormatter getLocalDateTimeFormatter(){
        return localDateFormatter;
    }

    public static LocalDate getLocalDateNow(){
        return LocalDate.now();
    }

    public static LocalDateTime getLocalDateTimeNow(){
        return LocalDateTime.now();
    }

    public static String formatLocalDateTime(LocalDateTime date){
        return date.format(localDateTimeFormatter);
    }

    public static LocalDate convertToLocalDate(String date){
        return LocalDate.parse(date, getLocalDateFormatter());
    }

    public static LocalDateTime convertToLocalDateTime(String date){
        return LocalDateTime.parse(date, getLocalDateTimeFormatter());
    }
    public static void printDateInformation(){
        System.out.println("Today is: " + getLocalDateNow().getDayOfWeek() + ", "+ formatLocalDateTime(getLocalDateTimeNow()) + ".");

    }
}
