package org.frb.kc.iloveotters.core;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.function.Consumer;

public class DateTimeTest {
    @Test
    public void testJavaUtilDate() {
        //Try not to use this, we don't like it
        //No Calendaring = No world view consideration
        //MUTABLE! YUCK!

        Date date = new Date();
        System.out.println(date);

        //Long 39291828282832 = Milliseconds since January 1, 1970.
        //epoch (Pronounced in America as epic, UK, Australia, India? eeepok)
    }

    @Test
    public void testJavaUtilCalendar() {
        Calendar calendar = new GregorianCalendar(2022, Calendar.OCTOBER, 28);
        System.out.println(calendar);
    }

    @Test
    public void testLocalDate() {
        LocalDate localDate = LocalDate.of(2022, 10, 28);
        System.out.println(localDate);
    }

    @Test
    public void testLocalDateTime() {
        LocalDateTime localDateTime = LocalDateTime.of(2022, 10, 29, 12, 0, 0, 0);
        System.out.println(localDateTime);
    }

    @Test
    public void testAvailableZones() {
        ZoneId
            .getAvailableZoneIds()
            .stream()
            .filter(w -> w.contains("Arizona"))
            .forEach(System.out::println);
    }

    @Test
    public void testZonedDateTime() {
        ZonedDateTime zonedDateTime = ZonedDateTime
            .of(2022, 10, 29, 12, 0, 0, 0, ZoneId.of("US/Central"));
        ZonedDateTime zonedDateTime2 = ZonedDateTime
            .of(2022, 10, 29, 12, 0, 0, 0, ZoneId.of("America/Chicago"));
        System.out.println(zonedDateTime);
        System.out.println(zonedDateTime2);

        System.out.println(zonedDateTime2.getDayOfWeek());
        System.out.println(zonedDateTime2.withZoneSameInstant(ZoneId.of("America/Denver")));
        System.out.println(zonedDateTime2.withZoneSameInstant(ZoneId.of("US/Arizona")));
    }


}
