package pl.dominisz.salaries;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.MonthDay;

/**
 * http://dominisz.pl
 * 11.04.2018
 */


public class MonthlyEmployee extends Employee {


    private BigDecimal salary;


    public MonthlyEmployee(String name, BigDecimal salary) {
        super(name);
        this.salary = salary;
    }

    @Override
    public BigDecimal computeSalary(LocalDate date) {
        return null;
    }

    @Override
    public LocalDate getFirstDayOfWorkingPeriod(LocalDate date) {
        return null;
    }

    @Override
    public boolean isPayDay(LocalDate date) {
        LocalDate lastDay = LocalDate.of(date.getYear(), date.getMonth(), date.lengthOfMonth());
        while(!isWorkingDay(lastDay)) {
            lastDay = lastDay.minusDays(1);
        }
            return date.equals(lastDay);
    }

    private boolean isWorkingDay(LocalDate date){
        return date.getDayOfWeek() != DayOfWeek.SATURDAY && date.getDayOfWeek() != DayOfWeek.SUNDAY;
    }
}
