package com.example.testjavaconcepts.DateAndTimeAPI;

import org.apache.commons.lang3.time.DateUtils;
import org.apache.tomcat.jni.Local;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class DateAPI {
    public static void main(String[] args) {
//        LocalTime();
//        LocalDate();
//        LocalDateTime();
//        Instant();
          Date_vs_Calendar_vs_LocalDate();
    }

    private static void Date_vs_Calendar_vs_LocalDate(){
        /**
         *   Date :      Mon Apr 22 15:46:33 ART 2019
         */
        Date date = new Date();
        System.out.println(date);
        /**
         *   Calendar :   Mon Apr 22 15:46:33 ART 2019
         */
        Calendar calendar =  new GregorianCalendar();
        Date date1 = calendar.getTime();
        System.out.println(date1);
        /**
         *   LocalDate:   2019-04-22
         */
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
    }

    private static void LocalTime(){

        // now() : hora actual
        LocalTime now = LocalTime.now();
        System.out.println(now);

        // of() : definis hora fija
        LocalTime hora_minuto_segundo = LocalTime.of(23, 59, 59);
        System.out.println(hora_minuto_segundo);
    }

    private static void LocalDate(){

        // now : fecha actual
        LocalDate today = LocalDate.now();
        // plus() : agrega X cantidad {dias, horas,...}
        LocalDate tomorrow = today.plusDays(1);
        //LocalDate tomorrow2 = today.plus(1, ChronoUnit.DAYS); // Idem anterior
        // minusDays() : le quitas dias a la fecha
        LocalDate yesterday = tomorrow.minusDays(2);

        System.out.println(today);
        System.out.println(tomorrow);
        System.out.println(yesterday);

        // of : seteas una fecha especifica
        LocalDate navidad = LocalDate.of(2019, Month.DECEMBER, 25);

        // getDayOfWeek() te retorna un objeto que representa el dia de la semana LUNES; MARTES, ETC
        DayOfWeek dayOfWeek = navidad.getDayOfWeek();
        System.out.println(dayOfWeek);    // FRIDAY


        DateTimeFormatter italiaFormater =
                    DateTimeFormatter
                            .ofLocalizedDate(FormatStyle.MEDIUM)
                            .withLocale(Locale.GERMAN);

        LocalDate navidad2 = LocalDate.parse("20.01.2019", italiaFormater);
        System.out.println(navidad2);
    }

    private static void LocalDateTime() {
        DateTimeFormatter formatter =
                DateTimeFormatter
                        .ofPattern("MMM dd, yyyy - HH:mm");

//        LocalDateTime parsed = LocalDateTime.parse("Nov 03, 2014 - 07:13", formatter);
//        String string = formatter.format(parsed);

        LocalDateTime fecha_hora = LocalDateTime.now();
        System.out.println(fecha_hora);     // AAAA-mm-DDTHH:mm:SS (2019-03-19T15:30:20.565)
    }

    private static void Instant() {
        Instant instant = Instant.now();

        System.out.println("Instant : " + instant);
    }

    public static void DateCalendarPOC() {
        try {

            // String ('May 15 2040 12:00AM') -> Date (Tue May 15 12:00:00 ART 2040)
            Date date = DateUtils.parseDate("May 15 2040 12:00AM","MMM dd yyyy kk:mma");
            System.out.println(date.toString());

            // Date (Tue May 15 12:00:00 ART 2040) -> String ('2040-05-15')
            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
            String dateString1 = sdf1.format(date);
            System.out.println(dateString1);

            // Calendar -> Date
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            // calendar.getTime (Tue May 15 12:00:00 ART 2040) -> String ('2040-05-15')
            SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
            String dateString2 = sdf2.format(calendar.getTime());
            System.out.println(dateString2);

            SimpleDateFormat sdf3 = new SimpleDateFormat("MMM dd yyyy kk:mma");
            sdf3.parse("May 15 2040 12:00AM");

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }




}
