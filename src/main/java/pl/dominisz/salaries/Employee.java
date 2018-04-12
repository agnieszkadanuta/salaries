package pl.dominisz.salaries;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * http://dominisz.pl
 * 11.04.2018
 */
public abstract class Employee {

    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public abstract BigDecimal computeSalary(LocalDate date);

    public abstract LocalDate getFirstDayOfWorkingPeriod(LocalDate date);

    public abstract boolean isPayDay(LocalDate date);

    public BigDecimal getSalary(LocalDate date) {
        if (isPayDay(date)) {
            return computeSalary(date);
        } else {
            return BigDecimal.ZERO;
        }
    }

}
