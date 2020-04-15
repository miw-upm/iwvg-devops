package es.upm.miw.iwvg_devops.code;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static java.time.temporal.TemporalAdjusters.firstDayOfMonth;

public class Dates {
    public static void main(String[] args) {
        new Dates().createDate();
        new Dates().createTime();
        new Dates().createDateTime();
        new Dates().instant();
    }

    public void createDate() {
        LocalDate date = LocalDate.of(2020, 1, 27);
        System.out.println("Year: " + date.getYear());
        System.out.println("Month: " + date.getMonth());
        System.out.println("Day: " + date.getDayOfMonth());
        System.out.println("Week day: " + date.getDayOfWeek());
        System.out.println("Month length: " + date.lengthOfMonth());
        System.out.println("Leap: " + date.isLeapYear());

        System.out.println("+3 days: " + date.plusDays(3));
        System.out.println("First day: " + date.with(firstDayOfMonth()));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MMM/yyyy", Locale.ENGLISH);
        System.out.println("Formatter: " + date.format(formatter));
    }

    public void createTime() {
        LocalTime time = LocalTime.of(13, 45, 20);
        System.out.println("Hour: " + time.getHour());
        System.out.println("Minute: " + time.getMinute());
        System.out.println("Second: " + time.getSecond());
    }

    public void createDateTime() {
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println("DateTime: " + dateTime);
    }

    public void instant() {
        Instant instant = Instant.now();
        System.out.println("Instant: " + instant);
    }

}
