package com.assignment;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class DaysOlder {

    public static void main(String[] args) {

 //       LocalDate oldDate = LocalDate.of(1982, Month.AUGUST, 31);
 //       LocalDate newDate = LocalDate.of(2016, Month.NOVEMBER, 9);

    	 LocalDate oldDate = LocalDate.of(1982, 07, 31);
    	 LocalDate newDate = LocalDate.of(2016, 10, 9);
        System.out.println(oldDate);
        System.out.println(newDate);

        // count between dates
        long years = ChronoUnit.YEARS.between(oldDate, newDate);
        long months = ChronoUnit.MONTHS.between(oldDate, newDate);
        long weeks = ChronoUnit.WEEKS.between(oldDate, newDate);
        long days = ChronoUnit.DAYS.between(oldDate, newDate);
 /*       long hours = ChronoUnit.HOURS.between(oldDate, newDate);
        long minutes = ChronoUnit.MINUTES.between(oldDate, newDate);
        long seconds = ChronoUnit.SECONDS.between(oldDate, newDate);
        long milis = ChronoUnit.MILLIS.between(oldDate, newDate);
        long nano = ChronoUnit.NANOS.between(oldDate, newDate);*/

        System.out.println("\n--- Total --- ");
        System.out.println(years + " years");
        System.out.println(months + " months");
        System.out.println(weeks + " weeks");
        System.out.println(days + " days");
      /*  System.out.println(hours + " hours");
        System.out.println(minutes + " minutes");
        System.out.println(seconds + " seconds");
        System.out.println(milis + " milis");
        System.out.println(nano + " nano");*/

    }
}
