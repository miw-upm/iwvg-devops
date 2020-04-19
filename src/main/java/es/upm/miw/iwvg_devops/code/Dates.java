package es.upm.miw.iwvg_devops.code;

import org.apache.logging.log4j.LogManager;

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
        LogManager.getLogger(this.getClass()).info("Year: " + date.getYear());
        LogManager.getLogger(this.getClass()).info("Month: " + date.getMonth());
        LogManager.getLogger(this.getClass()).info("Day: " + date.getDayOfMonth());
        LogManager.getLogger(this.getClass()).info("Week day: " + date.getDayOfWeek());
        LogManager.getLogger(this.getClass()).info("Month length: " + date.lengthOfMonth());
        LogManager.getLogger(this.getClass()).info("Leap: " + date.isLeapYear());

        LogManager.getLogger(this.getClass()).info("+3 days: " + date.plusDays(3));
        LogManager.getLogger(this.getClass()).info("First day: " + date.with(firstDayOfMonth()));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MMM/yyyy", Locale.ENGLISH);
        LogManager.getLogger(this.getClass()).info("Formatter: " + date.format(formatter));
    }

    public void createTime() {
        LocalTime time = LocalTime.of(13, 45, 20);
        LogManager.getLogger(this.getClass()).info("Hour: " + time.getHour());
        LogManager.getLogger(this.getClass()).info("Minute: " + time.getMinute());
        LogManager.getLogger(this.getClass()).info("Second: " + time.getSecond());
    }

    public void createDateTime() {
        LocalDateTime dateTime = LocalDateTime.now();
        LogManager.getLogger(this.getClass()).info("DateTime: " + dateTime);
    }

    public void instant() {
        Instant instant = Instant.now();
        LogManager.getLogger(this.getClass()).info("Instant: " + instant);
    }

}
