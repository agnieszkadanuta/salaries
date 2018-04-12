package pl.dominisz.salaries;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * http://dominisz.pl
 * 11.04.2018
 */
public abstract class Employee {

    private String name;

    public abstract BigDecimal getSalary(LocalDate date);

    public abstract LocalDate getFirstDayOfWorkingPeriod(LocalDate date);


    public abstract boolean isPayDay(LocalDate date);
}
