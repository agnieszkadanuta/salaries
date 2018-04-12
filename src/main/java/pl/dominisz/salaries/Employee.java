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

    protected abstract BigDecimal computeSalary(LocalDate date);

    protected abstract LocalDate getFirstDayOfWorkingPeriod(LocalDate date);

    protected abstract boolean isPayDay(LocalDate date);

    public BigDecimal getSalary(LocalDate date) {
        if (isPayDay(date)) {
            return computeSalary(date);
        } else {
            return BigDecimal.ZERO;
        }
    }

}
