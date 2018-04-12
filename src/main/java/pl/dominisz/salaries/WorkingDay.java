package pl.dominisz.salaries;

import java.time.LocalDate;

/**
 * http://dominisz.pl
 * 11.04.2018
 */
public class WorkingDay {

    private LocalDate date;
    private int hours;


    public boolean between(LocalDate firstDay, LocalDate lastDay){
        return (date.isAfter(firstDay) || date.equals(firstDay)) && (date.isBefore(lastDay) || date.equals(lastDay));
    }

    public LocalDate getDate() {
        return date;
    }

    public int getHours() {
        return hours;
    }
}
